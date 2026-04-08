package dev.skirtty.maintenancetrackerbackend.repositories;

import dev.skirtty.maintenancetrackerbackend.entities.Maintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    Page<Maintenance> findByRiskLevel (String type, Pageable pageable);
}
