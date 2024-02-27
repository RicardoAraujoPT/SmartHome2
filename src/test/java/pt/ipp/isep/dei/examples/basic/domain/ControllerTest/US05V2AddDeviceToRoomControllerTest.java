package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US05V2AddDeviceToRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class US05V2AddDeviceToRoomControllerTest {

    House myHouse;


    /**
     * Tests the successful addition of a device to a room.
     */
    @Test
    void shouldAddDeviceToRoom() throws InstantiationException {
        //Arrange
        myHouse = new House("zipCode", "Street", 55, 105);
        Room myRoom = myHouse.createRoom("roomName1", 0, 25, 2.5);
        US05V2AddDeviceToRoomController myController = new US05V2AddDeviceToRoomController(myHouse);

        RoomDTO myRoomDTO = new RoomDTO(myRoom.getRoomName(), myRoom.getFloorNumber(), myRoom.getArea(), myRoom.getHeight());

        String deviceName = "device1";

        int expected =1;
        //Act
        List <DeviceDTO> foundDeviceListDTO = myController.addDeviceToRoom(myRoomDTO, deviceName);
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
        myHouse = new House("zipCode", "Street", 55, 105);
        Room myRoom = myHouse.createRoom("roomName1", 0, 25, 2.5);
        US05V2AddDeviceToRoomController myController = new US05V2AddDeviceToRoomController(myHouse);

        RoomDTO myRoomDTO = new RoomDTO(myRoom.getRoomName(), myRoom.getFloorNumber(), myRoom.getArea(), myRoom.getHeight());

        String deviceName = "";

        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myController.addDeviceToRoom(myRoomDTO, deviceName));
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
