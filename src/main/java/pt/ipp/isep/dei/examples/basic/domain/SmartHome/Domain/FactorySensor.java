package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.lang.reflect.InvocationTargetException;

public class FactorySensor {
    public Sensor createSensor(String strModel, Catalogue catalogue) {
        try {
            Sensor sensor = (Sensor) Class.forName(strModel).getConstructor(Catalogue.class).newInstance(catalogue);
            return sensor;
        }
        // due to the previous conditions, exception will not throw, but Class.forName... requires the catch
        catch (ClassNotFoundException |
               NoSuchMethodException |
               InstantiationException |
               IllegalAccessException |
               InvocationTargetException e) {
            return null;
        }
    }
}
