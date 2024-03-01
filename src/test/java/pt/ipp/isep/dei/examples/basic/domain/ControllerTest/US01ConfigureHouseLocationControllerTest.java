package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US01ConfigureHouseLocationController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.LocationDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for ConfigureHouseLocationController.
 */
public class US01ConfigureHouseLocationControllerTest {

    /**
     * Verifies that configureHouseLocation method returns a properly configured LocationDTO.
     */
    @Test
    void shouldConfigureHouseLocation() throws InstantiationException {

        // Arrange
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        House myHouse = new House(factoryLocation, factoryRoom);
        US01ConfigureHouseLocationController myController = new US01ConfigureHouseLocationController(myHouse);
        LocationDTO inputDTO = new LocationDTO("NewAddress", "NewZipCode", 65.000000, 115.000000);

        String expectedAddress = "NewAddress";
        String expectedZipCode = "NewZipCode";
        double expectedLatitude = 65.000000;
        double expectedLongitude = 115.000000;

        // Act
        LocationDTO resultDTO = myController.configureHouseLocation(inputDTO);

        // Assert
        assertEquals(expectedAddress, resultDTO.getAddress());
        assertEquals(expectedZipCode, resultDTO.getZipCode());
        assertEquals(expectedLatitude, resultDTO.getLatitude());
        assertEquals(expectedLongitude, resultDTO.getLongitude());
    }

    /**
     * Test case to verify that providing a null house to the controller constructor throws an IllegalArgumentException.
     */
    @Test
    void nullHouse_shouldThrowInstantiationException() {
        // Arrange
        House myHouse = null;
        String expectedMessage = "Invalid house";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { new US01ConfigureHouseLocationController(myHouse); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing a null address to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    void nullAdress_shouldThrowInstantiationException() throws InstantiationException {

        // Arrange
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);

        House myHouse = new House(factoryLocation, factoryRoom);
        US01ConfigureHouseLocationController myController = new US01ConfigureHouseLocationController(myHouse);
        LocationDTO inputDTO = new LocationDTO(null, "NewZipCode", 65.000000, 115.000000);
        String expectedMessage = "Invalid address or ZIP code";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.configureHouseLocation(inputDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing a null zip code to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    void nullZipCode_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        US01ConfigureHouseLocationController myController = new US01ConfigureHouseLocationController(myHouse);
        LocationDTO inputDTO = new LocationDTO("NewAddress", null, 65.000000, 115.000000);
        String expectedMessage = "Invalid address or ZIP code";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.configureHouseLocation(inputDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing an invalid latitude to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    void invalidLatitude_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        US01ConfigureHouseLocationController myController = new US01ConfigureHouseLocationController(myHouse);
        LocationDTO inputDTO = new LocationDTO("NewAddress", "NewZipCode", 95.000000, 115.000000);
        String expectedMessage = "Invalid GPS coordinates";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.configureHouseLocation(inputDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing an invalid longitude to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    void invalidLongitude_shouldThrowInstantiationException() throws InstantiationException {
        // Arrange
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation, factoryRoom);
        US01ConfigureHouseLocationController myController = new US01ConfigureHouseLocationController(myHouse);
        LocationDTO inputDTO = new LocationDTO("NewAddress", "NewZipCode", 65.000000, 195.000000);
        String expectedMessage = "Invalid GPS coordinates";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> { myController.configureHouseLocation(inputDTO); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }
}