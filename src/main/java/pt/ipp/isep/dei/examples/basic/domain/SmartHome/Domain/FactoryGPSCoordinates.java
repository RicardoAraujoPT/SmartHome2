package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

public class FactoryGPSCoordinates {

        public GPSCoordinates createGPSCoordinates(double latitude, double longitude) throws InstantiationException {
            return new GPSCoordinates(latitude, longitude);
        }
}
