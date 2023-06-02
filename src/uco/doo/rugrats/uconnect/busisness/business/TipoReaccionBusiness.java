package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.TipoReaccionDomain;

import java.util.List;

public interface TipoReaccionBusiness {
	List<TipoReaccionDomain> consultar(TipoReaccionDomain domain);
}
