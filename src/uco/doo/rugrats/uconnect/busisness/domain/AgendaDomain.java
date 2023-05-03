package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class AgendaDomain {
    private UUID identificador;
    private GrupoDomain grupo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoDomain estado;

    public static final AgendaDomain DEFAULT_OBJECT = new AgendaDomain();
    private AgendaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setGrupo(GrupoDomain.getDefaultObject());
        setFechaInicio(UtilDate.getDefaultValue());
        setFechaFin(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public AgendaDomain(final UUID identificador, final GrupoDomain grupo, final LocalDateTime fechaInicio, final LocalDateTime fechaFin, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setGrupo(grupo);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setGrupo(final GrupoDomain grupo) {
        this.grupo = UtilObject.getDefault(grupo, GrupoDomain.getDefaultObject());
    }

    private void setFechaInicio(final LocalDateTime fechaInicio) {
        this.fechaInicio = UtilDate.getDefault(fechaInicio);
    }

    private void setFechaFin(final LocalDateTime fechaFin) {
        this.fechaFin = UtilDate.getDefault(fechaFin);
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static AgendaDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
