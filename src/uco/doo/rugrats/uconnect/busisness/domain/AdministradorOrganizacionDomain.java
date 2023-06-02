package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class AdministradorOrganizacionDomain {
    private UUID identificador;
    private PersonaDomain persona;

    public static final AdministradorOrganizacionDomain DEFAULT_OBJECT = new AdministradorOrganizacionDomain();
    private AdministradorOrganizacionDomain(){
		super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPersona(PersonaDomain.getDefaultObject());
    }

    public AdministradorOrganizacionDomain(final UUID identificador, final PersonaDomain persona){
        super();
        setIdentificador(identificador);
        setPersona(persona);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPersona(final PersonaDomain persona) {
        this.persona = UtilObject.getDefault(persona, PersonaDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getPersona() {
        return persona;
    }

    public static AdministradorOrganizacionDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
