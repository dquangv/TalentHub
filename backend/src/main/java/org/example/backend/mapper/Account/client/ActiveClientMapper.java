package org.example.backend.mapper.Account.client;

import org.example.backend.dto.response.account.client.ActiveClientDTOResponse;
import org.example.backend.dto.response.account.client.ClientDetailDTOResponse;
import org.example.backend.dto.response.account.client.CompanyDTOResponse;
import org.example.backend.dto.response.job.ClientReviewDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.job.FreelancerJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ActiveClientMapper {

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "fromPrice", source = "client.fromPrice")
    @Mapping(target = "toPrice", source = "client.toPrice")
    @Mapping(target = "jobsCount", expression = "java(client.getJobs() != null ? client.getJobs().size() : 0)")

    // User mappings
    @Mapping(target = "firstName", source = "client.user.firstName")
    @Mapping(target = "lastName", source = "client.user.lastName")
    @Mapping(target = "province", source = "client.user.province")
    @Mapping(target = "country", source = "client.user.country")
    @Mapping(target = "title", source = "client.user.title")
    @Mapping(target = "introduction", source = "client.user.introduction")
    @Mapping(target = "image", source = "client.user.image")

    @Mapping(target = "email", source = "client.user.account.email")

    @Mapping(target = "averageRating", source = "clientReviews", qualifiedByName = "calculateAverageRating")

    @Mapping(target = "companies", source = "companies")
    ActiveClientDTOResponse toActiveClientResponse(Client client, List<ClientReview> clientReviews, List<CompanyDTOResponse> companies);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "fromPrice", source = "client.fromPrice")
    @Mapping(target = "toPrice", source = "client.toPrice")
    @Mapping(target = "jobsCount", expression = "java(client.getJobs() != null ? client.getJobs().size() : 0)")

    @Mapping(target = "firstName", source = "client.user.firstName")
    @Mapping(target = "lastName", source = "client.user.lastName")
    @Mapping(target = "province", source = "client.user.province")
    @Mapping(target = "country", source = "client.user.country")
    @Mapping(target = "title", source = "client.user.title")
    @Mapping(target = "introduction", source = "client.user.introduction")
    @Mapping(target = "image", source = "client.user.image")

    @Mapping(target = "email", source = "client.user.account.email")

    @Mapping(target = "averageRating", source = "clientReviews", qualifiedByName = "calculateAverageRating")

    @Mapping(target = "companies", source = "companies")

    @Mapping(target = "reviews", source = "reviewDTOs")
    ClientDetailDTOResponse toClientDetailResponse(Client client, List<ClientReview> clientReviews,
                                                   List<CompanyDTOResponse> companies, List<ClientReviewDTOResponse> reviewDTOs);

    @Named("calculateAverageRating")
    default Float calculateAverageRating(List<ClientReview> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0f;
        }

        OptionalDouble average = reviews.stream()
                .map(ClientReview::getRating)
                .filter(rating -> rating != null)
                .mapToDouble(Float::doubleValue)
                .average();

        return average.isPresent() ? (float) ((float) Math.round(average.getAsDouble() * 100.0) / 100.0) : 0.0f;
    }

    @Mapping(target = "id", source = "review.id")
    @Mapping(target = "rating", source = "review.rating")
    @Mapping(target = "note", source = "review.note")
    @Mapping(target = "reviewerName", source = "reviewerName")
    ClientReviewDTOResponse toClientReviewResponse(ClientReview review, String reviewerName);
}