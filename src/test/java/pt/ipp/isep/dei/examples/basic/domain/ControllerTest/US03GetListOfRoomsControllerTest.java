package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US03GetListOfRoomsController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryDevice;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryLocation;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryRoom;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class is responsible for testing the US03GetListOfRoomsController class.
 * It verifies the correct behavior of the methods in the US03GetListOfRoomsController class.
 */
public class US03GetListOfRoomsControllerTest {


    /**
     * This test verifies that the constructor of the US03GetListOfRoomsController class throws an IllegalArgumentException
     * when a null House object is passed as an argument.
     *
     * @throws IllegalArgumentException
     */
    @Test
    void nullHouse_shouldThrowIllegalArgumentException() {
        //Arrange
        House myHouse = null;
        //act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US03GetListOfRoomsController(myHouse));
        //assert
        assertEquals("Invalid house", exception.getMessage());
    }


    /**
     * This test verifies that the getRoomList method of the House class returns an empty list
     * when no rooms have been added to the house.
     */
    @Test
    void emptyRoomList_shouldFindEmptyList() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);

        //Act + Assert
        assertEquals(new ArrayList<>(), myHouse.getRoomList());
    }


    /**
     * This test verifies that the getRoomList method of the US03GetListOfRoomsController class returns a list
     * of the correct size when several rooms have been added to the house.
     */
    @Test
    void validArguments_shouldAddSeveralRoomsToHouse() throws InstantiationException {
        //Arrange
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);

        myHouse.addRoom("Bedroom", 0, 35, 2.5);
        myHouse.addRoom("Guest Room", 0, 35, 2.5);
        myHouse.addRoom("Kitchen", 0, 35, 2.5);
        myHouse.addRoom("Bathroom", 0, 35, 2.5);
        US03GetListOfRoomsController myController = new US03GetListOfRoomsController(myHouse);
        //Act
        int expected = myHouse.getRoomList().size();
        int found = myController.getRoomList().size();
        //Assert
        assertEquals(found, expected);
    }

}
