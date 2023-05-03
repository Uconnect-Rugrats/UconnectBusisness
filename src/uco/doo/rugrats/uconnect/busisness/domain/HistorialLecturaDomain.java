package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class HistorialLecturaDomain {
    private UUID identificador;
    private GrupoDomain grupo;
    private ParticipanteGrupoDomain lector;
    private LocalDateTime fechaLectura;
    private MensajeDomain mensaje;
    private EstadoDomain estado;

    public static final HistorialLecturaDomain DEFAULT_OBJECT = new HistorialLecturaDomain();
    private HistorialLecturaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setGrupo(GrupoDomain.getDefaultObject());
        setLector(ParticipanteGrupoDomain.getDefaultObject());
        setFechaLectura(UtilDate.getDefaultValue());
        setMensaje(MensajeDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public HistorialLecturaDomain(final UUID identificador, final GrupoDomain grupo, final ParticipanteGrupoDomain lector, final LocalDateTime fechaLectura, final MensajeDomain mensaje, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setGrupo(grupo);
        setLector(lector);
        setFechaLectura(fechaLectura);
        setMensaje(mensaje);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setGrupo(final GrupoDomain grupo) {
        this.grupo = UtilObject.getDefault(grupo, GrupoDomain.getDefaultObject());
    }

    private void setLector(final ParticipanteGrupoDomain lector) {
        this.lector = UtilObject.getDefault(lector, ParticipanteGrupoDomain.getDefaultObject());
    }

    private void setFechaLectura(final LocalDateTime fechaLectura) {
        this.fechaLectura = UtilDate.getDefault(fechaLectura);
    }

    private void setMensaje(final MensajeDomain mensaje) {
        this.mensaje = UtilObject.getDefault(mensaje, MensajeDomain.getDefaultObject());
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

    public ParticipanteGrupoDomain getLector() {
        return lector;
    }

    public LocalDateTime getFechaLectura() {
        return fechaLectura;
    }

    public MensajeDomain getMensaje() {
        return mensaje;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static HistorialLecturaDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
