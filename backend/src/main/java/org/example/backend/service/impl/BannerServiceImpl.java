package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.entity.child.Banner;
import org.example.backend.exception.NotFoundException;
import org.example.backend.repository.BannerRepository;
import org.example.backend.service.intf.BannerService;
import org.example.backend.service.intf.image.CloudinaryImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final CloudinaryImageService cloudinaryImageService;
    @Override
    public BannerDTOResponse create(BannerDTORequest bannerDTORequest) {
        String imageUrl = cloudinaryImageService.uploadImage(bannerDTORequest.getImage());
        String logoUrl = cloudinaryImageService.uploadImage(bannerDTORequest.getLogo());
        Banner banner = new Banner();
        banner.setTitle(bannerDTORequest.getTitle());
        banner.setImage(imageUrl);
        banner.setImage(logoUrl);
        banner.setStatus(bannerDTORequest.isStatus());
        banner.setVendor(bannerDTORequest.getVendor());
        banner.setStartTime(bannerDTORequest.getStartTime());
        banner.setEndTime(bannerDTORequest.getEndTime());
        Banner savedBanner = bannerRepository.save(banner);

        return toDTO(savedBanner);
    }

    @Override
    public BannerDTOResponse update(Long id, BannerDTORequest bannerDTORequest) {
        Banner existingBanner = bannerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Banner not found"));

        if (bannerDTORequest.getImage() != null && !bannerDTORequest.getImage().isEmpty()) {
            String newImageUrl = cloudinaryImageService.uploadImage(bannerDTORequest.getImage());
            existingBanner.setImage(newImageUrl);
        }
        if (bannerDTORequest.getLogo() != null && !bannerDTORequest.getLogo().isEmpty()) {
            String newLogoUrl = cloudinaryImageService.uploadImage(bannerDTORequest.getLogo());
            existingBanner.setLogo(newLogoUrl);
        }

        existingBanner.setTitle(bannerDTORequest.getTitle());
        existingBanner.setStatus(bannerDTORequest.isStatus());
        existingBanner.setVendor(bannerDTORequest.getVendor());
        existingBanner.setEndTime(bannerDTORequest.getEndTime());
        existingBanner.setStartTime(bannerDTORequest.getStartTime());
        Banner updatedBanner = bannerRepository.save(existingBanner);

        return toDTO(updatedBanner);
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
        response.setLogo(banner.getLogo());
        response.setStatus(banner.isStatus());
        response.setVendor(banner.getVendor());
        response.setStartTime(banner.getStartTime());
        response.setEndTime(banner.getEndTime() != null ? banner.getEndTime() : null);
        return response;
    }


}
