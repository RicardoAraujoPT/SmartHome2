package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.LocationDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.LocationDTOMapper;

/**
 * The ConfigureHouseLocationController class represents a controller for the use case "Configure House Location".
 * It provides a method to configure the location of a house.
 */
public class ConfigureHouseLocationController {
    /**
     * The house being configured.
     */
    private House _myHouse;

    /**
     * Constructs a ConfigureHouseLocationController with the specified house.
     *
     * @param house The House object to be configured. Must not be null.
     * @throws IllegalArgumentException If the provided house is null.
     */
    public ConfigureHouseLocationController(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Invalid house");
        }
        this._myHouse = house;
    }

    /**
     * Configures the location and GPS coordinates of the house.
     *
     * @param address   The address of the house.
     * @param zipCode   The zip code of the house.
     * @param latitude  The latitude of the house.
     * @param longitude The longitude of the house.
     * @return LocationDTO The location of the house.
     */
    public LocationDTO configureHouseLocation(String address, String zipCode, double latitude, double longitude) throws IllegalArgumentException {

        this._myHouse.configureLocation(address, zipCode, latitude, longitude);

        return LocationDTOMapper.domain2DTO(_myHouse.getLocation());
    }
}