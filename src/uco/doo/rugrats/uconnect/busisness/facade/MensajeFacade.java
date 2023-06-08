package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.MensajeDTO;

import java.util.List;
import java.util.UUID;

public interface MensajeFacade {
	void enviar(MensajeDTO dto);

	void cambiarEstado(MensajeDTO dto);

	List<MensajeDTO> cargar(MensajeDTO dto);

	void eliminar(UUID dto);

}
