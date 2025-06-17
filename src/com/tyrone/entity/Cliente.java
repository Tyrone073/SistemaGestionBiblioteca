package com.tyrone.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    List<Prestamo> historialLibrosPrestados = new ArrayList<>();

    public Cliente() {
    }
    public Cliente(Usuario usuario) {
        super(
                usuario.getNombre(),
                usuario.getCedula(),
                usuario.getTelefono(),
                usuario.getDireccion()
        );
    }

    public List<Prestamo> getHistorialLibrosPrestados() {
        return historialLibrosPrestados;
    }

    public void setHistorialLibrosPrestados(Prestamo prestamo) {
        historialLibrosPrestados.add(prestamo);
    }


    @Override
    public String toString() {
        return  super.toString()+
                "\nhistorialLibrosPrestados=" + historialLibrosPrestados;
    }
}
