package Model;


public class Huesped {

    private String documentoIdentidad;
    private String nombreCompleto;
    private byte edad;
    private int numeroTelefono;
    private String ciudadProcedencia;

    public Huesped() {
    }

    public Huesped(String documentoIdentidad, String nombreCompleto, byte edad, int numeroTelefono, String ciudadProcedencia) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
        this.ciudadProcedencia = ciudadProcedencia;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }
}