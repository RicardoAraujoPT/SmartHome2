package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;


import java.util.ArrayList;
import java.util.List;

public class Room {
    private String _roomName;
    private Integer _floorNumber;
    private Double _area;

    private Double _height;

    private FactoryDevice _factoryDevice;
    private List<Device> _devices = new ArrayList<>();

    public Room(String roomName, Integer floorNumber, Double area, Double height) throws InstantiationException{
        if( !isValidConstructorArguments(roomName, floorNumber, area, height) ) {
            throw (new InstantiationException("Invalid arguments"));
        }
        this._roomName = roomName;
        this._floorNumber = floorNumber;
        this._area = area;
        this._height = height;
    }

    public Room(String roomName, Integer floorNumber, Double area, Double height, FactoryDevice device) throws InstantiationException{
        if( !isValidConstructorArguments(roomName, floorNumber, area, height) || !isFactoryDeviceValid(device) ) {
            throw (new InstantiationException("Invalid arguments"));
        }
        this._roomName = roomName;
        this._floorNumber = floorNumber;
        this._area = area;
        this._height = height;
        this._factoryDevice = device;
    }
    private boolean isValidConstructorArguments( String roomName, Integer floorNumber, Double area, Double height) {
        if (roomName == null || roomName.trim().isEmpty()) {
            return false;
        }
        if (floorNumber == null) {
            return false;
        }
        if (area <= 0) {
            return false;
        }
        if (height == null || height <= 0){
            return false;
        }
        return true;
    }

    public boolean isFactoryDeviceValid (FactoryDevice factoryDevice){
        if (factoryDevice == null){
            return false;
        }
        return true;
    }

    public String getRoomName() {
        return _roomName;
    }


    public Integer getFloorNumber() {
        return _floorNumber;
    }

    public Double getArea() {
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
        //check if device name is repeated
        if (isDeviceNameRepeated(deviceName)) {
            throw new IllegalArgumentException("Device name already exists in the list");
        }
        //check if device name is valid
        if (deviceName == null || deviceName.trim().isEmpty()){
            throw new IllegalArgumentException("Device name cannot be null or empty");
    }
        else {
            // instanciate device
            Device myDevice = new Device(deviceName);
            // add device to list
            _devices.add(myDevice);

            return myDevice;
        }
    }

    public Device createFactoryDevice(String deviceName) throws InstantiationException{
        // instanciate device
        Device myDevice = _factoryDevice.newDevice(deviceName);
        // add device to list
        if (deviceName == null || deviceName.trim().isEmpty()) {
            return null;
        }
        _devices.add(myDevice);

        return myDevice;
    }

    public Device getDeviceByName(String name) throws IllegalArgumentException {
        for (Device currentDevice : this._devices) {
            String currentDeviceName = currentDevice.getDeviceName();
            if (currentDeviceName.equals(name)) {
                return currentDevice;
            }
        }
        throw new IllegalArgumentException("Device name doesn't exist in the list");
    }

    /**
     * Checks if a device with the given name already exists in the list of devices.
     *
     * @param deviceName The name of the device to be checked for repetition.
     * @return true if a device with the given name already exists in the list.
     */
    public boolean isDeviceNameRepeated(String deviceName) {
        for (int i = 0; i < _devices.size(); i++) {
            Device currentDevice = _devices.get(i);
            String currentDeviceName = currentDevice.getDeviceName();
            if (currentDeviceName.equals(deviceName)) {
                return true;
            }
        }
        return false;
    }

}
