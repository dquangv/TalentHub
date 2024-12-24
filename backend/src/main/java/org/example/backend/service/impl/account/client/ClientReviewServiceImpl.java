package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.ClientReviewDTORequest;
import org.example.backend.dto.response.account.client.ClientReviewDTOResponse;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.service.intf.account.client.ClientReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientReviewServiceImpl implements ClientReviewService {

    @Override
    public ClientReviewDTOResponse create(ClientReviewDTORequest clientReviewDTORequest) {
        return null;
    }

    @Override
    public Optional<ClientReviewDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ClientReviewDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
