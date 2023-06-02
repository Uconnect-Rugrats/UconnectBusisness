package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class TipoEstadoDomain {
	private UUID identificador;
	private String nombre;
	private String descripcion;

	public static final TipoEstadoDomain DEFAULT_OBJECT = new TipoEstadoDomain();

	private TipoEstadoDomain() {
		setIdentificador(UtilUUID.getDefaultValue());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.getDefaultValue());
	}

	public TipoEstadoDomain(UUID identificador, String nombre, String descripcion) {
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
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

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilText.applyTrim(nombre);
	}

	private void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.applyTrim(descripcion);
	}

	public static TipoEstadoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

}
