package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class PublicacionDomain {
	private UUID identificador;
	private ParticipanteGrupoDomain autor;
	private LocalDateTime fechaPublicacion;
	private String titulo;
	private String contenido;
	private EstadoDomain estado;

	public static final PublicacionDomain DEFAULT_OBJECT = new PublicacionDomain();

	private PublicacionDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setAutor(ParticipanteGrupoDomain.getDefaultObject());
		setFechaPublicacion(UtilDate.getDefaultValue());
		setTitulo(UtilText.getDefaultValue());
		setContenido(UtilText.getDefaultValue());
		setEstado(EstadoDomain.getDefaultObject());
	}

	public PublicacionDomain( UUID identificador, ParticipanteGrupoDomain autor,
			LocalDateTime fechaPublicacion, String titulo, String contenido,
			EstadoDomain estado) {
		super();
		setIdentificador(identificador);
		setAutor(autor);
		setFechaPublicacion(fechaPublicacion);
		setTitulo(titulo);
		setContenido(contenido);
		setEstado(estado);
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setAutor(final ParticipanteGrupoDomain autor) {
		this.autor = UtilObject.getDefault(autor, ParticipanteGrupoDomain.getDefaultObject());
	}

	private void setFechaPublicacion(final LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = UtilDate.getDefault(fechaPublicacion);
	}

	private void setTitulo(final String titulo) {
		this.titulo = UtilText.applyTrim(titulo);
	}

	private void setContenido(final String contenido) {
		this.contenido = UtilText.applyTrim(contenido);
	}

	private void setEstado(final EstadoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public ParticipanteGrupoDomain getAutor() {
		return autor;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	public static final PublicacionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
}
