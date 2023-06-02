package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ReaccionDomain {
	private UUID identificador;
	private PublicacionDomain publicacion;
	private ParticipanteGrupoDomain autor;
	private LocalDateTime fechaReaccion;
	private TipoReaccionDomain tipo;
	private EstadoDomain estado;

	public static final ReaccionDomain DEFAULT_OBJECT = new ReaccionDomain();

	private ReaccionDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setPublicacion(PublicacionDomain.getDefaultObject());
		setAutor(ParticipanteGrupoDomain.getDefaultObject());
		setFechaReaccion(UtilDate.getDefaultValue());
		setTipo(TipoReaccionDomain.getDefaultObject());
		setEstado(EstadoDomain.getDefaultObject());
	}

	public ReaccionDomain(final UUID identificador, final PublicacionDomain publicacion,
			final ParticipanteGrupoDomain autor, final LocalDateTime fechaReaccion, final TipoReaccionDomain tipo,
			final EstadoDomain estado) {
		super();
		setIdentificador(identificador);
		setPublicacion(publicacion);
		setAutor(autor);
		setFechaReaccion(fechaReaccion);
		setTipo(tipo);
		setEstado(estado);
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setPublicacion(final PublicacionDomain publicacion) {
		this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
	}

	private void setAutor(final ParticipanteGrupoDomain autor) {
		this.autor = UtilObject.getDefault(autor, ParticipanteGrupoDomain.getDefaultObject());
	}

	private void setFechaReaccion(final LocalDateTime fechaReaccion) {
		this.fechaReaccion = UtilDate.getDefault(fechaReaccion);
	}

	private void setTipo(final TipoReaccionDomain tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoReaccionDomain.getDefaultObject());
	}

	private void setEstado(final EstadoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public PublicacionDomain getPublicacion() {
		return publicacion;
	}

	public ParticipanteGrupoDomain getAutor() {
		return autor;
	}

	public LocalDateTime getFechaReaccion() {
		return fechaReaccion;
	}

	public TipoReaccionDomain getTipo() {
		return tipo;
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	public static final ReaccionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
}
