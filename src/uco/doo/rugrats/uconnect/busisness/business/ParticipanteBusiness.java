package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteDomain;

import java.util.List;

public interface ParticipanteBusiness {
    void registrar(ParticipanteDomain domain);
    void cambiarEstado(ParticipanteDomain domain);
    List<ParticipanteDomain> consultar(ParticipanteDomain domain);
    void eliminar(ParticipanteDomain domain);
    EstadoDomain obtenerEstadoReal();
}
