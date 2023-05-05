package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.PersonaDomain;

import java.util.List;

public interface PersonaBusiness {
    void registrar(PersonaDomain domain);
    void editar(PersonaDomain domain);
    void cambiarEstado(PersonaDomain domain);
    List<PersonaDomain> consultar(PersonaDomain domain);
    void eliminar(PersonaDomain domain);
}
