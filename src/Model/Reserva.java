package Model;

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

    private ArrayList <Habitacion> listaHabitaciones;

    public Reserva(String codigoReserva, String fechaReserva, byte numeroNoche, byte cantidadHuesped, String estadoReserva, String metodoPago, float valorTotal) {
        this.codigoReserva = codigoReserva;
        this.fechaReserva = fechaReserva;
        this.numeroNoche = numeroNoche;
        this.cantidadHuesped = cantidadHuesped;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.listaHabitaciones = new ArrayList<>();
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public byte getNumeroNoche() {
        return numeroNoche;
    }

    public byte getCantidadHuesped() {
        return cantidadHuesped;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setNumeroNoche(byte numeroNoche) {
        this.numeroNoche = numeroNoche;
    }

    public void setCantidadHuesped(byte cantidadHuesped) {
        this.cantidadHuesped = cantidadHuesped;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean agregarHabitacion(Habitacion h) {
        if(buscarHabitacion(h.getNumeroHabitacion())) {
            return false;
        }
            this.listaHabitaciones.add(h);
            if (this.estadoReserva.equalsIgnoreCase("confirmado")) {
                h.setEstadoActual("ocupado");
            }
        return true;
     }

    }
    public boolean buscarHabitacion (int numeroHabitacion ){
        for(Habitacion aux : listaHabitaciones){
            if(aux.getNumeroHabitacion() == numeroHabitacion){
                return true;
            }
        }
        return false;
    }

}
