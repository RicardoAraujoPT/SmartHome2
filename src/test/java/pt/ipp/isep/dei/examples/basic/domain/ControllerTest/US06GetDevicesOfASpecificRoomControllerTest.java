package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US06GetDevicesOfASpecificRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the GetDevicesOfASpecificRoomController class.
 * It tests the functionality of getting devices of a specific room in a smart home system.
 */
public class US06GetDevicesOfASpecificRoomControllerTest {

    /**
     * Test case to verify if a valid House object can be instantiated.
     */
    @Test
    void shouldInstantiateValidHouse() {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        // Act
        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);
        // Assert
        assertNotNull(controller);
    }

    /**
     * Test case to verify if an exception is thrown when a null House object is provided.
     */
    @Test
    void shouldThrowExceptionWhenHouseIsNull() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new US06GetDevicesOfASpecificRoomController(null));
    }

    /**
     * Test case to verify if an empty list of devices is returned when a room without devices is provided.
     */
    @Test
    void roomWithoutDevices_shouldReturnEmptyListOfDevices() throws InstantiationException {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        Room room = house.createRoom("ChosenRoom", 1, 20.0, 3.0);

        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        RoomDTO roomDTO = roomDTOMapper.room_DomainToDTO(room);

        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO);

        // Assert
        assertTrue(result.isEmpty());
    }
    /**
     * Test case to verify if a list of two devices is returned when a room with two devices is provided.
     */
    @Test
    void roomWithTwoDevices_shouldReturnListOfTwoDevicesOfSpecificRoom() throws InstantiationException {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        Room room = house.createRoom("Living Room", 1, 20.0, 3.0);
        Device device1 = room.createDevice("Device 1");
        Device device2 = room.createDevice("Device 2");

        US06GetDevicesOfASpecificRoomController controller = new US06GetDevicesOfASpecificRoomController(house);

        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        RoomDTO roomDTO = roomDTOMapper.room_DomainToDTO(room);
        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO);

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device1.getDeviceName())));
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device2.getDeviceName())));
    }
}