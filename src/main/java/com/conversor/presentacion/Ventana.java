package com.conversor.presentacion;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public void centrarVentana(JFrame frame) {
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtener el tamaño de la ventana
        Dimension frameSize = frame.getSize();
        // Calcular la posición para centrar la ventana
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        // Establecer la posición de la ventana
        frame.setLocation(x, y);
    }

    public void modificarTamanioVentana(JFrame ventana, int ancho, int alto) {
        ventana.setSize(ancho, alto);
    }

    public void puedeModificarTamanioVentana(JFrame ventana, Boolean esPermitido) {
        ventana.setResizable(esPermitido);
    }

    public void mostrarVentana( JFrame ventana, Boolean esVisible) {
        ventana.setVisible(esVisible);
    }

    public void salirAlCerrarVentana(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

