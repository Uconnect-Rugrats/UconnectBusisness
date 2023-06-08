package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.ParticipanteDTO;

import java.util.List;
import java.util.UUID;

public interface ParticipanteFacade {
	void registrar(ParticipanteDTO dto);

	void cambiarEstado(ParticipanteDTO dto);

	List<ParticipanteDTO> consultar(ParticipanteDTO dto);

	void eliminar(UUID dto);

}
