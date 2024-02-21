package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * This class represents a geographic location with latitude and longitude coordinates.
 * A decimal degree (DD) notation is used for the coordinates.
 * When using this notation, coordinates are tipically stored with a precision of up to 6 decimal places.
 * Values with more than 6 decimal places will therefore be rounded.
 */
public class GPSCoordinates {

    /** The latitude coordinate. Valid range is from -90.0 to 90.0. */
    private double latitude;

    /** The longitude coordinate. Valid range is from -180.0 to 180.0. */
    private double longitude;

    /**
     * Constructs a GPSCoordinates object with the specified latitude and longitude.
     *
     * @param latitude  The latitude coordinate to set. Must be within the valid range.
     * @param longitude The longitude coordinate to set. Must be within the valid range.
     * @throws IllegalArgumentException If the provided coordinates are invalid.
     */
    public GPSCoordinates(double latitude, double longitude) {
        if (!isLatitudeValid(latitude) || !isLongitudeValid(longitude)) {
            throw new IllegalArgumentException("Invalid GPS coordinates");
        }
        this.latitude = roundTo6DecimalPlaces(latitude);
        this.longitude = roundTo6DecimalPlaces(longitude);
    }

    /**
     * Gets the latitude coordinate.
     *
     * @return The latitude coordinate.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude coordinate.
     *
     * @param latitude The latitude coordinate to set. Must be within the valid range.
     * @throws IllegalArgumentException If the provided latitude is invalid.
     */
    public void setLatitude(double latitude) {
        if (!isLatitudeValid(latitude)) {
            throw new IllegalArgumentException("Invalid latitude. Must be between -90.0 and 90.0.");
        }
        this.latitude = roundTo6DecimalPlaces(latitude);
    }

    /**
     * Gets the longitude coordinate.
     *
     * @return The longitude coordinate.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude coordinate.
     *
     * @param longitude The longitude coordinate to set. Must be within the valid range.
     * @throws IllegalArgumentException If the provided longitude is invalid.
     */
    public void setLongitude(double longitude) {
        if (!isLongitudeValid(longitude)) {
            throw new IllegalArgumentException("Invalid longitude. Must be between -180.0 and 180.0.");
        }
        this.longitude = roundTo6DecimalPlaces(longitude);
    }

    /**
     * Checks if the provided latitude is within the valid range.
     *
     * @param latitude The latitude to check.
     * @return True if the latitude is valid, false otherwise.
     */
    public static boolean isLatitudeValid(double latitude) {
        return latitude >= -90.0 && latitude <= 90.0;
    }

    /**
     * Checks if the provided longitude is within the valid range.
     *
     * @param longitude The longitude to check.
     * @return True if the longitude is valid, false otherwise.
     */
    public static boolean isLongitudeValid(double longitude) {
        return longitude >= -180.0 && longitude <= 180.0;
    }

    /**
     * Rounds the given value to 6 decimal places.
     *
     * @param value The value to round.
     * @return The rounded value.
     */
    private static double roundTo6DecimalPlaces(double value) {
        return Math.round(value * 1e6) / 1e6;
    }
}