package com.example.projeto.validacoes;

import java.text.ParseException;
import javafx.scene.control.TextField;
import javax.swing.text.MaskFormatter;

public class Formatar_CPF {

    private final MaskFormatter mf;
    private TextField tf;
    private String CaracteresValidos;
    private String mask;

    public Formatar_CPF() {
        mf = new MaskFormatter();
    }

    public void formatter(TextField tf, String CaracteresValidos, String mask) {
        try {
            mf.setMask(mask);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        mf.setValidCharacters(CaracteresValidos);
        mf.setValueContainsLiteralCharacters(false);
        String text = tf.getText().replaceAll("[\\W]", "");

        boolean repetir = true;
        while (repetir) {
            char ultimoCaractere;
            if (text.equals("")) {
                break;
            } else {
                ultimoCaractere = text.charAt(text.length() - 1);
            }

            try {
                text = mf.valueToString(text);
                repetir = false;
            } catch (ParseException ex) {
                text = text.replace(ultimoCaractere + "", "");
                repetir = true;
            }
        }

        tf.setText(text);

        if (!text.equals("") && tf.getLength() > 0) {
            for (int i = 0; i < tf.getLength(); i++) {
                if (tf.getText().charAt(i) != ' ') {
                    tf.forward();
                }
            }
        }
    }

    public void formatter() {
        formatter(this.tf, this.CaracteresValidos, this.mask);
    }

    public TextField getTf() {
        return tf;
    }

    public void setTf(TextField tf) {
        this.tf = tf;
    }

    public String getCaracteresValidos() {
        return CaracteresValidos;
    }

    public void setCaracteresValidos(String CaracteresValidos) {
        this.CaracteresValidos = CaracteresValidos;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }
}
