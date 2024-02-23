package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.ConfigureHouseLocationController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.LocationDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for ConfigureHouseLocationController.
 */
public class ConfigureHouseLocationTest {

    /**
     * Verifies that configureHouseLocation method returns a properly configured LocationDTO.
     */
    @Test
    public void shouldConfigureHouseLocation() {
        // Arrange
        House myHouse = new House("Address", "ZipCode", 55.000000, 105.000000);
        ConfigureHouseLocationController myController = new ConfigureHouseLocationController(myHouse);
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
        assertEquals(expectedLatitude, resultDTO.getGpsCoordinates().getLatitude());
        assertEquals(expectedLongitude, resultDTO.getGpsCoordinates().getLongitude());
    }

    /**
     * Test case to verify that providing a null house to the controller constructor throws an IllegalArgumentException.
     */
    @Test
    public void nullHouse_shouldThrowIllegalArgumentException() {
        // Arrange
        String expectedMessage = "Invalid house";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { new ConfigureHouseLocationController(null); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing a null address to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    public void nullAdress_shouldThrowIllegalArgumentException() {
        // Arrange
        House myHouse = new House("Address", "ZipCode", 55.000000, 105.000000);
        ConfigureHouseLocationController myController = new ConfigureHouseLocationController(myHouse);
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { myController.configureHouseLocation(new LocationDTO(null, "NewZipCode", 65.000000, 115.000000)); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing a null zip code to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    public void nullZipCode_shouldThrowIllegalArgumentException() {
        // Arrange
        House myHouse = new House("Address", "ZipCode", 55.000000, 105.000000);
        ConfigureHouseLocationController myController = new ConfigureHouseLocationController(myHouse);
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { myController.configureHouseLocation(new LocationDTO("NewAddress", null, 65.000000, 115.000000)); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing an invalid latitude to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    public void invalidLatitude_shouldThrowIllegalArgumentException() {
        // Arrange
        House myHouse = new House("Address", "ZipCode", 55.000000, 105.000000);
        ConfigureHouseLocationController myController = new ConfigureHouseLocationController(myHouse);
        String expectedMessage = "Invalid GPS coordinates";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { myController.configureHouseLocation(new LocationDTO("NewAddress", "NewZipCode", 95.000000, 115.000000)); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test case to verify that providing an invalid longitude to the configureHouseLocation method throws an IllegalArgumentException.
     */
    @Test
    public void invalidLongitude_shouldThrowIllegalArgumentException() {
        // Arrange
        House myHouse = new House("Address", "ZipCode", 55.000000, 105.000000);
        ConfigureHouseLocationController myController = new ConfigureHouseLocationController(myHouse);
        String expectedMessage = "Invalid GPS coordinates";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { myController.configureHouseLocation(new LocationDTO("NewAddress", "NewZipCode", 65.000000, 195.000000)); });

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }
}