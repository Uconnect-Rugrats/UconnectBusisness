package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.PersonaDomain;

import java.util.List;
import java.util.UUID;

public interface PersonaBusiness {
	void registrar(PersonaDomain domain);

	void editar(PersonaDomain domain);

	void cambiarEstado(PersonaDomain domain);

	List<PersonaDomain> consultar(PersonaDomain domain);

	void eliminar(UUID domain);
}
