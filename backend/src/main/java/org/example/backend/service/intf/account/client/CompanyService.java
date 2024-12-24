package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.CompanyDTORequest;
import org.example.backend.dto.response.account.client.CompanyDTOResponse;
import org.example.backend.service.BaseService;

public interface CompanyService extends BaseService<CompanyDTORequest, CompanyDTOResponse,Long> {
}
