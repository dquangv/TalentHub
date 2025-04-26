package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.request.account.client.UpdatePriceAndTypeDTORequest;
import org.example.backend.dto.response.account.client.*;
import org.example.backend.entity.child.account.client.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDTOResponse create(ClientDTORequest clientDTORequest);

    Optional<ClientDTOResponse> getById(Long id);

    List<ClientDTOResponse> getAll();

    Boolean deleteById(Long id);

    Client findById(Long clientId);

    UpdatePriceAndTypeDTOResponse updatePriceAndType(UpdatePriceAndTypeDTORequest updatePriceAndTypeDTORequest);

    List<CompanyDTOResponse> getCompaniesByClientId(Long clientId);

    List<ActiveClientDTOResponse> getAllActiveClients();

    ClientDetailDTOResponse getClientDetail(Long clientId);

    void findClientsByDiamondPackageAndCategory(Long freelancerId);
}