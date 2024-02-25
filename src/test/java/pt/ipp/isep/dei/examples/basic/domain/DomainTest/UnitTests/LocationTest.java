package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LocationTest {

    /**
     * This test verifies that the Location constructor correctly creates a new Location instance and the getAddress and getZipCode methods return the correct values.
     * It does this by creating a new Location instance with valid parameters and then checking that the getAddress and getZipCode methods return the expected values.
     */
    @Test
    void validParameters_ShouldNotThrowException() {
        // Arrange
        String expectedAddress = "Address";
        String expectedZipCode = "ZipCode";
        Double expectedLatitude = 90.0000;
        Double expectedLongitude = 180.0000;

        // Act
        Location location = new Location(expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude);

        // Assert
        assertEquals(expectedAddress, location.getAddress());
        assertEquals(expectedZipCode, location.getZipCode());
        assertEquals(expectedLatitude, location.getGpsCoordinates().getLatitude());
        assertEquals(expectedLongitude, location.getGpsCoordinates().getLongitude());
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given a null address.
     * It does this by attempting to create a new Location instance with a null address and then checking that an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void nullAddress_ShouldThrowException() {
        // Arrange
        String address = null;
        String zipCode = "ZipCode";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given a null zip code.
     * It does this by attempting to create a new Location instance with a null zip code and then checking that an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void nullZipCode_ShouldThrowException() {
        // Arrange
        String address = "Address";
        String zipCode = null;
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty address.
     * It does this by attempting to create a new Location instance with an empty address and then checking that an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void emptyAddress_ShouldThrowException() {
        // Arrange
        String address = "";
        String zipCode = "ZipCode";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty zip code.
     * It does this by attempting to create a new Location instance with an empty zip code and then checking that an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void emptyZipCode_ShouldThrowException() {
        // Arrange
        String address = "Address";
        String zipCode = "";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address, ZIP code, latitude or longitude";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the setAddress method in the Location class correctly updates the address of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new address, and then checking that the setAddress method returns true and the getAddress method returns the new address.
     */
    @Test
    void setAddress_ValidAddress_ShouldReturnTrue() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);
        String newAddress = "New Address";

        // Act
        boolean result = location.setAddress(newAddress);

        // Assert
        assertTrue(result);
        assertEquals(newAddress, location.getAddress());
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given a null address.
     * It does this by creating a new Location instance, attempting to set a null address, and then checking that the setAddress method returns false.
     */
    @Test
    void setAddress_NullAddress_ShouldReturnFalse() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setAddress(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given an empty address.
     * It does this by creating a new Location instance, attempting to set an empty address, and then checking that the setAddress method returns false.
     */
    @Test
    void setAddress_EmptyAddress_ShouldReturnFalse() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setAddress("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly updates the zip code of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new zip code, and then checking that the setZipCode method returns true and the getZipCode method returns the new zip code.
     */
    @Test
    void setZipCode_ValidZipCode_ShouldReturnTrue() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);
        String newZipCode = "New ZipCode";

        // Act
        boolean result = location.setZipCode(newZipCode);

        // Assert
        assertTrue(result);
        assertEquals(newZipCode, location.getZipCode());
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given a null zip code.
     * It does this by creating a new Location instance, attempting to set a null zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void setZipCode_NullZipCode_ShouldReturnFalse() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setZipCode(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given an empty zip code.
     * It does this by creating a new Location instance, attempting to set an empty zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void setZipCode_EmptyZipCode_ShouldReturnFalse() {
        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, initialZipCode, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setZipCode("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the getAddress method in the Location class correctly returns the address of the Location instance.
     * It does this by creating a new Location instance with a valid address and then checking that the getAddress method returns the expected address.
     */
    @Test
    void shouldGetAddress() {
        // Arrange
        String expectedAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(expectedAddress, initialZipCode, initialLatitude, initialLongitude);

        // Act
        String result = location.getAddress();

        // Assert
        assertEquals(expectedAddress, result);
    }

    /**
     * Verifies that the getZipCode method in the Location class correctly returns the zip code of the Location instance.
     * It does this by creating a new Location instance with a valid zip code and then checking that the getZipCode method returns the expected zip code.
     */
    @Test
    void shouldGetZipCode() {
        // Arrange
        String initialAddress = "Address";
        String expectedZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        Location location = new Location(initialAddress, expectedZipCode, initialLatitude, initialLongitude);

        // Act
        String result = location.getZipCode();

        // Assert
        assertEquals(expectedZipCode, result);
    }

    /**
     * Verifies that the getGpsCoordinates method in the Location class correctly returns the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance with valid latitude and longitude coordinates and then checking that the getGpsCoordinates method returns the expected coordinates.
     */
    @Test
    void shouldGetGpsCoordinates() {
        // Arrange
        double expectedLatitude = 90.0000;
        double expectedLongitude = 180.0000;
        Location location = new Location("Address", "ZipCode", expectedLatitude, expectedLongitude);

        // Act
        GPSCoordinates result = location.getGpsCoordinates();

        // Assert
        assertEquals(expectedLatitude, result.getLatitude());
        assertEquals(expectedLongitude, result.getLongitude());
    }

    /**
     * This test verifies that the setGpsCoordinates method in the Location class correctly updates the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance, setting new GPS coordinates, and then checking that the getGpsCoordinates method returns the new GPS coordinates.
     */
    @Test
    void shouldSetGpsCoordinatesAndReturnTrue() {
        // Arrange
        Location location = new Location("Address", "ZipCode", 0.0000, 0.0000);
        GPSCoordinates newCoordinates = new GPSCoordinates(90.0000, 180.0000);

        // Act
        location.setGpsCoordinates(newCoordinates);

        // Assert
        assertEquals(newCoordinates, location.getGpsCoordinates());
        assertTrue(location.setGpsCoordinates(newCoordinates));
    }

    /**
     * This test verifies that the setGpsCoordinates method in the Location class correctly returns false when given an invalid latitude.
     * It does this by creating a new Location instance and then attempting to set invalid latitude coordinates, and then checking that the setGpsCoordinates method returns false.
     */
    @Test
    void setGpsCoordinates_NullGpsCoordinates_ShouldReturnFalse() {
        // Arrange
        Location location = new Location("Address", "ZipCode", 0.0000, 0.0000);
        GPSCoordinates invalidCoordinates = null;

        // Act
        boolean result = location.setGpsCoordinates(invalidCoordinates);

        // Assert
        assertFalse(result);
    }
}