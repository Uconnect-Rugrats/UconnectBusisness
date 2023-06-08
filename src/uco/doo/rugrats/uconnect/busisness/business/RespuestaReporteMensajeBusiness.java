package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;

import java.util.List;
import java.util.UUID;

public interface RespuestaReporteMensajeBusiness {
	void revisar(RespuestaReporteMensajeDomain domain);

	void cerrarRespuesta(RespuestaReporteMensajeDomain domain);

	List<RespuestaReporteMensajeDomain> abrir(RespuestaReporteMensajeDomain domain);

	void eliminar(UUID domain);

}
