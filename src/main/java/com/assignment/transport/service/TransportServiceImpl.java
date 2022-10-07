package com.assignment.transport.service;

import com.assignment.transport.entity.Load;
import com.assignment.transport.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TransportServiceImpl implements TransportService{

    @Autowired
    private TransportRepository transportRepository;

    @Override
    public String saveLoad(Load payload) {
        Load load = Load.builder()
                .loadingPoint(payload.getLoadingPoint())
                .unloadingPoint(payload.getUnloadingPoint())
                .productType(payload.getProductType())
                .truckType(payload.getTruckType())
                .noOfTrucks(payload.getNoOfTrucks())
                .weight(payload.getWeight())
                .date(payload.getDate()).build();
        if (payload.getShipperId() == null){
            load.setShipperId("shipper:" + UUID.randomUUID());
        } else {
            load.setShipperId(payload.getShipperId());
        }
        if (payload.getComment() == null){
            load.setComment("");
        } else {
            load.setComment(payload.getComment());
        }
        transportRepository.save(load);

        return "loads details added successfully";
    }

    @Override
    public List<Load> getLoadList(String shipperId) {
        return transportRepository.findAllByShipperId(shipperId);
    }

    @Override
    public Load getLoadByLoadId(Long loadId) {
        return transportRepository.findById(loadId).get();
    }

    @Override
    public Load updateLoadByLoadId(Long loadId, Load payload) {
        Load oldLoad = transportRepository.findById(loadId).get();
        if (Objects.nonNull(oldLoad.getLoadingPoint()) && !oldLoad.getLoadingPoint().equalsIgnoreCase(payload.getLoadingPoint())){
            oldLoad.setLoadingPoint(payload.getLoadingPoint());
        }
        if (Objects.nonNull(oldLoad.getUnloadingPoint()) && !oldLoad.getUnloadingPoint().equalsIgnoreCase(payload.getUnloadingPoint())){
            oldLoad.setUnloadingPoint(payload.getUnloadingPoint());
        }
        if (Objects.nonNull(oldLoad.getProductType()) && !oldLoad.getProductType().equalsIgnoreCase(payload.getProductType())){
            oldLoad.setProductType(payload.getProductType());
        }
        if (Objects.nonNull(oldLoad.getTruckType()) && !oldLoad.getTruckType().equalsIgnoreCase(payload.getTruckType())){
            oldLoad.setTruckType(payload.getTruckType());
        }
        if (oldLoad.getNoOfTrucks() != payload.getNoOfTrucks()){
            oldLoad.setNoOfTrucks(payload.getNoOfTrucks());
        }
        if (oldLoad.getWeight() != payload.getWeight()){
            oldLoad.setWeight(payload.getWeight());
        }
        if (Objects.nonNull(oldLoad.getComment()) && !oldLoad.getComment().equalsIgnoreCase(payload.getComment())){
            oldLoad.setComment(payload.getComment());
        }
        if (Objects.nonNull(oldLoad.getDate()) && !oldLoad.getDate().equals(payload.getDate())){
            oldLoad.setDate(payload.getDate());
        }

        return transportRepository.save(oldLoad);

    }

    @Override
    public void deleteLoadByLoadId(Long loadId) {
        transportRepository.deleteById(loadId);
    }
}
