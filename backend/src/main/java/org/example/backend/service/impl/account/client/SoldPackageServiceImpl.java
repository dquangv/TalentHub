package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
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

        if (soldPackageDTORequest.getVoucherId() == null) {
            throw new BadRequestException("Voucher Id cannot be null");
        }

        SoldPackage soldPackage = soldPackageMapper.toEntity(soldPackageDTORequest);
        soldPackage.setStartDate(LocalDateTime.now());

        VoucherPackage voucherPackage = voucherPackageRepository.getReferenceById(soldPackageDTORequest.getVoucherId());
        soldPackage.setEndDate(LocalDateTime.now().plusDays(voucherPackage.getDuration()));

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
}
