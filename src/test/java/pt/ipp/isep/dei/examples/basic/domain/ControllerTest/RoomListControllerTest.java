package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.RoomListController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomListControllerTest {


    @Test
    public void getHouseRoomListManyRooms() {
        //Arrange
        House myHouse = new House("123","street",90.0,30.0);
        myHouse.createRoom("Test Room1", 0, 35, 2.5);
        myHouse.createRoom("Test Room2", 0, 35, 2.5);
        myHouse.createRoom("Test Room3", 0, 35, 2.5);
        myHouse.createRoom("Test Room4", 0, 35, 2.5);
        RoomListController myController = new RoomListController(myHouse);
        //Act
        myHouse.getRooms();
        myController.getHouseRoomList();
        //Assert
        assertEquals(myHouse.getRooms().size(), myController.getHouseRoomList().size());
    }

    @Test
    public void getRoomListNullHouse() {
        //Arrange
        House myHouse = null;
        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new RoomListController(myHouse));
        //assert
        assertEquals("Invalid house", exception.getMessage());
    }

    @Test
    public void getHouseRoomListWithoutRooms() {
        //Arrange
        House myHouse = new House("zipCode","street",90.0,30.0);
        //Act + Assert
        assertEquals(new ArrayList<>(), myHouse.getRooms());
    }

}