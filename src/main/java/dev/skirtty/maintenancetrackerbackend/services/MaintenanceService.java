package dev.skirtty.maintenancetrackerbackend.services;

import dev.skirtty.maintenancetrackerbackend.dtos.MaintenanceDTO;
import dev.skirtty.maintenancetrackerbackend.entities.Maintenance;
import dev.skirtty.maintenancetrackerbackend.entities.Zones;
import dev.skirtty.maintenancetrackerbackend.repositories.MaintenanceRepository;
import dev.skirtty.maintenancetrackerbackend.repositories.ZonesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceDTO add (MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setProvider(maintenanceDTO.getProvider());
        maintenance.setType(maintenanceDTO.getType());
        maintenance.setComments(maintenanceDTO.getComments());
        maintenance.setAffectedClients(maintenanceDTO.getAffectedClients());
        maintenance.setStartDate(maintenanceDTO.getStartDate());
        maintenance.setEndDate(maintenanceDTO.getEndDate());
        maintenance.setRiskLevel(maintenanceDTO.getRiskLevel());
        maintenance.setNotifications(maintenanceDTO.isNotifications());

        List<Zones> zonesList = new ArrayList<>();
        for (String zoneName : maintenanceDTO.getZones()) {
            Zones zones = new Zones();
            zones.setMaintenance(maintenance);
            zones.setZone(zoneName);
            zonesList.add(zones);
        }

        maintenance.setZones(zonesList);

        maintenanceRepository.save(maintenance);
        return maintenanceDTO;
    }

    public Page<Maintenance> getMaintenances (int page, int size, String type) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("startDate").ascending());
        return maintenanceRepository.findByRiskLevel(type, pageable);
    }
}
