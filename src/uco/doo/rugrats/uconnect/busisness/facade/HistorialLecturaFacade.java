package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.HistorialLecturaDTO;

import java.util.List;

public interface HistorialLecturaFacade {
	void generar(HistorialLecturaDTO dto);

	void leerMensaje(HistorialLecturaDTO dto);

	List<HistorialLecturaDTO> mostrarInformacionMensaje(HistorialLecturaDTO dto);

	EstadoDTO obtenerEstadoReal();
}
