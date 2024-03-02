package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


public class Catalogue {
    private List<SensorType> _listSensorTypes = new ArrayList<>();
    private List<String> _listStringClassesSensors;
    private List<ActuatorType> _listActuatorTypes = new ArrayList<>();
    private List<String> _listStringClassesActuators;
    private FactorySensorType _factorySensorType;

    public Catalogue(Configuration config, FactorySensorType factorySensorType) throws InstantiationException {

        if (!isValidConstructorArguments(config, factorySensorType))
            throw (new InstantiationException("Invalid arguments"));

        // access configuration properties
        String[] arrayStringClassesSensors = config.getStringArray("sensor");
        this._listStringClassesSensors = List.of(arrayStringClassesSensors);
        String[] arrayStringClassesActuators = config.getStringArray("actuator");
        this._listStringClassesActuators = List.of(arrayStringClassesActuators);
        this._factorySensorType = factorySensorType;
    }

    public Catalogue(String filePathname, FactorySensorType factorySensorType) throws InstantiationException {

        if (!isValidConstructorArguments(filePathname, factorySensorType))
            throw (new InstantiationException("Invalid arguments"));

        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File(filePathname)); // e.g. filePathname = "config.properties"

            // access configuration properties
            String[] arrayStringClassesSensors = config.getStringArray("sensor");
            this._listStringClassesSensors = List.of(arrayStringClassesSensors);
            String[] arrayStringClassesActuators = config.getStringArray("actuator");
            this._listStringClassesActuators = List.of(arrayStringClassesActuators);
            this._factorySensorType = factorySensorType;
        } catch (ConfigurationException exception) {
            // Something went wrong
            throw new InstantiationException("something went wrong in reading the configuration: " + exception.getMessage());
        }
    }

    /**
     * Method to validate Catalogue's constructor entry parameters.
     *
     * @param config            Configuration file.
     * @param factorySensorType Factory to create sensor types.
     * @return
     */
    private boolean isValidConstructorArguments(Configuration config, FactorySensorType factorySensorType) {
        if (config == null)
            return false;
        if (factorySensorType == null)
            return false;

        return true;
    }

    /**
     * Method to validate Catalogue's constructor entry parameters.
     *
     * @param filePathname      String pathname for the configuration file.
     * @param factorySensorType Factory to create sensor types.
     * @return
     */
    private boolean isValidConstructorArguments(String filePathname, FactorySensorType factorySensorType) {
        if (filePathname == null || filePathname.isEmpty() || filePathname.isBlank())
            return false;
        if (factorySensorType == null)
            return false;

        return true;
    }

    public SensorType addSensorType(String strDescription, Unit unit) throws InstantiationException {
        SensorType _sensor = _factorySensorType.newSensorType(strDescription, unit);

        this._listSensorTypes.add(_sensor);

        return _sensor;
    }

    public SensorType getSensorType(String strDescription) {
        Optional<SensorType> optSensorType = this._listSensorTypes.stream().filter(s -> s.getDescription().equals(strDescription)).findFirst();

        return optSensorType.orElse(null);
    }

    public List<String> getSensorModels() {
        return new ArrayList<>(this._listStringClassesSensors);
    }

    public Sensor getSensor(String strModel) {
        Optional<String> optSensorType = this.getSensorModels().stream().filter(s -> s.equals(strModel)).findFirst();

        if (optSensorType.isPresent()) {
            try {
                String strModelPath = "pt.ipp.isep.dei.examples.basic.domain.SmartHome." + strModel;
                Sensor sensor = (Sensor) Class.forName(strModelPath).getConstructor(Catalogue.class).newInstance(this);
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
        } else
            return null;
    }

    public ActuatorType addActuatorType(String strDescription, Unit unit) throws InstantiationException {
        ActuatorType _actuator = new ActuatorType(strDescription, unit);

        this._listActuatorTypes.add(_actuator);

        return _actuator;
    }

    public ActuatorType getActuatorType(String strDescription) {
        Optional<ActuatorType> optActuatorType = this._listActuatorTypes.stream().filter(a -> a.getDescription().equals(strDescription)).findFirst();

        return optActuatorType.orElse(null);
    }

    public List<String> getActuatorModels() {
        return new ArrayList<>(this._listStringClassesActuators);
    }

    public Actuator getActuator(String strModel) {
        Optional<String> optActuatorType = this.getActuatorModels().stream().filter(a -> a.equals(strModel)).findFirst();

        if (optActuatorType.isPresent()) {
            try {
                String strModelPath = "pt.ipp.isep.dei.examples.basic.domain.SmartHome." + strModel;
                Actuator actuator = (Actuator) Class.forName(strModelPath).getConstructor(Catalogue.class).newInstance(this);
                return actuator;
            }
            // due to the previous conditions, exception will not throw, but Class.forName... requires the catch
            catch (ClassNotFoundException |
                   NoSuchMethodException |
                   InstantiationException |
                   IllegalAccessException |
                   InvocationTargetException e) {
                return null;
            }
        } else
            return null;
    }
}
