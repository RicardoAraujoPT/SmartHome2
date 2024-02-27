package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

public interface FactorySensor {
    Sensor createSensor(String strModel, Catalogue catalogue);
}

