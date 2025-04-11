package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.admin.RevenueDTOResponse;
import org.example.backend.dto.response.account.client.CurrentPackageDTOResponse;
import org.example.backend.dto.response.account.client.PackageHistoryDTOResponse;
import org.example.backend.dto.response.account.client.SoldPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface SoldPackageService extends BaseService<SoldPackageDTORequest, SoldPackageDTOResponse, Long> {
    Optional<CurrentPackageDTOResponse> getCurrentPackage(Long clientId);

    List<PackageHistoryDTOResponse> getPackageHistory(Long clientId);
}
