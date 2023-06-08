package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.ReportePublicacionDomain;

import java.util.List;

public interface ReportePublicacionBusiness {
	void reportar(ReportePublicacionDomain domain);

	void cambiarEstado(ReportePublicacionDomain domain);

	List<ReportePublicacionDomain> abrir(ReportePublicacionDomain domain);

}
