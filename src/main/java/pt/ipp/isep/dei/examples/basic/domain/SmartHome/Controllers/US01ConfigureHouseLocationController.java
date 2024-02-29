package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.LocationDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.LocationMapper;

/**
 * The ConfigureHouseLocationController class represents a controller for the use case "Configure House Location".
 * It provides a method to configure the location of a house.
 */
public class US01ConfigureHouseLocationController {
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
    public US01ConfigureHouseLocationController(House house) throws InstantiationException {
        if (house == null) {
            throw new InstantiationException("Invalid house");
        }
        this._myHouse = house;
    }

    /**
     * Configures the location and GPS coordinates of the house.
     *
     * @param locationDTO The LocationDTO containing information for configuring the house.
     * @return LocationDTO The LocationDTO of the house after configuration.
     */
    public LocationDTO configureHouseLocation(LocationDTO locationDTO) throws InstantiationException {

        this._myHouse.configureLocation(locationDTO.getAddress(), locationDTO.getZipCode(), locationDTO.getLatitude(), locationDTO.getLongitude());

        return LocationMapper.domain2DTO(_myHouse.getLocation());
    }
}