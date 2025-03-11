package org.example.backend.service.intf;

import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.entity.child.Banner;
import org.example.backend.service.BaseService;

public interface BannerService extends BaseService<BannerDTORequest, BannerDTOResponse, Long> {
    BannerDTOResponse update(Long id, BannerDTORequest bannerDTORequest);
}
