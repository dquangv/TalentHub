package org.example.backend.service.impl.account;


import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.TypePackage;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.admin.VoucherPackageMapper;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.SoldPackageRepository;
import org.example.backend.repository.VoucherPackageRepository;
import org.example.backend.service.intf.account.admin.VoucherPackageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoucherPackageServiceImpl implements VoucherPackageService {

    private final VoucherPackageRepository voucherPackageRepository;
    private final AccountRepository accountRepository;
    private final VoucherPackageMapper voucherPackageMapper;
    private final SoldPackageRepository soldPackageRepository;

    @Override
    public VoucherPackageDTOResponse create(VoucherPackageDTORequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new NotFoundException("Account not found"));

        VoucherPackage voucherPackage = voucherPackageMapper.toEntity(request);
        voucherPackage.setAccount(account);

        VoucherPackage savedVoucherPackage = voucherPackageRepository.save(voucherPackage);
        return voucherPackageMapper.toDTO(savedVoucherPackage);
    }

    @Override
    public String updateByName(String name, VoucherPackageDTORequest request) {
        Optional<VoucherPackage> optionalVoucherPackage = voucherPackageRepository.findByName(name);

        if (optionalVoucherPackage.isPresent()) {
            VoucherPackage voucherPackage = optionalVoucherPackage.get();

            voucherPackage.setPrice(request.getPrice());
            voucherPackage.setDuration(request.getDuration());
            voucherPackage.setStatus(request.isStatus());
            voucherPackage.setTypePackage(request.getTypePackage());
            voucherPackage.setNumberPost(request.getNumberPost());

            VoucherPackage updatedVoucherPackage = voucherPackageRepository.save(voucherPackage);

            return "Update successful";
        } else {
            throw new RuntimeException("Voucher package with name " + name + " not found");
        }
    }


    @Override
    public VoucherPackageDTOResponse update(TypePackage typePackage, VoucherPackageDTORequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new NotFoundException("Account not found"));

        VoucherPackage existingVoucherPackage = voucherPackageRepository.findTopByTypePackageOrderByIdDesc(typePackage);

        if (existingVoucherPackage == null) {
            throw new NotFoundException("Voucher package not found");
        }

        if (request.getAccountId() != null) {
            existingVoucherPackage.setStatus(false);
        }

        voucherPackageRepository.save(existingVoucherPackage);

        VoucherPackage voucherPackage = voucherPackageMapper.toEntity(request);
        voucherPackage.setAccount(account);
        voucherPackage.setStatus(request.isStatus());
        voucherPackage.setTypePackage(typePackage);

        voucherPackageRepository.save(voucherPackage);

        return voucherPackageMapper.toDTO(voucherPackage);
    }

    @Override
    public Optional<VoucherPackageDTOResponse> getById(Long id) {
        Optional<VoucherPackage> voucherPackage = voucherPackageRepository.findById(id);
        return voucherPackage.map(voucherPackageMapper::toDTO);
    }

    @Override
    public List<VoucherPackageDTOResponse> getAll() {
        List<VoucherPackage> voucherPackages = voucherPackageRepository.findAll();
        return voucherPackages.stream()
                .map(voucherPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<VoucherPackage> voucherPackage = voucherPackageRepository.findById(id);
        if (voucherPackage.isPresent()) {
            voucherPackageRepository.delete(voucherPackage.get());
            return true;
        }
        return false;
    }

    @Override
    public VoucherPackageDTOResponse getDetailByTypePackage(TypePackage typePackage) {
        VoucherPackage voucherPackage = voucherPackageRepository.findTopByTypePackageOrderByIdDesc(typePackage);

        if (voucherPackage == null) {
            throw new NotFoundException("Voucher Package not found");
        }

        return voucherPackageMapper.toDTO(voucherPackage);
    }

    @Override
    public List<VoucherPackageDTOResponse> findLatestVoucherPackagesByType() {
        List<VoucherPackage> voucherPackages = voucherPackageRepository.findLatestVoucherPackagesByType();

        return voucherPackages.stream()
                .map(voucherPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VoucherPackageDTOResponse> findLatestVoucherPackagesByTypeOrdered() {
        List<VoucherPackage> voucherPackages = voucherPackageRepository.findLatestVoucherPackagesByTypeOrdered();

        return voucherPackages.stream()
                .map(voucherPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VoucherPackageDTOResponse> findLatestVoucherPackagesByTypeByClientId(Long clientId) {
        List<VoucherPackage> voucherPackages = voucherPackageRepository.findLatestVoucherPackagesByTypeOrdered();

        SoldPackage soldPackage = soldPackageRepository.findTopByClientIdAndStatusOrderByStartDateDesc(clientId, true);
        TypePackage clientTypePackage = (soldPackage != null) ? soldPackage.getVoucherPackage().getTypePackage() : null;

        return voucherPackages.stream()
                .map(voucherPackage -> {
                    VoucherPackageDTOResponse dto = voucherPackageMapper.toDTO(voucherPackage);

                    dto.setMyPackage(clientTypePackage != null && clientTypePackage == voucherPackage.getTypePackage());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
