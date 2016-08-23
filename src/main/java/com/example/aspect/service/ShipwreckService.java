package com.example.aspect.service;

import com.example.aspect.model.Shipwreck;
import com.example.aspect.repository.ShipwrecksRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShipwreckService {

    @Autowired
    private ShipwrecksRepository shipwrecksRepository;

    public List<Shipwreck> findAllShipwrecks() {
        return shipwrecksRepository.findAll();
    }

    public Shipwreck findShipwreckById(long id) {
        return shipwrecksRepository.findOne(id);
    }

    public Shipwreck saveShipwreck(Shipwreck shipwreck) {
        return shipwrecksRepository.saveAndFlush(shipwreck);
    }

    public Shipwreck deleteShipwreck(long id) {
        Shipwreck existingShipwreck = shipwrecksRepository.findOne(id);
        shipwrecksRepository.delete(existingShipwreck);
        return existingShipwreck;
    }

    public Shipwreck updateShipwreck(long id, Shipwreck shipwreck) {
        Shipwreck existingShipwreck = shipwrecksRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        shipwrecksRepository.saveAndFlush(existingShipwreck);
        return existingShipwreck;
    }
}
