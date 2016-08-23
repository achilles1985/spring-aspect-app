package com.example.aspect.controller;

import com.example.aspect.model.Shipwreck;
import com.example.aspect.service.ShipwreckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {

    @Autowired
    private ShipwreckService shipwreckService;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> getAllShipwrecks() {
        return shipwreckService.findAllShipwrecks();
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck getShipwreck(@PathVariable long id) {
        return shipwreckService.findShipwreckById(id);
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck createShipwreck(@RequestBody Shipwreck shipwreck) {
        return shipwreckService.saveShipwreck(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck deleteShipwreck(@PathVariable long id) {
        return shipwreckService.deleteShipwreck(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck updateShipwreck(@PathVariable long id, @RequestBody Shipwreck shipwreck) {
       return shipwreckService.updateShipwreck(id, shipwreck);
    }
}
