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
 * This class contains tests for the GetDevicesOfASpecificRoomController class.
 * It tests the functionality of getting devices of a specific room in a smart home system.
 */
public class US06GetDevicesOfASpecificRoomControllerTest {

    /**
     * Test case for the US06GetDevicesOfASpecificRoomController constructor.
     * The test setup involves creating a mock House object.
     * The test then calls the US06GetDevicesOfASpecificRoomController constructor with the mock House object and
     * asserts that the returned object is not null.
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
     * The test then calls the getDevicesOfASpecificRoom method with the name of the created room and asserts that the
     * returned list is empty.
     *
     * @throws InstantiationException if the creation of the Room object fails.
     */
    @Test
    void roomWithoutDevices_shouldReturnEmptyListOfDevices() throws InstantiationException {
        // Arrange

        FactoryRoom factoryRoom = mock (FactoryRoom.class);
        FactoryLocation factoryLocation = mock (FactoryLocation.class);

        House house = new House(factoryLocation, factoryRoom,"address", "zipCode", 55.2, -2.25);
        Room roomDTO = house.createRoom("ChosenRoom", 1, 20.0, 3.0);

        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO.getRoomName());

        // Assert
        assertTrue(result.isEmpty());
    }


    /**
     * The test verifies that the method correctly returns a list of two devices when the provided room has two devices.
     * The test setup involves creating a House object with a single Room and two Devices using Factory classes.
     * The test then calls the getDevicesOfASpecificRoom method with the name of the created room and asserts that the
     * returned list contains the two created devices.
     *
     * @throws InstantiationException if the creation of the Room or Device objects fails.
     */
    @Test
    void roomWithTwoDevices_shouldReturnListOfTwoDevicesOfSpecificRoom() throws InstantiationException {
        // Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        FactoryLocation factoryLocation = new FactoryLocation();
        House house = new House(factoryLocation, factoryRoom, "address", "zipCode", 55.2, -2.25);
        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        Room roomDTO = house.createRoom("Living Room", 1, 20.0, 3.0);
        Device device1 = roomDTO.createDevice("Device 1");
        Device device2 = roomDTO.createDevice("Device 2");

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO.getRoomName());

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device1.getDeviceName())));
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device2.getDeviceName())));
    }
}