package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room {
    private String _roomName;
    private String _roomID;
    private Integer _floorNumber;
    private double _area;

    private Double _height;
    private List<Device> _devices = new ArrayList<>();

    public Room(String roomName, Integer floorNumber, double area, Double height) throws InstantiationException{
        if( !isValidConstructorArguments(roomName, floorNumber, area, height) ) {
            throw (new InstantiationException("Invalid arguments"));
        }
        this._roomName = roomName;
        this._roomID = UUID.randomUUID().toString();
        this._floorNumber = floorNumber;
        this._area = area;
        this._height = height;
    }
    private boolean isValidConstructorArguments( String roomName, Integer floorNumber, double area, Double height) {
        if (roomName == null || roomName.trim().isEmpty()) {
            return false;
        }
        if (floorNumber == null) {
            return false;
        }
        if (area <= 0) {
            return false;
        }
        return height != null && height >= 0;
    }

    public String getRoomName() {
        return _roomName;
    }

    public String getRoomID() {
        return _roomID;
    }

    public Integer getFloorNumber() {
        return _floorNumber;
    }

    public double getArea() {
        return _area;
    }

    public Double getHeight() {
        return _height;
    }

    public ArrayList<Device> getDevices() {
        return new ArrayList<>(_devices);
    }

    /**
     * Creates a new device and adds it to the list of devices in the room.
     *
     * @param deviceName The name of the device to be created and added.
     */
    public Device createDevice(String deviceName) {
        // instanciate device
        Device myDevice = new Device(deviceName);
        // add device to list
        _devices.add(myDevice);
        return myDevice;
    }
}
