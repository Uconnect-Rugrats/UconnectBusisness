package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;

import java.util.List;
import java.util.UUID;

public interface GrupoBusiness {
	void crear(GrupoDomain domain);

	void editar(GrupoDomain domain);

	void cambiarEstado(GrupoDomain domain);

	List<GrupoDomain> buscar(GrupoDomain domain);

	void eliminar(UUID domain);

	EstadoDomain obtenerEstadoReal();
}
