package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.busisness.domain.ChatDomain;
import uco.doo.rugrats.uconnect.dto.ChatDTO;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;

import java.util.List;
import java.util.UUID;

public interface ChatFacade {
    void crear(ChatDTO dto);
    void cambiarEstado(ChatDTO dto);
    List<ChatDTO> consultar(ChatDTO dto);
    void eliminar(UUID dto);
    EstadoDTO obtenerEstadoReal();
}
