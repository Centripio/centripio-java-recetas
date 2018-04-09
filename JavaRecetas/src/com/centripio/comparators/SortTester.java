package com.centripio.comparators;

import com.centripio.comparators.OrdenarPorApellidoNombre;
import com.centripio.empleados.Empleado;

import java.util.*;
import java.util.stream.Collectors;

public class SortTester {
    public static void main(String[] args){
        List<Empleado> listaEmpleados = cargarEmpleados();

        //printResults(listaEmpleados);

        //Collections.sort(listaEmpleados, new OrdenarPorApellidoNombre());

        //List<Empleado> listaEmpleadosTemp = listaEmpleados.stream().sorted(new OrdenarPorApellidoNombre()).collect(Collectors.toList());

        //List<Empleado> listaEmpleadosTemp = listaEmpleados.stream().sorted(Comparator.comparing(Empleado::getApellido).thenComparing(Empleado::getNombre)).collect(Collectors.toList());

        List<Empleado> listaEmpleadosTemp = listaEmpleados.stream().sorted((e1, e2) -> e1.getApellido().equals(e2.getApellido())
                                        ? e1.getNombre().compareTo(e2.getNombre()) : e1.getApellido().compareTo(e2.getApellido())).collect(Collectors.toList());

        printResults(listaEmpleadosTemp);
    }

    private static List<Empleado> cargarEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();

        Empleado empleado01 = new Empleado(1, "Juan", "Perez", "LATAM", 3000, "Mexico");
        Empleado empleado02 = new Empleado(2, "Pedro", "Infante", "APAC", 2000, "Israel");
        Empleado empleado03 = new Empleado(3, "Roberto", "Bolanos", "NORTH AMERICA", 1000, "EEUU");
        Empleado empleado04 = new Empleado(4, "Juan", "Gabriel", "AFRICA", 4000, "Nigeria");
        Empleado empleado05 = new Empleado(5, "Roberto", "Baggio", "EUROPA", 5000, "Italia");
        Empleado empleado06 = new Empleado(6, "Jurgen", "Klinsmann", "EUROPA", 7000, "Alemania");
        Empleado empleado07 = new Empleado(7, "Edson", "Do Nacimento", "LATAM", 4000, "Brasil");
        Empleado empleado08 = new Empleado(8, "Landon", "Donovan", "NORTH AMERICA", 7000, "EEUU");
        Empleado empleado09 = new Empleado(9, "Taribo", "West", "AFRICA", 4000, "Nigeria");
        Empleado empleado10 = new Empleado(10, "Carlos", "Infante", "AFRICA", 4000, "Sudafrica");
        Empleado empleado11 = new Empleado(11, "Alberto", "Perez", "LATAM", 5000, "Uruguay");
        Empleado empleado12 = new Empleado(12, "Dino", "Baggio", "EUROPA", 7000, "Italia");
        Empleado empleado13 = new Empleado(13, "Emiliano", "Zapata", "LATAM", 9000, "Mexico");
        Empleado empleado14 = new Empleado(14, "Laura", "Zapata", "LATAM", 2000, "Argentina");
        Empleado empleado15 = new Empleado(15, "Ramiro", "Donovan", "NORTH AMERICA", 4000, "Canada");

        listaEmpleados.add(empleado01);
        listaEmpleados.add(empleado02);
        listaEmpleados.add(empleado03);
        listaEmpleados.add(empleado04);
        listaEmpleados.add(empleado05);
        listaEmpleados.add(empleado06);
        listaEmpleados.add(empleado07);
        listaEmpleados.add(empleado08);
        listaEmpleados.add(empleado09);
        listaEmpleados.add(empleado10);
        listaEmpleados.add(empleado11);
        listaEmpleados.add(empleado12);
        listaEmpleados.add(empleado13);
        listaEmpleados.add(empleado14);
        listaEmpleados.add(empleado15);

        return listaEmpleados;
    }

    private static void printResults(List<Empleado> listaEmpleados){
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado.getApellido() + ", " + empleado.getNombre() + " Ventas:" + empleado.getVentas());
        }
    }
}
