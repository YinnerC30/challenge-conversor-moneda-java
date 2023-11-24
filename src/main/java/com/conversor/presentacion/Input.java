package com.conversor.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JFrame {
    public Input(String mensajeLabel) {
        super("Input");
        JFrame ventana = new JFrame("Input");

        // Crea un label con el mensaje
        JLabel label = new JLabel(mensajeLabel);
        JPanel panelLabel = new JPanel();
        panelLabel.add(label);
        ventana.add(panelLabel, BorderLayout.NORTH);


        // Crear input
        JPanel panelInput = new JPanel();
        JTextField textField = new JTextField(25); // 10 es el ancho del campo de texto
        panelInput.add(textField);
        ventana.add(panelInput, BorderLayout.CENTER);


        // Crear botones
        JButton buttonOk = new JButton("OK");
        buttonOk.setPreferredSize(new Dimension(75, 25));
        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setPreferredSize(new Dimension(75, 25));

        JPanel panelButtons = new JPanel();
        panelButtons.add(buttonOk);
        panelButtons.add(buttonCancel);
        ventana.add(panelButtons, BorderLayout.SOUTH);


        // Evento del boton Ok
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                String tipoInput = label.getText();
                String valorInput = textField.getText();

                if ((valorInput != null || !valorInput.isEmpty()) && esNumeroValido(valorInput)) {
                    if (tipoInput.contains("dinero")) {
                        ventana.dispose();
                        System.out.println("Ingresaste al selector de moneda");
                        new SeleccionMoneda(Float.parseFloat(valorInput));
                    } else {
                        ventana.dispose();
                        System.out.println("Ingresaste al selector de temperatura");
                        new SeleccionTemperatura(Float.parseFloat(valorInput));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(ventana, "Debes ingresar un numero valido");
                }


            }
        });

        // Eventos del boton Cancel
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new SeleccionConversor();
            }
        });


        // Configurar la operación por defecto al cerrar y ocultar el botón de maximizar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Restringir la maximización horizontal y vertical
        ventana.setResizable(false);

        // Ajustes de ubicación en pantalla
        ventana.setSize(400, 150);
        centrarVentana(ventana);

        // Muestra la ventana
        ventana.setVisible(true);
    }

    private static void centrarVentana(JFrame frame) {
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

    private static boolean esNumeroValido(String numero) {
        try {
            Float.parseFloat(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
