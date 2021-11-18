package com.example.parkshark;

import com.example.parkshark.controller.DivisionController;
import com.example.parkshark.controller.ParkinglotController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParkSharkApplicationTests {

    @Test
    void contextLoads() {
    }

    private DivisionController divisionController;
    private ParkinglotController parkinglotController;

    @Autowired

    public ParkSharkApplicationTests(DivisionController divisionController, ParkinglotController parkinglotController) {
        this.divisionController = divisionController;
        this.parkinglotController = parkinglotController;
    }

    @Test
    void areAllRelevantBeansAvailable(){
        Assertions.assertThat(divisionController).isNotNull();
        Assertions.assertThat(parkinglotController).isNotNull();
    }
}
