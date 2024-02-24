package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

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
        assertTrue(found);
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

    @Test
    void addValidSensor() throws Exception
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K");
        Catalogue catalogue = new Catalogue( config );
        catalogue.addSensorType("Temperature", Unit.Celsius);

        Device device = new Device( "device1");

        // act
        Sensor sensor = device.addSensor( "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K", catalogue );

        // assert
        assertEquals( sensor.getSensorType().getDescription(), "Temperature" );
        // how to check if sensor was added to the device?
    }

    @Test
    void addInvalidSensor() throws Exception
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        Device device = new Device( "device1");

        // act
        Sensor sensor = device.addSensor( "123", catalogue );

        // assert
        assertNull( sensor );
    }


}
