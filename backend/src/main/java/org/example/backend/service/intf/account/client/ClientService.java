package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.request.account.client.UpdatePriceAndTypeDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.dto.response.account.client.UpdatePriceAndTypeDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.service.BaseService;

import java.math.BigDecimal;

public interface ClientService extends BaseService<ClientDTORequest, ClientDTOResponse,Long> {
    Client findById(Long clientId);
    UpdatePriceAndTypeDTOResponse updatePriceAndType(UpdatePriceAndTypeDTORequest updatePriceAndTypeDTORequest);
}
