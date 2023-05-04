package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class ChatDomain {
    private UUID identificador;
    private GrupoDomain grupo;
    private EstadoDomain estado;

    public static final ChatDomain DEFAULT_OBJECT = new ChatDomain();

    private ChatDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setGrupo(GrupoDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ChatDomain(final UUID identificador, final GrupoDomain grupo, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setGrupo(grupo);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setGrupo(final GrupoDomain grupo) {
        this.grupo = UtilObject.getDefault(grupo, GrupoDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public GrupoDomain getGrupo() {
        return grupo;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static ChatDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
