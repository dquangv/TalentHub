package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.client.CurrentPackageDTOResponse;
import org.example.backend.dto.response.account.client.SoldPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.client.SoldPackageMapper;
import org.example.backend.repository.SoldPackageRepository;
import org.example.backend.repository.VoucherPackageRepository;
import org.example.backend.service.intf.account.client.SoldPackageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SoldPackageServiceImpl implements SoldPackageService {
    private final SoldPackageRepository soldPackageRepository;
    private final SoldPackageMapper soldPackageMapper;
    private final VoucherPackageRepository voucherPackageRepository;

    @Override
    public SoldPackageDTOResponse create(SoldPackageDTORequest soldPackageDTORequest) {
        if (soldPackageDTORequest == null) {
            throw new BadRequestException("SoldPackage DTO cannot be null");
        }

        if (soldPackageDTORequest.getClientId() == null) {
            throw new BadRequestException("Client Id cannot be null");
        }

        if (soldPackageDTORequest.getTypePackage() == null) {
            throw new BadRequestException("Type Package cannot be null");
        }

        SoldPackage oldSoldPackage = soldPackageRepository.findTopByClientIdAndStatusOrderByStartDateDesc(soldPackageDTORequest.getClientId(), true);

        if (oldSoldPackage != null) {
            oldSoldPackage.setStatus(false);
            soldPackageRepository.save(oldSoldPackage);
        }

        VoucherPackage voucherPackage = voucherPackageRepository.findTopByTypePackageOrderByIdDesc(soldPackageDTORequest.getTypePackage());

        SoldPackage soldPackage = soldPackageMapper.toEntity(soldPackageDTORequest);
        soldPackage.setStartDate(LocalDateTime.now());
        soldPackage.setEndDate(LocalDateTime.now().plusDays(30));
        soldPackage.setNumberPost(voucherPackage.getNumberPost());
        soldPackage.setNumberPosted(Long.valueOf(0));
        soldPackage.setVoucherPackage(voucherPackage);

        soldPackage = soldPackageRepository.save(soldPackage);

        return soldPackageMapper.toResponseDto(soldPackage);
    }

    @Override
    public Optional<SoldPackageDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<SoldPackageDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<CurrentPackageDTOResponse> getCurrentPackage(Long clientId) {
        if (clientId == null) {
            throw new BadRequestException("Client ID cannot be null");
        }

        SoldPackage currentPackage = soldPackageRepository.findTopByClientIdAndStatusOrderByStartDateDesc(clientId, true);

        if (currentPackage == null) {
            return Optional.empty();
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endDate = currentPackage.getEndDate();

        long remainingHours = 0;
        String remainingFormatted = "Đã hết hạn";

        if (endDate.isAfter(now)) {
            remainingHours = java.time.Duration.between(now, endDate).toHours();
            long days = remainingHours / 24;
            long hours = remainingHours % 24;

            if (days > 0) {
                remainingFormatted = days + " ngày " + hours + " giờ";
            } else {
                remainingFormatted = hours + " giờ";
            }
        }
        Long postsRemaining = currentPackage.getNumberPost() - currentPackage.getNumberPosted();
        if (postsRemaining < 0) postsRemaining = 0L;

        return Optional.of(CurrentPackageDTOResponse.builder()
                .id(currentPackage.getId())
                .startDate(currentPackage.getStartDate())
                .endDate(currentPackage.getEndDate())
                .price(currentPackage.getPrice())
                .numberPost(currentPackage.getNumberPost())
                .numberPosted(currentPackage.getNumberPosted())
                .postsRemaining(postsRemaining)
                .packageType(currentPackage.getVoucherPackage().getTypePackage())
                .packageTypeName(currentPackage.getVoucherPackage().getTypePackage().getDisplayName())
                .remainingTimeInHours(remainingHours)
                .remainingTimeFormatted(remainingFormatted)
                .isActive(currentPackage.isStatus())
                .build());
    }
}
