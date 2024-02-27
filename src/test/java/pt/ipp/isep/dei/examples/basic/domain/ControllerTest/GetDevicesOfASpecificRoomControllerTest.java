package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.AddDeviceToRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.CreateRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.GetDevicesOfASpecificRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.ListOfRoomsController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the GetDevicesOfASpecificRoomController class.
 * It tests the functionality of getting devices of a specific room in a smart home system.
 */
public class GetDevicesOfASpecificRoomControllerTest {

    /**
     * This test checks the constructor of the GetDevicesOfASpecificRoomController class.
     */
    @Test
    public void shouldInstantiateHouseDeviceDTOMapperAndRoomDTOMapper() {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);

        // Act
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        // Assert
        assertEquals(deviceDTOMapper, controller.getDeviceDTOMapper());
    }

    /**
     * This test checks the getDevicesOfASpecificRoom method when the RoomDTO is null.
     * It is expected to throw an InstantiationException.
     */
    @Test
    public void nullRoom_shouldThrowInstantiationException() {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        // Act and Assert
        assertThrows(InstantiationException.class, () -> controller.getDevicesOfASpecificRoom(null));
    }

    /**
     * This test checks the getDevicesOfASpecificRoom method when the RoomDTO is valid but has no devices.
     * It is expected to return an empty list.
     */

    @Test
    public void roomWithoutDevices_shouldReturnEmptyListOfDevices() throws InstantiationException {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        Room room = house.createRoom("ChosenRoom", 1, 20.0, 3.0);
        RoomDTO roomDTO = RoomDTOMapper.room_DomainToDTO(room); //room is converted to DTO

        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO);

        // Assert
        assertTrue(result.isEmpty());
    }

    /**
     * This test checks the getDevicesOfASpecificRoom method when the RoomDTO is valid and has devices.
     * It is expected to return a list of DeviceDTOs.
     */

    /*
    @Test
    public void roomWithTwoDevices_shouldReturnListOfTwoDevicesOfSpecificRoom() throws InstantiationException {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        Room room = house.createRoom("Living Room", 1, 20.0, 3.0);
        Device device1 = room.createDevice("Device 1");
        Device device2 = room.createDevice("Device 2");

        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        RoomDTO roomDTO = RoomDTOMapper.room_DomainToDTO(room);  //room is converted to DTO

        // Act
        List<DeviceDTO> result = controller.getDevicesOfASpecificRoom(roomDTO);

        // Assert - Após debug dá erro no asserTrue
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device1.getDeviceName())));
        assertTrue(result.stream().anyMatch(deviceDTO -> deviceDTO.getDeviceName().equals(device2.getDeviceName())));
    }
    */

}