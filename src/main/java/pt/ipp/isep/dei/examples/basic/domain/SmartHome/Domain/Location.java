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
     * @param address
     * @param zipCode
     * @param latitude
     * @param longitude
     */
    public Location(String address, String zipCode, Double latitude, Double longitude) {
        if (!isAddressValid(address) || !isZipCodeValid(zipCode)) {
            throw new IllegalArgumentException("Invalid ZIP code or address");
        }
        this._address = address;
        this._zipCode = zipCode;
        this._gpsCoordinates = new GPSCoordinates(latitude, longitude);
    }

    /**
     * Method that verifies if street name is null or empty.
     * @param address
     * @return boolean
     */
    private boolean isAddressValid(String address) {
        return address != null && !address.trim().isEmpty();
    }

    /**
     * Method that verifies if ZIP code is null or empty.
     * @param zipCode
     * @return boolean
     */
    private boolean isZipCodeValid(String zipCode) {
        return zipCode != null && !zipCode.trim().isEmpty();
    }

    /**
     * Method to obtain the street name of the Location objects.
     * @return String
     */
    public String getAddress(){
        return _address;
    }

    /**
     * Method to obtain the ZIP code of the Location objects.
     * @return String
     */
    public String getZipCode(){
        return _zipCode;
    }

    /**
     * Method to obtain the GPS coordinates of the Location objects.
     * @return GPSCoordinates
     */
    public GPSCoordinates getGpsCoordinates() {
        return _gpsCoordinates;
    }

    /**
     * This method is used to set the address of the Location.
     * If the address is null or empty, it returns false and does not change the current address.
     * Otherwise, it sets the address of the Location to the provided address and returns true.
     * @param address
     * @return boolean
     */
    public boolean setAddress(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }
        this._address = address;
        return true;
    }

    /**
     * This method is used to set the zip code of the Location.
     * If the zip code is null or empty, it returns false and does not change the current zip code.
     * Otherwise, it sets the zip code of the Location to the provided zip code and returns true.
     * @param zipCode
     * @return boolean
     */
    public boolean setZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            return false;}
        this._zipCode = zipCode;
        return true;
    }

    /**
     * Method to set the GPS coordinates of the Location objects.
     * @param latitude
     * @param longitude
     * @return boolean
     */
    public boolean setGpsCoordinates(Double latitude, Double longitude) {
        if (latitude == null || longitude == null) {
            return false;
        }
        this._gpsCoordinates.setLatitude(latitude);
        this._gpsCoordinates.setLongitude(longitude);
        return this._gpsCoordinates.getLatitude() == latitude && this._gpsCoordinates.getLongitude() == longitude;
    }
}