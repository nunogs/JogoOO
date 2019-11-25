package lab;

import javax.swing.*;
import static java.lang.Thread.sleep;

public class Heroi implements Runnable{
    private int tamHeroiX;
    private int tamHeroiY;
    private int posHeroiX;
    private int posHeroiY;
    private int entradaX;
    private int entradaY;
    private ImageIcon iDino;
    private JLabel lDino;
    //------------------------------
    private Boolean puloDinoS;
    private Boolean puloDinoS2;
    private Boolean puloDinoB;
    private Boolean puloDinoB2;
    private Boolean movEsqDinoS;
    private Boolean movDirDinoS;
    //------------------------------
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
    }


    public void andarEsquerda(){
        this.lDino.setLocation(lDino.getX()-10, lDino.getY());
        this.lDino.setIcon(iDinoAnimadoEsquerda);

    }
    public void andarDireita(){
        this.lDino.setLocation(lDino.getX()+10, lDino.getY());
        this.lDino.setIcon(iDinoAnimadoDireita);
    }

    @Override
    public void run() {
        try {sleep(1);} catch (Exception erro) {}


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



    public int getEntradaX() {
        return entradaX;
    }

    public void setEntradaX(int entradaX) {
        this.entradaX = entradaX;
    }

    public int getEntradaY() {
        return entradaY;
    }

    public void setEntradaY(int entradaY) {
        this.entradaY = entradaY;
    }

    public Boolean getPuloDinoS() {
        return puloDinoS;
    }

    public void setPuloDinoS(Boolean puloDinoS) {
        this.puloDinoS = puloDinoS;
    }

    public Boolean getPuloDinoS2() {
        return puloDinoS2;
    }

    public void setPuloDinoS2(Boolean puloDinoS2) {
        this.puloDinoS2 = puloDinoS2;
    }

    public Boolean getPuloDinoB() {
        return puloDinoB;
    }

    public void setPuloDinoB(Boolean puloDinoB) {
        this.puloDinoB = puloDinoB;
    }

    public Boolean getPuloDinoB2() {
        return puloDinoB2;
    }

    public void setPuloDinoB2(Boolean puloDinoB2) {
        this.puloDinoB2 = puloDinoB2;
    }

    public Boolean getMovEsqDinoS() {
        return movEsqDinoS;
    }

    public void setMovEsqDinoS(Boolean movEsqDinoS) {
        this.movEsqDinoS = movEsqDinoS;
    }

    public Boolean getMovDirDinoS() {
        return movDirDinoS;
    }

    public void setMovDirDinoS(Boolean movDirDinoS) {
        this.movDirDinoS = movDirDinoS;
    }
}

