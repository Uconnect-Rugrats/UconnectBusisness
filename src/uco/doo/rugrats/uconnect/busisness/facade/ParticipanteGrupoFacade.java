package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ParticipanteGrupoDTO;

import java.util.List;
import java.util.UUID;

public interface ParticipanteGrupoFacade {
	void asignarGrupo(ParticipanteGrupoDTO dto);

	List<ParticipanteGrupoDTO> consultar(ParticipanteGrupoDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
