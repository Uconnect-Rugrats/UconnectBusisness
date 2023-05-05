package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.TipoIdentificacionDomain;

import java.util.List;

public interface TipoIdentificacionBusiness {
    List<TipoIdentificacionDomain> consultar(TipoIdentificacionDomain domain);
}
