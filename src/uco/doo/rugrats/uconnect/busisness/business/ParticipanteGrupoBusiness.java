package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteGrupoDomain;


import java.util.List;
import java.util.UUID;

public interface ParticipanteGrupoBusiness {
    void asignarGrupo(ParticipanteGrupoDomain domain);
    List<ParticipanteGrupoDomain> consultar(ParticipanteGrupoDomain domain);
    void eliminar(UUID domain);
    EstadoDomain obtenerEstadoReal();
}
