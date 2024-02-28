package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HouseTest {


    /**
     *Tests the instantiation of House objects, passing correct arguments in the constructor method.
     */
    @Test
    void shouldCreateValidHouse_ShouldNotThrowException() {

        //arrange
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        Location locationDouble = mock(Location.class);
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);

        when(locationDouble.getGPSCoordinates()).thenReturn(gpsCoordinatesDouble);
        when(locationDouble.getGPSCoordinates().getLatitude()).thenReturn(expectedLatitude);
        when(locationDouble.getGPSCoordinates().getLongitude()).thenReturn(expectedLongitude);
        when(locationDouble.getAddress()).thenReturn(expectedAddress);
        when(locationDouble.getZipCode()).thenReturn(expectedZipCode);

        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude)).thenReturn(locationDouble);

        //act
        House house = new House(factoryLocationsDouble,factoryRoomDouble,expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude);

        //assert
        assertEquals(house.getLocation().getAddress(),expectedAddress);
        assertEquals(house.getLocation().getZipCode(),expectedZipCode);
        assertEquals(house.getLocation().getGPSCoordinates().getLatitude(),expectedLatitude);
        assertEquals(house.getLocation().getGPSCoordinates().getLatitude(),expectedLatitude);
    }

    /**
     *Tests the instantiation of House objects, passing invalid address in the constructor method.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void invalidHouseAddress_ShouldThrowException() throws IllegalArgumentException{

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = null;
        double latitude = 53;
        double longitude = 100;
        String zipCode = "zipCode";
        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(address,zipCode,latitude,longitude)).thenThrow(new IllegalArgumentException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new House(factoryLocationsDouble,factoryRoomDouble,address,zipCode,latitude,longitude));

        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    /**
     *Tests the instantiation of House objects, passing invalid latitude in the constructor method.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void invalidHouseLatitude_ShouldThrowException() throws IllegalArgumentException{

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = "address";
        double latitude = -500;
        double longitude = 100;
        String zipCode = "zipCode";
        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(address,zipCode,latitude,longitude)).thenThrow(new IllegalArgumentException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new House(factoryLocationsDouble,factoryRoomDouble,address,zipCode,latitude,longitude));

        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    /**
     *Tests the instantiation of Room objects and add it to a list (passing correct arguments in the constructor method)
     *Tests the functionality of addRoom() method of House objects.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void shouldCreateAndAddRoomInHouseRoomList() throws InstantiationException {

        //arrange
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";
        String name = "name";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        Location locationDouble = mock(Location.class);
        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        when(factoryLocationDouble.createLocation(expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude)).thenReturn(locationDouble);

        Room roomDouble = mock(Room.class);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        when(factoryRoomDouble.createRoom(name,floorNumber,area,height)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn("name");

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble,expectedAddress,expectedZipCode,expectedLatitude,expectedLongitude);
        String roomName = house.addRoom(name,floorNumber, area, height).getRoomName();
        //assert
        assertEquals(roomName,"name");

    }

    /**
     *Tests the instantiation of Room objects and add it to a list (passing invalid name in the constructor method).
     *Tests the functionality of addRoom() method of House objects.
     *
     * @throws InstantiationException
     */
    @Test
    void createAndAddInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange

        String expected = "Invalid arguments";
        double expectedLatitude = 53;
        double expectedLongitude = 100;
        String expectedAddress = "address";
        String expectedZipCode = "zipCode";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        Location locationDouble = mock(Location.class);

        FactoryLocation factoryLocationsDouble = mock(FactoryLocation.class);
        when(factoryLocationsDouble.createLocation(expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude)).thenReturn(locationDouble);

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        when(factoryRoomDouble.createRoom(null,floorNumber,area,height)).thenThrow(new InstantiationException(expected));

        //act
        House house = new House(factoryLocationsDouble, factoryRoomDouble, expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude);
        Exception exception = assertThrows(InstantiationException.class, () ->
                house.addRoom(null,floorNumber,area,height) );

        // assert

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));

    }

    /**
     * Tests the functionality of getRoomList() method of House objects.
     *
     */
    @Test
    void shouldGetHouseRooms_HouseWithoutRooms() {

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

    /**
     *Tests the instantiation of Room objects and add it to a list (passing invalid name in the constructor method).
     *Tests the functionality of getRoomByName() method of House objects.
     * Tests the instantiation of House objects, passing correct arguments in the constructor method.
     */
    @Test
    void shouldGetHouseRoomByName() throws InstantiationException {

        // arrange
        double latitude = 53;
        double longitude = 100;
        String address = "address";
        String zipCode = "zipCode";
        String name = "name";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom(name,floorNumber,area,height)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn("name");

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);

        //act
        House house = new House(factoryLocationDouble, factoryRoomDouble,address,zipCode,latitude,longitude);
        house.addRoom(name,floorNumber,area,height);
        house.getRoomByName("name");

        // assert
        assertEquals(house.getRoomByName("name").getRoomName(),"name");

    }

    /**
     *Tests the instantiation of Room objects and add it to a list (passing correct arguments in the constructor method)
     *Tests the functionality of addRoom() method of House objects.
     *Tests the functionality of getRoomByName() method of House objects, when the name of the room we are looking for does not exist in the list.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void houseGetRoomInvalidName_ShouldThrowException() throws InstantiationException {

        // arrange
        String expected = "Room name doesn't exist in the list";
        double latitude = 53;
        double longitude = 100;
        String address = "address";
        String zipCode = "zipCode";
        String name = "name";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom(name, floorNumber, area, height)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn("name");

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);

        //act
        House house = new House(factoryLocationDouble, factoryRoomDouble, address, zipCode, latitude, longitude);
        house.addRoom(name, floorNumber, area, height);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.getRoomByName("living room");
                });

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    /**
     *Tests the instantiation of Room objects and add it to a list (passing correct arguments in the constructor method)
     *Tests the functionality of addRoom() method of House objects, when the name of the room we want to add already exists in the list.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void addRoomDuplicatedName_ShouldThrowException() throws InstantiationException {

        // arrange
        String expected = "Room name already exists";
        double latitude = 53;
        double longitude = 100;
        String address = "address";
        String zipCode = "zipCode";
        String name = "name";
        int floorNumber = 1;
        double area = 2.4;
        double height = 1.5;

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom(name, floorNumber, area, height)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn("name");

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);

        //act
        House house = new House(factoryLocationDouble, factoryRoomDouble, address, zipCode, latitude, longitude);
        house.addRoom(name, floorNumber, area, height);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.addRoom(name, floorNumber, area, height);
                });

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

}
