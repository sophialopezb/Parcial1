package Model;
/**
 * Esta clase representa las reservas del hotel
 * @version 1.0
 * @author Sophia Lopez y Juan Esteban
 * @fecha : 22/09/26
 */

import java.util.ArrayList;

public class Reserva {

    private String codigoReserva;
    private String fechaReserva;
    private byte numeroNoche;
    private byte cantidadHuesped;
    private String estadoReserva;
    private String metodoPago;
    private float valorTotal;
    private Huesped huesped;
    private ArrayList<Habitacion> habitaciones;

    public Reserva() {
        habitaciones = new ArrayList<Habitacion>();
    }

    public Reserva(String codigoReserva, String fechaReserva, byte numeroNoche, byte cantidadHuesped, String estadoReserva, String metodoPago, Huesped huesped) {
        this.codigoReserva = codigoReserva;
        this.fechaReserva = fechaReserva;
        this.numeroNoche = numeroNoche;
        this.cantidadHuesped = cantidadHuesped;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        habitaciones = new ArrayList<Habitacion>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        if (estadoReserva.equals("Confirmada")) {
            habitacion.setEstadoActual("Reservada");
        }
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        float total = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            total = total + habitaciones.get(i).getPrecioNoche();
        }
        valorTotal = total * numeroNoche;
    }

    public boolean esCapicua() {
        boolean capicua = true;
        for (int i = 0; i < codigoReserva.length() / 2; i++) {
            if (codigoReserva.charAt(i) != codigoReserva.charAt(codigoReserva.length() - 1 - i)) {
                capicua = false;
            }
        }
        return capicua;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public byte getNumeroNoche() {
        return numeroNoche;
    }

    public void setNumeroNoche(byte numeroNoche) {
        this.numeroNoche = numeroNoche;
    }

    public byte getCantidadHuesped() {
        return cantidadHuesped;
    }

    public void setCantidadHuesped(byte cantidadHuesped) {
        this.cantidadHuesped = cantidadHuesped;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
