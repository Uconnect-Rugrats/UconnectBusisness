package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.PaisDomain;

import java.util.List;

public interface PaisBusiness {
    List<PaisDomain> consultar(PaisDomain domain);
}
