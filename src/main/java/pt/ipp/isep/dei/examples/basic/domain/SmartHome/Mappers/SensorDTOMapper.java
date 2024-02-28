package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.SensorDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

public class SensorDTOMapper {

    public static SensorDTO convertToDTO(Sensor sensor) {
        if (sensor == null)
            return null;
        String strDescription = sensor.getSensorType().getDescription();
        String unit = sensor.getSensorType().getUnit().toString();
        return new SensorDTO(strDescription, unit);
    }
}
