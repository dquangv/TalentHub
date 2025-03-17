package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.request.account.client.UpdatePriceAndTypeDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.dto.response.account.client.UpdatePriceAndTypeDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.User;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.client.ClientMapper;
import org.example.backend.mapper.Account.client.UpdatePriceAndTypeMapper;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.account.client.ClientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ClientMapper clientMapper;
    private final UpdatePriceAndTypeMapper updatePriceAndTypeMapper;

    @Override
    public ClientDTOResponse create(ClientDTORequest clientDTORequest) {
        User user = userRepository.findById(clientDTORequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Client client = new Client();
        client.setFromPrice(clientDTORequest.getFromPrice());
        client.setToPrice(clientDTORequest.getToPrice());
        client.setTypePrice(clientDTORequest.getTypePrice());
        client.setUser(user);

        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(savedClient);
    }

    @Override
    public Optional<ClientDTOResponse> getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return Optional.of(clientMapper.toResponseDto(client.get()));
        }
        return Optional.empty();
    }


    @Override
    public List<ClientDTOResponse> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toResponseDto).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client findById(Long clientId) {
        if (clientId == null) {
            throw new BadRequestException("Client id is null");
        }

        return clientRepository.findById(clientId)
                .orElseThrow(() -> new BadRequestException("Client not found"));
    }
    @Override
    public UpdatePriceAndTypeDTOResponse updatePriceAndType(UpdatePriceAndTypeDTORequest updatePriceAndTypeDTORequest) {

        clientRepository.updatePrice(
                updatePriceAndTypeDTORequest.getClientId(),
                updatePriceAndTypeDTORequest.getFromPrice(),
                updatePriceAndTypeDTORequest.getToPrice(),
                updatePriceAndTypeDTORequest.getTypePrice()
        );

        Client updatedClient = clientRepository.findById(updatePriceAndTypeDTORequest.getClientId())
                .orElseThrow(() -> new BadRequestException("Client not found after update"));

        return updatePriceAndTypeMapper.toResponseDto(updatedClient);
    }

}
