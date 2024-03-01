package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryDevice;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomTest {

    @Test
    void validParameters_shouldNotThrowException() throws InstantiationException {
        //Act
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room bedroom = new Room("Bedroom1", 1, 25.0, 2.8, factoryDeviceDouble);

        //Assert
        assertEquals("Bedroom1", bedroom.getRoomName());
        assertEquals(1, bedroom.getFloorNumber());
        assertEquals(25, bedroom.getArea());
        assertEquals(2.8, bedroom.getHeight());
    }

    @Test
    void nullRoomName_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room(null, 1, 25.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void emptyRoomName_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("", 1, 25.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void blankRoomName_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room(" ", 1, 25.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void invalidHouseFloor_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("Bedroom", null, 25.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void AreaIsZero_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("Bedroom", 1, 0.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void AreaIsNegative_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("Bedroom", 1, -10.0, 2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void heightIsNegative_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("Bedroom", 1, 25.0, -2.5, factoryDeviceDouble));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldReturnValidRoomName() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);
        String expected = "Bedroom";
        //Act
        String found = myRoom.getRoomName();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void shouldReturnValidFloorNumber() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);
        Integer expected = 0;
        //Act
        Integer found = myRoom.getFloorNumber();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void shouldReturnValidArea() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);
        Double expected = 25.0;
        //Act
        Double found = myRoom.getArea();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void shouldReturnValidHeight() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);
        Double expected = 3.2;
        //Act
        Double found = myRoom.getHeight();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void shouldReturnEmptyDeviceList() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList<Device> found = myRoom.getDevices();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    void nullFactoryDevice_shouldThrowException() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactoryDevice factoryDevice = null;
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Room("Bedroom", 1, 25.0, 2.5, factoryDevice));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void validDeviceName_shouldCreateAndAddDeviceToRoom() throws InstantiationException {
        //Arrange
        String deviceName = "Device";
        Device deviceDouble = mock(Device.class);
        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        when(factoryDeviceDouble.newDevice(deviceName)).thenReturn(deviceDouble);

        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);

        //Act
        Device device = myRoom.addDevice(deviceName);

        //Assert
        assertEquals(myRoom.getDevices().size(), 1);
        assertEquals(myRoom.getRoomName(), "Bedroom");
        assertEquals(myRoom.getFloorNumber(), 0);
        assertEquals(myRoom.getArea(), 25.0);
        assertEquals(myRoom.getHeight(), 3.2);
    }

    @Test
    void twoValidDevices_shouldCreateAndAddBothDevicesToRoom() throws InstantiationException {
        //Arrange
        String deviceName1 = "Device1";
        String deviceName2 = "Device2";

        Device deviceDouble1 = mock(Device.class);
        Device deviceDouble2 = mock(Device.class);
        when(deviceDouble1.getDeviceName()).thenReturn(deviceName1);
        when(deviceDouble2.getDeviceName()).thenReturn(deviceName2);

        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        when(factoryDeviceDouble.newDevice(deviceName1)).thenReturn(deviceDouble1);
        when(factoryDeviceDouble.newDevice(deviceName2)).thenReturn(deviceDouble2);


        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);

        //Act
        myRoom.addDevice(deviceName1);
        myRoom.addDevice(deviceName2);

        //Assert
        assertEquals(myRoom.getDevices().size(), 2);
        assertEquals(myRoom.getRoomName(), "Bedroom");
        assertEquals(myRoom.getFloorNumber(), 0);
        assertEquals(myRoom.getArea(), 25.0);
        assertEquals(myRoom.getHeight(), 3.2);
    }

    @Test
    void emptyNameDevice_shouldThrowException() throws InstantiationException {
        // Arrange
        String expectedMessage = "Device name cannot be null or empty";

        String deviceName = "";

        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        when(factoryDeviceDouble.newDevice(deviceName)).thenThrow(new IllegalArgumentException(expectedMessage));

        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);

        // Act + Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                myRoom.addDevice(deviceName));

        // Act
        String actualMessage = exception.getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(myRoom.getDevices().size(), 0);
    }

    @Test
    void nullNameDevice_shouldThrowException() throws InstantiationException {
        // Arrange
        String expectedMessage = "Device name cannot be null or empty";

        String deviceName = null;

        FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
        when(factoryDeviceDouble.newDevice(deviceName)).thenThrow(new IllegalArgumentException(expectedMessage));

        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);

        // Act + Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                myRoom.addDevice(deviceName));

        // Act
        String actualMessage = exception.getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(myRoom.getDevices().size(), 0);
    }

        @Test
        void duplicateDeviceName_shouldThrowException() throws InstantiationException {
            // Arrange
            String existingDeviceName = "Device1";
            String expectedMessage = "Device name already exists in the list";

            Device deviceDouble = mock(Device.class);
            when(deviceDouble.getDeviceName()).thenReturn(existingDeviceName);

            // Create a mock FactoryDevice
            FactoryDevice factoryDeviceDouble = mock(FactoryDevice.class);
            when(factoryDeviceDouble.newDevice(existingDeviceName)).thenReturn(deviceDouble);


            // Create a Room instance with a mocked FactoryDevice
            Room room = new Room("Bedroom", 0, 25.0, 3.2, factoryDeviceDouble);

            // Add a device with an existing name
            room.addDevice(existingDeviceName);

            // Act & Assert

            // Adding a device with a duplicate name
            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    room.addDevice(existingDeviceName));

            // Get the actual exception message
            String actualMessage = exception.getMessage();

            // Assert
            assertTrue(actualMessage.contains(expectedMessage));
            assertEquals(room.getDevices().size(), 1);
        }
    }



