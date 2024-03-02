package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class HouseTest {


    /**
     * Test to ensure that a valid house with a valid location can be created successfully.
     * This test checks if the house's location is correctly defined with the provided parameters.
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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

    /**
     * Test to ensure that attempting to create a house with an invalid address results in an exception.
     * The test checks if InstantiationException is thrown with the expected error message.
     *
     * @throws InstantiationException If an attempt to create a house with an invalid address is made.
     */
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

    /**
     * Test to ensure that attempting to create a house with an invalid zipCode results in an exception.
     * The test checks if InstantiationException is thrown with the expected error message.
     *
     * @throws InstantiationException If an attempt to create a house with an invalid zipCode is made.
     */
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

    /**
     * Test to ensure that attempting to create a house with an invalid latitude results in an exception.
     * The test checks if InstantiationException is thrown with the expected error message.
     *
     * @throws InstantiationException If an attempt to create a house with an invalid latitude is made.
     */
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

    /**
     * Test to ensure that attempting to create a house with an invalid longitude results in an exception.
     * The test checks if InstantiationException is thrown with the expected error message.
     *
     * @throws InstantiationException If an attempt to create a house with an invalid longitude is made.
     */
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


    /**
     * Test to verify that a house without rooms is created successfully.
     * The test checks if the list of rooms in the house is empty after instantiation.
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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

    /**
     * Test to ensure that a valid room can be created and added to a house successfully.
     * The test checks if the number of rooms in the house increases by one after adding a valid room.
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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


    /**
     * Test to ensure that a valid room can be created and added to a house successfully.
     * The test checks if the number of rooms in the house increases by two after adding 2 valid rooms.
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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

    /**
     * Test to ensure that attempting to create an invalid room (with null name) results in an exception.
     * The test checks if InstantiationException is thrown with the expected error message.
     *
     * @throws InstantiationException If an attempt to create an invalid room is made.
     */
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

    /**
     * Test to verify the functionality of retrieving a room by its name.
     * The test checks if the correct room is obtained by calling the getRoomByName method.
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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

    /**
     * Test to verify that attempting to get a non-existent room by name results in an exception.
     * The test checks if IllegalArgumentException is thrown with the expected error message.
     *
     * This test sets up a house with existing rooms, adds "bedroom" and "bathroom" to the house.
     * It then attempts to retrieve a room named "living room," which does not exist in the list of rooms.
     * The test expects an IllegalArgumentException to be thrown with the error message "Room name doesn't exist in the list."
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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

    /**
     * Test case to verify that attempting to get a room with a null name results in an exception.
     * The test checks if IllegalArgumentException is thrown with the expected error message.
     *
     * This test sets up a house with existing rooms, adds "bedroom" and "bathroom" to the house.
     * It then attempts to retrieve a room with a null name, which is an invalid argument.
     * The test expects an IllegalArgumentException to be thrown with the error message "Room name doesn't exist in the list."
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */
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


    /**
     * Test case to verify that attempting to add a room with a repeated name results in an exception.
     * The test checks if IllegalArgumentException is thrown with the expected error message.
     *
     * This test sets up a house with an existing room named "bedroom."
     * It then attempts to add another room with the same name ("bedroom").
     * The test expects an IllegalArgumentException to be thrown with the error message "Room name already exists."
     *
     * @throws InstantiationException If there is an issue with instantiating the required factory objects.
     */

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
