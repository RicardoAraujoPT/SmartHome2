package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HouseTest {


    @Test
    void createValidHouse() {

        //arrange
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";
        Location location = mock(Location.class);
        GPSCoordinates expectedGpsCoordinates = location.getGpsCoordinates();
        when(location.getAddress()).thenReturn(expectedAddress);
        when(location.getZipCode()).thenReturn(expectedZipCode);
        when(location.getGpsCoordinates()).thenReturn(expectedGpsCoordinates);

        //act
        House house = new House(location);
        String houseAddress = house.getLocation().getAddress();
        String houseZipCode = house.getLocation().getZipCode();
        GPSCoordinates houseGpsCoordinates = house.getLocation().getGpsCoordinates();

        //assert
        assertEquals(expectedAddress,houseAddress);
        assertEquals(expectedZipCode,houseZipCode);
        assertEquals(expectedGpsCoordinates,houseGpsCoordinates);

    }
}
