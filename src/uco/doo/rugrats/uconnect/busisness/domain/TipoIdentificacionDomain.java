package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class TipoIdentificacionDomain {
	private UUID identificador;
	private String nombre;
	private String indicador;

	public static final TipoIdentificacionDomain DEFAULT_OBJECT = new TipoIdentificacionDomain();

	private TipoIdentificacionDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setNombre(UtilText.getDefaultValue());
		setIndicador(UtilText.getDefaultNumeric());
	}

	public TipoIdentificacionDomain(UUID identificador, String nombre, String indicador) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setIndicador(indicador);
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilText.getDefault(nombre);
	}

	private void setIndicador(final String indicador) {
		this.indicador = UtilText.getUtilText().numericIsValid(UtilText.applyTrim(indicador))
				? UtilText.applyTrim(indicador)
				: UtilText.getDefaultNumeric();
	}

	public String getNombre() {
		return nombre;
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public String getIndicador() {
		return indicador;
	}

	public static TipoIdentificacionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

}
