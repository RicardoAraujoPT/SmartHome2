package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Actuator;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceTest {

    @Test
    public void createValidDevice() throws InstantiationException {
        Device device = new Device("device1");
    }

    @Test
    public void createInvalidDeviceWithEmptyName() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,() ->  new Device(""));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void createInvalidDeviceWithNullName() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,() ->  new Device(null));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, foundMessage);
    }

    @Test
    public void getValidDeviceName() {
        //Arrange
        Device device = new Device("device1");
        String expected = "device1";
        //Act
        String found = device.getDeviceName();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getValidDeviceIsActive() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.getDeviceIsActive();
        //Assert
        assertFalse(found);
    }

    @Test
    public void getValidDeviceAvailableSensors() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList <Sensor> found = device.getAvailableSensors();
        //Assert
        assertEquals(expected,found);
    }

    @Test
    public void getValidDeviceAvailableActuators() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList <Actuator> found = device.getAvailableActuators();
        //Assert
        assertEquals(expected,found);
    }

    @Test
    public void setValidDeviceName() {
        //Arrange
        Device device = new Device("device1");
        String name = "newDevice";
        //Act
        device.setDeviceName(name);
        String found = device.getDeviceName();
        //Assert
        assertEquals(name,found);
    }

    @Test
    public void setInvalidDeviceName() {
        //Arrange
        Device device = new Device("device1");
        String name = "";
        String expectedMessage = "Device name cannot be null or empty";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,() -> device.setDeviceName(name));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage,foundMessage);
    }

    @Test
    public void deactivateValidDevice() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.deactivateDevice();
        //Assert
        assertTrue(found);
    }

    @Test
    public void activateValidDevice() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.activateDevice();
        //Assert
        assertTrue(found);
    }


}
