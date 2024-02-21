package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Class that allows the instantiation of Location objects.
 * House objects are constructed by configuring its ZIP code, address and GPS coordinates.
 * The zip code and address are represented by Strings.
 * The GPS coordinates are represented by a GPSCoordinates object.
 */
public class Location {

    private String _zipCode;
    private String _address;
    private GPSCoordinates _gpsCoordinates;

    /**
     * Constructor method that allows the instantiation of Location objects, with the following inputs:
     *
     * @param zipCode
     * @param address
     * @param latitude
     * @param longitude
     */
    public Location(String zipCode, String address, Double latitude, Double longitude) {
        if (!isZipCodeValid(zipCode) || !isAddressValid(address)) {
            throw new IllegalArgumentException("Invalid ZIP code or address");
        }
        this._zipCode = zipCode;
        this._address = address;
        this._gpsCoordinates = new GPSCoordinates(latitude, longitude);
    }

    /**
     * Method that verifies if ZIP code is null or empty
     * @param zipCode
     * @return boolean
     */
    private boolean isZipCodeValid(String zipCode) {
        return zipCode != null && !zipCode.trim().isEmpty();
    }

    /**
     * Method that verifies if street name is null or empty
     * @param address
     * @return boolean
     */
    private boolean isAddressValid(String address) {
        return address != null && !address.trim().isEmpty();
    }

    /**
     * Method to obtain the ZIP code of the Location objects
     * @return String
     */
    public String getZipCode(){
        return _zipCode;
    }

    /**
     * Method to obtain the street name of the Location objects
     * @return String
     */
    public String getAddress(){
        return _address;
    }

    /**
     * Method to obtain the GPS coordinates of the Location objects
     * @return GPSCoordinates
     */
    public GPSCoordinates getGpsCoordinates() {
        return _gpsCoordinates;
    }

    /**
     * Method to modify the street name of the Location objects
     */
    public void setAddress(String address) {
        this._address = address;
    }

    /**
     * Method to modify the street name of the Location objects
     */
    public void setZipCode(String zipCode) {
        this._zipCode = zipCode;
    }

    /**
     * Method to modify the GPS coordinates of the Location objects
     */
    public void setGpsCoordinates(double latitude, double longitude) {
        this._gpsCoordinates = new GPSCoordinates(latitude, longitude);
    }
}