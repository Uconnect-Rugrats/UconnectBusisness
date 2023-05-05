package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteGrupoDomain;


import java.util.List;

public interface ParticipanteGrupoBusiness {
    void asignarGrupo(ParticipanteGrupoDomain domain);
    List<ParticipanteGrupoDomain> consultar(ParticipanteGrupoDomain domain);
    void eliminar(ParticipanteGrupoDomain domain);
    EstadoDomain obtenerEstadoReal();
}
