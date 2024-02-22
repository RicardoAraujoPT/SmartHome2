package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.CreateRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import static org.junit.jupiter.api.Assertions.*;

public class CreateRoomControllerTest {
    @Test
    public void createRoom(){
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
    public void createRoomWithInvalidName(){
        //Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO(null, 0, 25.0, 3.2);
        //Act
        RoomDTO result =  myController.createRoom(roomDTO);
        //Assert
        assertNull(result);
    }

    @Test
    public void createRoomWithInvalidArea(){
        //Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO("Test Room", 0, -25.0, 3.2);
        //Act
        RoomDTO result =  myController.createRoom(roomDTO);
        //Assert
        assertNull(result);
    }

    @Test
    public void createRoomWithInvalidHeight(){
        //Arrange
        House myHouse = new House("address", "zipCode", 55.2, -2.25);
        CreateRoomController myController = new CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO("Test Room", 0, 25.0, -3.2);
        //Act
        RoomDTO result =  myController.createRoom(roomDTO);
        //Assert
        assertNull(result);
    }
}
