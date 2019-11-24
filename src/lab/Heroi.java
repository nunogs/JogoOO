package lab;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Heroi {
    private int tamHeroiX;
    private int tamHeroiY;
    private int posHeroiX;
    private int posHeroiY;
    private ImageIcon iDino;
    private JLabel lDino;
    private boolean esqPressionada;
    private boolean dirPressionada;
    ImageIcon iDinoAnimadoDireita = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
    ImageIcon iDinoAnimadoEsquerda = new ImageIcon(getClass().getResource("res\\dinoAnimadoEsquerda.gif"));
    ImageIcon iDinoMorto = new ImageIcon(getClass().getResource("res\\morto.png"));

    public Heroi(){
        tamHeroiX = 100;
        tamHeroiY = 107;
        posHeroiX = 200;
        posHeroiY = 300;
        iDino = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
        lDino = new JLabel(iDino);
        this.lDino.setBounds(getPosHeroiX(), getPosHeroiY(), getTamHeroiX(),getTamHeroiY());
        this.lDino.setVisible(true);
//        capturaTeclado();
    }
    public void atualizarHeroi(){
        lDino.setLocation(posHeroiX, posHeroiY);
    }

    public void andarEsquerda(){
        posHeroiX -= 5;
        //        this.lDino.setLocation(lDino.getX()-5, lDino.getY());
        System.out.println("esquerda");
        this.lDino.setIcon(iDinoAnimadoEsquerda);

    }
    public void andarDireita(){
        posHeroiX += 5;
//        this.lDino.setLocation(lDino.getX()+5, lDino.getY());
        System.out.println("direita");
        this.lDino.setIcon(iDinoAnimadoDireita);
    }




    //Metodos getters e setters

    public int getTamHeroiX() {
        return tamHeroiX;
    }

    public void setTamHeroiX(int tamHeroiX) {
        this.tamHeroiX = tamHeroiX;
    }

    public int getTamHeroiY() {
        return tamHeroiY;
    }

    public void setTamHeroiY(int tamHeroiY) {
        this.tamHeroiY = tamHeroiY;
    }

    public int getPosHeroiX() {
        return posHeroiX;
    }

    public void setPosHeroiX(int posHeroiX) {
        this.posHeroiX = posHeroiX;
    }

    public int getPosHeroiY() {
        return posHeroiY;
    }

    public void setPosHeroiY(int posHeroiY) {
        this.posHeroiY = posHeroiY;
    }

    public ImageIcon getiDino() {
        return iDino;
    }

    public void setiDino(ImageIcon iDino) {
        this.iDino = iDino;
    }

    public JLabel getlDino() {
        return lDino;
    }

    public void setlDino(JLabel lDino) {
        this.lDino = lDino;
    }
}

