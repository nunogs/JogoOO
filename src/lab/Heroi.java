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
    public JLabel lDino;
    //------------------------------
    private int posAtualDinoY;
    private int posAtualDinoX;

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
        posHeroiY = 280;
        this.puloDinoS = false;
        this.puloDinoS2 = false;
        this.puloDinoB = false;
        this.puloDinoB2= false;
        this.movEsqDinoS = false;
        this.movDirDinoS = false;
        iDino = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
        lDino = new JLabel(iDino);
        this.lDino.setBounds(getPosHeroiX(), getPosHeroiY(), getTamHeroiX(),getTamHeroiY());
        this.lDino.setVisible(true);
    }


//    public void andarEsquerda(){
//        this.lDino.setLocation(lDino.getX()-10, lDino.getY());
//        this.lDino.setIcon(iDinoAnimadoEsquerda);
//
//    }
//    public void andarDireita(){
//        this.lDino.setLocation(lDino.getX()+10, lDino.getY());
//        this.lDino.setIcon(iDinoAnimadoDireita);
//    }
    public void atualizarMovimentosDino(){
        posHeroiX = lDino.getX();
        posHeroiY = lDino.getY();
        pular();
        andarEsquerda();
        andarDireita();
    }
    public void pular(){
        // PULO DINO - MOVIMENTO PARA CIMA
        int velPulo = 2 ;// Apenas numeros pares
        Integer estagioLento = (velPulo/2);
        Integer estagioRapido = velPulo;
        if(this.puloDinoS) {
            this.lDino.setLocation(this.lDino.getX(), this.lDino.getY() - estagioRapido);
            if (this.lDino.getY() == this.posAtualDinoY - 112) {
                this.puloDinoS = false;
                this.puloDinoS2 = true;
            }
        }
        if(puloDinoS2) {
            lDino.setLocation(lDino.getX(), lDino.getY() - estagioLento);
            if(lDino.getY() == posAtualDinoY -192){
                puloDinoS2 = false;
                puloDinoB = true;
            }
        }
        //PULO DINO - MOVIMENTO PARA BAIXO
        if(puloDinoB){
            lDino.setLocation(lDino.getX(), lDino.getY()+estagioLento);
            if(lDino.getY() == posAtualDinoY -112){
                puloDinoB = false;
                puloDinoB2 = true;
            }
        }
        if(puloDinoB2){
            lDino.setLocation(lDino.getX(), lDino.getY()+estagioRapido);
            if(lDino.getY() == posAtualDinoY){
                puloDinoB2 = false;
            }
        }
    }
    public void andarEsquerda(){
        if(getMovEsqDinoS()){
            this.lDino.setIcon(iDinoAnimadoEsquerda);
            this.lDino.setLocation(lDino.getX()-1, lDino.getY());
        }
    }
    public void andarDireita(){
        if(getMovDirDinoS()){
            this.lDino.setIcon(iDinoAnimadoDireita);
            this.lDino.setLocation(lDino.getX()+1, lDino.getY());
        }
    }
    @Override
    public void run() {
        while (true) {
            try {sleep(1);} catch (Exception erro) {}
            atualizarMovimentosDino();

        }
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

    public int getPosAtualDinoY() {
        return posAtualDinoY;
    }

    public void setPosAtualDinoY(int posAtualDinoY) {
        this.posAtualDinoY = posAtualDinoY;
    }

    public int getPosAtualDinoX() {
        return posAtualDinoX;
    }

    public void setPosAtualDinoX(int posAtualDinoX) {
        this.posAtualDinoX = posAtualDinoX;
    }
}

