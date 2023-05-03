package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class OrganizacionAdministradorOrganizacionDomain {
    private UUID identificador;
    private AdministradorOrganizacionDomain administrador;
    private OrganizacionDomain organizacion;
    private EstadoDomain estado;

    public static final OrganizacionAdministradorOrganizacionDomain DEFAULT_OBJECT = new OrganizacionAdministradorOrganizacionDomain();
    private OrganizacionAdministradorOrganizacionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setAdministrador(AdministradorOrganizacionDomain.getDefaultObject());
        setOrganizacion(OrganizacionDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public OrganizacionAdministradorOrganizacionDomain(final UUID identificador, final AdministradorOrganizacionDomain administrador, final OrganizacionDomain estructura, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setAdministrador(administrador);
        setOrganizacion(estructura);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setAdministrador(final AdministradorOrganizacionDomain administrador) {
        this.administrador = UtilObject.getDefault(administrador, AdministradorOrganizacionDomain.getDefaultObject());
    }

    private void setOrganizacion(final OrganizacionDomain estructura) {
        this.organizacion = UtilObject.getDefault(estructura, OrganizacionDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public AdministradorOrganizacionDomain getAdministrador() {
        return administrador;
    }

    public OrganizacionDomain getOrganizacion() {
        return organizacion;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static OrganizacionAdministradorOrganizacionDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
