package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

import java.util.Random;

// Model of Wind Sensor
public class WS8600 implements Sensor {

    private final SensorType _sensorType;



    public WS8600(Catalogue catalogue) throws InstantiationException {

        //this is a wind sensor

        SensorType sensorType = catalogue.getSensorType("Wind Sensor");
        if( sensorType == null )
            throw new InstantiationException("SensorType with description 'Wind Sensor' does not exist.");
        else
            this._sensorType = sensorType;
    }

    // obter a descrição e unidade de medida do sensor
    public SensorType getSensorType() {

        return this._sensorType;
    }

    //obter o valor associado a velocidade

    public Value getValue() {

        Random rand = new Random();

        int dValue = rand.nextInt(401);  // velocidade do vento nao pode ser maior que 400

        return new WS8600Value( dValue );
    }


    //return 1 of 8 cardinal points (N,S,E,W,NW,SW,SE,NE)
    public String getWindDirection(double azimuthDegrees){

        if(azimuthDegrees == 0){
            return "N";
        }
        if(azimuthDegrees == 90.0){
            return "E";
        }
        if(azimuthDegrees == 180.0){
            return "S";
        }
        if(azimuthDegrees == 270.0){
            return "W";
        }
        if(azimuthDegrees == 45.0){
            return "NE";
        }
        if(azimuthDegrees == 135.0){
            return "SE";
        }
        if(azimuthDegrees == 315.0){
            return "NW";
        }
        if(azimuthDegrees == 225) {
            return "SW";
        }
        throw new IllegalArgumentException("Azimuth degree not valid");
    }


}
