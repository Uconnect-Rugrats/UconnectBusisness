package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class OrganizacionDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    private TipoOrganizacionDomain tipo;
    private EstadoDomain estado;

    public static final OrganizacionDomain DEFAULT_OBJECT = new OrganizacionDomain();

    private OrganizacionDomain(){
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setTipo(TipoOrganizacionDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public OrganizacionDomain(final UUID identificador, final String nombre, final String descripcion, final TipoOrganizacionDomain tipo, final EstadoDomain estado) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTipo(tipo);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    private void setTipo(final TipoOrganizacionDomain tipo) {
        this.tipo = UtilObject.getDefault(tipo, TipoOrganizacionDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoOrganizacionDomain getTipo() {
        return tipo;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static OrganizacionDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
