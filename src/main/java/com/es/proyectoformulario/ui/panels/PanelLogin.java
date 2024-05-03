package com.es.proyectoformulario.ui.panels;


import com.es.proyectoformulario.services.impl.ServiceUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Pablo Macías
 */
public class PanelLogin extends JPanel {
    private JPasswordField texto1 = new JPasswordField();
    private JTextField texto2 = new JTextField();

    private JLabel texto3 = new JLabel();

    ServiceUser serviceUser = new ServiceUser();

    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (texto2.getText().isEmpty() && texto1.getText().isEmpty()) {
                texto1.setBackground(new Color(255, 0, 0, 255));
                texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto2.setBackground(new Color(255, 0, 0, 243));
                texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto3.setText("Te falta la contrasenia y el usuario Atún");
            } else if (texto2.getText().isEmpty()) {
                texto2.setBackground(new Color(255, 0, 0, 243));
                texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto3.setText("Te falta la contrasenia cirimolla");
            } else if (texto1.getText().isEmpty()) {
                texto1.setBackground(new Color(255, 0, 0, 255));
                texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                texto3.setText("Te falta el usuario cara gazpacho");
            } else {

                if (serviceUser.checkUser(texto2.getText(), texto1.getText())) {
                    System.out.println("Esta registrado");
                    texto3.setText("Esta registrado");
                    texto2.setBackground(new Color(123, 255, 0, 243));
                    texto1.setBackground(new Color(85, 255, 0, 255));
                    texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                    texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));

                } else {
                    System.out.println("Pa tu casa");
                    texto3.setText("Pa tu casa");
                    texto2.setBackground(new Color(230, 255, 0, 243));
                    texto1.setBackground(new Color(191, 255, 0, 255));
                    texto2.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                    texto1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
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

    public PanelLogin() {
        this.setBackground(new Color(85, 255, 0, 255));
        this.setLayout(null);

        JLabel passwd = new JLabel("Passwd");
        passwd.setLocation(new Point(200, 250));
        passwd.setSize(new Dimension(152, 32));
        this.add(passwd);

        JLabel user = new JLabel("Usuario");
        user.setLocation(new Point(200, 200));
        user.setSize(new Dimension(152, 32));
        this.add(user);

        JButton bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(220, 321));
        bEnviar.setSize(new Dimension(152, 32));
        this.add(bEnviar);

        texto1.setLocation(new Point(250, 250));
        texto1.setSize(new Dimension(152, 32));
        this.add(texto1);

        texto2.setLocation(new Point(250, 200));
        texto2.setSize(new Dimension(152, 32));
        this.add(texto2);

        texto3.setLocation(new Point(220, 350));
        texto3.setSize(new Dimension(152, 32));
        this.add(texto3);

        bEnviar.addMouseListener(listenerMouse);
    }
}