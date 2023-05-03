package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class ParticipanteDomain {
    private UUID identificador;
    private PersonaDomain persona;
    private EstadoDomain estado;

    public static final ParticipanteDomain DEFAULT_OBJECT = new ParticipanteDomain();

    private ParticipanteDomain(){
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPersona(PersonaDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ParticipanteDomain(final UUID identificador, final PersonaDomain persona, final EstadoDomain estado){
        super();
        setIdentificador(identificador);
        setPersona(persona);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPersona(final PersonaDomain persona) {
        this.persona = UtilObject.getDefault(persona, PersonaDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getPersona() {
        return persona;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static ParticipanteDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
