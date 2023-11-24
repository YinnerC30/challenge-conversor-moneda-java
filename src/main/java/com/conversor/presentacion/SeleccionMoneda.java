package com.conversor.presentacion;

import com.conversor.logica.TiposMoneda;
import com.conversor.logica.ValorConversionPesoColombiano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionMoneda {
    public SeleccionMoneda(Float valorInput) {
        Menu menu = new Menu("Monedas",
                "Elige la moneda a la que deseas convertir tu dinero",
                new String[]{
                        "De Pesos Colombianos a Dolár",
                        "De Pesos Colombianos a Euros",
                        "De Pesos Colombianos a Libras Esterlinas",
                        "De Pesos Colombianos a Yen Japonés",
                        "De Pesos Colombianos a Won sul-coreano",
                        "De Dolár a Pesos Colombianos ",
                        "De Euros a Pesos Colombianos a ",
                        "De Libras Esterlinas a Pesos Colombianos",
                        "De Yen Japonés a Pesos Colombianos",
                        "De Won sul-coreano a Pesos Colombianos"
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
                            resultado = conversionMonedas(TiposMoneda.PESOS_COLOMBIANOS, TiposMoneda.DOLARES, valorInput);

                    case 1 ->
                            resultado = conversionMonedas(TiposMoneda.PESOS_COLOMBIANOS, TiposMoneda.EUROS, valorInput);
                    case 2 ->
                            resultado = conversionMonedas(TiposMoneda.PESOS_COLOMBIANOS, TiposMoneda.LIBRAS_ESTERLINAS, valorInput);
                    case 3 ->
                            resultado = conversionMonedas(TiposMoneda.PESOS_COLOMBIANOS, TiposMoneda.YEN_JAPONES, valorInput);
                    case 4 ->
                            resultado = conversionMonedas(TiposMoneda.PESOS_COLOMBIANOS, TiposMoneda.WON_SOUL_COREANO, valorInput);
                    case 5 ->
                            resultado = conversionMonedas(TiposMoneda.DOLARES, TiposMoneda.PESOS_COLOMBIANOS, valorInput);
                    case 6 ->
                            resultado = conversionMonedas(TiposMoneda.EUROS, TiposMoneda.PESOS_COLOMBIANOS, valorInput);
                    case 7 ->
                            resultado = conversionMonedas(TiposMoneda.LIBRAS_ESTERLINAS, TiposMoneda.PESOS_COLOMBIANOS, valorInput);
                    case 8 ->
                            resultado = conversionMonedas(TiposMoneda.YEN_JAPONES, TiposMoneda.PESOS_COLOMBIANOS, valorInput);
                    case 9 ->
                            resultado = conversionMonedas(TiposMoneda.WON_SOUL_COREANO, TiposMoneda.PESOS_COLOMBIANOS, valorInput);
                }


                new Resultado("Resultado conversor moneda", "El resultado es: " + resultado);

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

    private float conversionMonedas(TiposMoneda moneda1, TiposMoneda moneda2, float valor) {
        if (moneda1 == TiposMoneda.PESOS_COLOMBIANOS) {

            switch (moneda2) {
                case DOLARES -> {
                    return valor * ValorConversionPesoColombiano.PESO_COL_A_DOLAR;
                }
                case EUROS -> {
                    return valor * ValorConversionPesoColombiano.PESO_COL_A_EURO;
                }
                case LIBRAS_ESTERLINAS -> {
                    return valor * ValorConversionPesoColombiano.PESO_COL_A_LIBRA_ESTERLINA;
                }
                case YEN_JAPONES -> {
                    return valor * ValorConversionPesoColombiano.PESO_COL_A_YEN_JAPONES;
                }
                case WON_SOUL_COREANO -> {
                    return valor * ValorConversionPesoColombiano.PESO_COL_A_WON_SURCOREANO;
                }
            }


        } else {
            switch (moneda1) {
                case DOLARES -> {
                    return valor / ValorConversionPesoColombiano.PESO_COL_A_DOLAR;
                }
                case EUROS -> {
                    return valor / ValorConversionPesoColombiano.PESO_COL_A_EURO;
                }
                case LIBRAS_ESTERLINAS -> {
                    return valor / ValorConversionPesoColombiano.PESO_COL_A_LIBRA_ESTERLINA;
                }
                case YEN_JAPONES -> {
                    return valor / ValorConversionPesoColombiano.PESO_COL_A_YEN_JAPONES;
                }
                case WON_SOUL_COREANO -> {
                    return valor / ValorConversionPesoColombiano.PESO_COL_A_WON_SURCOREANO;
                }
            }
        }
        return valor;
    }
}
