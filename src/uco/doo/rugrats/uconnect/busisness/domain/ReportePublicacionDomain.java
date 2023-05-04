package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ReportePublicacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private ParticipanteGrupoDomain autor;
    private CausaReporteDomain causa;
    private LocalDateTime fechaAcusacion;
    private EstadoDomain estado;

    public static final ReportePublicacionDomain DEFAULT_OBJECT = new ReportePublicacionDomain();
    private ReportePublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setAutor(ParticipanteGrupoDomain.getDefaultObject());
        setCausa(CausaReporteDomain.getDefaultObject());
        setFechaAcusacion(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ReportePublicacionDomain(final UUID identificador, final PublicacionDomain publicacion, final ParticipanteGrupoDomain autor, final CausaReporteDomain causa, final LocalDateTime fechaAcusacion, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setAutor(autor);
        setCausa(causa);
        setFechaAcusacion(fechaAcusacion);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
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

    public PublicacionDomain getPublicacion() {
        return publicacion;
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

    public static final ReportePublicacionDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
