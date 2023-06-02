package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.ChatDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;
import java.util.UUID;

public interface ChatBusiness {
	void crear(ChatDomain domain);

	void cambiarEstado(ChatDomain domain);

	List<ChatDomain> consultar(ChatDomain domain);

	void eliminar(UUID domain);

	EstadoDomain obtenerEstadoReal();
}
