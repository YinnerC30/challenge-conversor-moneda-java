package com.conversor.presentacion;

import com.conversor.logica.TiposMoneda;
import com.conversor.logica.TiposTemperatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SeleccionTemperatura {

    public SeleccionTemperatura(float valorInput) {

        Menu menu = new Menu("Temperatura", "Elige una opción para convertir",
                new String[]{
                        "Grados Celcius a Grados Farenheit",
                        "Grados Celcius a Grados Kelvin",
                        "Grados Farenheit a Grados Celcius",
                        "Grados Farenheit a Grados Kelvin",
                        "Grados Kelvin a Grados Celcius",
                        "Grados Kelvin a Grados Farenheit"
                });

        // Evento del boton Ok
        menu.buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se hace clic en el botón
                float resultado = 0F;
                int posicion = menu.comboBox.getSelectedIndex();
                menu.ventana.dispose();

                switch (posicion) {
                    case 0 ->
                            resultado = convertirTemperatura(TiposTemperatura.CELCIUS, TiposTemperatura.FARENHEIT, valorInput);

                    case 1 ->
                            resultado = convertirTemperatura(TiposTemperatura.CELCIUS, TiposTemperatura.KELVIN, valorInput);
                    case 2 ->
                            resultado = convertirTemperatura(TiposTemperatura.FARENHEIT, TiposTemperatura.CELCIUS, valorInput);
                    case 3 ->
                            resultado = convertirTemperatura(TiposTemperatura.FARENHEIT, TiposTemperatura.KELVIN, valorInput);
                    case 4 ->
                            resultado = convertirTemperatura(TiposTemperatura.KELVIN, TiposTemperatura.CELCIUS, valorInput);
                    case 5 ->
                            resultado = convertirTemperatura(TiposTemperatura.KELVIN, TiposTemperatura.FARENHEIT, valorInput);

                }

                DecimalFormat formato = new DecimalFormat("#.##");
                new Resultado("Resultado conversión de temperatura", "El resultado es: " + formato.format(resultado));

            }
        });

        // Evento del boton Cancel
        menu.buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menu.ventana.dispose();
                SeleccionConversor conversor = new SeleccionConversor();
            }
        });
    }

    public float convertirTemperatura(TiposTemperatura tipo1, TiposTemperatura tipo2, float valor) {
        if (tipo1 == TiposTemperatura.CELCIUS) {

            switch (tipo2) {
                case FARENHEIT -> {
                    return (valor * ((float) 9 /5)) + 32;
                }case KELVIN -> {
                    return valor + 273.15F ;
                }
            }

        }

        if (tipo1 == TiposTemperatura.FARENHEIT) {

            switch (tipo2) {
                case CELCIUS -> {
                    return ((valor - 32) * 5)/9;
                }case KELVIN -> {
                    return (((valor - 32) * 5)/9) + 273.15F ;
                }
            }

        }if (tipo1 == TiposTemperatura.KELVIN) {

            switch (tipo2) {
                case CELCIUS -> {
                    return valor - 273.15F;
                }case FARENHEIT -> {
                    return (valor - 273.15F) * ((float) 9 /5) + 32 ;
                }
            }

        }


        return valor;
    }
}
