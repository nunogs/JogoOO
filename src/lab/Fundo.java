package lab;

import javax.swing.*;

public class Fundo {
    private int tamFundoX ;
    private int tamFundoY ;
    private int posFundoX ;
    private int posFundoY ;
    private ImageIcon iFundo;
    private JLabel lfundo;


    public Fundo() {
        tamFundoX = 1280;
        tamFundoY = 720;
        posFundoX = 0;
        posFundoY = 0;
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
