package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HouseTest {


    @Test
    void shouldCreateValidHouse_validLocation() throws InstantiationException {
        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55.0;
        double longitude = 105.0;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        when(locationDouble.getZipCode()).thenReturn(zipCode);
        when(locationDouble.getAddress()).thenReturn(address);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        House myHouse = new House(factoryLocationDouble,factoryRoomDouble);
        Location houseLocation = myHouse.defineLocation(address,zipCode,latitude,longitude);

        //assert
        assertEquals(houseLocation.getZipCode(),zipCode);
        assertEquals(houseLocation.getAddress(),address);
    }

    @Test
    void shouldCreateValidHouse_validGPS() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55.0;
        double longitude = 105.0;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.createLocation(address,zipCode,latitude,longitude)).thenReturn(locationDouble);

        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);

        when(factoryGPSCoordinatesDouble.createGPSCoordinates(latitude,longitude)).thenReturn(gpsCoordinatesDouble);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        when(locationDouble.getZipCode()).thenReturn(zipCode);
        when(locationDouble.getAddress()).thenReturn(address);
        when(locationDouble.getGPSCoordinates()).thenReturn(gpsCoordinatesDouble);
        when(locationDouble.getGPSCoordinates().getLatitude()).thenReturn(latitude);
        when(locationDouble.getGPSCoordinates().getLongitude()).thenReturn(longitude);

        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        House myHouse = new House(factoryLocationDouble,factoryRoomDouble);
        Location houseLocation = myHouse.defineLocation(address,zipCode,latitude,longitude);


        //assert
        assertEquals(houseLocation.getGPSCoordinates().getLatitude(),latitude);
        assertEquals(houseLocation.getGPSCoordinates().getLongitude(),longitude);
    }

    @Test
    void houseInvalidAddress_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = null;
        String zipCode = "zipcode";
        double latitude = 55.0;
        double longitude = 105.0;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenThrow(new InstantiationException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocationDouble,factoryRoomDouble).defineLocation(address,zipCode,latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidZipCode_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = "address";
        String zipCode = null;
        double latitude = 55.0;
        double longitude = 105.0;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenThrow(new InstantiationException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocationDouble,factoryRoomDouble).defineLocation(address,zipCode,latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidLatitude_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid GPS coordinates";
        String address = "address";
        String zipCode = "zipcode";
        double latitude = -800;
        double longitude = 105.0;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenThrow(new InstantiationException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocationDouble,factoryRoomDouble).defineLocation(address,zipCode,latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidLongitude_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid GPS coordinates";
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 6000;

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenThrow(new InstantiationException(expected));
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocationDouble,factoryRoomDouble).defineLocation(address,zipCode,latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    void HouseWithoutRooms() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        House myHouse = new House(factoryLocationDouble,factoryRoomDouble);
        ArrayList<Room> rooms = myHouse.getRoomList();

        //assert
        assertEquals(rooms.size(),0);
    }


    @Test
    void createAndAdd1ValidRoom() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble);
        ArrayList<Room> rooms = house.getRoomList();
        house.addRoom("name",2,40,5);
        ArrayList<Room> rooms1 = house.getRoomList();

        // assert
        assertEquals(0,rooms.size());
        assertEquals(1,rooms1.size());

    }

    @Test
    void createAndAdd2ValidRooms() throws InstantiationException {

        // arrange
        Room roomDouble1 = mock(Room.class);
        Room roomDouble2 = mock(Room.class);

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        when(factoryRoomDouble.createRoom("Living Room1", 0, 10, 9)).thenReturn(roomDouble1);
        when(factoryRoomDouble.createRoom("Living Room2", 0, 10, 9)).thenReturn(roomDouble2);
        when(roomDouble1.getRoomName()).thenReturn("Living Room1");

        House house = new House(factoryLocationDouble, factoryRoomDouble);

        // act
        house.addRoom("Living Room1", 0, 10, 9);
        house.addRoom("Living Room2", 0, 10, 9);

        // assert
        assertEquals(house.getRoomList().size(), 2);
    }


    @Test
    void createInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid arguments";
        String address = "address";
        String zipCode = "zipcode";

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        when(factoryRoomDouble.createRoom(null,2,40,5)).thenThrow(new InstantiationException(expected));

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble);

        Exception exception = assertThrows(InstantiationException.class, ()
                -> {
            house.addRoom(null,2,40,5);
        });

        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    void testGetRoomByName() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom("bedroom",1,2,3)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn("bedroom");

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble);
        house.addRoom("bedroom", 1, 2, 3);
        house.addRoom("bathroom", 1, 2, 3);
        String expected = house.getRoomList().get(0).getRoomName();
        String result = house.getRoomByName("bedroom").getRoomName();

        //assert
        assertEquals(expected, result);

    }

    @Test
    void getInexistentRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Room name doesn't exist in the list";
        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        Room roomDouble = mock(Room.class);
        when(factoryRoomDouble.createRoom("living room",1,2,3)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenThrow(new IllegalArgumentException(expected));

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.getRoomByName("living room").getRoomName();
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));

    }

    @Test
    void repeatedRoomName_ShouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Room name already exists";
        String address = "address";
        String zipCode = "zipcode";

        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        Location locationDouble = mock(Location.class);
        when(factoryLocationDouble.defineLocation(address,zipCode)).thenReturn(locationDouble);
        FactoryRoom factoryRoomDouble = mock(FactoryRoom.class);
        when(factoryRoomDouble.createRoom("living room",2,40,5)).thenThrow(new InstantiationException(expected));

        //act
        House house = new House(factoryLocationDouble,factoryRoomDouble);

        Exception exception = assertThrows(InstantiationException.class, ()
                -> {
            house.addRoom("living room",2,40,5);
        });

        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

}
