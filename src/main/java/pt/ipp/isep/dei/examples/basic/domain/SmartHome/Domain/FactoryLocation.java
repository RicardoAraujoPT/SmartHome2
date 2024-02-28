package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
public class FactoryLocation
{
    FactoryGPSCoordinates _factoryGPSCoordinates;

    public FactoryLocation(FactoryGPSCoordinates factoryGPSCoordinates)
    {
        _factoryGPSCoordinates = factoryGPSCoordinates;
    }

    public Location createLocation(String address, String zipcode,FactoryGPSCoordinates _factoryGPSCoordinates) throws InstantiationException {
    {
        return new Location(address,zipcode, _factoryGPSCoordinates);
    }
}

/*
        public ArrayList<Room> initRooms(){

        }

         */


    }

