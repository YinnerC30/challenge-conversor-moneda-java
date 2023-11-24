package com.conversor.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionConversor {
    public SeleccionConversor() {
        Menu menu = new Menu(
                "Menu",
                "Seleccione una opción de conversión",
                new String[]{"Conversor de Moneda", "Conversor de Temperatura"}
        );

        // Evento del boton Ok
        menu.buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                int posicion = menu.comboBox.getSelectedIndex();
                menu.ventana.dispose();
                if (posicion == 0) {
                    Input inputVaalorMoneda = new Input("Ingrese la cantidad de dinero que desea convertir");
                } else {
                    Input inputValorTemperatura = new Input("Ingrese el valor de la temperatura que desea convertir");
                }
            }
        });

        // Evento del boton Cancel
        menu.buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.ventana.dispose();
            }
        });
    }


}
