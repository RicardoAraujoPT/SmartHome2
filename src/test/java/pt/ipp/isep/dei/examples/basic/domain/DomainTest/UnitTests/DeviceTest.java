package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeviceTest {

    @Test
    void validCreatedDevice_shouldInstantiateDeviceWithoutException() throws InstantiationException {
        Device device = new Device("myDevice");
    }

    @Test
    void emptyDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(""));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void nullDeviceName_shouldThrowIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Invalid arguments for Device";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device(null));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, foundMessage);
    }

    @Test
    void validDeviceName_shouldReturnDeviceName() {
        //Arrange
        Device device = new Device("myDevice");
        String expected = "myDevice";
        //Act
        String found = device.getDeviceName();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void validIsActive_shouldReturnTrue() {
        //Arrange
        Device device = new Device("myDevice");
        //Act
        Boolean found = device.getDeviceIsActive();
        //Assert
        assertTrue(found);
    }

    @Test
    void validDeviceIsActive_shouldReturnTrue() {
        //Arrange
        Device device = new Device("myDevice");
        //Act
        Boolean found = device.getDeviceIsActive();
        //Assert
        assertTrue(found);
    }

    @Test
    void validDeviceSensors_shouldReturnValidSensors() {
        //Arrange
        Device device = new Device("myDevice");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Sensor> found = device.getSensors();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void validDeviceActuators_shouldReturnValidActuators() {
        //Arrange
        Device device = new Device("myDevice");
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Actuator> found = device.getActuators();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void validNewDeviceName_shouldReturnNewName() {
        //Arrange
        Device device = new Device("myDevice");
        String name = "myDevice";
        //Act
        device.setDeviceName(name);
        String found = device.getDeviceName();
        //Assert
        assertEquals(name, found);
    }

    @Test
    void invalidNewDeviceName_shouldReturnExceptionMessage() {
        //Arrange
        Device device = new Device("myDevice");
        String name = "";
        String expectedMessage = "Device name cannot be null or empty";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> device.setDeviceName(name));
        String foundMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, foundMessage);
    }

    @Test
    void validDeactivatedDevice_shouldReturnTrue() {
        //Arrange
        Device device = new Device("myDevice");
        //Act
        boolean found = device.deactivateDevice();
        //Assert
        assertTrue(found);
    }

    @Test
    void validActivatedDevice_shouldReturnTrue() {
        //Arrange
        Device device = new Device("myDevice");
        //Act
        boolean found = device.activateDevice();
        //Assert
        assertTrue(found);
    }


    @Test
    void validGA100KSensorModel_shouldReturnInstantiatedSensor() {
        // arrange
        String strSensorModel = "Sensors.GA100K";
        String strSensorTypeDescription = "Temperature";

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strSensorTypeDescription);

        Sensor sensorDouble = mock(Sensor.class);
        when(sensorDouble.getSensorType()).thenReturn(sensorTypeDouble);

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(sensorDouble);

        Device device = new Device("myDevice");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertEquals(sensor.getSensorType().getDescription(), strSensorTypeDescription);
        // Verify that the sensor was added to the device
        assertTrue(device.getSensors().contains(sensor));
    }

    @Test
    void invalidGA100KSensorModel_shouldReturnNull() {
        // arrange
        String strSensorModel = "Sensors.GA100K";

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(null);

        Device device = new Device("myDevice");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertNull(sensor);
    }

    @Test
    void validTSY01SensorModel_shouldReturnInstantiatedSensor(){
        // arrange
        String strSensorModel = "Sensors.TSY01";
        String strSensorTypeDescription = "Humidity";

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strSensorTypeDescription);

        Sensor sensorDouble = mock(Sensor.class);
        when(sensorDouble.getSensorType()).thenReturn(sensorTypeDouble);

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(sensorDouble);

        Device device = new Device("myDevice");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertEquals(sensor.getSensorType().getDescription(), strSensorTypeDescription);
        // Verify that the sensor was added to the device
        assertTrue(device.getSensors().contains(sensor));
    }

    @Test
    void invalidTSY01SensorModel_shouldReturnNull() {
        // arrange
        String strSensorModel = "Sensors.TSY01";

        Catalogue catalogueDouble = mock(Catalogue.class);
        when(catalogueDouble.getSensor(strSensorModel)).thenReturn(null);

        Device device = new Device("myDevice");

        // act
        Sensor sensor = device.addSensor(strSensorModel, catalogueDouble);

        // assert
        assertNull(sensor);
    }


}