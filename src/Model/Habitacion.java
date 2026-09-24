package Model;
/**
 * Esta clase representa una habitacion de un hotel
 * @version 1.0
 * @author Sophia Lopez y Juan Esteban
 * @fecha : 22/09/26
 */
public class Habitacion {
private byte numeroHabitacion;
private String tipoHabitacion; // (Individual, Doble o Suite)
private String piso;
private byte capacidad;
private float precioNoche;
private String estadoActual; // Disponible, Reservada, ocupada

    public Habitacion(byte numeroHabitacion, String tipoHabitacion, String piso, byte capacidad, float precioNoche, String estadoActual) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.estadoActual = estadoActual;
    }

    public byte getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public String getPiso() {
        return piso;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setNumeroHabitacion(byte numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void disponibilidadHabitacion (String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public boolean estaDisponible() {
        return this.estadoActual.equalsIgnoreCase("Disponible");
    }

    public boolean estaOcupada() {
        return this.estadoActual.equalsIgnoreCase("Ocupada") || this.estadoActual.equalsIgnoreCase("Reservada");
    }

    public boolean estaEnMantenimiento() {
        return this.estadoActual.equalsIgnoreCase("Mantenimiento");
    }

}
