package com.assignment.transport.repository;

import com.assignment.transport.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Load, Long> {

    public List<Load> findAllByShipperId(String shipperId);

}
