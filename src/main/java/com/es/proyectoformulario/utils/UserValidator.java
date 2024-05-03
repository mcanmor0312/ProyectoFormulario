package com.es.proyectoformulario.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    //Declaramos una expresion regular que valide que la contraseña no tiene 2 puntos
    private static final String EXP_REG_CONT = ":";

    public static boolean checkCont2(String conterniconalineitor) {
        Pattern pattern = Pattern.compile(EXP_REG_CONT);
        Matcher matcher = pattern.matcher(conterniconalineitor);
        return matcher.find();
    }
}
