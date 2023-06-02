package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class EventoDomain {
    private UUID identificador;
    private AgendaDomain agenda;
    private String nombre;
    private String descripcion;
    private String lugar;
    private EstructuraAdministradorEstructuraDomain organizador;
    private TipoEventoDomain tipo;
    private LocalDateTime fechaEjecucion;
    private EstadoDomain estado;

    public static final EventoDomain DEFAULT_OBJECT = new EventoDomain();
    private EventoDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setAgenda(AgendaDomain.getDefaultObject());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setLugar(UtilText.getDefaultValue());
        setOrganizador(EstructuraAdministradorEstructuraDomain.getDefaultObject());
        setTipo(TipoEventoDomain.getDefaultObject());
        setFechaEjecucion(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public EventoDomain(UUID identificador, AgendaDomain agenda, String nombre, String descripcion, String lugar, EstructuraAdministradorEstructuraDomain organizador, TipoEventoDomain tipo, LocalDateTime fechaEjecucion, EstadoDomain estado) {
		super();
        setIdentificador(identificador);
        setAgenda(agenda);
        setNombre(nombre);
        setDescripcion(descripcion);
        setLugar(lugar);
        setOrganizador(organizador);
        setTipo(tipo);
        setFechaEjecucion(fechaEjecucion);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setAgenda(final AgendaDomain agenda) {
        this.agenda = UtilObject.getDefault(agenda, AgendaDomain.getDefaultObject());
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    private void setLugar(final String lugar) {
        this.lugar = UtilText.applyTrim(lugar);
    }

    private void setOrganizador(final EstructuraAdministradorEstructuraDomain organizador) {
        this.organizador = UtilObject.getDefault(organizador, EstructuraAdministradorEstructuraDomain.getDefaultObject());
    }

    private void setTipo(final TipoEventoDomain tipo) {
        this.tipo = UtilObject.getDefault(tipo, TipoEventoDomain.getDefaultObject());
    }

    private void setFechaEjecucion(final LocalDateTime fechaEjecucion) {
        this.fechaEjecucion = UtilDate.getDefault(fechaEjecucion);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public AgendaDomain getAgenda() {
        return agenda;
    }

    public String getNombreEvento() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public EstructuraAdministradorEstructuraDomain getOrganizador() {
        return organizador;
    }

    public TipoEventoDomain getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaEjecucion() {
       return fechaEjecucion;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static final EventoDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
