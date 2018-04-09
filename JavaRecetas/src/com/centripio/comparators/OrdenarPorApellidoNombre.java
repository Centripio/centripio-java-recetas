package com.centripio.comparators;

import com.centripio.empleados.Empleado;

import java.util.Comparator;

/**
 * Created by Carlos on 3/24/18.
 */
public class OrdenarPorApellidoNombre implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {
        if (o1.getApellido().equals(o2.getApellido())){
            return o1.getNombre().compareTo(o2.getNombre());
        }

        return o1.getApellido().compareTo(o2.getApellido());
    }
}
