package lab;

import javax.swing.*;

public class Fundo {
    private int tamFundoX = 1280;
    private int tamFundoY = 720;
    private int posFundoX = 0;
    private int posFundoY = 0;
    private ImageIcon iFundo;
    private JLabel lfundo;


    public Fundo() {
        iFundo = new ImageIcon(getClass().getResource("res\\fundo.png"));
        lfundo = new JLabel(iFundo);
        this.lfundo.setBounds(getPosFundoX(), getPosFundoY(), getTamFundoX(),getTamFundoY());
        lfundo.setVisible(true);
    }


    public void setTamFundoX(int tamFundoX) {
        this.tamFundoX = tamFundoX;
    }

    public void setTamFundoY(int tamFundoY) {
        this.tamFundoY = tamFundoY;
    }

    public void setPosFundoX(int posFundoX) {
        this.posFundoX = posFundoX;
    }

    public void setPosFundoY(int posFundoY) {
        this.posFundoY = posFundoY;
    }


    public JLabel getLfundo() {
        return lfundo;
    }

    public void setLfundo(JLabel lfundo) {
        this.lfundo = lfundo;
    }

    public ImageIcon getiFundo() {
        return iFundo;
    }

    public void setiFundo(ImageIcon iFundo) {
        this.iFundo = iFundo;
    }

    public int getTamFundoX() {
        return tamFundoX;
    }

    public int getTamFundoY() {
        return tamFundoY;
    }

    public int getPosFundoX() {
        return posFundoX;
    }

    public int getPosFundoY() {
        return posFundoY;
    }
}
