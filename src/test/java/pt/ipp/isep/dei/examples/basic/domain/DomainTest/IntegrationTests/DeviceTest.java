package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactorySensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DeviceTest {
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
    public void addTemperatureSensorToDevice() throws InstantiationException {
        // Arrange
        FactorySensor factorySensor = mock(FactorySensor.class);
        Sensor mockSensor = mock(Sensor.class);
        Catalogue catalogue = new Catalogue("config.properties");
        Device device = new Device("Thermostat");



//        doReturn(mockSensor).when(factorySensor).createSensor("GA100K", catalogue);

        ArrayList<Sensor> expected = new ArrayList<>();
        expected.add(mockSensor);
        doReturn(mockSensor).when(factorySensor).createSensor("GA100K", catalogue);
        // Act
//        device.addSensor();

        ArrayList<Sensor> found = device.getSensors();

        // Assert
        assertEquals(expected, found);
    }

//    @Test
//    public void  addHumiditySensorToDevice() {
//
//        //Arrange
//        FactorySensor factorySensor = mock(FactorySensor.class);
//        Sensor mockSensor = mock(Sensor.class);
//        Device device = new Device("Humidifier");
//
//
//        doReturn(mockSensor).when(factorySensor).createSensor(anyString());
//
//        ArrayList<Sensor> expected = new ArrayList<>();
//        expected.add(mockSensor);
//
//        //Act
//
//        device.addSensor(factorySensor.createSensor(""));
//
//        ArrayList<Sensor> found = device.getSensors();
//
//        //Assert
//        assertEquals(expected,found);
//    }
//
//    @Test
//    public void addMultipleSensorsToDevice() {
//        // Arrange
//        FactorySensor factorySensor = mock(FactorySensor.class);
//
//        Sensor mockTemperatureSensor = mock(Sensor.class);
//        Sensor mockHumiditySensor = mock(Sensor.class);
//
//        Device device = new Device("Thermidifier Device");
//
//        doReturn(mockTemperatureSensor).when(factorySensor).createSensor(anyString());
//        doReturn(mockHumiditySensor).when(factorySensor).createSensor(anyString());
//
//        // Expected list contains the mock sensors
//        ArrayList<Sensor> expected = new ArrayList<>();
//        expected.add(mockTemperatureSensor);
//        expected.add(mockHumiditySensor);
//
//        // Act
//        device.addSensor(factorySensor.createSensor("", )));
//        device.addSensor(factorySensor.createSensor(""));
//
//        ArrayList<Sensor> found = device.getSensors();
//
//        // Assert
//        assertEquals(expected, found);
//    }
//
//    @Test
//    public void addNoSensorsAddedToDevice() {
//        // Arrange
//
//        FactorySensor factorySensor = mock(FactorySensor.class);
//
//        // Create the device
//        Device device = new Device("Smart Device");
//
//        // Act
//
//        // Retrieve the list of sensors frm the device
//        ArrayList<Sensor> found = device.getSensors();
//
//        // Expected list is empty
//        ArrayList<Sensor> expected = new ArrayList<>();
//
//        // Assert
//        assertEquals(expected, found);
//    }


}




