package org.example.backend.controller.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.service.intf.account.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseObject<ClientDTOResponse> createClient(@Valid @RequestBody ClientDTORequest clientDTORequest) {
        ClientDTOResponse clientDTOResponse = clientService.create(clientDTORequest);
        return ResponseObject.<ClientDTOResponse>builder()
                .message("Client created successfully")
                .status(HttpStatus.CREATED.value())
                .data(clientDTOResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<ClientDTOResponse> getClientById(@PathVariable Long id) {
        return clientService.getById(id)
                .map(client -> ResponseObject.<ClientDTOResponse>builder()
                        .message("Client retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(client)
                        .build())
                .orElse(ResponseObject.<ClientDTOResponse>builder()
                        .message("Client not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }

    @GetMapping
    public ResponseObject<List<ClientDTOResponse>> getAllClients() {
        List<ClientDTOResponse> clients = clientService.getAll();
        return ResponseObject.<List<ClientDTOResponse>>builder()
                .message("All clients retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(clients)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deleteClient(@PathVariable Long id) {
        boolean isDeleted = clientService.deleteById(id);
        if (isDeleted) {
            return ResponseObject.<Void>builder()
                    .message("Client deleted successfully")
                    .status(HttpStatus.NO_CONTENT.value())
                    .build();
        }
        return ResponseObject.<Void>builder()
                .message("Client not found")
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
