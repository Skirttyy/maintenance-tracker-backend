package dev.skirtty.maintenancetrackerbackend.dtos;

import dev.skirtty.maintenancetrackerbackend.entities.Zones;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MaintenanceDTO {

    private Long id;
    private String name;
    private String type;
    private String provider;
    private String comments;
    private Long affectedClients;
    private List<String> zones;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String riskLevel;
    private boolean notifications;
}
