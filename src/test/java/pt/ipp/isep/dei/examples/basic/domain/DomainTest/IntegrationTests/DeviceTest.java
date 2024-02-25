package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactorySensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeviceTest {

   /* @Test
    public void addTemperatureSensorToDevice() throws InstantiationException {
        // Arrange
        FactorySensor factorySensor = mock(FactorySensor.class);
        Sensor mockSensor = mock(Sensor.class);
        Catalogue catalogue = mock(Catalogue.class);
        Device device = new Device("Thermostat");


        when(factorySensor.createSensor("GA100K", catalogue)).thenReturn(mockSensor);

        // Act
        Sensor mockSensor = device.addSensor("GA100K", catalogue);
//VER ESTA PARTE
        // Assert

        assertTrue(device.getSensors().contains(mockSensor)); // Verify that the added sensor is present in the device's list of sensors
    }
*/
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




