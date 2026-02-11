package com.prakhar.servicerequest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceRequestCreateDto {

    @NotBlank
    private String customerName;

    @NotBlank
    private String serviceType;

    @NotBlank
    private String priority;

    private String assignedTo;
}
