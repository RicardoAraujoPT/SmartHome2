package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

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


}
