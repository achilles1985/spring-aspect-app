package com.example.aspect.service;

import com.example.aspect.model.Shipwreck;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ShipwreckServiceTest {

    @Autowired
    private ShipwreckService shipwreckService;

    @Test
    public void shouldSaveNewShipwreck() throws Exception {
        // given
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setName("name1");
        shipwreck.setCondition("some conditions");
        shipwreck.setYearDiscovered(1980);

        // when
        shipwreckService.saveShipwreck(shipwreck);
        List<Shipwreck> actualShipwrecks = shipwreckService.findAllShipwrecks();

        // then
        Assertions.assertThat(actualShipwrecks).size().isEqualTo(1);
        Assertions.assertThat(actualShipwrecks).contains(shipwreck);
    }

    @Test
    public void shouldDeleteEntity() {
        // given
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setName("name1");
        shipwreck.setCondition("some conditions");
        shipwreck.setYearDiscovered(1980);

        shipwreckService.saveShipwreck(shipwreck);
        List<Shipwreck> actualShipwrecks = shipwreckService.findAllShipwrecks();
        Assertions.assertThat(actualShipwrecks).size().isEqualTo(1);
        Assertions.assertThat(actualShipwrecks).contains(shipwreck);

        shipwreckService.deleteShipwreck(actualShipwrecks.get(0).getId());
        List<Shipwreck> actualShipwrecksAfterDeletion = shipwreckService.findAllShipwrecks();
        Assertions.assertThat(actualShipwrecksAfterDeletion).size().isEqualTo(0);

    }

}