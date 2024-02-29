package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryGPSCoordinates;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationTest {

    /**
     * This test verifies that the Location constructor correctly creates a new Location instance.
     */
    @Test
    void validParameters_ShouldNotThrowException() throws InstantiationException {

        // Arrange
        String expectedAddress = "Address";
        String expectedZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();

        // Act
        Location location = new Location(expectedAddress, expectedZipCode, factoryGPSCoordinates);

        // Assert
        assertEquals(expectedAddress, location.getAddress());
        assertEquals(expectedZipCode, location.getZipCode());
    }

    /**
     * Verifies that the Location constructor correctly throws an InstantiationException when given a null address.
     * It does this by attempting to create a new Location instance with a null address and then checking that an
     * InstantiationException is thrown with the message "Invalid address or ZIP code".
     */
    @Test
    void nullAddress_ShouldThrowException() {

        // Arrange
        String address = null;
        String zipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        String expectedMessage = "Invalid address or ZIP code";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Location(address, zipCode, factoryGPSCoordinates));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an InstantiationException when given a null zip code.
     * It does this by attempting to create a new Location instance with a null zip code and then checking that an
     * InstantiationException is thrown with the message "Invalid address or ZIP code".
     */
    @Test
    void nullZipCode_ShouldThrowException() {

        // Arrange
        String address = "Address";
        String zipCode = null;
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        String expectedMessage = "Invalid address or ZIP code";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Location(address, zipCode, factoryGPSCoordinates));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an InstantiationException when given an empty address.
     * It does this by attempting to create a new Location instance with an empty address and then checking that an
     * InstantiationException is thrown with the message "Invalid address or ZIP code".
     */
    @Test
    void emptyAddress_ShouldThrowException() {

        // Arrange
        String address = "";
        String zipCode = "ZipCode";
        String expectedMessage = "Invalid address or ZIP code";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Location(address, zipCode, factoryGPSCoordinates));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an InstantiationException when given an empty zip code.
     * It does this by attempting to create a new Location instance with an empty zip code and then checking that an
     * InstantiationException is thrown with the message "Invalid address or ZIP code".
     */
    @Test
    void emptyZipCode_ShouldThrowException() {

        // Arrange
        String address = "Address";
        String zipCode = "";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        String expectedMessage = "Invalid address or ZIP code";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Location(address, zipCode, factoryGPSCoordinates));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the setAddress method in the Location class correctly updates the address of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new address, and then checking that
     * the setAddress method returns true and the getAddress method returns the new address.
     */
    @Test
    void setAddress_ValidAddress_ShouldReturnTrue() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);
        String newAddress = "New Address";

        // Act
        boolean result = location.setAddress(newAddress);

        // Assert
        assertTrue(result);
        assertEquals(newAddress, location.getAddress());
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given a null address.
     * It does this by creating a new Location instance, attempting to set a null address, and then checking that
     * the setAddress method returns false.
     */
    @Test
    void setAddress_NullAddress_ShouldReturnFalse() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);

        // Act
        boolean result = location.setAddress(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given an empty address.
     * It does this by creating a new Location instance, attempting to set an empty address, and then checking that
     * the setAddress method returns false.
     */
    @Test
    void setAddress_EmptyAddress_ShouldReturnFalse() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);

        // Act
        boolean result = location.setAddress("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly updates the zip code of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new zip code, and then checking that
     * the setZipCode method returns true and the getZipCode method returns the new zip code.
     */
    @Test
    void setZipCode_ValidZipCode_ShouldReturnTrue() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);
        String newZipCode = "New ZipCode";

        // Act
        boolean result = location.setZipCode(newZipCode);

        // Assert
        assertTrue(result);
        assertEquals(newZipCode, location.getZipCode());
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given a null zip code.
     * It does this by creating a new Location instance, attempting to set a null zip code, and then checking that
     * the setZipCode method returns false.
     */
    @Test
    void setZipCode_NullZipCode_ShouldReturnFalse() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);

        // Act
        boolean result = location.setZipCode(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given an empty zip code.
     * It does this by creating a new Location instance, attempting to set an empty zip code, and then checking that
     * the setZipCode method returns false.
     */
    @Test
    void setZipCode_EmptyZipCode_ShouldReturnFalse() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinates);

        // Act
        boolean result = location.setZipCode("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the getAddress method in the Location class correctly returns the address of the Location instance.
     * It does this by creating a new Location instance with a valid address and then checking that
     * the getAddress method returns the expected address.
     */
    @Test
    void shouldGetAddress() throws InstantiationException {

        // Arrange
        String expectedAddress = "Address";
        String initialZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(expectedAddress, initialZipCode, factoryGPSCoordinates);

        // Act
        String result = location.getAddress();

        // Assert
        assertEquals(expectedAddress, result);
    }

    /**
     * Verifies that the getZipCode method in the Location class correctly returns the zip code of the Location instance.
     * It does this by creating a new Location instance with a valid zip code and then checking that
     * the getZipCode method returns the expected zip code.
     */
    @Test
    void shouldGetZipCode() throws InstantiationException {

        // Arrange
        String initialAddress = "Address";
        String expectedZipCode = "ZipCode";
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        Location location = new Location(initialAddress, expectedZipCode, factoryGPSCoordinates);

        // Act
        String result = location.getZipCode();

        // Assert
        assertEquals(expectedZipCode, result);
    }

    /**
     * Verifies that the getGPSCoordinates method in the Location class correctly returns the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance, calling its defineGPSCoordinates method with valid latitude and longitude coordinates
     * and then checking that the getGPSCoordinates method returns the expected coordinates.
     */
    @Test
    void shouldDefineAndGetGPSCoordinates() throws InstantiationException {

        // Arrange
        double validLatitude = 37.7749;
        double validLongitude = -122.4194;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = new FactoryGPSCoordinates();
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble);

        // Act
        location.defineGPSCoordinates(validLatitude, validLongitude);
        GPSCoordinates result = location.getGPSCoordinates();

        // Assert
        assertEquals(validLatitude, result.getLatitude());
        assertEquals(validLongitude, result.getLongitude());
    }

    /**
     * Verifies that the defineGPSCoordinates method in the Location class correctly throws an InstantiationException when given an invalid latitude.
     * It does this by creating a new Location instance and then calling its defineGPSCoordinates method with an invalid latitude.
     * It then checks that an InstantiationException is thrown with the message "Invalid GPS coordinates".
     */
    @Test
    void invalidLatitude_ShouldThrowException() throws InstantiationException {

        // Arrange
        String expectedMessage = "Invalid GPS coordinates";

        double invalidLatitude = 100;
        double validLongitude = -122.4194;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = new FactoryGPSCoordinates();
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble);

        // Act + Assert
        Exception exception = assertThrows(InstantiationException.class, () -> location.defineGPSCoordinates(invalidLatitude, validLongitude));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the defineGPSCoordinates method in the Location class correctly throws an InstantiationException when given an invalid longitude.
     * It does this by creating a new Location instance and then calling its defineGPSCoordinates method with an invalid longitude.
     * It then checks that an InstantiationException is thrown with the message "Invalid GPS coordinates".
     */
    @Test
    void invalidLongitude_ShouldThrowException() throws InstantiationException {

        // Arrange
        String expectedMessage = "Invalid GPS coordinates";

        double validLatitude = 37.7749;
        double invalidLongitude = 200;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = new FactoryGPSCoordinates();
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble);

        // Act + Assert
        Exception exception = assertThrows(InstantiationException.class, () -> location.defineGPSCoordinates(validLatitude, invalidLongitude));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}