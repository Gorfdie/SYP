package UT03.Server;

import java.awt.*;
import java.io.Serializable;
//-- IMPORTAMOS LIBRERIAS QUE UTILIZAREMOS
import javax.swing.*;
public class ServerWindow extends JFrame implements Serializable {
    public JLabel texto;
    public JTextField entrada;
    public JButton BOTON_VERDE;

    public ServerWindow() {
        super("Servidor");

//-- CONFIGURAMOS LA VENTANA
//LE PONEMOS UN TITULO
//-- LE DAMOS UN TAMAÑO A LA VENTANA
        this.setSize(170, 400);
//-- HACEMOS QUE LA VENTANA SE CIERRE POR DEFFECTO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//-- LE AGREGAMOS UN DISTRIBUIDOR DE COMPONENTES
        FlowLayout DISTRIBUCION = new FlowLayout();
        this.setLayout(DISTRIBUCION);
        // -- Poner texto
        this.texto = new JLabel("Mensajes de los usuarios ");
        this.add(this.texto);
    }
    //-- HACEMOS NUESTRO METODO MAIN

    public void addText(String text){
        this.add(new JLabel(text));
    }

    public static void main(String[] ARGS) {
        ServerWindow MI_INTERFAZ = new ServerWindow();
        for (int i = 0; i < 9; i++) {
            MI_INTERFAZ.add(new JLabel("HOLAA "));
        }
        MI_INTERFAZ.setVisible(true);
    }
}