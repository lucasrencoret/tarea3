/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion.Ejemplo.Paises;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author lucasrencoret
 */
@WebService(serviceName = "Paises")
public class Paises {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerCuidades")
    public String[] obtenerCuidades(@WebParam(name = "pais") String pais) {
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        Airport ap = new Airport();
        AirportSoap apSoap = ap.getAirportSoap();
        
        
        
        String cities = gwSoap.getCitiesByCountry(pais);
        String aeropuertos = apSoap.getAirportInformationByCountry(pais);
        String[] respuesta = new String[2];
        respuesta[0] = cities;
        respuesta[1] = aeropuertos;
        
        return respuesta;
    }
}
