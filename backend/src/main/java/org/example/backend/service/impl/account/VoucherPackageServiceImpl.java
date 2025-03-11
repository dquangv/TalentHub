package org.example.backend.service.impl.account;


import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.entity.child.account.Account;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.admin.VoucherPackageMapper;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.VoucherPackageRepository;
import org.example.backend.service.intf.account.admin.VoucherPackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoucherPackageServiceImpl implements VoucherPackageService {

    private final VoucherPackageRepository voucherPackageRepository;
    private final AccountRepository accountRepository;
    private final VoucherPackageMapper voucherPackageMapper;

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
    public VoucherPackageDTOResponse update(Long id, VoucherPackageDTORequest request) {
        VoucherPackage existingVoucherPackage = voucherPackageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Voucher Package not found"));

        existingVoucherPackage.setName(request.getName());
        existingVoucherPackage.setPrice(request.getPrice());
        existingVoucherPackage.setDuration(request.getDuration());
        existingVoucherPackage.setStatus(request.isStatus());

        if (request.getAccountId() != null) {
            Account account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new NotFoundException("Account not found"));
            existingVoucherPackage.setAccount(account);
        }

        VoucherPackage updatedVoucherPackage = voucherPackageRepository.save(existingVoucherPackage);
        return voucherPackageMapper.toDTO(updatedVoucherPackage);
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
}
