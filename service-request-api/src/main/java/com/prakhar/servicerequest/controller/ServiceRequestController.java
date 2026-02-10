package com.prakhar.servicerequest.controller;

import com.prakhar.servicerequest.dto.ServiceRequestCreateDto;
import jakarta.validation.Valid;
import com.prakhar.servicerequest.entity.ServiceRequest;
import com.prakhar.servicerequest.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService service;

    @PostMapping
    public ServiceRequest create(@Valid @RequestBody ServiceRequestCreateDto dto) {

        ServiceRequest req = ServiceRequest.builder()
                .customerName(dto.getCustomerName())
                .serviceType(dto.getServiceType())
                .priority(dto.getPriority())
                .assignedTo(dto.getAssignedTo())
                .build();

        return service.create(req);
    }


    @GetMapping("/{id}")
    public ServiceRequest getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ServiceRequest> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public ServiceRequest updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
