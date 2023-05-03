package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ReporteMensajeDomain {
    private UUID identificador;
    private MensajeDomain mensaje;
    private ParticipanteGrupoDomain autor;
    private CausaReporteDomain causa;
    private LocalDateTime fechaAcusacion;
    private EstadoDomain estado;
    public static final ReporteMensajeDomain DEFAULT_OBJECT = new ReporteMensajeDomain();
    private ReporteMensajeDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setMensaje(MensajeDomain.getDefaultObject());
        setAutor(ParticipanteGrupoDomain.getDefaultObject());
        setCausa(CausaReporteDomain.getDefaultObject());
        setFechaAcusacion(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ReporteMensajeDomain(final UUID identificador, final MensajeDomain mensaje, final ParticipanteGrupoDomain autor, final CausaReporteDomain causa, final LocalDateTime fechaAcusacion, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setMensaje(mensaje);
        setAutor(autor);
        setCausa(causa);
        setFechaAcusacion(fechaAcusacion);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setMensaje(final MensajeDomain mensaje) {
        this.mensaje = UtilObject.getDefault(mensaje, MensajeDomain.getDefaultObject());
    }

    private void setAutor(final ParticipanteGrupoDomain autor) {
        this.autor = UtilObject.getDefault(autor, ParticipanteGrupoDomain.getDefaultObject());
    }

    private void setCausa(final CausaReporteDomain causa) {
        this.causa = UtilObject.getDefault(causa, CausaReporteDomain.getDefaultObject());
    }

    private void setFechaAcusacion(final LocalDateTime fechaAcusacion) {
        this.fechaAcusacion = UtilDate.getDefault(fechaAcusacion);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public MensajeDomain getMensaje() {
        return mensaje;
    }

    public ParticipanteGrupoDomain getAutor() {
        return autor;
    }

    public CausaReporteDomain getCausa() {
        return causa;
    }

    public LocalDateTime getFechaAcusacion() {
        return fechaAcusacion;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static final ReporteMensajeDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
