package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US08DeactivateDeviceController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class of the US08DeactivateDeviceController. It contains tests for:
 * valid device;
 * Non existing Device;
 * Already inactive Device
 * And non-existing House
 */
public class US08DeactivateDeviceControllerTest {


    @Test
    void validDevice_shouldreturnFalse() throws InstantiationException {
        //Arrange
        House _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myHouse.getRoomByName("roomName1").createDevice("myDevice");
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("myDevice","roomName1");
        //Act
        myController.deactivateDevice(deviceToDeactivate);
        //Assert
        assertFalse(deviceToDeactivate.getIsActive());
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a non-existing device name.
     * The expected result is that the method returns an exception.
     */
    @Test
    void nonExistingDevice_shouldReturnNull() throws InstantiationException {
        //Arrange
        House _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myHouse.getRoomByName("roomName1").createDevice("myDevice");
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("myOtherDevice","roomName1");
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myController.deactivateDevice(deviceToDeactivate));
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device is already inactive.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device that is already inactive.
     * The expected result is that the method returns false, confirming the device is deactivated.
     */
    @Test
    void deactivatedDevice_shouldReturnFalse() throws InstantiationException {
        //Arrange
        House _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myHouse.getRoomByName("roomName1").createDevice("myDevice");
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("myDevice","roomName1");
        //Act
        myController.deactivateDevice(deviceToDeactivate);
        myController.deactivateDevice(deviceToDeactivate);
        //Assert
        assertFalse(deviceToDeactivate.getIsActive());
    }

    /**
     * This test checks if the deactivateDevice method correctly handles the case where the house in which the device
     * is located does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device
     * on a non-existing house.
     * The expected result is that the method should return an exception.
     */
    @Test
    void nullHouse_shouldThrowIllegalArgumentException() throws IllegalArgumentException {
        //Arrange
        String expectedMessage = "Invalid house";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US08DeactivateDeviceController(null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * This test checks if the deactivateDevice method correctly handles the case where the room in which the device
     * is located does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device
     * on a non-existing room.
     * The expected result is that the method should return an exception.
     */
    @Test
    void nullRoom_shouldThrowIllegalArgumentException() throws IllegalArgumentException {
        //Arrange
        House _myHouse = new House("zipCode", "Street", 55, 105);
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("myDevice","roomName1");
        String expectedMessage = "Room name doesn't exist in the list";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myController.deactivateDevice (deviceToDeactivate));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
