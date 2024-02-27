package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;

/** Class that represents a House in a smart home system.
 * House objects are constructed by configuring its location.
 * House objects have a list of rooms that is initialized as empty, so that Room objects can be added to the list.
 */
public class House {

    private FactoryLocation _factoryLocation;
    private FactoryRoom _factoryRoom;

    private Location _location;
    private ArrayList <Room> _rooms;

    /**
     * Constructor method that allows the instantiation of House objects, with the following inputs:
     * @param address
     * @param zipCode
     * @param latitude
     * @param longitude
     */
    public House (String address, String zipCode, double latitude, double longitude){
        this._location = new Location(address, zipCode, latitude, longitude);
        this._rooms = new ArrayList<>();
    }

    //only for isolation tests por agora
    public House(FactoryLocation factoryLocation, FactoryRoom factoryRoom,String address, String zipCode, double latitude, double longitude) throws InstantiationException{

        this._location = factoryLocation.createLocation(address, zipCode, latitude, longitude);

        this._factoryRoom = factoryRoom;

        this._rooms = factoryRoom.initRooms();
    }


    /** Getter for the House's location.
     *
     * @return Location object representing the location of the house.
     */
    public Location getLocation(){

        return this._location;
    }

    /**
     * Method to create a Room object and add it to the House's roomList.
     *
     * @param roomName The name of the room.
     * @param floorNumber The floor number where the room is located.
     * @param area The area of the room in square meters.
     * @param height The height of the room in meters.
     * @return Room object created and added to the House's roomList.
     * @throws InstantiationException if any given attribute for Room is empty or null.
     */
    public Room createRoom(String roomName, int floorNumber, double area, double height) throws InstantiationException {

        Room myRoom = this._factoryRoom.createRoom(roomName, floorNumber, area, height);

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
    public Location configureLocation(String address, String zipCode, Double latitude, Double longitude) throws IllegalArgumentException {
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