package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

public class LocationDTO {

    private String _address;
    private String _zipCode;
    private GPSCoordinates _gpsCoordinates;

    /**
     * Constructor for creating a LocationDTO.
     *
     * @param zipCode
     * @param address
     * @param latitude
     * @param longitude
     */
    public LocationDTO(String address, String zipCode, Double latitude, Double longitude) {
        //validação?
        this._address = address;
        this._zipCode = zipCode;
        this._gpsCoordinates = new GPSCoordinates(latitude, longitude);
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
     * Gets the GPScoordinates objects in Location objects.
     */
    public GPSCoordinates getGpsCoordinates() {
        return _gpsCoordinates;
    }
}