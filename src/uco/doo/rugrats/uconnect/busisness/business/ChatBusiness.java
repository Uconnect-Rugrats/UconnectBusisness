package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.ChatDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;

public interface ChatBusiness {
    void crear(ChatDomain domain);
    void cambiarEstado(ChatDomain domain);
    List<ChatDomain> consultar(ChatDomain domain);
    void eliminar(ChatDomain domain);
    EstadoDomain obtenerEstadoReal();
}
