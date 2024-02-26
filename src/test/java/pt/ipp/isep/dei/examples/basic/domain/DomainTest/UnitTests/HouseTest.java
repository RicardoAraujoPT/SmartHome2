package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HouseTest {

    @Test
    void createValidHouse() {

        //arrange
        double expectedLatitude = 53;
        double expectedLongitude = 100;

        String expectedAddress = "address";
        String expectedZipCode = "zipCode";

        Location locationDouble = mock(Location.class);
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);

       FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
       when(factoryLocationsDouble.createLocation(expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude)).thenReturn(locationDouble);

        when(locationDouble.getGpsCoordinates()).thenReturn(gpsCoordinatesDouble);
        when(locationDouble.getGpsCoordinates().getLatitude()).thenReturn(expectedLatitude);
        when(locationDouble.getGpsCoordinates().getLongitude()).thenReturn(expectedLongitude);
        when(locationDouble.getAddress()).thenReturn(expectedAddress);
        when(locationDouble.getZipCode()).thenReturn(expectedZipCode);

        //act
        House house = new House(locationDouble);
        String houseAddress = house.getLocation().getAddress();
        String houseZipCode = house.getLocation().getZipCode();
        double houseLatitude = house.getLocation().getGpsCoordinates().getLatitude();
        double houseLongitude = house.getLocation().getGpsCoordinates().getLongitude();

        //assert
        assertEquals(expectedLatitude,houseLatitude);
        assertEquals(expectedLongitude,houseLongitude);
        assertEquals(expectedAddress,houseAddress);
        assertEquals(expectedZipCode,houseZipCode);
    }


    @Test
    void createHouseInvalidAddressShouldThrowException() {

        //arrange

        String expected = "Invalid location";
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = null;
        String expectedZipCode = "zipCode";

        Location locationDouble = mock(Location.class);

        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude)).thenReturn(locationDouble);

        //act
        Exception exception = assertThrows(
                IllegalArgumentException.class, ()
                        -> new House(locationDouble));

        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }





}
