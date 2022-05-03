package com.ceiba.validador;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidadorServiteca {

    public static void verificarDiaInvalido(LocalDateTime fecha,DayOfWeek dia,String mensaje){
        if(fecha.toLocalDate().getDayOfWeek()== dia){
            throw  new ExcepcionValorInvalido(mensaje);
        }
    }
}
