package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US02CreateRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US06GetDevicesOfASpecificRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Test class for the US06GetDevicesOfASpecificRoomController.
 * It tests the functionality of retrieving devices of a specific room in a smart home system.
 * It includes the following tests:
 *  - validHouse_shouldInstantiateValidHouse
 *  - nullHouse_shouldThrowExceptionWhenHouseIsNull
 *  -  roomWithoutDevices_shouldReturnEmptyListOfDevices
 *  - roomWithTwoDevices_shouldReturnListOfTwoDevicesOfSpecificRoom
 */
public class US06GetDevicesOfASpecificRoomControllerTest {

    /**
     * Test case for the US06GetDevicesOfASpecificRoomController constructor.
     * The test setup involves creating a mock House object.
     * This test verifies if a new instance of US06GetDevicesOfASpecificRoomController can be created with a valid
     * House object.
     */
    @Test
    void validHouse_shouldInstantiateValidHouse() {
        // Arrange
        House house = mock(House.class);
        // Act
        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);
        // Assert
        assertNotNull(controller);
    }

    /**
     * Test case to verify if an exception is thrown when a null House object is provided.
     */
    @Test
    void nullHouse_shouldThrowExceptionWhenHouseIsNull() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new US06GetDevicesOfASpecificRoomController(null));
    }

    /**
     * The test verifies that the method correctly returns an empty list when the room has no devices.
     * The test setup involves creating a mock House object with a single Room, but without any Devices using Factory
     * classes.
     *
     * @throws InstantiationException if the creation of the Room object fails.
     */
    @Test
    void roomWithoutDevices_shouldReturnEmptyListOfDevices() throws InstantiationException {
        // Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        FactoryLocation factoryLocation = new FactoryLocation();

        House house = new House(factoryLocation, factoryRoom);
        Room myRoom = house.addRoom("ChosenRoom", 1, 20.0, 3.0);

        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(myRoom.getRoomName());

        // Assert
        assertTrue(result.isEmpty());
    }


    /**
     * The test verifies that the method correctly returns a list of two devices when the provided room has two devices.
     * The test setup involves creating a House object with a single Room and two Devices using Factory classes.
     *
     * @throws InstantiationException if the creation of the Room or Device objects fails.
     */
    @Test
    void roomWithTwoDevices_shouldReturnListOfTwoDevicesOfSpecificRoom() throws InstantiationException {
        // Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        FactoryLocation factoryLocation = new FactoryLocation();

        House house = new House(factoryLocation, factoryRoom);
        Room myRoom = house.addRoom("ChosenRoom", 1, 20.0, 3.0);

        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        Device device1 = myRoom.addDevice("Device 1");
        Device device2 = myRoom.addDevice("Device 2");

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(myRoom.getRoomName());

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device1.getDeviceName())));
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device2.getDeviceName())));
    }
}