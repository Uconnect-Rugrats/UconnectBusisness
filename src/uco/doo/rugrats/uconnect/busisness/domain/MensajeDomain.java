package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class MensajeDomain {
    private UUID identificador;
    private ChatDomain chat;
    private ParticipanteGrupoDomain autor;
    private LocalDateTime fechaEnviado;
    private String contenido;
    private EstadoDomain estado;

    public static final MensajeDomain DEFAULT_OBJECT = new MensajeDomain();
    public MensajeDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setChat(ChatDomain.getDefaultObject());
        setAutor(ParticipanteGrupoDomain.getDefaultObject());
        setFechaEnviado(UtilDate.getDefaultValue());
        setContenido(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public MensajeDomain(final UUID identificador, final ChatDomain chat, final ParticipanteGrupoDomain autor, final LocalDateTime fechaEnviado, final String contenido, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setChat(chat);
        setAutor(autor);
        setFechaEnviado(fechaEnviado);
        setContenido(contenido);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setChat(final ChatDomain chat) {
        this.chat = UtilObject.getDefault(chat, ChatDomain.getDefaultObject());
    }

    private void setAutor(ParticipanteGrupoDomain autor) {
        this.autor = UtilObject.getDefault(autor, ParticipanteGrupoDomain.getDefaultObject());
    }

    private void setFechaEnviado(LocalDateTime fechaEnviado) {
        this.fechaEnviado = UtilDate.getDefault(fechaEnviado);
    }

    private void setContenido(String contenido) {
        this.contenido = UtilText.applyTrim(contenido);
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public ChatDomain getChat() {
        return chat;
    }

    public ParticipanteGrupoDomain getAutor() {
        return autor;
    }

    public LocalDateTime getFechaEnviado() {
        return fechaEnviado;
    }

    public String getContenido() {
        return contenido;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static MensajeDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
