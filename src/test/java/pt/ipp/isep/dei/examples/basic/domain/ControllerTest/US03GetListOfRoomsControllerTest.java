package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US03GetListOfRoomsController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class US03GetListOfRoomsControllerTest {


    @Test
    void nullHouse_shouldThrowIllegalArgumentException() {
        //Arrange
        House myHouse = null;
        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US03GetListOfRoomsController(myHouse));
        //assert
        assertEquals("Invalid house", exception.getMessage());
    }

    @Test
    void emptyRoomList_shouldFindEmptyList() {
        //Arrange
        House myHouse = new House("zipCode","street",90.0,30.0);
        //Act + Assert
        assertEquals(new ArrayList<>(), myHouse.getRoomList());
    }

    @Test
    void validArguments_shouldAddSeveralRoomsToHouse() throws InstantiationException {
        //Arrange
        House myHouse = new House("rua algures","5000-300",90.0,30.0);
        myHouse.createRoom("Bedroom", 0, 35, 2.5);
        myHouse.createRoom("Guest Room", 0, 35, 2.5);
        myHouse.createRoom("Kitchen", 0, 35, 2.5);
        myHouse.createRoom("Bathroom", 0, 35, 2.5);
        US03GetListOfRoomsController myController = new US03GetListOfRoomsController(myHouse);
        //Act
        int expected = myHouse.getRoomList().size();
        int found = myController.getRoomList().size();
        //Assert
        assertEquals(found, expected);
    }




}
