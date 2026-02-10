package com.prakhar.servicerequest.service;

import com.prakhar.servicerequest.entity.ServiceRequest;

import java.util.List;

public interface ServiceRequestService {

    ServiceRequest create(ServiceRequest request);

    ServiceRequest getById(Long id);

    List<ServiceRequest> getAll();

    ServiceRequest updateStatus(Long id, String status);

    void delete(Long id);
}
