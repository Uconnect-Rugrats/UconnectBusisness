package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilBoolean;
import uco.doo.rugrats.uconnect.utils.UtilDate;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ComentarioDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private ComentarioDomain comentarioPadre;
    private LocalDateTime fechaPublicacion;
    private ParticipanteGrupoDomain autor;
    private String contenido;
    private EstadoDomain estado;
    private boolean tienePadre;
    private static final String UUID_PADRE = "";

    private static final ComentarioDomain PADRE = new ComentarioDomain(UtilUUID.generateUUIDFromString(UUID_PADRE),PublicacionDomain.getDefaultObject(),null,UtilDate.getDefaultValue(),ParticipanteGrupoDomain.getDefaultObject(),UtilText.getDefaultValue(),EstadoDomain.getDefaultObject(),UtilBoolean.getDefaultValue());

    public static final ComentarioDomain DEFAULT_OBJECT = new ComentarioDomain();

    private ComentarioDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setComentarioPadre(PADRE); 
        setFechaPublicacion(UtilDate.getDefaultValue());
        setAutor(ParticipanteGrupoDomain.getDefaultObject());
        setContenido(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
        setTienePadre(UtilBoolean.getDefaultValue());
    }

    public ComentarioDomain( UUID identificador, PublicacionDomain publicacion, ComentarioDomain comentarioPadre, LocalDateTime fechaPublicacion, ParticipanteGrupoDomain autor,String contenido, EstadoDomain estado, boolean tienePadre) {
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setComentarioPadre(comentarioPadre);
        setFechaPublicacion(fechaPublicacion);
        setAutor(autor);
        setContenido(contenido);
        setEstado(estado);
        setTienePadre(tienePadre);
    }
    

    public final boolean isTienePadre() {
		return tienePadre;
	}

	public final void setTienePadre(boolean tienePadre) {
		this.tienePadre = UtilBoolean.getDefault(tienePadre);
	}

	private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setComentarioPadre(final ComentarioDomain comentarioPadre) {
    	if(isTienePadre()) {
            this.comentarioPadre = UtilObject.getDefault(comentarioPadre, ComentarioDomain.getDefaultObject());
    	}else {
            this.comentarioPadre = PADRE;
    	}
    }

    private void setFechaPublicacion(final LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = UtilDate.getDefault(fechaPublicacion);
    }

    private void setAutor(final ParticipanteGrupoDomain autor) {
        this.autor = UtilObject.getDefault(autor, ParticipanteGrupoDomain.getDefaultObject());
    }

    private void setContenido(final String contenido) {
        this.contenido = UtilText.applyTrim(contenido);
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public ComentarioDomain getComentarioPadre() {
        return comentarioPadre;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public ParticipanteGrupoDomain getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static final ComentarioDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
