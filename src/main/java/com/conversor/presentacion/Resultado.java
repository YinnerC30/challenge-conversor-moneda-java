package com.conversor.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultado extends Ventana {
    public Resultado(String nombreVentana, String mensaje) {
        JFrame ventana = new JFrame(nombreVentana);

        JPanel panelLabel = new JPanel();
        JLabel labelMensaje = new JLabel(mensaje);
        panelLabel.add(labelMensaje);
        ventana.add(panelLabel, BorderLayout.NORTH);


        JPanel panelBottons = new JPanel();
        JButton buttonOk = new JButton("Ok");
        panelBottons.add(buttonOk);
        ventana.add(panelBottons, BorderLayout.CENTER);


        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                ventana.dispose();
                new ContinuarEnPrograma();
            }
        });

        salirAlCerrarVentana(ventana);
        modificarTamanioVentana(ventana, 350, 150);
        puedeModificarTamanioVentana(ventana, false);
        centrarVentana(ventana);
        mostrarVentana(ventana, true);
    }
}
