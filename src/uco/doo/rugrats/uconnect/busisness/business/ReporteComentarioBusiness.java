package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteComentarioDomain;

import java.util.List;

public interface ReporteComentarioBusiness {
	void reportar(ReporteComentarioDomain domain);

	void cambiarEstado(ReporteComentarioDomain domain);

	List<ReporteComentarioDomain> abrir(ReporteComentarioDomain domain);

	EstadoDomain obtenerEstadoReal();
}
