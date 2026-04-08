package dev.skirtty.maintenancetrackerbackend.repositories;

import dev.skirtty.maintenancetrackerbackend.entities.Zones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonesRepository extends JpaRepository<Zones, Long> {
}
