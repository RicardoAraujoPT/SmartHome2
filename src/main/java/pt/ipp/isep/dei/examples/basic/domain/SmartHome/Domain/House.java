package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;


public class House {

    private Location _location;

    private ArrayList <Room> _rooms;

    public House (String address, String zipCode, double latitude, double longitude){
        //if (!isAddressValid(address) || !isZipCodeValid(zipCode) || !isLatitudeValid(latitude) || !isLongitudeValid(longitude)){
            //throw new IllegalArgumentException("Invalid arguments");
        //}

        this._location = new Location(address, zipCode, latitude, longitude);
        this._rooms = new ArrayList<>();
    }

    public Location getLocation(){

        return this._location;
    }

    public ArrayList<Room> getRooms(){

        return new ArrayList<>(_rooms);
    }


}
