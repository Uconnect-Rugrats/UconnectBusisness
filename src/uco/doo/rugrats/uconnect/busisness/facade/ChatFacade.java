package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.ChatDTO;
import java.util.List;
import java.util.UUID;

public interface ChatFacade {
	void crear(ChatDTO dto);

	void cambiarEstado(ChatDTO dto);

	List<ChatDTO> consultar(ChatDTO dto);

	void eliminar(UUID dto);

}
