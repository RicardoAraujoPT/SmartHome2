package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

// Model of Wind Sensor
public class WS8600 implements Sensor {

    private final SensorType _sensorType;


    public WS8600(Catalogue catalogue) throws InstantiationException {

        //this is a wind sensor

        SensorType sensorType = catalogue.getSensorType("Wind");
        if( sensorType ==null )
            throw new InstantiationException("SensorType with description 'Wind' does not exist.");
        else
            this._sensorType = sensorType;
    }

    //de onde vem este valor?é introduzido ?
    public Value getValue() {
        return null;
    }

    public SensorType getSensorType() {
        return null;
    }

    /*
    return 1 of 8 cardinal points (N,S,E,W,NW,SW,SE,NE)
     */
    public String getWindDirection(double azimuthDegrees){

        if(azimuthDegrees > 0 && azimuthDegrees <= 45){
            return "NE";
        }
        if(azimuthDegrees == 90){
            return "E";
        }
        if(azimuthDegrees <= 135){
            return "SE";
        }
        if(azimuthDegrees == 180){
            return "S";
        }
        if(azimuthDegrees <= 225){
            return "SW";
        }
        if(azimuthDegrees == 270){
            return "W";
        }
        if(azimuthDegrees <= 315){
            return "NW";
        }
        return "N";
    }










}
