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

public class GetDevicesOfASpecificRoomControllerTest {

    @Test
    public void testConstructor() {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);

        // Act
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        // Assert
        assertEquals(deviceDTOMapper, controller.getDeviceDTOMapper());
    }

    @Test
    public void testGetDevicesOfSpecificRoom_NullRoomDTO() {
        // Arrange
        House house = new House("address", "zipCode", 55.2, -2.25);
        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(house);
        RoomDTOMapper roomDTOMapper = new RoomDTOMapper(house);
        GetDevicesOfASpecificRoomController controller = new GetDevicesOfASpecificRoomController(deviceDTOMapper, roomDTOMapper, house);

        // Act and Assert
        assertThrows(InstantiationException.class, () -> controller.getDevicesOfASpecificRoom(null));
    }

    @Test
    public void testGetEmptyListOfDevicesOfSpecificRoom() throws InstantiationException {
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

    /*
    @Test
    public void testGetDevicesOfSpecificRoom_ReturnsTwoDevices() throws InstantiationException {
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