package dev.skirtty.maintenancetrackerbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String provider;
    private String comments;

    @JoinColumn(name = "affected_clients")
    private Long affectedClients;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Zones> zones = new ArrayList<>();

    @JoinColumn(name = "start_date")
    private LocalDateTime startDate;

    @JoinColumn(name = "end_date")
    private LocalDateTime endDate;

    @JoinColumn(name = "risk_level")
    private String riskLevel;

    private boolean notifications;
}
