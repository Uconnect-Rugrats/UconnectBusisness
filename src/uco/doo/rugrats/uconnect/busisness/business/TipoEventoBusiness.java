package uco.doo.rugrats.uconnect.busisness.business;


import uco.doo.rugrats.uconnect.busisness.domain.TipoEventoDomain;

import java.util.List;

public interface TipoEventoBusiness {
    List<TipoEventoDomain> consultar(TipoEventoDomain domain);
}
