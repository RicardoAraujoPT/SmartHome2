package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HouseTest {

    @Test
    void shouldCreateValidHouse() throws InstantiationException {

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

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        House house = new House(factoryLocationsDouble,factoryRoomDouble,expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude);

        //assert
        assertEquals(house.getLocation().getAddress(),expectedAddress);
        assertEquals(house.getLocation().getZipCode(),expectedZipCode);
        assertEquals(house.getLocation().getGpsCoordinates().getLatitude(),expectedLatitude);
        assertEquals(house.getLocation().getGpsCoordinates().getLatitude(),expectedLatitude);
    }


    @Test
    void shouldCreateAndAddRoomInHouseRoomList() throws InstantiationException {

        //arrange
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";

        String roomName = "name";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        Location locationDouble = mock(Location.class);
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);

        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude)).thenReturn(locationDouble);

        when(locationDouble.getGpsCoordinates()).thenReturn(gpsCoordinatesDouble);
        when(locationDouble.getGpsCoordinates().getLatitude()).thenReturn(expectedLatitude);
        when(locationDouble.getGpsCoordinates().getLongitude()).thenReturn(expectedLongitude);
        when(locationDouble.getAddress()).thenReturn(expectedAddress);
        when(locationDouble.getZipCode()).thenReturn(expectedZipCode);

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        ArrayList<Room> rooms = mock(ArrayList.class);
        when(factoryRoomDouble.initRooms()).thenReturn(rooms);

        //act + assert
        House house = new House(factoryLocationsDouble,factoryRoomDouble,expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude);

        house.createRoom(roomName,floorNumber, area, height);

        verify(rooms).add(any(Room.class));
    }

    @Test
    void createAndAddInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange

        String expected = "Invalid arguments";
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";

        String roomName = null;
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        Location locationDouble = mock(Location.class);

        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude)).thenReturn(locationDouble);

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom(roomName,floorNumber,area,height)).thenReturn(roomDouble).thenThrow(new InstantiationException(expected));

        //act + assert
        House house = new House(factoryLocationsDouble, factoryRoomDouble, expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude);

        Exception exception = assertThrows(InstantiationException.class, () ->
                house.createRoom(roomName,floorNumber,area,height)
        );

        // assert
        String actualMessage = exception.getMessage();

        // assert
        assertTrue(actualMessage.contains(expected));
        assertEquals(house.getRoomList().size(), 0);

    }




    @Test
    void shouldGetHouseRooms_HouseWithoutRooms() throws InstantiationException {

        // arrange
        double latitude = 53;
        double longitude = 100;
        String address = "address";
        String zipCode = "zipCode";

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);

        House house = new House(factoryLocationDouble, factoryRoomDouble,address,zipCode,latitude,longitude);

        // act
        List<Room> listRooms = house.getRoomList();

        // assert
        assertEquals(listRooms.size(), 0);


    }







}
