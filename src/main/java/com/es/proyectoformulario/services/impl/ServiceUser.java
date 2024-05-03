package com.es.proyectoformulario.services.impl;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.utils.UserValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUser {

    // ATRIBUTOS
    private ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    private GestionFicheroUser gestionUser; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    private ServiceLogger logger;

    private String ruta = "src/main/resources/users/users.txt";

    public void anadirUsuarioPremium(User usuario){
        boolean terrible=false;
        if (!this.userExists(usuario.getId())) {
            if (!UserValidator.checkCont2(usuario.getId()) && !UserValidator.checkCont2(usuario.getPass()) && !UserValidator.checkCont2(usuario.getName())) {
                if (usuario.getId().length() <= 20 && usuario.getName().length() <= 20 && usuario.getPass().length() <= 20) {
                    terrible = true;
                }
            }
        }
        if (terrible) {
            users.add(usuario);
            anadirFicheroUsers(usuario);
        }
    }
    public ServiceUser() {
        this.users = new ArrayList<>();
        this.gestionUser = new GestionFicheroUser();
        leerFicheroUsers();
        this.logger = new ServiceLogger();
    }


    public boolean checkUser(String idUser, String password) {
        for (int i = 0; i < this.users.size(); i++) {
            User usuario = this.users.get(i); // usuario es el elemento de la posicion i de users
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)) {
                this.logger.registrarLog(idUser, "LOGIN", "OK");
                return true;
            }
        }
        this.logger.registrarLog(idUser, "LOGIN", "NOT OK");
        return false;
    }

    public boolean userExists(String idUser) {
        return this.users.stream().anyMatch(user -> user.getId().equalsIgnoreCase(idUser));
    }

    public void leerFicheroUsers() {
        this.users = gestionUser.leerFichero(this.ruta);
    }

    public void anadirFicheroUsers(User u) {
        gestionUser.anadirFichero(u, this.ruta);
    }

    public void modificarFicheroUsers() {
        gestionUser.modificarFichero(this.users, this.ruta);
    }

}
