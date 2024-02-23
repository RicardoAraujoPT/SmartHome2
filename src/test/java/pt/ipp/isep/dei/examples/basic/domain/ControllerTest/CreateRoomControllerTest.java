package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.CreateRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import static org.junit.jupiter.api.Assertions.*;

public class CreateRoomControllerTest {
    @Test
    void validArguments_shouldCreateValidRoom() throws InstantiationException {
        //Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO("Test Room", 0, 25.0, 3.2);
        //Act
        RoomDTO result =  myController.createRoom(roomDTO);
        //Assert
        assertEquals(result.getName(), roomDTO.getName());
    }

    @Test
    void nullRoomName_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        String expectedMessage = "Invalid arguments";
        RoomDTO roomDTO = new RoomDTO(null, 0, 25.0, 3.2);

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.createRoom(roomDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void negativeArea_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        String expectedMessage = "Invalid arguments";
        RoomDTO roomDTO = new RoomDTO("Test Room", 0, -25.0, 3.2);

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.createRoom(roomDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void negativeHeight_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        String expectedMessage = "Invalid arguments";
        RoomDTO roomDTO = new RoomDTO("Test Room", 0, 25.0, -3.2);

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.createRoom(roomDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void nullHouse_shouldThrowInstantiationException() {
        //Arrange
        String expectedMessage = "Invalid house";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new CreateRoomController(null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
