package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;

import java.util.List;


public interface HistorialChatGrupoBusiness {
    void generar(HistorialChatGrupoDomain domain);
    List<HistorialChatGrupoDomain> Listar(HistorialChatGrupoDomain domain);
    void eliminar(HistorialChatGrupoDomain domain);
    EstadoDomain obtenerEstadoReal();
}
