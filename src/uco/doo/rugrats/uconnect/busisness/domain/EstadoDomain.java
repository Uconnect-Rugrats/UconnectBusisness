package uco.doo.rugrats.uconnect.busisness.domain;


import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;


public final class EstadoDomain {

    private UUID identificador;
    private String nombre;
    private String descripcion;
    private TipoEstadoDomain tipoEstado;

    public static final EstadoDomain DEFAULT_OBJECT = new EstadoDomain();
    private EstadoDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setTipoEstado(TipoEstadoDomain.getDefaultObject());
    }


    public EstadoDomain(final UUID identificador, final String nombre, final TipoEstadoDomain tipoEstado, final String descripcion) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTipoEstado(tipoEstado);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    private final void setTipoEstado(final TipoEstadoDomain tipoEstado) {
        this.tipoEstado = UtilObject.getDefault(tipoEstado, TipoEstadoDomain.getDefaultObject());
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final String getNombre() {
        return nombre;
    }

    public final TipoEstadoDomain getTipoEstado() {
        return tipoEstado;
    }

    public static EstadoDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
