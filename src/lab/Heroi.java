package lab;

import javax.swing.*;

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
   protected Boolean dinoVivo;
   protected Boolean puloDinoCimaInicial;
   protected Boolean puloDinoCimaFinal;
   protected Boolean puloDinoBaixoInicial;
   protected Boolean puloDinoBaixoFinal;
   protected Boolean teclaParaEsquerdaApertada;
   protected Boolean teclaParaDireitaApertada;
   protected Boolean teclaParaCimaApertada;
   protected Boolean teclaParaBaixoApertada;

    //------------------------------
    ImageIcon iDinoAnimadoDireita = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
    ImageIcon iDinoAnimadoEsquerda = new ImageIcon(getClass().getResource("res\\dinoAnimadoEsquerda.gif"));
    ImageIcon iDinoMorto = new ImageIcon(getClass().getResource("res\\morto.png"));

    public Heroi(){
        tamHeroiX = 100;
        tamHeroiY = 107;
        posHeroiX = 200;
        posHeroiY = 300;
        puloDinoCimaInicial = false;
        puloDinoCimaFinal = false;
        puloDinoBaixoInicial = false;
        puloDinoBaixoFinal = false;
        teclaParaEsquerdaApertada = false;
        teclaParaDireitaApertada = false;
        teclaParaCimaApertada = false;
        teclaParaBaixoApertada = false;

        dinoVivo = true;
        iDino = new ImageIcon(getClass().getResource("res\\dinoAnimadoDireita.gif"));
        lDino = new JLabel(iDino);
        lDino.setBounds(getPosHeroiX(), getPosHeroiY(), getTamHeroiX(),getTamHeroiY());
        lDino.setVisible(true);
    }
    public int atualizarPosX(){
        return this.posHeroiX;
    }
    public int atualizarPosY(){
        return this.posHeroiY;
    }

    public void iniciarPulo(){
        if (!(puloDinoCimaInicial ||
                puloDinoCimaFinal ||
                puloDinoBaixoInicial ||
                puloDinoBaixoFinal)) {
            puloDinoCimaInicial = true;
            posAtualDinoY = lDino.getY();
        }
    }
    public void pular(){
        if(dinoVivo) {
            // PULO DINO - MOVIMENTO PARA CIMA
            int velPulo = 2;// Apenas numeros pares
            Integer estagioLento = (velPulo / 2);
            Integer estagioRapido = velPulo;
            if (this.puloDinoCimaInicial) {
                this.lDino.setLocation(this.posHeroiX, this.posHeroiY - estagioRapido);
                if (this.lDino.getY() == this.posAtualDinoY - 112) {
                    this.puloDinoCimaInicial = false;
                    this.puloDinoCimaFinal = true;
                }
            }
            if (puloDinoCimaFinal) {
                lDino.setLocation(posHeroiX, this.posHeroiY - estagioLento);
                if (lDino.getY() == posAtualDinoY - 192) {
                    puloDinoCimaFinal = false;
                    puloDinoBaixoInicial = true;
                }
            }
            //PULO DINO - MOVIMENTO PARA BAIXO
            if (puloDinoBaixoInicial) {
                lDino.setLocation(lDino.getX(), lDino.getY() + estagioLento);
                if (lDino.getY() == posAtualDinoY - 112) {
                    puloDinoBaixoInicial = false;
                    puloDinoBaixoFinal = true;
                }
            }
            if (puloDinoBaixoFinal) {
                lDino.setLocation(lDino.getX(), lDino.getY() + estagioRapido);
                if (lDino.getY() == posAtualDinoY) {
                    puloDinoBaixoFinal = false;
                }
            }
        }
    }

    public void apertouTeclaParaEsquerda(Boolean teclaParaEsquerdaApertada) {
        if(dinoVivo) {
            this.teclaParaEsquerdaApertada = teclaParaEsquerdaApertada;
        }
    }
    public void andarEsquerda(){
        if(teclaParaEsquerdaApertada){
            this.lDino.setIcon(iDinoAnimadoEsquerda);
            this.lDino.setLocation(lDino.getX()-1, lDino.getY());
        }
    }
    public void apertouTeclaParaDireita(Boolean teclaParaDireitaApertada) {
        if (dinoVivo) {
            this.teclaParaDireitaApertada = teclaParaDireitaApertada;
        }
    }
    public void andarDireita(){
        if(teclaParaDireitaApertada){
            this.lDino.setIcon(iDinoAnimadoDireita);
            this.lDino.setLocation(lDino.getX()+1, lDino.getY());
        }
    }
    public void andarParaCima(){
        if (teclaParaCimaApertada && posHeroiY > 270){
            this.lDino.setLocation(lDino.getX(),lDino.getY()-1);
        }
        if(posHeroiY <=270){
            teclaParaCimaApertada = false;
        }
    }
    public void apertouTeclaParaCima(boolean teclaParaCimaApertada) {
        if (dinoVivo && posHeroiY > 270) {
            this.teclaParaCimaApertada = teclaParaCimaApertada;
        }
    }
    public void andarParaBaixo(){
        if (teclaParaBaixoApertada && posHeroiY < 550){
            this.lDino.setLocation(lDino.getX(),lDino.getY()+1);
        }
        if(posHeroiY >= 550){
            teclaParaBaixoApertada = false;
        }
    }
    public void apertouTeclaParaBaixo(boolean teclaParaBaixoApertada) {
        if (dinoVivo && posHeroiY < 550) {
            this.teclaParaBaixoApertada = teclaParaBaixoApertada;
        }
    }

    public void atualizarMovimentosDino(){
        if(dinoVivo) {
            posHeroiX = lDino.getX();
            posHeroiY = lDino.getY();
            pular();
            andarEsquerda();
            andarDireita();
            andarParaCima();
            andarParaBaixo();
        }
    }

    @Override
    public void run() {
        while (true) {

            try {sleep(1);} catch (Exception erro) {}
            atualizarMovimentosDino();


        }
    }

    public void matarDino() {
        dinoVivo = false;
        lDino.setIcon(iDinoMorto);

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

    public JLabel getlDino() {
        return lDino;
    }
    
}