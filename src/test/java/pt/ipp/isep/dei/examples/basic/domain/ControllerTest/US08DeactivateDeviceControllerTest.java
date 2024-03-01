package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US08DeactivateDeviceController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class of the US08DeactivateDeviceController. It contains tests for:
 * valid device;
 * Non existing Device;
 * Already inactive Device
 * Non-existing House
 * Non-existing Room
 */
public class US08DeactivateDeviceControllerTest {

    /**
     * This tests finds an existing Device and deactivates it, asserting that its state is false (is inactive);
     * @throws InstantiationException
     */
    @Test
    void validDevice_shouldReturnFalse() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        myHouse.addRoom("myRoom",2,25,5).addDevice("myDevice");
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(myHouse);
        //Act
        myController.deactivateDevice("myDevice","myRoom");
        //Assert
        assertFalse(myHouse.getRoomByName("myRoom").getDeviceByName("myDevice").getDeviceIsActive());
    }

    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a non-existing device name.
     * The expected result is that the method returns an exception.
     */
    @Test
    void nonExistingDevice_shouldReturnException() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        myHouse.addRoom("myRoom",2,25,5);
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(myHouse);
        String expected = "Device name doesn't exist in the list";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                myController.deactivateDevice("myOtherDevice","myRoom"));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expected,actualMessage);
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device is already inactive.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device that is already inactive.
     * The expected result is that the method returns false, confirming the device is deactivated.
     */
    @Test
    void deactivatedDevice_shouldReturnFalse() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        myHouse.addRoom("myRoom",2,25,5).addDevice("myDevice");
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(myHouse);
        //Act
        myController.deactivateDevice("myDevice","myRoom");
        myController.deactivateDevice("myDevice","myRoom");
        //Assert
        assertFalse(myHouse.getRoomByName("myRoom").getDeviceByName("myDevice").getDeviceIsActive());
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
    void nullRoom_shouldThrowIllegalArgumentException() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        US08DeactivateDeviceController myController = new US08DeactivateDeviceController(myHouse);
        String expectedMessage = "Room name doesn't exist in the list";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myController.deactivateDevice("myDevice","myRoom"));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
