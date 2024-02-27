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
    void createValidDevice() throws InstantiationException {
        Device device = new Device("device1");
    }

    @Test
    void EmptyDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(""));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void NullDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(null));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, foundMessage);
    }

    @Test
    void getValidDeviceName() {
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
    void getValidDeviceIsActive() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.getDeviceIsActive();
        //Assert
        assertTrue(found);
    }

    @Test
    void getValidDeviceSensors() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Sensor> found = device.getSensors();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void getValidDeviceActuators() {
        //Arrange
        Device device = new Device("device1");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Actuator> found = device.getActuators();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void setValidDeviceName() {
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
    void setInvalidDeviceName() {
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
    void deactivateValidDevice() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.deactivateDevice();
        //Assert
        assertTrue(found);
    }

    @Test
    void activateValidDevice() {
        //Arrange
        Device device = new Device("device1");
        //Act
        Boolean found = device.activateDevice();
        //Assert
        assertTrue(found);
    }


    @Test
    void whenAddingValidGA100KSensorModel_thenNewSensorIsInstantiated() throws Exception{
        // arrange
        String strSensorModel = "Sensors.GA100K";
        String strSensorTypeDescription = "Temperature";

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strSensorTypeDescription);

        Sensor sensorDouble = mock(Sensor.class);
        when(sensorDouble.getSensorType()).thenReturn(sensorTypeDouble);

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(sensorDouble);

        Device device = new Device("device1");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertEquals(sensor.getSensorType().getDescription(), strSensorTypeDescription);
        // Verify that the sensor was added to the device
        assertTrue(device.getSensors().contains(sensor));
    }

    @Test
    void whenAddingInvalidGA100KSensorModel_thenNullIsReturned() throws Exception{
        // arrange
        String strSensorModel = "Sensors.GA100K";

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(null);

        Device device = new Device("device1");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertNull(sensor);
    }

    @Test
    void whenAddingValidTSY01SensorModel_thenNewSensorIsInstantiated() throws Exception{
        // arrange
        String strSensorModel = "Sensors.TSY01";
        String strSensorTypeDescription = "Humidity";

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strSensorTypeDescription);

        Sensor sensorDouble = mock(Sensor.class);
        when(sensorDouble.getSensorType()).thenReturn(sensorTypeDouble);

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(sensorDouble);

        Device device = new Device("device1");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertEquals(sensor.getSensorType().getDescription(), strSensorTypeDescription);
        // Verify that the sensor was added to the device
        assertTrue(device.getSensors().contains(sensor));
    }

    @Test
    void whenAddingInvalidTSY01SensorModel_thenNullIsReturned() throws Exception{
        // arrange
        String strSensorModel = "Sensors.TSY01";

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(null);

        Device device = new Device("device1");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertNull(sensor);
    }


}