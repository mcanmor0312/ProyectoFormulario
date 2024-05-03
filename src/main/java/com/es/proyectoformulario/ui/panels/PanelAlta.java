package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.ServiceUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAlta extends JPanel {
    private JTextField texto1 = new JTextField();
    private JTextField texto2 = new JTextField();
    private JPasswordField texto3 = new JPasswordField();
    private JPasswordField texto4 = new JPasswordField();
    private JComboBox <String> texto5 = new JComboBox<>();
    private JLabel texto6 = new JLabel();


    ServiceUser serviceUser = new ServiceUser();
    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (texto3.getText().isEmpty() && texto4.getText().isEmpty()&&texto2.getText().isEmpty() && texto1.getText().isEmpty()) {
                texto3.setBackground(new Color(255, 0, 0, 255));
                texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto4.setBackground(new Color(255, 0, 0, 243));
                texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto1.setBackground(new Color(255, 0, 0, 255));
                texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto2.setBackground(new Color(255, 0, 0, 243));
                texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Te faltan todo wey");
            }else if (texto3.getText().isEmpty() && texto4.getText().isEmpty()) {
                texto3.setBackground(new Color(255, 0, 0, 255));
                texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto4.setBackground(new Color(255, 0, 0, 243));
                texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Te faltan las contrasenias");
            }else if (texto2.getText().isEmpty() && texto1.getText().isEmpty()) {
                texto1.setBackground(new Color(255, 0, 0, 255));
                texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto2.setBackground(new Color(255, 0, 0, 243));
                texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Te faltan los usuarios");
            } else if (texto1.getText().isEmpty()) {
                texto1.setBackground(new Color(255, 0, 0, 255));
                texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Falta el idusuario");
            } else if (texto2.getText().isEmpty()) {
                texto2.setBackground(new Color(255, 0, 0, 243));
                texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Falta el usuario");
            } else if (texto3.getText().isEmpty()) {
                texto3.setBackground(new Color(255, 0, 0, 255));
                texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Falta la contrasenia");
            } else if (texto4.getText().isEmpty()) {
                texto4.setBackground(new Color(255, 0, 0, 255));
                texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto6.setText("Falta repetir la contrasenia contrasenia");
            } else{

                if (texto3.getText().equals(texto4.getText())) {
                    if (serviceUser.userExists(texto1.getText())) {
                        System.out.println("Ya Esta registrado");
                        texto6.setText("Ya Esta registrado");
                        texto1.setBackground(new Color(255, 234, 0, 243));
                        texto2.setBackground(new Color(255, 221, 0, 255));
                        texto3.setBackground(new Color(255, 234, 0, 243));
                        texto4.setBackground(new Color(255, 221, 0, 255));
                        texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));

                    } else {
                        System.out.println("Bienvenido " + texto2.getText());
                        texto6.setText("Bienvenido " + texto2.getText());
                        texto1.setBackground(new Color(26, 255, 0, 243));
                        texto2.setBackground(new Color(0, 255, 89, 255));
                        texto3.setBackground(new Color(26, 255, 0, 243));
                        texto4.setBackground(new Color(0, 255, 89, 255));
                        texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));

                        ServiceUser servicioUsuario = new ServiceUser();
                        boolean laVelda = false;
                        try {
                            if (texto5 != null && texto5.getSelectedItem().equals("Si")) {
                                laVelda = true;
                            }
                        } catch (NullPointerException d) {
                            System.out.println("Feo :)");
                        }
                        User p = new User(texto1.getText(), texto2.getText(), texto3.getText(), laVelda);
                        servicioUsuario.anadirUsuarioPremium(p);

                    }
                }else {
                    System.out.println("Las contraseñas no coinciden");
                    texto6.setText("Las contrasenias no coinciden");
                    texto1.setBackground(new Color(255, 234, 0, 243));
                    texto2.setBackground(new Color(255, 221, 0, 255));
                    texto3.setBackground(new Color(255, 234, 0, 243));
                    texto4.setBackground(new Color(255, 221, 0, 255));
                    texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                    texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                    texto3.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                    texto4.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton botonSupremo = (JButton) e.getSource();
            botonSupremo.setBackground(new Color(115, 11, 122, 255));
            botonSupremo.setBorder(new LineBorder(new Color(0, 0, 0), 1));


        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton botonSupremo = (JButton) e.getSource();
            botonSupremo.setBackground(new Color(122, 113, 11, 255));
            botonSupremo.setBorder(new LineBorder(new Color(0, 0, 0), 1));

        }
    };
    public PanelAlta(){
        this.setBackground(new Color(85, 255, 0, 255));
        this.setLayout(null);

        JLabel idUser = new JLabel("IdUser");
        idUser.setLocation(new Point(200, 100));
        idUser.setSize(new Dimension(152, 32));
        this.add(idUser);

        JLabel usuario = new JLabel("Usuario");
        usuario.setLocation(new Point(200, 150));
        usuario.setSize(new Dimension(152, 32));
        this.add(usuario);

        JLabel psswd1 = new JLabel("Passwd1");
        psswd1.setLocation(new Point(200, 200));
        psswd1.setSize(new Dimension(152, 32));
        this.add(psswd1);

        JLabel psswd2 = new JLabel("Passwd2");
        psswd2.setLocation(new Point(200, 250));
        psswd2.setSize(new Dimension(152, 32));
        this.add(psswd2);

        JLabel isAdmin = new JLabel("EsAdmin");
        isAdmin.setLocation(new Point(200, 300));
        isAdmin.setSize(new Dimension(152, 32));
        this.add(isAdmin);

        JButton bEnviar = new JButton("Alta");
        bEnviar.setLocation(new Point(220, 350));
        bEnviar.setSize(new Dimension(152, 32));
        this.add(bEnviar);

        texto1.setLocation(new Point(270, 100));
        texto1.setSize(new Dimension(152, 32));
        this.add(texto1);

        texto2.setLocation(new Point(270, 150));
        texto2.setSize(new Dimension(152, 32));
        this.add(texto2);

        texto3.setLocation(new Point(270, 200));
        texto3.setSize(new Dimension(152, 32));
        this.add(texto3);


        texto4.setLocation(new Point(270, 250));
        texto4.setSize(new Dimension(152, 32));
        this.add(texto4);

        texto5.setLocation(new Point(270, 300));
        texto5.setSize(new Dimension(152, 32));
        texto5.addItem("Si");
        texto5.addItem("No");
        this.add(texto5);

        texto6.setLocation(new Point(220, 400));
        texto6.setSize(new Dimension(152, 32));
        this.add(texto6);

        bEnviar.addMouseListener(listenerMouse);

    }
}
