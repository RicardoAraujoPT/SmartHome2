package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US02CreateRoomController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for US02CreateRoomController
 */

public class US02CreateRoomControllerTest {
    @Test
    void validArguments_shouldCreateValidRoom() throws InstantiationException {
        //Arrange
        String roomName = "Test Room";
        Integer houseFloor = 0;
        Double area = 25.0;
        Double height = 3.2;

        FactoryLocation fLocationDouble = mock(FactoryLocation.class);
        FactoryRoom fRoomDouble = mock(FactoryRoom.class);

        Room roomDouble = mock(Room.class);
        when(fRoomDouble.createRoom(roomName, houseFloor, area, height)).thenReturn(roomDouble);
        when(roomDouble.getRoomName()).thenReturn(roomName);
        when(roomDouble.getFloorNumber()).thenReturn(houseFloor);
        when(roomDouble.getArea()).thenReturn(area);
        when(roomDouble.getHeight()).thenReturn(height);

        House myHouse = new House(fLocationDouble, fRoomDouble);

        US02CreateRoomController myController = new US02CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO(roomName, houseFloor, area, height);
        //Act
        RoomDTO result =  myController.createRoom(roomDTO);
        //Assert
        assertEquals(result.getName(), roomDTO.getName());
        assertEquals(result.getHouseFloor(), roomDTO.getHouseFloor());
        assertEquals(result.getArea(), roomDTO.getArea());
        assertEquals(result.getHeight(), roomDTO.getHeight());
    }

    @Test
    void nullRoomName_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        String expectedMessage = "Invalid arguments";
        String roomName = null;
        Integer houseFloor = 0;
        Double area = 25.0;
        Double height = 3.2;

        FactoryLocation fLocationDouble = mock(FactoryLocation.class);
        FactoryRoom fRoomDouble = mock(FactoryRoom.class);

        when(fRoomDouble.createRoom(roomName, houseFloor, area, height)).thenThrow(new InstantiationException(expectedMessage));

        House myHouse = new House(fLocationDouble, fRoomDouble);

        US02CreateRoomController myController = new US02CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO(roomName, houseFloor, area, height);

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.createRoom(roomDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void negativeArea_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        String expectedMessage = "Invalid arguments";
        String roomName = "Test Room";
        Integer houseFloor = 0;
        Double area = -25.0;
        Double height = 3.2;

        FactoryLocation fLocationDouble = mock(FactoryLocation.class);
        FactoryRoom fRoomDouble = mock(FactoryRoom.class);

        when(fRoomDouble.createRoom(roomName, houseFloor, area, height)).thenThrow(new InstantiationException(expectedMessage));

        House myHouse = new House(fLocationDouble, fRoomDouble);

        US02CreateRoomController myController = new US02CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO(roomName, houseFloor, area, height);

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.createRoom(roomDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void negativeHeight_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        String expectedMessage = "Invalid arguments";
        String roomName = "Test Room";
        Integer houseFloor = 0;
        Double area = 25.0;
        Double height = -3.2;

        FactoryLocation fLocationDouble = mock(FactoryLocation.class);
        FactoryRoom fRoomDouble = mock(FactoryRoom.class);

        when(fRoomDouble.createRoom(roomName, houseFloor, area, height)).thenThrow(new InstantiationException(expectedMessage));

        House myHouse = new House(fLocationDouble, fRoomDouble);

        US02CreateRoomController myController = new US02CreateRoomController(myHouse);
        RoomDTO roomDTO = new RoomDTO(roomName, houseFloor, area, height);

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
        Exception exception = assertThrows(InstantiationException.class, () -> new US02CreateRoomController(null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
