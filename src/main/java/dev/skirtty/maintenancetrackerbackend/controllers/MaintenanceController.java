package dev.skirtty.maintenancetrackerbackend.controllers;

import dev.skirtty.maintenancetrackerbackend.dtos.MaintenanceDTO;
import dev.skirtty.maintenancetrackerbackend.entities.Maintenance;
import dev.skirtty.maintenancetrackerbackend.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenances/")
@RequiredArgsConstructor
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @PostMapping("add/")
    public ResponseEntity<MaintenanceDTO> add (@RequestBody MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceService.add((maintenanceDTO)));
    }

    @GetMapping("get/")
    public Page<Maintenance> getByType (@RequestParam String type, @RequestParam int page, @RequestParam int size) {
        return maintenanceService.getMaintenances(page, size, type);
    }
}
