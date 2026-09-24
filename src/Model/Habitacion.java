package Model;
/**
 * Esta clase representa una habitacion de un hotel
 * @version 1.0
 * @author Sophia Lopez y Juan Esteban
 * @fecha : 22/09/26
 */
public class Habitacion {

    private int numeroHabitacion;
    private String tipoHabitacion;
    private String piso;
    private byte capacidad;
    private float precioNoche;
    private String estadoActual;

    public Habitacion() {
    }

    public Habitacion(int numeroHabitacion, String tipoHabitacion, String piso, byte capacidad, float precioNoche, String estadoActual) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.estadoActual = estadoActual;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
}
