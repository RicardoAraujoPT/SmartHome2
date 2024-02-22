package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
import java.util.Objects;


public class House {

    private Location _location;

    private ArrayList <Room> _rooms;

    public House (String address, String zipCode, double latitude, double longitude){
        //if (!isAddressValid(address) || !isZipCodeValid(zipCode) || !isLatitudeValid(latitude) || !isLongitudeValid(longitude)){
            //throw new IllegalArgumentException("Invalid arguments");


        this._location = new Location(address, zipCode, latitude, longitude);
        this._rooms = new ArrayList<>();
    }

    public Location getLocation(){

        return this._location;
    }

    public ArrayList<Room> getRooms(){

        return new ArrayList<>(_rooms);
    }

    public Room createRoom(String roomName, int floorNumber, double area, double height) throws InstantiationException {

        Room myRoom = new Room(roomName, floorNumber, area, height);

        this._rooms.add(myRoom);

        return myRoom;
    }

    /**
     * Method to get the House's RoomList.
     *
     * @return List<Room> (copy) representing the room list of the house.
     */
    public ArrayList<Room> getRoomList() {

        return new ArrayList<>(_rooms);
    }

    /**
     * Method to configure the location (ZIP code and address) of the House.
     *
     * @param address The new address.
     * @param zipCode The new ZIP code.
     * @param latitude The new latitude.
     * @param longitude The new longitude.
     * @return Boolean indicating if the configuration was successful.
     */
    public boolean configureLocation(String address, String zipCode, Double latitude, Double longitude) {
        if (address == null || zipCode == null || latitude == null || longitude == null) {
            return false;
        }
        this._location= new Location(address, zipCode, latitude, longitude);
        return true;
    }
}
