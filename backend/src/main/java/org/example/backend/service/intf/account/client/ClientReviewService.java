package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.ClientReviewDTORequest;
import org.example.backend.dto.response.account.client.ClientReviewDTOResponse;

import org.example.backend.service.BaseService;

public interface ClientReviewService extends BaseService<ClientReviewDTORequest, ClientReviewDTOResponse, Long> {
}
