package lab;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.lang.Thread.sleep;

public class Heroi implements Runnable{
    protected int tamHeroiX;
    protected int tamHeroiY;
    protected int posHeroiX;
    protected int posHeroiY;
    protected ImageIcon iDino;
    public JLabel lDino;
    //------------------------------
   protected int posAtualDinoY;
   protected int posAtualDinoX;
   protected Boolean dinoVivo;
   protected Boolean puloDinoS;
   protected Boolean puloDinoS2;
   protected Boolean puloDinoB;
   protected Boolean puloDinoB2;
   protected Boolean movEsqDinoS;
   protected Boolean movDirDinoS;
    //------------------------------
    ImageIcon iDinoAnimadoDireita = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
    ImageIcon iDinoAnimadoEsquerda = new ImageIcon(getClass().getResource("res\\dinoAnimadoEsquerda.gif"));
    ImageIcon iDinoMorto = new ImageIcon(getClass().getResource("res\\morto.png"));

    public Heroi(){
        tamHeroiX = 100;
        tamHeroiY = 107;
        posHeroiX = 200;
        posHeroiY = 280;
        puloDinoS = false;
        puloDinoS2 = false;
        puloDinoB = false;
        puloDinoB2= false;
        movEsqDinoS = false;
        movDirDinoS = false;
        dinoVivo = true;
        iDino = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
        lDino = new JLabel(iDino);
        lDino.setBounds(getPosHeroiX(), getPosHeroiY(), getTamHeroiX(),getTamHeroiY());
        lDino.setVisible(true);
    }

    public void atualizarMovimentosDino(){
        if(dinoVivo) {
            posHeroiX = lDino.getX();
            posHeroiY = lDino.getY();
            pular();
            andarEsquerda();
            andarDireita();
        }
    }
    public int atualizarPosX(){
        return this.posHeroiX;
    }
    public int atualizarPosY(){
        return this.posHeroiY;
    }

    public void iniciarPulo(){
        if (!(getPuloDinoS() ||
                getPuloDinoS2() ||
                getPuloDinoB() ||
                getPuloDinoB2())) {

            setPuloDinoS(true);
            setPosAtualDinoY(lDino.getY());
        }
    }
    public void pular(){
        if(dinoVivo) {
            // PULO DINO - MOVIMENTO PARA CIMA
            int velPulo = 2;// Apenas numeros pares
            Integer estagioLento = (velPulo / 2);
            Integer estagioRapido = velPulo;
            if (this.puloDinoS) {
                this.lDino.setLocation(this.lDino.getX(), this.lDino.getY() - estagioRapido);
                if (this.lDino.getY() == this.posAtualDinoY - 112) {
                    this.puloDinoS = false;
                    this.puloDinoS2 = true;
                }
            }
            if (puloDinoS2) {
                lDino.setLocation(lDino.getX(), lDino.getY() - estagioLento);
                if (lDino.getY() == posAtualDinoY - 192) {
                    puloDinoS2 = false;
                    puloDinoB = true;
                }
            }
            //PULO DINO - MOVIMENTO PARA BAIXO
            if (puloDinoB) {
                lDino.setLocation(lDino.getX(), lDino.getY() + estagioLento);
                if (lDino.getY() == posAtualDinoY - 112) {
                    puloDinoB = false;
                    puloDinoB2 = true;
                }
            }
            if (puloDinoB2) {
                lDino.setLocation(lDino.getX(), lDino.getY() + estagioRapido);
                if (lDino.getY() == posAtualDinoY) {
                    puloDinoB2 = false;
                }
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

    public int getTamHeroiY() {
        return tamHeroiY;
    }

    public int getPosHeroiX() {
        return posHeroiX;
    }

    public int getPosHeroiY() {
        return posHeroiY;
    }

    public ImageIcon getiDino() {
        return iDino;
    }

    public JLabel getlDino() {
        return lDino;
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

    public void movimentoParaEsquerda(Boolean movEsqDinoS) {
        if(dinoVivo) {
            this.movEsqDinoS = movEsqDinoS;
        }
    }

    public Boolean getMovDirDinoS() {
        return movDirDinoS;
    }

    public void movimentoParaDireita(Boolean movDirDinoS) {
        if (dinoVivo) {
            this.movDirDinoS = movDirDinoS;
        }
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

    public void matarDino() {
        dinoVivo = false;
        lDino.setIcon(iDinoMorto);

    }
}

