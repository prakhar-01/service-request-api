package com.prakhar.servicerequest.repository;

import com.prakhar.servicerequest.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository
        extends JpaRepository<ServiceRequest, Long> {
}
