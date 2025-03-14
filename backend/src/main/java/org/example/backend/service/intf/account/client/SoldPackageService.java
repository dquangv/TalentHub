package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.client.SoldPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.service.BaseService;

public interface SoldPackageService extends BaseService<SoldPackageDTORequest, SoldPackageDTOResponse, Long> {

}
