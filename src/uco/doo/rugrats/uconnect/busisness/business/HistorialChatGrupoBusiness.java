package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;

import java.util.List;
import java.util.UUID;


public interface HistorialChatGrupoBusiness {
    void generar(HistorialChatGrupoDomain domain);
    List<HistorialChatGrupoDomain> listar(HistorialChatGrupoDomain domain);
    void eliminar(UUID domain);
    EstadoDomain obtenerEstadoReal();
}
