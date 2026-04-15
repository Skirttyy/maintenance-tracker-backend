package dev.skirtty.maintenancetrackerbackend.repositories;

import dev.skirtty.maintenancetrackerbackend.entities.Maintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    Page<Maintenance> findByRiskLevelContainingIgnoreCase (String content, Pageable pageable);
    Page<Maintenance> findByTypeContainingIgnoreCase (String content, Pageable pageable);
    Page<Maintenance> findByProviderContainingIgnoreCase (String content, Pageable pageable);
    Page<Maintenance> findByCommentsContainingIgnoreCase (String content, Pageable pageable);
    Page<Maintenance> findByNotificationsContainingIgnoreCase (String content, Pageable pageable);
    Page<Maintenance> findByNameContainingIgnoreCase (String content, Pageable pageable);
}
