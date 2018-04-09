package com.centripio.streams;

import com.centripio.empleados.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
    public static void main(String[] args){
        List<Empleado> listaEmpleado = cargarEmpleados();

        Map<String, Integer> agruparZonaVentaMap = agruparZonaVenta(listaEmpleado);

        agruparZonaVentaMap.forEach((key, value) -> System.out.println(key + ", " + value));

        Map<String, Map<String, Integer>> agruparZonaPaisMap = agruparZonaVentaPais(listaEmpleado);

        agruparZonaPaisMap.forEach((key, value) -> {
                    System.out.println(key);
                    value.forEach((pais, ventas) -> System.out.println(".." + pais + ", " + ventas));
                }
        );

        Map<String, List<Empleado>> agruparZonaEmpleadoMap = agruparZonaVentaListaEmpleado(listaEmpleado);

        agruparZonaEmpleadoMap.forEach((key, value) -> {
                    System.out.println(key);
                    value.forEach((empleado) -> System.out.println(".." + empleado.getApellido()));
                }
        );

        Map<String, List<String>> agruparZonaVentaCaracteristicaMap = agruparZonaVentaCaracteristica(listaEmpleado);

        agruparZonaVentaCaracteristicaMap.forEach((key, value) -> {
                    System.out.println(key);
                    value.forEach((pais) -> System.out.println(".." + pais));
                }
        );

    }

    private static Map<String, List<String>> agruparZonaVentaCaracteristica(List<Empleado> empleados){
        return empleados.stream().collect(Collectors.groupingBy(Empleado::getZonaVenta, Collectors.mapping(Empleado::getPais, Collectors.toList())));
    }

    private static Map<String, List<Empleado>> agruparZonaVentaListaEmpleado(List<Empleado> empleados){
        return empleados.stream().collect(Collectors.groupingBy(Empleado::getZonaVenta, Collectors.toList()));
    }

    private static Map<String, Integer> agruparZonaVenta(List<Empleado> empleados){
        return empleados.stream().collect(Collectors.groupingBy(Empleado::getZonaVenta, Collectors.summingInt(Empleado::getVentas)));
    }

    private static Map<String, Map<String, Integer>> agruparZonaVentaPais(List<Empleado> empleados){
        return empleados.stream().collect(Collectors.groupingBy(Empleado::getZonaVenta,
                Collectors.groupingBy(Empleado::getPais, Collectors.summingInt(Empleado::getVentas))));

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
}

