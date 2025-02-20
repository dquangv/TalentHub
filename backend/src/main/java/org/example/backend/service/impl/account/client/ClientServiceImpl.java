package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.User;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.account.client.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

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

        return new ClientDTOResponse(
                savedClient.getId(),
                savedClient.getFromPrice(),
                savedClient.getToPrice(),
                savedClient.getTypePrice(),
                savedClient.getUser().getId()
        );
    }

    @Override
    public Optional<ClientDTOResponse> getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(c -> new ClientDTOResponse(
                c.getId(),
                c.getFromPrice(),
                c.getToPrice(),
                c.getTypePrice(),
                c.getUser().getId()
        ));
    }

    @Override
    public List<ClientDTOResponse> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> new ClientDTOResponse(
                client.getId(),
                client.getFromPrice(),
                client.getToPrice(),
                client.getTypePrice(),
                client.getUser().getId()
        )).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
