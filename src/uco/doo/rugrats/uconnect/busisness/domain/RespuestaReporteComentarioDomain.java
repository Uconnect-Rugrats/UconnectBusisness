package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class RespuestaReporteComentarioDomain {
    private UUID identificador;
    private LocalDateTime fechaRespuesta;
    private ReporteComentarioDomain reporte;
    private EstadoDomain estado;
    private String explicacionVeredicto;
    private EstructuraAdministradorEstructuraDomain administrador;

    public static final RespuestaReporteComentarioDomain DEFAULT_OBJECT = new RespuestaReporteComentarioDomain();

    private RespuestaReporteComentarioDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setFechaRespuesta(UtilDate.getDefaultValue());
        setReporte(RespuestaReporteComentarioDomain.getDefaultObject().getReporte());
        setEstado(EstadoDomain.getDefaultObject());
        setExplicacionVeredicto(UtilText.getDefaultValue());
        setAdministrador(EstructuraAdministradorEstructuraDomain.getDefaultObject());
    }

    public RespuestaReporteComentarioDomain(final UUID identificador, final LocalDateTime fechaRespuesta, final ReporteComentarioDomain reporte, final EstadoDomain estado, final String explicacionVeredicto, final EstructuraAdministradorEstructuraDomain administrador) {
        super();
        setIdentificador(identificador);
        setFechaRespuesta(fechaRespuesta);
        setReporte(reporte);
        setEstado(estado);
        setExplicacionVeredicto(explicacionVeredicto);
        setAdministrador(administrador);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setFechaRespuesta(final LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = UtilDate.getDefault(fechaRespuesta);
    }

    private void setReporte(final ReporteComentarioDomain reporte) {
        this.reporte = UtilObject.getDefault(reporte, ReporteComentarioDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    private void setExplicacionVeredicto(final String explicacionVeredicto) {
        this.explicacionVeredicto = UtilText.applyTrim(explicacionVeredicto);
    }

    private void setAdministrador(final EstructuraAdministradorEstructuraDomain administrador) {
        this.administrador = UtilObject.getDefault(administrador, EstructuraAdministradorEstructuraDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public ReporteComentarioDomain getReporte() {
        return reporte;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public String getExplicacionVeredicto() {
        return explicacionVeredicto;
    }

    public EstructuraAdministradorEstructuraDomain getAdministrador() {
        return administrador;
    }

    public static final RespuestaReporteComentarioDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
