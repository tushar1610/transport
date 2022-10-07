package com.assignment.transport.service;

import com.assignment.transport.entity.Load;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransportService {
    String saveLoad(Load payload);

    List<Load> getLoadList(String shipperId);

    Load getLoadByLoadId(Long loadId);

    Load updateLoadByLoadId(Long loadId, Load payload);

    void deleteLoadByLoadId(Long loadId);
}
