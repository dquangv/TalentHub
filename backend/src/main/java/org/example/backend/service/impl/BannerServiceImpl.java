package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.entity.child.Banner;
import org.example.backend.repository.BannerRepository;
import org.example.backend.service.intf.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public BannerDTOResponse create(BannerDTORequest bannerDTORequest) {
        Banner banner = new Banner();
        banner.setTitle(bannerDTORequest.getTitle());
        banner.setImage(bannerDTORequest.getImage());
        banner.setStatus(bannerDTORequest.getStatus());
        banner.setVendor(bannerDTORequest.getVendor());

        Banner savedBanner = bannerRepository.save(banner);

        return toDTO(savedBanner);
    }

    @Override
    public Optional<BannerDTOResponse> getById(Long bannerId) {
        Optional<Banner> banner = bannerRepository.findById(bannerId);
        return banner.map(this::toDTO);
    }

    @Override
    public List<BannerDTOResponse> getAll() {
        List<Banner> banners = bannerRepository.findAll();
        return banners.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long bannerId) {
        Optional<Banner> banner = bannerRepository.findById(bannerId);
        if (banner.isPresent()) {
            bannerRepository.delete(banner.get());
            return true;
        }
        return false;
    }

    private BannerDTOResponse toDTO(Banner banner) {
        BannerDTOResponse response = new BannerDTOResponse();
        response.setId(banner.getId());
        response.setTitle(banner.getTitle());
        response.setImage(banner.getImage());
        response.setStatus(banner.getStatus());
        response.setVendor(banner.getVendor());
        response.setCreatedAt(banner.getCreatedAt().toString());
        response.setUpdatedAt(banner.getUpdatedAt() != null ? banner.getUpdatedAt().toString() : null);
        return response;
    }
}
