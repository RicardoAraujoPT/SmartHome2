package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;

public class FactoryLocation {

        public Location createLocation(String address, String zipCode, double latitude, double longitude) throws IllegalArgumentException{

            return new Location(address, zipCode, latitude, longitude);
        }
        /*
        public ArrayList<Room> initRooms(){

        }

         */


    }

