package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;

public class FactoryLocation {
    FactoryGPSCoordinates _factoryGPSCoordinates;

    public FactoryLocation() {

    }

    public FactoryLocation(FactoryGPSCoordinates factoryGPSCoordinates) {
        _factoryGPSCoordinates = factoryGPSCoordinates;
    }
    public Location createLocation(String address, String zipCode, double latitude, double longitude) throws InstantiationException{

        return new Location(address, zipCode, latitude, longitude);
    }
    //only for isolation tests por agora

    public Location defineLocation(String address, String zipcode) throws InstantiationException {

        return new Location(address, zipcode, _factoryGPSCoordinates);

    }


}

