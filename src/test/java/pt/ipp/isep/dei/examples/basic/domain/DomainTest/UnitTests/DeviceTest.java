package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeviceTest {

    @Test
    public void createValidDevice() throws InstantiationException {
        Device device = new Device("device1");
    }

    @Test
    public void EmptyDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(""));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void NullDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(null));
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
    @Disabled
    public void getValidDeviceIsActive() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.getDeviceIsActive();
        //Assert
        assertTrue(found);
    }

    @Test
    public void getValidDeviceSensors() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Sensor> found = device.getSensors();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getValidDeviceActuators() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Actuator> found = device.getActuators();
        //Assert
        assertEquals(expected, found);
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
        assertEquals(name, found);
    }

    @Test
    public void setInvalidDeviceName() {
        //Arrange
        Device device = new Device("device1");
        String name = "";
        String expectedMessage = "Device name cannot be null or empty";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> device.setDeviceName(name));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, foundMessage);
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

    @Test
    public void testAddSensor() throws InstantiationException {
        // Initialize mock objects
        FactorySensor factorySensor = mock(FactorySensor.class);
        Catalogue catalogue = new Catalogue("config.properties");
        //Catalogue catalogue = mock(Catalogue.class);

        // Create a GA100K sensor
        catalogue.addSensorType("Temperature", Unit.Percentage);
        Sensor sensor = new GA100K(catalogue);

        // Mock behavior of FactorySensor
        when(factorySensor.createSensor(anyString(), any(Catalogue.class))).thenReturn(sensor);

        // Create the device and add a sensor using the mocked FactorySensor
        Device device = new Device("Test Device");
        Sensor sensor1 = device.addSensor("Sensors.GA100K", catalogue);

        // Verify that the sensor was added to the device
        assertTrue(device.getSensors().contains(sensor1));
    }

}