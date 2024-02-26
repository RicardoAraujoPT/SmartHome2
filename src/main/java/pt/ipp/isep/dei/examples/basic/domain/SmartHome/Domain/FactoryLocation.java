package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

    public class FactoryLocation {

        public Location createLocation(String address, String zipCode, double latitude, double longitude) {

            return new Location(address, zipCode, latitude, longitude);
        }

    }

