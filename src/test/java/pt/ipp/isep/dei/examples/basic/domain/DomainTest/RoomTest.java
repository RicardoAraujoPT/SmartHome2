package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {

    @Test
    public void createBedroom() throws InstantiationException {

        Room bedroom = new Room("Bedroom1", 1, 25, 2.8);
    }

    @Test
    public void newNullNameRoom() {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room(null, 1,25,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void newEmptyNameRoom () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room("", 1,25,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void newBlankNameRoom () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room(" ", 1,25,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void newInvalidHouseFloor () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room("Bedroom", null,25,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void newZeroAreaRoom () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room("Bedroom", 1,0,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void newNegativeAreaRoom () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room("Bedroom", 1,-10,2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newNegativeHeightRoom () {
        //Arrange
        String expectedMessage = "Invalid arguments";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> new Room("Bedroom", 1,25,-2.5));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void getValidRoomName() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        String expected = "Bedroom";
        //Act
        String found = myRoom.getRoomName();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getValidFloorNumber() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        Integer expected = 0;
        //Act
        Integer found = myRoom.getFloorNumber();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getValidArea() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        Double expected = 25.0;
        //Act
        Double found = myRoom.getArea();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getValidHeight() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        Double expected = 3.2;
        //Act
        Double found = myRoom.getHeight();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void getEmptyDeviceList() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        ArrayList expected = new ArrayList<>();
        //Act
        ArrayList <Device> found = myRoom.getDevices();
        //Assert
        assertEquals(expected, found);
    }

    @Test
    public void createDeviceInRoom() throws InstantiationException {
        //Arrange
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        String expected = "Device Test";
        //Act
        Device myDevice = myRoom.createDevice("Device Test");
        String found = myDevice.getDeviceName();
        //Assert
        assertEquals(expected, found);
    }


}
