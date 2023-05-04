package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class RespuestaReporteMensajeDomain {
    private UUID identificador;
    private LocalDateTime fechaRespuesta;
    private ReporteMensajeDomain reporte;
    private EstadoDomain estado;
    private String explicacionVeredicto;
    private EstructuraAdministradorEstructuraDomain administrador;

    public static final RespuestaReporteMensajeDomain DEFAULT_OBJECT = new RespuestaReporteMensajeDomain();

    private RespuestaReporteMensajeDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setFechaRespuesta(UtilDate.getDefaultValue());
        setReporte(ReporteMensajeDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
        setExplicacionVeredicto(UtilText.getDefaultValue());
        setAdministrador(EstructuraAdministradorEstructuraDomain.getDefaultObject());
    }

    public RespuestaReporteMensajeDomain(final UUID identificador, final LocalDateTime fechaRespuesta, final ReporteMensajeDomain reporte, final EstadoDomain estado, final String explicacionVeredicto, final EstructuraAdministradorEstructuraDomain administrador) {
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

    private void setReporte(final ReporteMensajeDomain reporte) {
        this.reporte = UtilObject.getDefault(reporte, ReporteMensajeDomain.getDefaultObject());
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

    public ReporteMensajeDomain getReporte() {
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

    public static final RespuestaReporteMensajeDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
