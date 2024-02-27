package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void emptyNameDevice_shouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Invalid arguments";

        //act
        Room myRoom = new Room("Bedroom", 0, 25, 3.2);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myRoom.createDevice(" ");
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    public void nullNameDevice_shouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Invalid arguments";

        //act
        Room myRoom = new Room("Bedroom", 0, 25, 3.2);
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myRoom.createDevice(null);
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }


    @Test
    public void repeatedDeviceName_ShouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Device already exists";

        //act
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
        myRoom.createDevice("myDevice");
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    myRoom.createDevice("myDevice");
                });
        //assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @Test
    public void addTwoValidDevicesToRoom () throws InstantiationException {
        //arrange
        String roomName = "Bathroom";
        int floorNumber = 0;
        double area = 25;
        double height = 3.2;

        Room myRoom = new Room(roomName, floorNumber, area, height);
        //act
        myRoom.createDevice("myDevice1");
        myRoom.createDevice("myDevice2");
        int deviceListSize = myRoom.getDevices().size();
        // assert
        assertEquals(2, deviceListSize);
    }

    }




