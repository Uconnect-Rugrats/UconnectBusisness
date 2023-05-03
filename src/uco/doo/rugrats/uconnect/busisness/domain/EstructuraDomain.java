package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class EstructuraDomain {
    private UUID identificador;
    private OrganizacionDomain organizacion;
    private EstructuraDomain estructuraPadre;
    private String nombre;
    private EstadoDomain estado;

    public static final EstructuraDomain DEFAULT_OBJECT = new EstructuraDomain();

    public EstructuraDomain(final UUID identificador, final OrganizacionDomain organizacion, final EstructuraDomain estructuraPadre, final String nombre, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setOrganizacion(organizacion);
        setEstructuraPadre(estructuraPadre);
        setNombre(nombre);
        setEstado(estado);

    }

    private EstructuraDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setOrganizacion(OrganizacionDomain.getDefaultObject());
        setEstructuraPadre(EstructuraDomain.getDefaultObject());
        setNombre(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());

    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setOrganizacion(final OrganizacionDomain organizacion) {
        this.organizacion = UtilObject.getDefault(organizacion, OrganizacionDomain.getDefaultObject());
    }

    private void setEstructuraPadre(final EstructuraDomain estructuraPadre) {
        this.estructuraPadre = UtilObject.getDefault(estructuraPadre, EstructuraDomain.getDefaultObject());
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public OrganizacionDomain getOrganizacion() {
        return organizacion;
    }

    public EstructuraDomain getEstructuraPadre() {
        return estructuraPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static EstructuraDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
