package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.ListOfRoomsController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ListOfRoomsControllerTest {


    @Test
    public void nullHouse_shouldThrowIllegalArgumentException() {
        //Arrange
        House myHouse = null;
        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ListOfRoomsController(myHouse));
        //assert
        assertEquals("Invalid house", exception.getMessage());
    }

    @Test
    public void emptyRoomList_shouldFindEmptyList() {
        //Arrange
        House myHouse = new House("zipCode","street",90.0,30.0);
        //Act + Assert
        assertEquals(new ArrayList<>(), myHouse.getRoomList());
    }

    @Test
    public void validArguments_shouldAddSeveralRoomsToHouse() throws InstantiationException {
        //Arrange
        House myHouse = new House("rua algures","5000-300",90.0,30.0);
        myHouse.createRoom("Bedroom", 0, 35, 2.5);
        myHouse.createRoom("Guest Room", 0, 35, 2.5);
        myHouse.createRoom("Kitchen", 0, 35, 2.5);
        myHouse.createRoom("Bathroom", 0, 35, 2.5);
        ListOfRoomsController myController = new ListOfRoomsController(myHouse);
        //Act
        int expected = myHouse.getRoomList().size();
        int found = myController.getRoomList().size();
        //Assert
        assertEquals(found, expected);
    }




}
