package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteMensajeDomain;

import java.util.List;

public interface ReporteMensajeBusiness {
	void reportar(ReporteMensajeDomain domain);

	void cambiarEstado(ReporteMensajeDomain domain);

	List<ReporteMensajeDomain> abrir(ReporteMensajeDomain domain);

	EstadoDomain obtenerEstadoReal();
}
