package lab;

import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class Tiro extends Heroi implements Runnable{
    private int tamTiroX;
    private int tamTiroY;
    private int posTiroX;
    private int posTiroY;
    private ImageIcon iTiro;
    private JLabel lTiro;
    private Boolean iniciouOMovimento;
    private Boolean tiroDado;
    private Boolean tiroDadoP1;
    private Component lDino;

    public Tiro() {
        this.tamTiroX = 10;
        this.tamTiroY = 15;

        this.iTiro = new ImageIcon(getClass().getResource("res\\tiro.png"));
        this.lTiro = new JLabel(iTiro);
        this.iniciouOMovimento = false;
        this.tiroDado = false;
        this.tiroDadoP1 = false;
        this.lTiro.setVisible(true);
//        this.posTiroX = lDino.getX();
//        this.posTiroY = lDino.getY();
        this.lTiro.setBounds(1300, 760, tamTiroX,tamTiroY);
    }

    @Override
    public void run() {
        while (true){
            try {sleep(5);} catch (Exception erro) {}

            atirar();

        }
    }

    public void atirar(){
        if(this.tiroDado) {
            this.lTiro.setLocation(getlDino().getX(), getlDino().getY());
            this.setTiroDado(false);
            this.setTiroDadoP1(true);
        }
        if (this.tiroDadoP1) {
            this.lTiro.setVisible(true);
            this.lTiro.setLocation(lTiro.getX() + 10, lTiro.getY());
        }
    }



    public int getTamTiroX() {
        return tamTiroX;
    }

    public void setTamTiroX(int tamTiroX) {
        this.tamTiroX = tamTiroX;
    }

    public int getTamTiroY() {
        return tamTiroY;
    }

    public void setTamTiroY(int tamTiroY) {
        this.tamTiroY = tamTiroY;
    }

    public int getPosTiroX() {
        return posTiroX;
    }

    public void setPosTiroX(int posTiroX) {
        this.posTiroX = posTiroX;
    }

    public int getPosTiroY() {
        return posTiroY;
    }

    public void setPosTiroY(int posTiroY) {
        this.posTiroY = posTiroY;
    }

    public ImageIcon getiTiro() {
        return iTiro;
    }

    public void setiTiro(ImageIcon iTiro) {
        this.iTiro = iTiro;
    }

    public JLabel getlTiro() {
        return lTiro;
    }

    public void setlTiro(JLabel lTiro) {
        this.lTiro = lTiro;
    }

    public Boolean getIniciouOMovimento() {
        return iniciouOMovimento;
    }

    public void setIniciouOMovimento(Boolean iniciouOMovimento) {
        this.iniciouOMovimento = iniciouOMovimento;
    }

    public Boolean getTiroDado() {
        return tiroDado;
    }

    public void setTiroDado(Boolean tiroDado) {
        this.tiroDado = tiroDado;
    }

    public Boolean getTiroDadoP1() {
        return tiroDadoP1;
    }

    public void setTiroDadoP1(Boolean tiroDadoP1) {
        this.tiroDadoP1 = tiroDadoP1;
    }

}
