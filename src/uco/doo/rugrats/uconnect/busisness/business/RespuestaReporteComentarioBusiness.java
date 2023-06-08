package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteComentarioDomain;

import java.util.List;
import java.util.UUID;

public interface RespuestaReporteComentarioBusiness {
	void revisar(RespuestaReporteComentarioDomain domain);

	void cerrarRespuesta(RespuestaReporteComentarioDomain domain);

	List<RespuestaReporteComentarioDomain> abrir(RespuestaReporteComentarioDomain domain);

	void eliminar(UUID domain);

}
