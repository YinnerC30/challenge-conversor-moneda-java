package com.conversor.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Ventana {

    public JFrame ventana;
    public JLabel label;
    public JPanel panelLabel;

    public JComboBox<String> comboBox;
    public JPanel panelComboBox;
    public JButton buttonOk;
    public JButton buttonCancel;

    public JPanel panelButtons;

    public Menu(String nombreVentana, String labelMenu, String[] opciones) {

        ventana = new JFrame(nombreVentana);

        // Configurar la operación por defecto al cerrar y ocultar el botón de maximizar
        salirAlCerrarVentana(ventana);

        // Crea un label con el mensaje
        label = new JLabel(labelMenu);
        panelLabel = new JPanel();
        panelLabel.add(label);
        ventana.add(panelLabel, BorderLayout.NORTH);


        // Crea un menú desplegable con dos opciones
        comboBox = new JComboBox<>(opciones);
        panelComboBox = new JPanel();
        panelComboBox.add(comboBox);
        ventana.add(panelComboBox, BorderLayout.CENTER);


        // Crear botones
        buttonOk = new JButton("OK");
        buttonOk.setPreferredSize(new Dimension(75, 25));


        buttonCancel = new JButton("Cancel");
        buttonCancel.setPreferredSize(new Dimension(75, 25));


        panelButtons = new JPanel();
        panelButtons.add(buttonOk);
        panelButtons.add(buttonCancel);
        ventana.add(panelButtons, BorderLayout.SOUTH);


        // Restringir la maximización horizontal y vertical
        puedeModificarTamanioVentana(ventana, false);

        // Ajustes de ubicación en pantalla
        modificarTamanioVentana(ventana, 350, 150);
        centrarVentana(ventana);

        // Muestra la ventana
        mostrarVentana(ventana, true);
    }

}
