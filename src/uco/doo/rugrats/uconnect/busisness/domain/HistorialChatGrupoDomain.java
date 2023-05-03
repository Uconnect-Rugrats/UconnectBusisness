package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class HistorialChatGrupoDomain {
    private UUID identificador;
    private ChatDomain chat;
    private ParticipanteGrupoDomain participante;
    private LocalDateTime fechaIngreso;

    public static final HistorialChatGrupoDomain DEFAULT_OBJECT = new HistorialChatGrupoDomain();
    private HistorialChatGrupoDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setChat(ChatDomain.getDefaultObject());
        setParticipante(ParticipanteGrupoDomain.getDefaultObject());
        setFechaIngreso(UtilDate.getDefaultValue());
    }

    public HistorialChatGrupoDomain(final UUID identificador, final ChatDomain chat, final ParticipanteGrupoDomain participante, final LocalDateTime fechaIngreso) {
        super();
        setIdentificador(identificador);
        setChat(chat);
        setParticipante(participante);
        setFechaIngreso(fechaIngreso);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setChat(final ChatDomain chat) {
        this.chat = UtilObject.getDefault(chat, ChatDomain.getDefaultObject());
    }

    public void setParticipante(final ParticipanteGrupoDomain participante) {
        this.participante = UtilObject.getDefault(participante, ParticipanteGrupoDomain.getDefaultObject());
    }

    private void setFechaIngreso(final LocalDateTime fechaIngreso) {
        this.fechaIngreso = UtilDate.getDefault(fechaIngreso);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public ChatDomain getChat() {
        return chat;
    }

    public ParticipanteGrupoDomain getParticipante() {
        return participante;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public static final HistorialChatGrupoDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
