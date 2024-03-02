package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     * Method that create house objects.
     * It uses a factory location constructor object to define location and then define gpscoordinates.
     * It uses a factory room constructor object to create room objects.
     *
     * @param factoryLocation location constructor
     * @param factoryRoom room constructor
     */
    public House(FactoryLocation factoryLocation, FactoryRoom factoryRoom) {
        _factoryLocation = factoryLocation;
        _factoryRoom = factoryRoom;
        this._rooms = new ArrayList<>();
    }

    /**
     * Method that create location and gpscoordinates objects.
     * It uses a factory location constructor object to define location and then define gpscoordinates.
     *
     * @param address location address
     * @param zipCode location zip code
     * @param latitude gps latitude
     * @param longitude gps longitude
     *
     * @return location
     */
    public Location defineLocation(String address, String zipCode, double latitude, double longitude) throws InstantiationException{

        this._location = _factoryLocation.defineLocation(address, zipCode);

        this._location.defineGPSCoordinates(latitude, longitude);

        return this._location;

    }

    public Location getLocation(){

        return this._location;
    }


    /**
     * Method that create and add room objects in the house roomList.
     *
     * @param roomName The name of the room.
     * @param floorNumber floor number in the house.
     * @param area room area.
     * @param height room height.
     *
     * @return myRoom.
     */
    public Room addRoom(String roomName, int floorNumber, double area, double height) throws InstantiationException {
        if (isRoomNameDuplicated(roomName)) {
            throw new IllegalArgumentException("Room name already exists");
        }
        Room myRoom = this._factoryRoom.createRoom(roomName, floorNumber, area, height);
        this._rooms.add(myRoom);
        return myRoom;
    }

    /**
     * Method that verifies if there are duplicate room names in the roomList.
     *
     * @param name The name to check for duplicates.
     * @return Boolean indicating whether there are duplicate room names.
     */
    private boolean isRoomNameDuplicated(String name) {
        for (Room room : this._rooms) {
            if (room.getRoomName().equals(name)) {
                return true;
            }
        }
        return false;
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
     * Method that allows getting a room that exists in the House's roomList.
     *
     * @param name The name of the Room object to retrieve.
     * @return Room object with the specified name.
     * @throws IllegalArgumentException if attempting to get a room that doesn't exist in the House's roomList,
     * or if the name is empty or null.
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



    /**
     * This method groups devices by their type. For each room in the house, it iterates over the devices in the room.
     * Each device is then assigned to a group based on its type using the assignDeviceToGroupType method.
     * The result is a map where the keys are the device types and the values are maps.
     * In these inner maps, the keys are the rooms and the values are lists of devices of the corresponding type in the
     * corresponding room.
     * @return A map where the keys are the device types and the values are maps.
     * In these inner maps, the keys are the rooms and the values are lists of devices of the corresponding type in the
     * corresponding room.
     */
    public HashMap<String, HashMap<Room, List<Device>>> groupDevicesByType() {
        this._rooms = getRoomList();
        HashMap<String, HashMap<Room,List<Device>>> groupDevices = new HashMap<>();
        for (Room room : _rooms) {
            List<Device> devices = room.getDevices();
            for (Device device : devices) {
                assignDeviceToGroupType(groupDevices, device, room);
            }
        }
        return groupDevices;
    }


    /**
     * This method assigns a device to a group based on its type. If the device has no sensors, it is not assigned to any group.
     * Otherwise, it is assigned to a group based on the type of its sensors.
     * The group is represented as a map where the keys are the rooms and the values are lists of devices of the
     * corresponding type in the corresponding room.
     * If the group does not exist yet, it is created. If the room does not exist yet in the group, it is added.
     * If the device is not yet in the list of devices for the corresponding room in the group, it is added.
     * @param groupedDevices A map where the keys are the device types and the values are maps.
     * In these inner maps, the keys are the rooms and the values are lists of devices of the corresponding type in the
     * corresponding room.
     * @param device The device to be assigned to a group.
     * @param room The room in which the device is located.
     */
    private void assignDeviceToGroupType(HashMap<String, HashMap<Room,List<Device>>> groupedDevices, Device device, Room room) {
        if (!device.getSensors().isEmpty()) {
            List<Sensor> sensors = device.getSensors();
            for (Sensor sensor : sensors) {
                String type = sensor.getSensorType().getDescription();
                groupedDevices.putIfAbsent(type,new HashMap<>());
                groupedDevices.get(type).putIfAbsent(room,new ArrayList<>());
                if (!isDeviceOnListOfKey(groupedDevices.get(type), device.getDeviceName(),room)) {
                    groupedDevices.get(type).get(room).add(device);
                }
            }
        }
    }

    /**
     * This method checks if a device with a given name is in the list of devices for a given room in a given list of
     * devices grouped by room.
     * It iterates over the devices in the list for the given room and checks if any device has the same name as the
     * given device name.
     * If a device with the same name is found, it returns true. If no device with the same name is found, it returns false.
     * @param listType A map where the keys are the rooms and the values are lists of devices in the corresponding room.
     * @param deviceName The name of the device to be checked.
     * @param room The room to be checked.
     * @return A boolean indicating whether a device with the given name is in the list of devices for the given room.
     */
    private boolean isDeviceOnListOfKey(HashMap<Room,List<Device>> listType, String deviceName, Room room) {
        for (Device device : listType.get(room)) {
            if (device.getDeviceName().equals(deviceName)) {
                return true;
            }
        }
        return false;
    }

}