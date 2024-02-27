package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomTest {

    @Test
    void emptyNameDevice_shouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Device name cannot be null or empty";

        //act
        Room myRoom = new Room("Bedroom", 0, 25.0, 3.2);
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
    void repeatedDeviceName_ShouldThrowException() throws InstantiationException {
        //arrange
        String expected = "Device name already exists in the list";

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



}
