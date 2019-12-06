package lab.entity;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Heroi  extends Personagem implements Runnable{
	protected Integer nivel;
	//--------------------------------------
    
    protected ImageIcon iHeroi;
    public JLabel lHeroi;
    //--------------------------------------
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
   //-----------------------------------------
   ImageIcon iRoboAnimadoDireita = new ImageIcon(getClass().getResource("../img/heroi/roboTDirLento.gif"));
   ImageIcon iRoboAnimadoDireitaRapido = new ImageIcon(getClass().getResource("../img/heroi/roboTDirRapido.gif"));
   ImageIcon iRoboAnimadoEsquerda = new ImageIcon(getClass().getResource("../img/heroi/roboTDirFreando.gif"));
   ImageIcon iRoboMorto = new ImageIcon(getClass().getResource("../img/heroi/roboTMorto.gif"));

    
    public Heroi(){
        tamanhoX = 62;
        tamanhoY = 130;
        posicaoX = 200;
        posicaoY = 300;
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
    
//    public void nivelDoJogo(Integer nivel) {
//    	this.nivel = nivel;
//    }
//    
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
//            int velPulo = 2;// Apenas numeros pares
            int estagioLento = 2;
            int estagioRapido = 4;
            int alturaDeDesaceleracaoDoPulo = 140;
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
            this.lHeroi.setIcon(iRoboAnimadoDireitaRapido);
            this.lHeroi.setLocation(lHeroi.getX()+2, lHeroi.getY());
        }
        if(lHeroi.getX() >= 1150){
            this.teclaParaDireitaApertada = false;
        }
    }
    public void andarParaCima(){
        if (teclaParaCimaApertada && posicaoY > 270){
            this.lHeroi.setLocation(lHeroi.getX(),lHeroi.getY()-2);
        }
        if(posicaoY <=270){
            teclaParaCimaApertada = false;
        }
    }
    public void apertouTeclaParaCima(boolean teclaParaCimaApertada) {
        if ((heroiVivo && posicaoY > 270 && !puloHeroiCimaInicial) && !(puloHeroiCimaInicial ||
                puloHeroiCimaFinal ||
                puloHeroiBaixoInicial ||
                puloHeroiBaixoFinal)){
            this.teclaParaCimaApertada = teclaParaCimaApertada;
        }
    }
    public void andarParaBaixo(){
        if (teclaParaBaixoApertada && posicaoY < 550){
            this.lHeroi.setLocation(lHeroi.getX(),lHeroi.getY()+2);
        }
        if(posicaoY >= 550){
            teclaParaBaixoApertada = false;
        }
    }
    public void apertouTeclaParaBaixo(boolean teclaParaBaixoApertada) {
        if ((heroiVivo && posicaoY < 550 ) && !(puloHeroiCimaInicial ||
                puloHeroiCimaFinal ||
                puloHeroiBaixoInicial ||
                puloHeroiBaixoFinal)){
            this.teclaParaBaixoApertada = teclaParaBaixoApertada;
        }
    }

    public void atualizarMovimentosDino(){
        if(heroiVivo) {
            posicaoX = lHeroi.getX();
            posicaoY = lHeroi.getY();
            pular();
            andarEsquerda();
            andarDireita();
            andarParaCima();
            andarParaBaixo();
        }
    }
    
    //--------------------------------------------RUN---------------------------------------------------------------RUN--------------

    @Override
    public void run() {
        while (true) {
            try {sleep(4);} catch (Exception erro) {}

            atualizarMovimentosDino();


        }
    }

    public void matarDino() {
        heroiVivo = false;
        lHeroi.setIcon(iRoboMorto);

    }


    //Metodos getters e setters

    public int getTamHeroiX() {
        return tamanhoX;
    }

    public int getTamHeroiY() {
        return tamanhoY;
    }

    public int getPosHeroiX() {
        return posicaoX;
    }

    public int getPosHeroiY() {
        return posicaoY;
    }

    public JLabel getlHeroi() {
        return lHeroi;
    }
	public Boolean getDinoVivo() {
		return heroiVivo;
	}
    
    

}