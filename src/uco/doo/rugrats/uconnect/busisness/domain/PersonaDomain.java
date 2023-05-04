package uco.doo.rugrats.uconnect.busisness.domain;

import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilText;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.UUID;

public final class PersonaDomain {
    private UUID identificador;
    private TipoIdentificacionDomain tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private PaisDomain paisTelefono;
    private String numeroTelefono;
    private EstadoDomain estado;

    public static final PersonaDomain DEFAULT_OBJECT = new PersonaDomain();
    private PersonaDomain(){
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setTipoIdentificacion(TipoIdentificacionDomain.getDefaultObject());
        setNumeroIdentificacion(UtilText.getDefaultNumeric());
        setPrimerNombre(UtilText.getDefaultValue());
        setSegundoNombre(UtilText.getDefaultValue());
        setPrimerApellido(UtilText.getDefaultValue());
        setSegundoApellido(UtilText.getDefaultValue());
        setCorreo(UtilText.getDefaultEmailAdress());
        setPaisTelefono(PaisDomain.getDefaultObject());
        setNumeroTelefono(UtilText.getDefaultNumeric());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PersonaDomain(final UUID identificador, final TipoIdentificacionDomain tipoIdentificacion, final String numeroIdentificacion, final String primerNombre, final String segundoNombre, final String primerApellido, final String segundoApellido, final String correo, final PaisDomain paisTelefono, final String numeroTelefono, final EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        setCorreo(correo);
        setPaisTelefono(paisTelefono);
        setNumeroTelefono(numeroTelefono);
        setEstado(estado);
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
        this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion, TipoIdentificacionDomain.getDefaultObject());
    }

    private void setNumeroIdentificacion(final String numeroIdentificacion) {
        this.numeroIdentificacion = UtilText.numericIsValid(UtilText.applyTrim(numeroIdentificacion)) ? UtilText.applyTrim(numeroIdentificacion) : UtilText.getDefaultNumeric();
    }

    private void setPrimerNombre(String primerNombre) {
        this.primerNombre = UtilText.applyTrim(primerNombre);
    }

    private void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = UtilText.applyTrim(segundoNombre);
    }

    private void setPrimerApellido(String primerApellido) {
        this.primerApellido = UtilText.applyTrim(primerApellido);
    }

    private void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = UtilText.applyTrim(segundoApellido);
    }

    private void setCorreo(final String correo) {
        this.correo = UtilText.emailIsvalid(UtilText.applyTrim(correo)) ? UtilText.applyTrim(correo) : UtilText.getDefaultEmailAdress();
    }

    private void setPaisTelefono(final PaisDomain paisTelefono) {
        this.paisTelefono = UtilObject.getDefault(paisTelefono, PaisDomain.getDefaultObject());
    }

    private void setNumeroTelefono(final String numeroTelefono) {
        this.numeroTelefono = UtilText.numericIsValid(UtilText.applyTrim(numeroTelefono)) ? UtilText.applyTrim(numeroTelefono) : UtilText.getDefaultNumeric();
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public TipoIdentificacionDomain getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public PaisDomain getPaisTelefono() {
        return paisTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public static PersonaDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
