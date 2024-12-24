package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.entity.child.Banner;
import org.example.backend.service.intf.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    @Override
    public BannerDTOResponse create(BannerDTORequest bannerDTORequest) {
        return null;
    }

    @Override
    public Optional<BannerDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<BannerDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
