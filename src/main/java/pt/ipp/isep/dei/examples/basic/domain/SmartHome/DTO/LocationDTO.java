package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

public class LocationDTO {

    private String _address;
    private String _zipCode;
    private double _latitude;
    private double _longitude;

    /**
     * Constructor for creating a LocationDTO.
     *
     * @param zipCode
     * @param address
     * @param latitude
     * @param longitude
     */
    public LocationDTO(String address, String zipCode, Double latitude, Double longitude) {

        this._address = address;
        this._zipCode = zipCode;
        this._latitude = latitude;
        this._longitude = longitude;
    }

    /**
     * Gets the zip code.
     */
    public String getZipCode() {

        return _zipCode;
    }

    /**
     * Gets the address.
     */
    public String getAddress() {

        return _address;
    }

    /**
     * Gets the latitude.
     */
    public double getLatitude() {

        return _latitude;
    }

    /**
     * Gets the longitude.
     */
    public double getLongitude() {

        return _longitude;
    }
}