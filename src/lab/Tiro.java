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

    public Tiro() {
        this.tamTiroX = 10;
        this.tamTiroY = 15;

        this.iTiro = new ImageIcon(getClass().getResource("res\\tiro.png"));
        this.lTiro = new JLabel(iTiro);
        this.iniciouOMovimento = false;
        this.tiroDado = false;
        this.tiroDadoP1 = false;
        this.lTiro.setVisible(true);
        this.lTiro.setBounds(1300, 1000, tamTiroX,tamTiroY);
    }

    @Override
    public void run() {
        while (true){
            try {sleep(4);} catch (Exception erro) {}
            if(lTiro.getX() > 1300){
                lTiro.setLocation(1300, 1000);
            }
            atirar();

        }
    }
    public void atualizarPosHeroi(int posHeroiX, int posHeroiY) {
        this.posTiroX = posHeroiX;
        this.posTiroY = posHeroiY;
    }

    public void atirar(){
        if(this.tiroDado) {
            this.lTiro.setLocation(posTiroX,posTiroY);
            this.tiroDado =false;
            this.tiroDadoP1 = true;
        }
        if (this.tiroDadoP1) {
            this.lTiro.setVisible(true);
            this.lTiro.setLocation(lTiro.getX() + 10, lTiro.getY());
        }
    }
    public void tiroAcertou(){
        this.lTiro.setLocation(1300,760);

    }


    public int getTamTiroX() {
        return tamTiroX;
    }

    public int getTamTiroY() {
        return tamTiroY;
    }

    public int getPosTiroX() {
        return posTiroX;
    }

    public int getPosTiroY() {
        return posTiroY;
    }

    public ImageIcon getiTiro() {
        return iTiro;
    }

    public JLabel getlTiro() {
        return lTiro;
    }

    public Boolean getIniciouOMovimento() {
        return iniciouOMovimento;
    }

    public Boolean getTiroDado() {
        return tiroDado;
    }

    public Boolean getTiroDadoP1() {
        return tiroDadoP1;
    }

    public void setTiroDado(Boolean tiroDado) {
        this.tiroDado = tiroDado;
    }
}
