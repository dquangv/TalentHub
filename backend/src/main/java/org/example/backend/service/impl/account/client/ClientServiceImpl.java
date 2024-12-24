package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.service.intf.account.client.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDTOResponse create(ClientDTORequest clientDTORequest) {
        return null;
    }

    @Override
    public Optional<ClientDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ClientDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
