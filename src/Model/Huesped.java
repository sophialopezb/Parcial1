package Model;


public class Huesped {
private String documentoIdentidad;
private String nombreCompleto;
private byte edad;
private int numeroTelefono;
private String ciudadProcedencia;

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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public byte getEdad() {
        return edad;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", numeroTelefono=" + numeroTelefono +
                ", ciudadProcedencia='" + ciudadProcedencia + '\'' +
                '}';
    }
}

