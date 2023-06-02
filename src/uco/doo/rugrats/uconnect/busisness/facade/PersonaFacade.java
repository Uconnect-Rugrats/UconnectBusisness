package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.PersonaDTO;

import java.util.List;
import java.util.UUID;

public interface PersonaFacade {
	void registrar(PersonaDTO dto);

	void editar(PersonaDTO dto);

	void cambiarEstado(PersonaDTO dto);

	List<PersonaDTO> consultar(PersonaDTO dto);

	void eliminar(UUID dto);
}
