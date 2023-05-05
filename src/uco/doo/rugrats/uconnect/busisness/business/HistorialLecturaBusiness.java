package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialLecturaDomain;

import java.util.List;


public interface HistorialLecturaBusiness {
    void generar(HistorialLecturaDomain domain);
    void leerMensaje(HistorialLecturaDomain domain);
    List<HistorialLecturaDomain> mostrarInformacionMensaje(HistorialLecturaDomain domain);
    EstadoDomain obtenerEstadoReal();
}
