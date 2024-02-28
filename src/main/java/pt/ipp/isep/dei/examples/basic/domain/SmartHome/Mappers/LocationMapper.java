package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.LocationDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;

public class LocationMapper {
    public static LocationDTO domain2DTO(Location location) {
        return new LocationDTO(location.getAddress(), location.getZipCode(), location.getGpsCoordinates().getLatitude(), location.getGpsCoordinates().getLongitude());
    }
}
