package com.prakhar.servicerequest.service;

import com.prakhar.servicerequest.entity.ServiceRequest;
import com.prakhar.servicerequest.repository.ServiceRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRequestServiceImpl implements ServiceRequestService {

    private final ServiceRequestRepository repository;

    @Override
    public ServiceRequest create(ServiceRequest request) {
        request.setStatus("OPEN");
        request.setCreatedAt(LocalDateTime.now());
        return repository.save(request);
    }

    @Override
    public ServiceRequest getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Request not found"));
    }

    @Override
    public List<ServiceRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public ServiceRequest updateStatus(Long id, String status) {
        ServiceRequest r = getById(id);
        r.setStatus(status);
        r.setUpdatedAt(LocalDateTime.now());
        return repository.save(r);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
