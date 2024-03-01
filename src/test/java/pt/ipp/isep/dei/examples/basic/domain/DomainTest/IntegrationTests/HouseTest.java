package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class HouseTest {

    @Test
    void shouldCreateValidHouse_validLocation() throws InstantiationException {
        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55.0;
        double longitude = 105.0;
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House myHouse = new House(factoryLocation,factoryRoom);
        Location houseLocation = myHouse.defineLocation(address,zipCode,latitude,longitude);

        //assert
        assertEquals(houseLocation.getZipCode(),zipCode);
        assertEquals(houseLocation.getAddress(),address);
        assertEquals(houseLocation.getGPSCoordinates().getLatitude(),latitude);
    }

    @Test
    void createHouseInvalidAddress_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = null;
        String zipCode = "zipcode";
        double latitude = 55.0;
        double longitude = 105.0;
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocation,factoryRoom).defineLocation(address,zipCode,latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidZipCode_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid address or ZIP code";
        String address = "address";
        String zipCode = "";
        double latitude = 55.0;
        double longitude = 105.0;
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocation,factoryRoom).defineLocation(address,zipCode,latitude,longitude));
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
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocation,factoryRoom).defineLocation(address,zipCode,latitude,longitude).defineGPSCoordinates(latitude,longitude));
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
        double longitude = -9000;
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(factoryLocation,factoryRoom).defineLocation(address,zipCode,latitude,longitude).defineGPSCoordinates(latitude,longitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }



    @Test
    void HouseWithoutRooms() throws InstantiationException {

        //arrange
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House myHouse = new House(factoryLocation,factoryRoom);
       ArrayList<Room> rooms = myHouse.getRoomList();

        //assert
        assertEquals(rooms.size(),0);
    }


    @Test
    void createAndAdd1ValidRoom() throws InstantiationException {

        //arrange
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House house = new House(factoryLocation,factoryRoom);
        ArrayList<Room> rooms = house.getRoomList();
        house.addRoom("name",2,40,5);
        ArrayList<Room> rooms1 = house.getRoomList();

        // assert
        assertEquals(0,rooms.size());
        assertEquals(1,rooms1.size());

    }

    @Test
    void createAndAdd2ValidRooms() throws InstantiationException {

        //arrange
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House house = new House(factoryLocation,factoryRoom);
        ArrayList<Room> rooms = house.getRoomList();
        house.addRoom("name",2,40,5);
        house.addRoom("name1",2,40,5);
        ArrayList<Room> rooms2 = house.getRoomList();

        // assert
        assertEquals(0,rooms.size());
        assertEquals(2,rooms2.size());
    }


    @Test
    void createInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid arguments";
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House house = new House(factoryLocation,factoryRoom);

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
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        //act
        House house = new House(factoryLocation,factoryRoom);
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
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        //act
        House house = new House(factoryLocation,factoryRoom);
        house.addRoom("bedroom", 1, 2, 3);
        house.addRoom("bathroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.getRoomByName("living room");
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));

    }

    @Test
    void getInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Room name doesn't exist in the list";
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        //act
        House house = new House(factoryLocation,factoryRoom);
        house.addRoom("bedroom", 1, 2, 3);
        house.addRoom("bathroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.getRoomByName(null);
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));

    }


    @Test
    void repeatedRoomName_ShouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Room name already exists";
        FactoryGPSCoordinates gpsCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(gpsCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        //act
        House house = new House(factoryLocation,factoryRoom);
        house.addRoom("bedroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    house.addRoom("bedroom", 1, 2, 3);
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


}
