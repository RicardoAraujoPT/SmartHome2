package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseTest {

    @Test
    void shouldCreateValidHouse() throws InstantiationException {
        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;

        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        String houseAddress = myHouse.getLocation().getAddress();
        double houseLatitude = myHouse.getLocation().getGPSCoordinates().getLatitude();
        double houseLongitude = myHouse.getLocation().getGPSCoordinates().getLongitude();
        String houseZipCode = myHouse.getLocation().getZipCode();
        //assert
        assertEquals("address", houseAddress);
        assertEquals("zipcode", houseZipCode);
        assertEquals(55, houseLatitude);
        assertEquals(105, houseLongitude);
    }

    @Test
    void createHouseInvalidAddress_ShouldThrowException() {

        //arrange
        String expected = "Invalid address or ZIP code";
        String houseZipCode = "zipCode";
        double houseLatitude = 55;
        double houseLongitude = 100;
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(null, houseZipCode, houseLatitude, houseLongitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    void createHouseInvalidZipCode_ShouldThrowException() {

        //arrange
        String expected = "Invalid address or ZIP code";
        String houseAddress = "address";
        double houseLatitude = 55;
        double houseLongitude = 100;
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(houseAddress, null, houseLatitude, houseLongitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidLatitude_ShouldThrowException() {

        //arrange
        String expected = "Invalid GPS coordinates";
        String houseAddress = "address";
        String houseZipCode = "zipCode";
        double houseLongitude = 100;
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(houseAddress, houseZipCode, -180, houseLongitude));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    void createHouseInvalidLongitude_ShouldThrowException() {

        //arrange
        String expected = "Invalid GPS coordinates";
        String houseAddress = "address";
        String houseZipCode = "zipCode";
        double houseLatitude = 55;
        //act
        Exception exception = assertThrows(
                InstantiationException.class, ()
                        -> new House(houseAddress, houseZipCode, houseLatitude, 300));
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    void HouseWithoutRooms() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        List<Room> listRooms = myHouse.getRoomList();
        // assert
        assertEquals(listRooms.size(), 0);
    }

    @Test
    void create1ValidRoom() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        int roomListSize = myHouse.getRoomList().size();
        // assert
        assertEquals(1, roomListSize);
    }

    @Test
    void create2ValidRooms() throws InstantiationException {

        //arrange
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        myHouse.createRoom("bathroom", 1, 2, 3);
        int roomListSize = myHouse.getRoomList().size();
        // assert
        assertEquals(2, roomListSize);
    }

    @Test
    void createInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Invalid arguments";
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        int floorNumber = 1;
        double roomArea = 25;
        double roomHeight = 2.5;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        Exception exception = assertThrows(InstantiationException.class, ()
                -> {
            myHouse.createRoom(null, floorNumber, roomArea, roomHeight);
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
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        myHouse.createRoom("bathroom", 1, 2, 3);
        String expected = myHouse.getRoomList().get(0).getRoomName();
        String result = myHouse.getRoomByName("bedroom").getRoomName();

        //assert
        assertEquals(expected, result);

    }

    @Test
    void getInexistentRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Room name doesn't exist in the list";
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        myHouse.createRoom("bathroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myHouse.getRoomByName("living room");
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));

    }

    @Test
    void getInvalidRoom_ShouldThrowException() throws InstantiationException {

        //arrange
        String expected = "Room name doesn't exist in the list";
        String address = "address";
        String zipCode = "zipcode";
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        myHouse.createRoom("bathroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myHouse.getRoomByName(null);
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
        double latitude = 55;
        double longitude = 105;
        //act
        House myHouse = new House(address, zipCode, latitude, longitude);
        myHouse.createRoom("bedroom", 1, 2, 3);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myHouse.createRoom("bedroom", 1, 2, 3);
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


}
