package org.example.backend.service.intf.account.admin;

import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.service.BaseService;

public interface VoucherPackageService extends BaseService<VoucherPackageDTORequest, VoucherPackageDTOResponse, Long> {
    public VoucherPackageDTOResponse update(Long id, VoucherPackageDTORequest request);
}
