package Main;
/**
 * representa la interfas del sistema
 * @version 1.0
 * @author Sophia Lopez y Juan Esteban
 * @fecha : 22/09/26
 */

import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;

import Model.Habitacion;
import Model.Hotel;
import Model.Huesped;
import Model.Reserva;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = cargarDatos();
        int opcion = 0;

        JOptionPane.showMessageDialog(null,"======================================"+"\n"+
                "     SISTEMA DE GESTIÓN HOTELERA"+"\n"+
                "======================================"+"\n"+
                "Hotel: " + hotel.getNombreComercial()+"\n"+
                "NIT: " + hotel.getNIT()+"\n"+
                "Dirección: " + hotel.getDireccion()+"\n"+
                "Teléfono: " + hotel.getTelefono()+"\n"+
                "======================================"+"\n");


        do{
            mostrarMenu();
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opcion: "));
            System.out.println();

            switch(opcion){
                case 1:
                    consultarHuespedPorTelefono(hotel);
                    break;
                case 2:
                    reporteDisponibilidad(hotel);
                    break;
                case 3:
                    analizarMatrizOcupacion(hotel);
                    break;
                case 4:
                    identificarReservasCapicua(hotel);
                    break;
                case 5:
                    consultarIngresosPorFecha(hotel);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"Sistema finalizado. Gracias por usar el sistema.");
                    break;
                default:JOptionPane.showMessageDialog(null,"Opción no válida. Intente de nuevo.");
            }

        }while(opcion!=6);
    }

    public static void mostrarMenu() {
        JOptionPane.showMessageDialog(null,"======================================"+"\n"+
                "     SISTEMA DE GESTIÓN HOTELERA"+"\n"+
                "======================================"+"\n"+
                "1. Consultar huésped por teléfono"+"\n"+
                "2. Reporte de disponibilidad de habitaciones"+"\n"+
                "3. Análisis de matriz de ocupación semanal"+"\n"+
                "4. Identificar reservas especiales (Capicúa)"+"\n"+
                "5. Consultar ingresos por fecha"+"\n"+
                "6. Salir"+"\n"+
                "======================================");
    }

    public static Hotel cargarDatos() {
        Hotel hotel = new Hotel("Hotel StayPlus", "900.123.456-7", "Calle 10 # 5-40, Centro", 601234567);

        Huesped h1 = hotel.crearHuesped("123456789", "Carlos Gómez", (byte) 30, 300123456, "Bogotá");
        Huesped h2 = hotel.crearHuesped("987654321", "Ana López", (byte) 25, 300765432, "Medellín");
        Huesped h3 = hotel.crearHuesped("456789123", "Luis Pérez", (byte) 40, 310987654, "Cali");
        Huesped h4 = hotel.crearHuesped("789123456", "Marta Torres", (byte) 35, 315123987, "Barranquilla");
        Huesped h5 = hotel.crearHuesped("321654987", "Pedro Ramírez", (byte) 29, 320456789, "Cartagena");

        Habitacion ha1 = hotel.crearHabitacion(101, "Individual", "Piso 1", (byte) 2, 80000, "Disponible");
        Habitacion ha2 = hotel.crearHabitacion(102, "Doble", "Piso 1", (byte) 3, 150000, "Disponible");
        Habitacion ha3 = hotel.crearHabitacion(103, "Suite", "Piso 1", (byte) 4, 300000, "Disponible");
        Habitacion ha4 = hotel.crearHabitacion(104, "Individual", "Piso 1", (byte) 2, 90000, "Disponible");
        Habitacion ha5 = hotel.crearHabitacion(201, "Doble", "Piso 2", (byte) 3, 160000, "Disponible");
        Habitacion ha6 = hotel.crearHabitacion(202, "Individual", "Piso 2", (byte) 2, 95000, "Disponible");
        Habitacion ha7 = hotel.crearHabitacion(203, "Suite", "Piso 2", (byte) 4, 350000, "Mantenimiento");
        Habitacion ha8 = hotel.crearHabitacion(204, "Doble", "Piso 2", (byte) 3, 170000, "Disponible");
        Habitacion ha9 = hotel.crearHabitacion(205, "Doble", "Piso 2", (byte) 3, 165000, "Disponible");

        Reserva r1 = hotel.crearReserva("1221", "2026-09-20", (byte) 3, (byte) 2, "Confirmada", "Tarjeta", h1);
        r1.agregarHabitacion(ha1);

        Reserva r2 = hotel.crearReserva("2002", "2026-09-20", (byte) 2, (byte) 3, "Confirmada", "Efectivo", h2);
        r2.agregarHabitacion(ha2);
        r2.agregarHabitacion(ha5);

        Reserva r3 = hotel.crearReserva("1234", "2026-09-21", (byte) 1, (byte) 2, "Confirmada", "Tarjeta", h3);
        r3.agregarHabitacion(ha3);
        ha3.setEstadoActual("Ocupada");

        Reserva r4 = hotel.crearReserva("3456", "2026-09-21", (byte) 4, (byte) 1, "Confirmada", "Transferencia bancaria", h4);
        r4.agregarHabitacion(ha6);

        Reserva r5 = hotel.crearReserva("1001", "2026-09-22", (byte) 2, (byte) 2, "Confirmada", "Tarjeta", h5);
        r5.agregarHabitacion(ha4);

        Reserva r6 = hotel.crearReserva("5555", "2026-09-22", (byte) 1, (byte) 2, "Pendiente", "Efectivo", h1);
        r6.agregarHabitacion(ha8);

        Reserva r7 = hotel.crearReserva("4321", "2026-09-22", (byte) 2, (byte) 2, "Confirmada", "Tarjeta", h2);
        r7.agregarHabitacion(ha9);

        char[][] matriz = {
                { 'D', 'O', 'O', 'O', 'D', 'D', 'D' },
                { 'O', 'D', 'D', 'D', 'O', 'O', 'D' },
                { 'D', 'D', 'O', 'O', 'D', 'O', 'O' },
                { 'O', 'O', 'D', 'D', 'D', 'D', 'D' },
                { 'D', 'D', 'O', 'D', 'O', 'O', 'D' },
                { 'O', 'O', 'D', 'O', 'D', 'D', 'D' },
                { 'D', 'D', 'D', 'D', 'D', 'D', 'O' },
                { 'O', 'D', 'O', 'O', 'O', 'D', 'D' },
                { 'D', 'O', 'D', 'D', 'D', 'O', 'O' }
        };
        hotel.setMatrizOcupacion(matriz);

        return hotel;
    }

    public static void consultarHuespedPorTelefono(Hotel hotel) {
        int telefono =Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese el número de teléfono del huésped: "));
        Huesped h = hotel.buscarHuespedPorTelefono(telefono);

        if (h == null) {
            JOptionPane.showMessageDialog(null,"No se encontró un huésped con el teléfono " + telefono + ".");
        } else {
            JOptionPane.showMessageDialog(null,"=== DATOS DEL HUÉSPED ==="+"\n"+
                    "Nombre: " + h.getNombreCompleto()+"\n"+
                    "Documento: " + h.getDocumentoIdentidad()+"\n"+
                    "Ciudad: " + h.getCiudadProcedencia()+"\n");
            JOptionPane.showMessageDialog(null,"=== RESERVAS REALIZADAS ===");
            ArrayList<Reserva> reservas = hotel.obtenerReservasDeHuesped(h);
            if (reservas.size() == 0) {
                JOptionPane.showMessageDialog(null,"El huésped no tiene reservas registradas.");
            }
            for (int i = 0; i < reservas.size(); i++) {
                Reserva r = reservas.get(i);
                JOptionPane.showMessageDialog(null,"Código: " + r.getCodigoReserva()
                        + " | Fecha: " + r.getFechaReserva()
                        + " | Noches: " + r.getNumeroNoche()
                        + " | Estado: " + r.getEstadoReserva()
                        + " | Valor total: $" + (int) r.getValorTotal());
            }
        }
    }

    public static void reporteDisponibilidad(Hotel hotel) {
        JOptionPane.showMessageDialog(null,"=== REPORTE DE DISPONIBILIDAD ==="+"\n"+
                "Habitaciones disponibles: " + hotel.getCantidadDisponibles()+"\n"+
                "Habitaciones reservadas: " + hotel.getCantidadReservadas()+"\n"+
                "Habitaciones ocupadas: " + hotel.getCantidadOcupadas()+"\n"+
                "Habitaciones en mantenimiento: " + hotel.getCantidadMantenimiento()+"\n");

        Habitacion mayor = hotel.getHabitacionMayorPrecio();
        Habitacion menor = hotel.getHabitacionMenorPrecio();

        JOptionPane.showMessageDialog(null,"Habitación con mayor precio por noche: " + mayor.getNumeroHabitacion()
                + " (" + mayor.getTipoHabitacion() + ") - $" + (int) mayor.getPrecioNoche());
        JOptionPane.showMessageDialog(null,"Habitación con menor precio por noche: " + menor.getNumeroHabitacion()
                + " (" + menor.getTipoHabitacion() + ") - $" + (int) menor.getPrecioNoche());
    }

    public static void analizarMatrizOcupacion(Hotel hotel) {
        char[][] matriz = hotel.getMatrizOcupacion();
        String[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

        JOptionPane.showMessageDialog(null,"=== MATRIZ DE OCUPACIÓN SEMANAL ==="+"\n"+
                "            ");
        String textoDias="";
        for (int j = 0; j < dias.length; j++) {
            textoDias +=(dias[j] + "\t");
        }
        JOptionPane.showMessageDialog(null,textoDias);

        String reporte = "";

        for (int i = 0; i < matriz.length; i++) {
            reporte += "Habitación " + hotel.getHabitaciones().get(i).getNumeroHabitacion() + "  \t";

            for (int j = 0; j < matriz[i].length; j++) {
                reporte += matriz[i][j] + "  \t";
            }

            reporte += "\n";
        }

        JOptionPane.showMessageDialog(null, reporte);

        System.out.println();
        JOptionPane.showMessageDialog(null,"Día con mayor ocupación: " + dias[hotel.getDiaMayorOcupacion()]+"\n"+
                "Día con menor ocupación: " + dias[hotel.getDiaMenorOcupacion()]+"\n"+
                "Total de habitaciones ocupadas durante la semana: " + hotel.getTotalOcupadasSemana()+"\n");
    }

    public static void identificarReservasCapicua(Hotel hotel) {
        JOptionPane.showMessageDialog(null,"=== RESERVAS ESPECIALES (CAPICÚA) ===");
        ArrayList<Reserva> especiales = hotel.getReservasEspeciales();

        if (especiales.size() == 0) {
            JOptionPane.showMessageDialog(null,"No se encontraron reservas con código capicúa.");
        }

        String reporteEspeciales = "";

        if (especiales.size() > 0) {
            System.out.println();
            JOptionPane.showMessageDialog(null,"Total de reservas especiales: " + especiales.size());
        }

        for (int i = 0; i < especiales.size(); i++) {
            Reserva r = especiales.get(i);

            reporteEspeciales += "Reserva " + r.getCodigoReserva()
                    + " | Huésped: " + r.getHuesped().getNombreCompleto()
                    + " | Fecha: " + r.getFechaReserva()
                    + " | Valor total: $" + (int) r.getValorTotal()
                    + "\n";
        }

        JOptionPane.showMessageDialog(null, reporteEspeciales);



    }

    public static void consultarIngresosPorFecha(Hotel hotel) {
        String fecha = JOptionPane.showInputDialog(null,"Ingrese la fecha a consultar (AAAA-MM-DD): ");
        JOptionPane.showMessageDialog(null,"=== INGRESOS DEL " + fecha + " ==="+"\n"+
                "Reservas encontradas: " + hotel.getCantidadReservasPorFecha(fecha)+"\n"+
                "Ingreso total del día: $" + (int) hotel.getIngresosPorFecha(fecha));
    }
}
