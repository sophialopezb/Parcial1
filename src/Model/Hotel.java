package Model;
public class Hotel {

    private String nombreComercial;
    private String NIT;
    private String direccion;
    private int telefono;

    public Hotel(String nombreComercial, String NIT, String direccion, int telefono) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
