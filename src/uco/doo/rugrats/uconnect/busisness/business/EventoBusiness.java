package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EventoDomain;

import java.util.List;
import java.util.UUID;

public interface EventoBusiness {
	void crear(EventoDomain domain);

	void editar(EventoDomain domain);

	void cambiarEstado(EventoDomain domain);

	List<EventoDomain> abrir(EventoDomain domain);

	void eliminar(UUID domain);

}
