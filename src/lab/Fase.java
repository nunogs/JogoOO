package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;


public class Fase extends JFrame implements Runnable{
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	//---MUDA A VELOCIDADE DO JOGO --- onde 1 Eh o mais rapido
    public Integer velJogo = 1;
    //---MUDA A VELOCIDADE DO JOGO ---

    protected ImageIcon iPlacar = new ImageIcon(getClass().getResource("res\\placar.png"));
    protected int mortesInimigos;
    JLabel txtPlacar = new JLabel(String.valueOf(mortesInimigos));
    protected JLabel placar = new JLabel(iPlacar);
    protected Fundo fundo = new Fundo(0,0);
    protected Fundo fundoForaDireita = new Fundo(1280,0);
    protected Fundo fundoForaEsquerda = new Fundo(-1280,0);
    protected Chao chao = new Chao();
    protected DetalhesChao detalhesChao = new DetalhesChao();
    protected Inimigo inimigo0 = new Inimigo();
    protected Caixa caixa = new Caixa();
    protected Inimigo inimigo1 = new Inimigo();
    protected Inimigo inimigo2 = new Inimigo();
    protected Inimigo inimigo3 = new Inimigo();
    protected Inimigo inimigo4 = new Inimigo();
    protected Inimigo inimigo5 = new Inimigo();
    protected Inimigo inimigo6 = new Inimigo();
    protected Inimigo inimigo7 = new Inimigo();
    protected InimigoQueSegue inimigo8 = new InimigoQueSegue();
    protected Nuvens nuvens0 = new Nuvens();
    protected Nuvens nuvens1 = new Nuvens();
    protected Nuvens nuvens2 = new Nuvens();
    protected Nuvens nuvens3 = new Nuvens();
    protected Nuvens nuvens4 = new Nuvens();
    protected Heroi heroi= new Heroi();
    protected Armas armas0 = new Armas();
    protected Armas armas1 = new Armas();
    protected Armas armas2 = new Armas();
//    protected Boolean pedraNaMao0= true;
//    protected Boolean pedraNaMao1= true;
//    protected Boolean pedraNaMao2= true;
    protected int posHeroiX;
    protected int posHeroiY;
    protected int nivel;


    //---------------------------------COSNTRUTOR--------------------------------------- CONSTRUTOR----------
	public Fase(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();
        nivel = 1;

    }
	 //---------------------------------MONTAR A JANELA--------------------------------------- MONTAR A JANELA ----------
    public void carregarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

    }
    //---------------------------------ADICIONAR jLABELS NA JANELA---------------------------------------- ADICIONAR jLABELS NA JANELA----------
    public void iniciarObjetos(){
        loadPlacar();
        add(fundoForaDireita.getLfundo());
        add(fundoForaEsquerda.getLfundo());
        add(armas0.getlPedra());
        add(armas1.getlPedra());
        add(armas2.getlPedra());
        add(heroi.getlHeroi());
        add(inimigo0.getlInimigo());
        add(inimigo1.getlInimigo());
        add(inimigo2.getlInimigo());
        add(inimigo3.getlInimigo());
        add(inimigo4.getlInimigo());
        add(inimigo5.getlInimigo());
        add(inimigo6.getlInimigo());
        add(inimigo7.getlInimigo());
        add(inimigo8.getlCacto());
        add(caixa.getlCaixa());
        add(nuvens3.getlNuvens());
        add(nuvens4.getlNuvens());
        add(nuvens1.getlNuvens());
        add(nuvens0.getlNuvens());
        add(nuvens2.getlNuvens());
        add(detalhesChao.getlDetalhes());
        add(chao.getlChao());
        add(fundo.getLfundo());
    }
  //---------------------------------CARREGAR PLACAR---------------------------------------- CARREGAR PLACAR--------------
    private void loadPlacar() {
        placar.setVisible(true);
        placar.setBounds(100,20,150,120);
        txtPlacar.setVisible(true);
        txtPlacar.setBounds(60,25,90,50);
        Font fonteGeral = new Font("Arial", Font.BOLD, 50);
        txtPlacar.setFont(fonteGeral);
        placar.add(txtPlacar);
        add(placar);

    }


