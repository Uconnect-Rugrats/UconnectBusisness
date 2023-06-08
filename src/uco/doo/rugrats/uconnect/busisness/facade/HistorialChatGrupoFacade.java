package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.HistorialChatGrupoDTO;

import java.util.List;
import java.util.UUID;

public interface HistorialChatGrupoFacade {
	void generar(HistorialChatGrupoDTO dto);

	List<HistorialChatGrupoDTO> listar(HistorialChatGrupoDTO dto);

	void eliminar(UUID dto);

}
