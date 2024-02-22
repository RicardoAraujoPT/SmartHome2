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
     * Method to configure the location of the House.
     *
     * @param address The new address.
     * @param zipCode The new ZIP code.
     * @param latitude The new latitude.
     * @param longitude The new longitude.
     * @return the new Location object of the House or null if any of the parameters is null.
     */
    public Location configureLocation(String address, String zipCode, Double latitude, Double longitude) {
        if (address == null || zipCode == null || latitude == null || longitude == null) {
            return null;
        }
        this._location= new Location(address, zipCode, latitude, longitude);
        return this._location;
    }

    /**
     * Method that allows getting a room that exists in the House's roomList.
     *
     * @param name The name of the Room object to retrieve.
     * @return Room object with the specified name.
     * @throws IllegalArgumentException if attempting to get a room that doesn't exist in the House's roomList,
     *                                  or if the name is empty or null.
     */
    public Room getRoomByName(String name) {
        for (int i = 0; i < this._rooms.size(); i++) {
            Room currentRoom = this._rooms.get(i);
            String currentRoomName = currentRoom.getRoomName();
            if (currentRoomName.equals(name)) {
                return currentRoom;
            }
        }
        throw new IllegalArgumentException("Room name doesn't exist in the list");
    }

}
