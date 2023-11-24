package com.conversor.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinuarEnPrograma extends Ventana {
    public ContinuarEnPrograma() {
        JFrame ventana = new JFrame("Selecciona una opción");
        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel("¿Desea continuar?");
        panelLabel.add(label);
        ventana.add(panelLabel, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        JButton buttonYes = new JButton("Yes");
        buttonYes.setPreferredSize(new Dimension(75, 25));
        JButton buttonNo = new JButton("No");
        buttonNo.setPreferredSize(new Dimension(75, 25));
        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setPreferredSize(new Dimension(75, 25));
        panelButtons.add(buttonYes);
        panelButtons.add(buttonNo);
        panelButtons.add(buttonCancel);
        ventana.add(panelButtons, BorderLayout.CENTER);

        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                ventana.dispose();
                new SeleccionConversor();
            }
        });

        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                JOptionPane.showMessageDialog(ventana, "El programa ha finalizado");
                ventana.dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                JOptionPane.showMessageDialog(ventana, "El programa ha finalizado");
                ventana.dispose();
            }
        });



        salirAlCerrarVentana(ventana);
        modificarTamanioVentana(ventana, 350, 150);
        puedeModificarTamanioVentana(ventana, false);
        centrarVentana(ventana);
        mostrarVentana(ventana, true);
    }
}
