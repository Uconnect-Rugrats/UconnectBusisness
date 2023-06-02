package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class EstructuraAdministradorEstructuraDomain {

	private UUID identificador;
	private AdministradorEstructuraDomain administrador;
	private EstructuraDomain estructura;
	private EstadoDomain estado;

	public static final EstructuraAdministradorEstructuraDomain DEFAULT_OBJECT = new EstructuraAdministradorEstructuraDomain();

	private EstructuraAdministradorEstructuraDomain() {
		setIdentificador(UtilUUID.getDefaultValue());
		setAdministrador(AdministradorEstructuraDomain.getDefaultObject());
		setEstructura(EstructuraDomain.getDefaultObject());
		setEstado(EstadoDomain.getDefaultObject());
	}

	public EstructuraAdministradorEstructuraDomain(final UUID identificador,
			final AdministradorEstructuraDomain administrador, final EstructuraDomain estructura,
			final EstadoDomain estado) {
		super();
		setIdentificador(identificador);
		setAdministrador(administrador);
		setEstructura(estructura);
		setEstado(estado);
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setAdministrador(final AdministradorEstructuraDomain administrador) {
		this.administrador = UtilObject.getDefault(administrador, AdministradorEstructuraDomain.getDefaultObject());
	}

	private void setEstructura(final EstructuraDomain estructura) {
		this.estructura = UtilObject.getDefault(estructura, EstructuraDomain.getDefaultObject());
	}

	private void setEstado(final EstadoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public AdministradorEstructuraDomain getAdministrador() {
		return administrador;
	}

	public EstructuraDomain getEstructura() {
		return estructura;
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	public static EstructuraAdministradorEstructuraDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
}