//    public void iniciarComPergunta(){
//        Scanner tc = new Scanner(System.in);
//        System.out.println("Deseja come√ßar o jogo? [ s / n] ");
//        String resp = tc.next().toUpperCase();
//        if ("S".equals(resp)) {
//            new Tela();
//        }else{
//            System.out.println("Ok, entao tchau. ");
//        }
//        System.out.println("fui");
//    }

    //-----------------------------------------------------INICIALIZAR AS THREADS -------------------------INICIALIZAR AS THREADS
    public void iniciarThreads(){
        if(heroi.heroiVivo) {
            new Thread(heroi).start();
            new Thread(nuvens0).start();
            new Thread(nuvens1).start();
            new Thread(nuvens2).start();
            new Thread(nuvens3).start();
            new Thread(nuvens4).start();
            new Thread(caixa).start();
            new Thread(armas0).start();
            new Thread(armas1).start();
            new Thread(armas2).start();
            new Thread(inimigo0).start();
            new Thread(inimigo1).start();
            new Thread(inimigo2).start();
            new Thread(inimigo3).start();
            new Thread(inimigo4).start();
            new Thread(inimigo5).start();
            new Thread(inimigo6).start();
            new Thread(inimigo7).start();
            new Thread(inimigo8).start();
        }
    }
    //--------------------------------------------RUN--------------------------------------------------RUN--------------
    @Override
    public void run() {
        iniciarThreads();
        while (true){
            try {sleep(velJogo/*NAO MECHE NESSA POHA*/);} catch (Exception erro) {}
            enviarNivel();
            atualizaPlacar();
            colisaoInimigoTiro();
            colisaoHeroiCacto();
            receberPosicaoDoHeroiParaMapearOTiro();
            colisaoTiroFora();
            detalhesChao.comportamento();
        }
    }
    //--------------------------------------------CONTROLE DE MUNICOES-------------------------------------CONTROLE DE MUNICOES--------------
    private void tacarPedra() {
        if(nivel <= 2) {
            if (armas0.getPedraNaMao() && armas1.getPedraNaMao()) {
                armas0.tacaPedra();

            } else if (armas1.getPedraNaMao() && !armas0.getPedraNaMao()) {
                armas1.tacaPedra();
            }
        }else if(nivel >= 3){
            if ((armas0.getPedraNaMao() && armas1.getPedraNaMao() && armas2.getPedraNaMao()) ||
                    (armas0.getPedraNaMao() && armas1.getPedraNaMao() && !armas2.getPedraNaMao()) ||
                    (armas0.getPedraNaMao() && !armas1.getPedraNaMao() && armas2.getPedraNaMao()) ) {
                armas0.tacaPedra();

            } else if ((!armas0.getPedraNaMao() && armas1.getPedraNaMao() && armas2.getPedraNaMao()) ||
                    (!armas0.getPedraNaMao() && armas1.getPedraNaMao() && !armas2.getPedraNaMao())) {
                armas1.tacaPedra();
            }else if((!armas0.getPedraNaMao() && !armas1.getPedraNaMao() && armas2.getPedraNaMao())){
                armas2.tacaPedra();
            }
        }
    }


  //-----------------------------------------------------SE HEROI TROMBAR NO CACTO -------------------------SE HEROI TROMBAR NO CACTO
    public void colisaoHeroiCacto(){
        if (verificaColisao(heroi.getlHeroi(), inimigo0.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo1.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo2.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo3.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo4.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo5.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo6.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo7.getlInimigo(), false) ||
                verificaColisao(heroi.getlHeroi(), inimigo8.getlCacto(), false)){
            heroi.matarDino();
            JOptionPane.showMessageDialog(null, "  Matou " + mortesInimigos + " inimigos.");
            System.exit(0);
        }
    }

  //-----------------------------------------------------SE CACTO LEVAR UM TIRO -------------------------------SE CACTO LEVAR UM TIRO
    
    public void colisaoInimigoTiro(){

        // tiro 0
        if (verificaColisao(armas0.getlPedra(), inimigo0.getlInimigo(), true)){
            inimigo0.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo1.getlInimigo(), true)) {
            inimigo1.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo2.getlInimigo(), true)) {
            inimigo2.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo3.getlInimigo(), true)) {
            inimigo3.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo4.getlInimigo(), true)) {
            inimigo4.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo5.getlInimigo(), true)) {
            inimigo5.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo6.getlInimigo(), true)) {
            inimigo6.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo7.getlInimigo(), true)) {
            inimigo7.matarInimigoPorTiro();
            armas0.pararPedra();
        }
        if (verificaColisao(armas0.getlPedra(), inimigo8.getlCacto(), true)) {
            inimigo8.matarInimigoPorTiro();
            armas0.pararPedra();
        }
   
        // Tiro 2
        if (verificaColisao(armas1.getlPedra(), inimigo0.getlInimigo(), true)) {
            inimigo0.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo1.getlInimigo(), true)) {
            inimigo1.matarInimigoPorTiro();
            armas1.pararPedra();
            mortesInimigos++;
        if (verificaColisao(armas1.getlPedra(), inimigo2.getlInimigo(), true)) {
            inimigo2.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo3.getlInimigo(), true)) {
            inimigo3.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo4.getlInimigo(), true)) {
            inimigo4.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo5.getlInimigo(), true)) {
            inimigo5.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo6.getlInimigo(), true)) {
            inimigo6.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo7.getlInimigo(), true)) {
            inimigo7.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        if (verificaColisao(armas1.getlPedra(), inimigo8.getlCacto(), true)) {
            inimigo8.matarInimigoPorTiro();
            armas1.pararPedra();
        }
        
        // tiro 3
        if (verificaColisao(armas2.getlPedra(), inimigo0.getlInimigo(), true)) {
            inimigo0.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo1.getlInimigo(), true)) {
            inimigo1.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo2.getlInimigo(), true)) {
            inimigo2.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo3.getlInimigo(), true)) {
            inimigo3.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo4.getlInimigo(), true)) {
            inimigo4.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo5.getlInimigo(), true)) {
            inimigo5.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo6.getlInimigo(), true)) {
            inimigo6.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo7.getlInimigo(), true)) {
            inimigo7.matarInimigoPorTiro();
            armas2.pararPedra();
        }
        if (verificaColisao(armas2.getlPedra(), inimigo8.getlCacto(), true)) {
            inimigo8.matarInimigoPorTiro();
            armas2.pararPedra();
        }
    }
 }

    //----------------------------------------INICIALIZAR MOVIMENTOS DAS NUVENS ---------------------INICIALIZAR MOVIMENTOS DAS NUVENS
