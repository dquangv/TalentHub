package org.example.backend.service.intf;

import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.dto.response.LogoDTOResponse;
import org.example.backend.entity.child.Banner;
import org.example.backend.service.BaseService;

import java.util.List;

public interface BannerService extends BaseService<BannerDTORequest, BannerDTOResponse, Long> {
    BannerDTOResponse update(Long id, BannerDTORequest bannerDTORequest);

    List<LogoDTOResponse> getAllLogo();
}
