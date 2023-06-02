package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;
import java.util.UUID;

public interface ComentarioBusiness {
	void comentar(ComentarioDomain domain);

	void cambiarEstado(ComentarioDomain domain);

	List<ComentarioDomain> consultar(ComentarioDomain domain);

	void eliminar(UUID domain);

	EstadoDomain obtenerEstadoReal();
}
