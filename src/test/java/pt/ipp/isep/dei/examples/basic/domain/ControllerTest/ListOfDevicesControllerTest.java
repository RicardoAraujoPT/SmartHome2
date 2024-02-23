package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.ListOfDevicesController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class contains tests for the ListOfDevicesController class.
 */

public class ListOfDevicesControllerTest {

    /**
     * Test for the ListOfDevicesController constructor when the provided room is null.
     * The test asserts that an IllegalArgumentException is thrown with the message "Invalid room".
     */
    @Test
    public void testConstructorWithNullRoom() {
        Room myRoom = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ListOfDevicesController(myRoom));
        assertEquals("Invalid room", exception.getMessage());
    }

    /**
     * Test for the getDeviceList method when the room has no devices.
     * The test asserts that the size of the returned list is 0.
     */
    @Test
    public void testGetDeviceListWithNoDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 0;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    /**
     * Test for the getDeviceList method when the room has one device.
     * The test asserts that the size of the returned list is 1.
     */
    @Test
    public void testGetDeviceListWithOneDevice() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 1;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    /**
     * Test for the getDeviceList method when the room has multiple devices.
     * The test asserts that the size of the returned list is equal to the number of devices in the room.
     */
    @Test
    public void testGetDeviceListWithMultipleDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        myRoom.createDevice("Device2");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 2;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    /**
     * Test for the getDeviceDTOList method when the room has no devices.
     * The test asserts that the size of the returned list is 0.
     */
    @Test
    public void testGetDeviceDTOListWithNoDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 0;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    /**
     * Test for the getDeviceDTOList method when the room has one device.
     * The test asserts that the size of the returned list is 1.
     */
    @Test
    public void testGetDeviceDTOListWithOneDevice() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 1;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    /**
     * Test for the getDeviceDTOList method when the room has multiple devices.
     * The test asserts that the size of the returned list is equal to the number of devices in the room.
     */
    @Test
    public void testGetDeviceDTOListWithMultipleDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        myRoom.createDevice("Device2");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 2;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }
}

