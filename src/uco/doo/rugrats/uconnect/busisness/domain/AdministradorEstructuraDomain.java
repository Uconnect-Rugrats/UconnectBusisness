package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class AdministradorEstructuraDomain {
    private UUID identificador;
    private PersonaDomain persona;
    public static final AdministradorEstructuraDomain DEFAULT_OBJECT = new AdministradorEstructuraDomain();
    private AdministradorEstructuraDomain(){
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPersona(PersonaDomain.getDefaultObject());
    }

    public AdministradorEstructuraDomain(final UUID identificador, final PersonaDomain persona){
        super();
        setIdentificador(identificador);
        setPersona(persona);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPersona(PersonaDomain persona) {
        this.persona = UtilObject.getDefault(persona, PersonaDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getPersona() {
        return persona;
    }

    public static AdministradorEstructuraDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