//    public void movimentosNuvens(){
//        nuvens0.comportamentoDasNuvens();
//        nuvens1.comportamentoDasNuvens();
//        nuvens2.comportamentoDasNuvens();
//        nuvens3.comportamentoDasNuvens();
//    }

    //-----------------------------------------------------SE TIRO SAIR DA TELA  -------------------------------SE TIRO SAIR  DA TELA  
    public void colisaoTiroFora(){
        // Tiro sair pela direita

        if (verificaColisao(fundoForaDireita.getLfundo(), armas0.getlPedra(), false)){
        	armas0.pararPedra();
        }
        if (verificaColisao(fundoForaDireita.getLfundo(), armas1.getlPedra(), false)){
        	armas1.pararPedra();
        }
        if (verificaColisao(fundoForaDireita.getLfundo(), armas2.getlPedra(), false)){
        	armas2.pararPedra();
        }
        // Tiro sair pela esquerda

        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas0.getlPedra(), false)){
        	armas0.pararPedra();
        }
        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas1.getlPedra(), false)){
        	armas1.pararPedra();
        }
        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas2.getlPedra(), false)){
        	armas2.pararPedra();
        }


    }

    //-----------------------------------------------------DIFICULDADE PLACAR-------------------------------DIFICULDADE PLACAR
    public void atualizaPlacar() {
        txtPlacar.setText(String.valueOf(mortesInimigos));
        if(mortesInimigos >= 5){
            nivel = 2;
        }
        if(mortesInimigos >= 20){
            nivel = 3;
        }
        if(mortesInimigos >= 40){
            nivel = 4;
        }
    }
    //---------------------------------MAPEAR MOVIMENTOS DO HEROI----------------------------------------MAPEAR MOVIMENTOS DO HEROI-----------
    public void receberPosicaoDoHeroiParaMapearOTiro(){
        posHeroiX = heroi.atualizarPosX();
        posHeroiY = heroi.atualizarPosY();
        
        armas0.atualizarPosHeroi(posHeroiX, posHeroiY);

        armas1.atualizarPosHeroi(posHeroiX, posHeroiY);

        armas2.atualizarPosHeroi(posHeroiX, posHeroiY);
        
        inimigo8.atualizarPosHeroi(posHeroiX, posHeroiY);
   
    }
    //---------------------------------VERIFICADOR DE COLIS√O----------------------------------------VERIFICADOR DE COLIS√O-------------
    public boolean verificaColisao(Component objetoA, Component objetoB, Boolean comMorte) {
        int aX = objetoA.getX();
        int aY = objetoA.getY();
        int ladoDireitoA = aX+objetoA.getWidth();
        int ladoEsquerdoA= aX;
        int ladoBaixoA= aY+objetoA.getHeight();
        int ladoCimaA= aY;

        int bX = objetoB.getX();
        int bY = objetoB.getY();
        int ladoDireitoB = bX+objetoB.getWidth();
        int ladoEsquerdoB= bX;
        int ladoBaixoB= bY+objetoB.getHeight();
        int ladoCimaB= bY;

        boolean colidiu = false;
        boolean colidiuDireita=false;
        boolean colidiuCima=false;
        boolean colidiuBaixo=false;
        boolean colidiuEsquerda=false;

        if(ladoDireitoA>=ladoEsquerdoB) {
            colidiuDireita=true;
        }
        if(ladoCimaA<=ladoBaixoB) {
            colidiuCima=true;
        }
        if(ladoBaixoA>=ladoCimaB) {
            colidiuBaixo=true;
        }
        if(ladoEsquerdoA<=ladoDireitoB) {
            colidiuEsquerda=true;
        }

        if(colidiuDireita && colidiuEsquerda && colidiuBaixo && colidiuCima) {
            colidiu = true;
            if(comMorte) {
            	mortesInimigos ++;
            }
        }
        return colidiu;
    }
    
    //---------------------------------CAPTURA DE TECLADO----------------------------------------CAPTURA DE TECLADO--------------
    public void capturaTeclado(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent tecla) {
//                System.out.println(tecla.getKeyCode());
                if (tecla.getKeyCode() == 32/*ESPA√áO*/) {
                    if (tecla.getKeyCode() == 32/*ESPA√áO*/) {
                        heroi.iniciarPulo();
                    }
                }
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.apertouTeclaParaEsquerda(true);
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.apertouTeclaParaDireita(true);
                }
                if (tecla.getKeyCode() == 38 /*SETA CIMA*/) {
                    heroi.apertouTeclaParaCima(true);
                }

                if (tecla.getKeyCode() == 40 /*SETA BAIXO*/) {
                    heroi.apertouTeclaParaBaixo(true);
                }

                if (tecla.getKeyCode() == 68/* D */) {
                    tacarPedra();
                }
            }

            @Override
            public void keyReleased(KeyEvent tecla) {
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.apertouTeclaParaEsquerda(false);
                }
                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.apertouTeclaParaDireita(false);
                }
                if (tecla.getKeyCode() == 38 /*SETA CIMA*/) {
                    heroi.apertouTeclaParaCima(false);
                }
                if (tecla.getKeyCode() == 40 /*SETA BAIXO*/) {
                    heroi.apertouTeclaParaBaixo(false);
                }
            }
        });
    }
    
    //---------------------------------ENVIAR O ATUAL NIVEL DE JOGO----------------------------------------ENVIAR O ATUAL NIVEL DE JOGO-------------
    public void enviarNivel() {
    	inimigo0.nivelDoJogo(nivel);
    	inimigo1.nivelDoJogo(nivel);
    	inimigo2.nivelDoJogo(nivel);
    	inimigo3.nivelDoJogo(nivel);
    	inimigo4.nivelDoJogo(nivel);
    	inimigo5.nivelDoJogo(nivel);
    	inimigo6.nivelDoJogo(nivel);
    	inimigo7.nivelDoJogo(nivel);
    	inimigo8.nivelDoJogo(nivel);
	}
}


