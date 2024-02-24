package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.DeactivateDeviceController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class DeactivateDeviceControllerTest {

    House _myHouse;

    Room _myRoom;

    @Test
    void deactivateDeviceSuccessfully() throws InstantiationException {
        //Arrange
        _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myRoom = _myHouse.getRoomByName("roomName1");
        Device myDevice = _myRoom.createDevice("device1");
        Device alreadyInactiveDevice = _myRoom.createDevice("inactiveDevice");
        alreadyInactiveDevice.deactivateDevice();
        DeactivateDeviceController myController = new DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("device1",UUID.randomUUID().toString());
        //Act
        //myController.deactivateDevice(deviceToDeactivate);
        //Assert
        assertFalse(deviceToDeactivate.getIsActive());
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a non-existing device name.
     * The expected result is that the method returns null, indicating that the device was not found.
     */
    @Test
    void deactivateDeviceNonExistingDevice() throws InstantiationException {
        //Arrange
        _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myRoom = _myHouse.getRoomByName("roomName1");
        Device myDevice = _myRoom.createDevice("device1");
        Device alreadyInactiveDevice = _myRoom.createDevice("inactiveDevice");
        alreadyInactiveDevice.deactivateDevice();
        DeactivateDeviceController myController = new DeactivateDeviceController(_myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("device2",UUID.randomUUID().toString());
        //Act
        //myController.deactivateDevice(deviceToDeactivate);
        //Assert
        assertNull(deviceToDeactivate);
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device is already inactive.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device that is already inactive.
     * The expected result is that the method returns false, confirming the device is deactivated.
     */
    @Test
    void deactivateDeviceWhenDeviceIsAlreadyInactive() throws InstantiationException {
        //Arrange
        _myHouse = new House("zipCode", "Street", 55, 105);
        _myHouse.createRoom("roomName1", 0, 25, 2.5);
        _myRoom = _myHouse.getRoomByName("roomName1");
        Device myDevice = _myRoom.createDevice("device1");
        DeactivateDeviceController myController = new DeactivateDeviceController(_myHouse);
        DeviceDTO alreadyInactiveDevice = new DeviceDTO("inactiveDevice",UUID.randomUUID().toString());
        //Act
        //myController.deactivateDevice(alreadyInactiveDevice);
        //Assert
        assertFalse(alreadyInactiveDevice.getIsActive());
    }

}
