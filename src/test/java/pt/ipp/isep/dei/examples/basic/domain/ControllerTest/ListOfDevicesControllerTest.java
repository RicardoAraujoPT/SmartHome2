package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.ListOfDevicesController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListOfDevicesControllerTest {

    @Test
    public void testConstructorWithNullRoom() {
        Room myRoom = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ListOfDevicesController(myRoom));
        assertEquals("Invalid room", exception.getMessage());
    }

    @Test
    public void testGetDeviceListWithNoDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 0;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetDeviceListWithOneDevice() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 1;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

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

    @Test
    public void testGetDeviceDTOListWithNoDevices() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 0;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDeviceDTOListWithOneDevice() throws InstantiationException {
        Room myRoom = new Room("Living Room", 1, 35, 2.5);
        myRoom.createDevice("Device1");
        ListOfDevicesController controller = new ListOfDevicesController(myRoom);
        int expected = 1;
        int actual = controller.getDeviceList().size();
        assertEquals(expected, actual);
    }

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

