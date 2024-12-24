package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.service.BaseService;

public interface ClientService extends BaseService<ClientDTORequest, ClientDTOResponse,Long> {
}
