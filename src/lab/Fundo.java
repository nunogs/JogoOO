package lab;

import javax.swing.*;

public class Fundo {
    private int tamFundoX ;
    private int tamFundoY ;
    private int posFundoX ;
    private int posFundoY ;
    private ImageIcon iFundo;
    private JLabel lfundo;


    public Fundo(int posFundoX, int posFundoY) {
        this.tamFundoX = 1280;
        this.tamFundoY = 720;
        this.posFundoX = posFundoX;
        this.posFundoY = posFundoY;
        this.iFundo = new ImageIcon(getClass().getResource("res\\fundo.png"));
        this.lfundo = new JLabel(iFundo);
        this.lfundo.setBounds( this.posFundoX, this.posFundoY, this.tamFundoX, this.tamFundoY);
        this.lfundo.setVisible(true);
    }


    // METODOS ACESSORES

    public JLabel getLfundo() {
        return lfundo;
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
