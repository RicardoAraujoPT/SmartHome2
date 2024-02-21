package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

public class FactoryGPSCoordinates {

        public GPSCoordinates createGPSCoordinates(double latitude, double longitude) {
            return new GPSCoordinates(latitude, longitude);
        }
}
