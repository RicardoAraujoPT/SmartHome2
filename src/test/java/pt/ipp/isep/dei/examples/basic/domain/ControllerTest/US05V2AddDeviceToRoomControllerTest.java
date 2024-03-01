package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US05V2AddDeviceToRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class US05V2AddDeviceToRoomControllerTest {

    House myHouse;


    /**
     * Tests the successful addition of a device to a room.
     */
    @Test
    void validDevice_shouldAddDeviceToRoom() throws InstantiationException {
        //Arrange
        String roomName = "roomName1";
        Integer houseFloor = 0;
        Double area = 25.0;
        Double height = 3.2;
        String deviceName = "device1";

        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        Room myRoom = myHouse.addRoom(roomName, houseFloor, area, height);
        US05V2AddDeviceToRoomController myController = new US05V2AddDeviceToRoomController(myHouse);

        int expected =1;
        //Act
        List <DeviceDTO> foundDeviceListDTO = myController.addDeviceToRoom(myRoom.getRoomName(), deviceName);
        int found = foundDeviceListDTO.size();
        //Assert
        assertEquals(expected, found);
    }

    /**
     * Tests adding a device with an empty name to a room.
     */
    @Test
    void deviceNameEmpty_shouldThrowIllegalArgumentException() throws InstantiationException {
        //Arrange
        String roomName = "roomName1";
        Integer houseFloor = 0;
        Double area = 25.0;
        Double height = 3.2;
        String deviceName = "";

        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        Room myRoom = myHouse.addRoom(roomName, houseFloor, area, height);
        US05V2AddDeviceToRoomController myController = new US05V2AddDeviceToRoomController(myHouse);

        String expectedMessage = "Device name cannot be null or empty";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myController.addDeviceToRoom(myRoom.getRoomName(), deviceName));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);

    }

    /**
     * Tests the behavior when attempting to create an AddDeviceToRoomController with a null house.
     */
    @Test
    void testNullHouse_shouldThrowIllegalArgumentException() throws InstantiationException {
        //Arrange
        String expectedMessage = "Provided house cannot be null";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US05V2AddDeviceToRoomController(null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
