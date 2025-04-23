package org.example.backend.service.intf.account.admin;

import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.enums.TypePackage;
import org.example.backend.service.BaseService;

import java.util.List;

public interface VoucherPackageService extends BaseService<VoucherPackageDTORequest, VoucherPackageDTOResponse, Long> {
    public VoucherPackageDTOResponse update(TypePackage typePackage, VoucherPackageDTORequest request);

    public String updateByName(String name, VoucherPackageDTORequest request);

    VoucherPackageDTOResponse getDetailByTypePackage(TypePackage typePackage);

    List<VoucherPackageDTOResponse> findLatestVoucherPackagesByType();
    List<VoucherPackageDTOResponse> findLatestVoucherPackagesByTypeOrdered();

    List<VoucherPackageDTOResponse> findLatestVoucherPackagesByTypeByClientId(Long clientId);
}
