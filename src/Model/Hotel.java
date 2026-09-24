package Model;
import java.util.ArrayList;

public class Hotel {

    private String nombreComercial;
    private String NIT;
    private String direccion;
    private int telefono;
    private ArrayList<Huesped> huespedes;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;
    private char[][] matrizOcupacion;

    public Hotel() {
        huespedes = new ArrayList<Huesped>();
        habitaciones = new ArrayList<Habitacion>();
        reservas = new ArrayList<Reserva>();
    }

    public Hotel(String nombreComercial, String NIT, String direccion, int telefono) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccion = direccion;
        this.telefono = telefono;
        huespedes = new ArrayList<Huesped>();
        habitaciones = new ArrayList<Habitacion>();
        reservas = new ArrayList<Reserva>();
    }

    public Huesped crearHuesped(String documentoIdentidad, String nombreCompleto, byte edad, int numeroTelefono, String ciudadProcedencia) {
        Huesped h = new Huesped(documentoIdentidad, nombreCompleto, edad, numeroTelefono, ciudadProcedencia);
        huespedes.add(h);
        return h;
    }

    public Habitacion crearHabitacion(int numeroHabitacion, String tipoHabitacion, String piso, byte capacidad, float precioNoche, String estadoActual) {
        Habitacion h = new Habitacion(numeroHabitacion, tipoHabitacion, piso, capacidad, precioNoche, estadoActual);
        habitaciones.add(h);
        return h;
    }

    public Reserva crearReserva(String codigoReserva, String fechaReserva, byte numeroNoche, byte cantidadHuesped, String estadoReserva, String metodoPago, Huesped huesped) {
        Reserva r = new Reserva(codigoReserva, fechaReserva, numeroNoche, cantidadHuesped, estadoReserva, metodoPago, huesped);
        reservas.add(r);
        return r;
    }

    public Huesped buscarHuespedPorTelefono(int numeroTelefono) {
        for (int i = 0; i < huespedes.size(); i++) {
            if (huespedes.get(i).getNumeroTelefono() == numeroTelefono) {
                return huespedes.get(i);
            }
        }
        return null;
    }

    public ArrayList<Reserva> obtenerReservasDeHuesped(Huesped huesped) {
        ArrayList<Reserva> reservasHuesped = new ArrayList<Reserva>();
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getHuesped().getDocumentoIdentidad().equals(huesped.getDocumentoIdentidad())) {
                reservasHuesped.add(reservas.get(i));
            }
        }
        return reservasHuesped;
    }

    public int getCantidadDisponibles() {
        int cantidad = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getEstadoActual().equals("Disponible")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int getCantidadReservadas() {
        int cantidad = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getEstadoActual().equals("Reservada")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int getCantidadOcupadas() {
        int cantidad = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getEstadoActual().equals("Ocupada")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int getCantidadMantenimiento() {
        int cantidad = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getEstadoActual().equals("Mantenimiento")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Habitacion getHabitacionMayorPrecio() {
        Habitacion mayor = habitaciones.get(0);
        for (int i = 1; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getPrecioNoche() > mayor.getPrecioNoche()) {
                mayor = habitaciones.get(i);
            }
        }
        return mayor;
    }

    public Habitacion getHabitacionMenorPrecio() {
        Habitacion menor = habitaciones.get(0);
        for (int i = 1; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getPrecioNoche() < menor.getPrecioNoche()) {
                menor = habitaciones.get(i);
            }
        }
        return menor;
    }

    public int[] getOcupacionPorDia() {
        int[] ocupacion = new int[matrizOcupacion[0].length];
        for (int j = 0; j < matrizOcupacion[0].length; j++) {
            for (int i = 0; i < matrizOcupacion.length; i++) {
                if (matrizOcupacion[i][j] == 'O') {
                    ocupacion[j]++;
                }
            }
        }
        return ocupacion;
    }

    public int getDiaMayorOcupacion() {
        int[] ocupacion = getOcupacionPorDia();
        int diaMayor = 0;
        for (int j = 1; j < ocupacion.length; j++) {
            if (ocupacion[j] > ocupacion[diaMayor]) {
                diaMayor = j;
            }
        }
        return diaMayor;
    }

    public int getDiaMenorOcupacion() {
        int[] ocupacion = getOcupacionPorDia();
        int diaMenor = 0;
        for (int j = 1; j < ocupacion.length; j++) {
            if (ocupacion[j] < ocupacion[diaMenor]) {
                diaMenor = j;
            }
        }
        return diaMenor;
    }

    public int getTotalOcupadasSemana() {
        int total = 0;
        for (int i = 0; i < matrizOcupacion.length; i++) {
            for (int j = 0; j < matrizOcupacion[i].length; j++) {
                if (matrizOcupacion[i][j] == 'O') {
                    total++;
                }
            }
        }
        return total;
    }

    public ArrayList<Reserva> getReservasEspeciales() {
        ArrayList<Reserva> especiales = new ArrayList<Reserva>();
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).esCapicua()) {
                especiales.add(reservas.get(i));
            }
        }
        return especiales;
    }

    public int getCantidadReservasPorFecha(String fecha) {
        int cantidad = 0;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getFechaReserva().equals(fecha)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public float getIngresosPorFecha(String fecha) {
        float total = 0;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getFechaReserva().equals(fecha)) {
                total = total + reservas.get(i).getValorTotal();
            }
        }
        return total;
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

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public char[][] getMatrizOcupacion() {
        return matrizOcupacion;
    }

    public void setMatrizOcupacion(char[][] matrizOcupacion) {
        this.matrizOcupacion = matrizOcupacion;
    }
}
