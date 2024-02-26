package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.AddDeviceToRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDeviceToRoomControllerTest {

    House myHouse;

    /**
     * Sets up a house and room before each test case.
     */
    @BeforeEach
    public void shouldInstantiateHouseAndRoom() throws InstantiationException {
        myHouse = new House("zipCode", "Street", 55, 105);
        myHouse.createRoom("roomName1", 0, 25, 2.5);
    }

    /**
     * Tests the successful addition of a device to a room.
     */
    @Test
    public void shouldAddDeviceToRoom(){
        //Arrange
        AddDeviceToRoomController myController = new AddDeviceToRoomController(myHouse);
        String roomName = "roomName1";
        String deviceName = "device1";
        //Act
        DeviceDTO foundDeviceDTO = myController.addDeviceToRoom(roomName, deviceName);
        //Assert
        assertEquals(deviceName, foundDeviceDTO.getDeviceName());
    }

    /**
     * Tests adding a device with an empty name to a room.
     */
    @Test
    public void deviceNameEmpty_shouldGetNullDeviceDTO(){
        //Act
        AddDeviceToRoomController myController = new AddDeviceToRoomController(myHouse);
        String deviceName = " ";
        String roomName = "roomName1";
        //Act
        DeviceDTO foundDeviceDTO = myController.addDeviceToRoom(roomName, deviceName);
        //Assert
        assertNull(foundDeviceDTO);
    }

    /**
     * Tests the behavior when attempting to create an AddDeviceToRoomController with a null house.
     */
    @Test
    public void testNullHouse_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Provided house cannot be null";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new AddDeviceToRoomController(null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
