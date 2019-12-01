package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Heroi implements Runnable{
    protected int tamHeroiX;
    protected int tamHeroiY;
    protected int posHeroiX;
    protected int posHeroiY;
    protected ImageIcon iHeroi;
    public JLabel lHeroi;
    //------------------------------
   protected int posAtualHeroiY;
   protected Boolean heroiVivo;
   protected Boolean puloHeroiCimaInicial;
   protected Boolean puloHeroiCimaFinal;
   protected Boolean puloHeroiBaixoInicial;
   protected Boolean puloHeroiBaixoFinal;
   protected Boolean teclaParaEsquerdaApertada;
   protected Boolean teclaParaDireitaApertada;
   protected Boolean teclaParaCimaApertada;
   protected Boolean teclaParaBaixoApertada;
    //------------------------------
    ImageIcon iRoboAnimadoDireita = new ImageIcon(getClass().getResource("res\\roboTDir.png"));
    ImageIcon iRoboAnimadoEsquerda = new ImageIcon(getClass().getResource("res\\roboTEsqr.png"));
    ImageIcon iRoboMorto = new ImageIcon(getClass().getResource("res\\roboTMorto.gif"));

    
    public Heroi(){
        tamHeroiX = 62;
        tamHeroiY = 130;
        posHeroiX = 200;
        posHeroiY = 300;
        puloHeroiCimaInicial = false;
        puloHeroiCimaFinal = false;
        puloHeroiBaixoInicial = false;
        puloHeroiBaixoFinal = false;
        teclaParaEsquerdaApertada = false;
        teclaParaDireitaApertada = false;
        teclaParaCimaApertada = false;
        teclaParaBaixoApertada = false;
        heroiVivo = true;
        lHeroi = new JLabel(iRoboAnimadoDireita);
        lHeroi.setBounds(getPosHeroiX(), getPosHeroiY(), getTamHeroiX(),getTamHeroiY());
        lHeroi.setVisible(true);
    }
    public int atualizarPosX(){
        return this.lHeroi.getX();
    }
    public int atualizarPosY(){
        return this.lHeroi.getY();
    }

    public void iniciarPulo(){
        if (!(puloHeroiCimaInicial ||
                puloHeroiCimaFinal ||
                puloHeroiBaixoInicial ||
                puloHeroiBaixoFinal ||
                teclaParaCimaApertada ||
                teclaParaBaixoApertada)) {
            puloHeroiCimaInicial = true;
            posAtualHeroiY = lHeroi.getY();
        }
    }
    public void pular(){
        if(heroiVivo) {
            // PULO DINO - MOVIMENTO PARA CIMA
            int velPulo = 2;// Apenas numeros pares
            int estagioLento = (velPulo / 2);
            int estagioRapido = velPulo;
            int alturaDeDesaceleracaoDoPulo = 130;
            int alturaMaximaDoPulo = 200;
            if (this.puloHeroiCimaInicial) {
                this.lHeroi.setLocation(lHeroi.getX(), lHeroi.getY() - estagioRapido);
                if (this.lHeroi.getY() == this.posAtualHeroiY - alturaDeDesaceleracaoDoPulo) {
                    this.puloHeroiCimaInicial = false;
                    this.puloHeroiCimaFinal = true;
                }
            }
            if (puloHeroiCimaFinal) {
                lHeroi.setLocation(lHeroi.getX(), lHeroi.getY() - estagioLento);
                if (lHeroi.getY() == posAtualHeroiY - alturaMaximaDoPulo) {
                    puloHeroiCimaFinal = false;
                    puloHeroiBaixoInicial = true;
                }
            }
            //PULO HEROI - MOVIMENTO PARA BAIXO
            if (puloHeroiBaixoInicial) {
                lHeroi.setLocation(lHeroi.getX(), lHeroi.getY() + estagioLento);
                if (lHeroi.getY() == posAtualHeroiY - alturaDeDesaceleracaoDoPulo) {
                    puloHeroiBaixoInicial = false;
                    puloHeroiBaixoFinal = true;
                }
            }
            if (puloHeroiBaixoFinal) {
                lHeroi.setLocation(lHeroi.getX(), lHeroi.getY() + estagioRapido);
                if (lHeroi.getY() == posAtualHeroiY) {
                    puloHeroiBaixoFinal = false;
                }
            }
        }
    }

    public void apertouTeclaParaEsquerda(Boolean teclaParaEsquerdaApertada) {
        if(heroiVivo && lHeroi.getX() > 5) {
            this.teclaParaEsquerdaApertada = teclaParaEsquerdaApertada;
        }
    }
    public void andarEsquerda(){
        if(teclaParaEsquerdaApertada && lHeroi.getX() > 5){
            this.lHeroi.setIcon(iRoboAnimadoEsquerda);
            this.lHeroi.setLocation(lHeroi.getX()-1, lHeroi.getY());
        }
        if(lHeroi.getX() <= 5){
            this.teclaParaEsquerdaApertada = false;
        }
    }
    public void apertouTeclaParaDireita(Boolean teclaParaDireitaApertada) {
        if (heroiVivo && lHeroi.getX() < 1150) {
            this.teclaParaDireitaApertada = teclaParaDireitaApertada;
        }
    }
    public void andarDireita(){
        if(teclaParaDireitaApertada && lHeroi.getX() < 1150 ){
            this.lHeroi.setIcon(iRoboAnimadoDireita);
            this.lHeroi.setLocation(lHeroi.getX()+1, lHeroi.getY());
        }
        if(lHeroi.getX() >= 1150){
            this.teclaParaDireitaApertada = false;
        }
    }
    public void andarParaCima(){
        if (teclaParaCimaApertada && posHeroiY > 270){
            this.lHeroi.setLocation(lHeroi.getX(),lHeroi.getY()-1);
        }
        if(posHeroiY <=270){
            teclaParaCimaApertada = false;
        }
    }
    public void apertouTeclaParaCima(boolean teclaParaCimaApertada) {
        if ((heroiVivo && posHeroiY > 270 && !puloHeroiCimaInicial) && !(puloHeroiCimaInicial ||
                puloHeroiCimaFinal ||
                puloHeroiBaixoInicial ||
                puloHeroiBaixoFinal)){
            this.teclaParaCimaApertada = teclaParaCimaApertada;
        }
    }
    public void andarParaBaixo(){
        if (teclaParaBaixoApertada && posHeroiY < 550){
            this.lHeroi.setLocation(lHeroi.getX(),lHeroi.getY()+1);
        }
        if(posHeroiY >= 550){
            teclaParaBaixoApertada = false;
        }
    }
    public void apertouTeclaParaBaixo(boolean teclaParaBaixoApertada) {
        if ((heroiVivo && posHeroiY < 550 ) && !(puloHeroiCimaInicial ||
                puloHeroiCimaFinal ||
                puloHeroiBaixoInicial ||
                puloHeroiBaixoFinal)){
            this.teclaParaBaixoApertada = teclaParaBaixoApertada;
        }
    }

    public void atualizarMovimentosDino(){
        if(heroiVivo) {
            posHeroiX = lHeroi.getX();
            posHeroiY = lHeroi.getY();
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
        heroiVivo = false;
        lHeroi.setIcon(iRoboMorto);

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

    public JLabel getlHeroi() {
        return lHeroi;
    }
	public Boolean getDinoVivo() {
		return heroiVivo;
	}
    
    

}