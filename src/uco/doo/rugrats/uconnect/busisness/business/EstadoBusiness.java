package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;

public interface EstadoBusiness {
	List<EstadoDomain> consultar(EstadoDomain domain);

}
