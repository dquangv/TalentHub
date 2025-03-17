package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.repository.SoldPackageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoldPackageSchedulerServiceImpl {
    private final SoldPackageRepository soldPackageRepository;

    @Scheduled(cron = "0 */1 * * * ?") // cron format
    public void checkAndExpirePackages() {
        log.info("Scheduler running: Checking expired sold packages...");

        // find expired packages with true status
        List<SoldPackage> expiredPackages = soldPackageRepository
                .findByEndDateBeforeAndStatus(LocalDateTime.now(), true);

        log.info("Found {} packages to expire", expiredPackages.size());

        // update status
        expiredPackages.forEach(packageItem -> {
            packageItem.setStatus(false);
            log.info("Expired package ID: {}", packageItem.getId());
        });

        // save at database
        soldPackageRepository.saveAll(expiredPackages);
    }
}
