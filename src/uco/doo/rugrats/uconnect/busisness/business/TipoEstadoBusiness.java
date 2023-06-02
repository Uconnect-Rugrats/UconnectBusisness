package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.TipoEstadoDomain;

import java.util.List;

public interface TipoEstadoBusiness {
	List<TipoEstadoDomain> consultar(TipoEstadoDomain domain);
}
