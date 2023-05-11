package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.PaisDTO;

import java.util.List;

public interface PaisFacade {
    List<PaisDTO> consultar(PaisDTO dto);
}
