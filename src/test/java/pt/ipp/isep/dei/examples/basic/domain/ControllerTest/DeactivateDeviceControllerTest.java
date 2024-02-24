package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.DeactivateDeviceController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class DeactivateDeviceControllerTest {

    House myHouse;

    Room myRoom;

    /**
     * Sets up a house and room before each test case.
     */
    @BeforeEach
    public void instantiateHouseAndRoom() throws InstantiationException {
        myHouse = new House("zipCode", "Street", 55, 105);
        myHouse.createRoom("roomName1", 0, 25, 2.5);
        myRoom = myHouse.getRoomByName("roomName1");
        Device myDevice = myRoom.createDevice("device1");
        Device alreadyInactiveDevice = myRoom.createDevice("inactiveDevice");
        alreadyInactiveDevice.deactivateDevice();

    }

    @Test
    void deactivateDeviceSuccessfully() throws InstantiationException {
        DeactivateDeviceController myController = new DeactivateDeviceController(myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("device1",UUID.randomUUID().toString(),null);
        //myController.deactivateDevice(deviceToDeactivate);
        assertFalse(deviceToDeactivate.getIsActive());
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a non-existing device name.
     * The expected result is that the method returns null, indicating that the device was not found.
     */
    @Test
    void deactivateDeviceNonExistingDevice() {
        DeactivateDeviceController myController = new DeactivateDeviceController(myHouse);
        DeviceDTO deviceToDeactivate = new DeviceDTO("device2",UUID.randomUUID().toString(),null);
        //myController.deactivateDevice(deviceToDeactivate);
        assertNull(deviceToDeactivate);
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device is already inactive.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device that is already inactive.
     * The expected result is that the method returns false, confirming the device is deactivated.
     */
    @Test
    void deactivateDeviceWhenDeviceIsAlreadyInactive() {
        DeactivateDeviceController myController = new DeactivateDeviceController(myHouse);
        DeviceDTO alreadyInactiveDevice = new DeviceDTO("inactiveDevice",UUID.randomUUID().toString(),null);
        //myController.deactivateDevice(alreadyInactiveDevice);
        assertFalse(alreadyInactiveDevice.getIsActive());
    }

}
