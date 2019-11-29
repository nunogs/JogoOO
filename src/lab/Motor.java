package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;


public class Motor extends JFrame implements Runnable{
    //---MUDA A VELOCIDADE DO JOGO --- onde 1 é o mais rapido
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
    protected Inimigo inimigo1 = new Inimigo();
    protected Inimigo inimigo2 = new Inimigo();
    protected Inimigo inimigo3 = new Inimigo();
    protected Inimigo inimigo4 = new Inimigo();
    protected Inimigo inimigo5 = new Inimigo();
    protected Inimigo inimigo6 = new Inimigo();
    protected Inimigo inimigo7 = new Inimigo();
    protected Nuvens nuvens0 = new Nuvens();
    protected Nuvens nuvens1 = new Nuvens();
    protected Nuvens nuvens2 = new Nuvens();
    protected Nuvens nuvens3 = new Nuvens();
    protected Nuvens nuvens4 = new Nuvens();
    protected Heroi heroi= new Heroi();
    protected Armas armas0 = new Armas();
    protected Armas armas1 = new Armas();
    protected Boolean pedraNaMao0= true;;
    protected Boolean pedraNaMao1= true;;
    protected int posHeroiX;
    protected int posHeroiY;
    protected int nivel;

    public Motor(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();
        nivel = 1;

    }

    public void carregarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

    }

    public void iniciarObjetos(){
        loadPlacar();
        add(fundoForaDireita.getLfundo());
        add(fundoForaEsquerda.getLfundo());
        add(armas0.getlPedra());
        add(armas1.getlPedra());
        add(heroi.getlDino());
        add(inimigo0.getlCacto());
        add(inimigo1.getlCacto());
        add(inimigo2.getlCacto());
        add(inimigo3.getlCacto());
        add(inimigo4.getlCacto());
        add(inimigo5.getlCacto());
        add(inimigo6.getlCacto());
        add(inimigo7.getlCacto());
        add(nuvens3.getlNuvens());
        add(nuvens4.getlNuvens());
        add(nuvens1.getlNuvens());
        add(nuvens0.getlNuvens());
        add(nuvens2.getlNuvens());
        add(detalhesChao.getlDetalhes());
        add(chao.getlChao());
        add(fundo.getLfundo());
    }

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
//        System.out.println("Deseja começar o jogo? [ s / n] ");
//        String resp = tc.next().toUpperCase();
//        if ("S".equals(resp)) {
//            new Tela();
//        }else{
//            System.out.println("Ok, entao tchau. ");
//        }
//        System.out.println("fui");
//    }

    //---------------------------------CAPTURA DE TECLADO----------------------------------------CAPTURA DE TECLADO--------------
    public void capturaTeclado(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent tecla) {
//                System.out.println(tecla.getKeyCode());
                if (tecla.getKeyCode() == 32/*ESPAÇO*/) {
                    if (tecla.getKeyCode() == 32/*ESPAÇO*/) {
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

    //--------------------------------------------RUN--------------------------------------------------RUN--------------
    @Override
    public void run() {
        iniciarMovimentos();
        while (true){
            try {sleep(velJogo/*NAO MECHE NESSA POHA*/);} catch (Exception erro) {}

            atualizaPlacar();
            movimentosCactos();
            colisaoCactoTiro();
            colisaoDinoCacto();
            movimentosNuvens();
            receberPosicaoDoHeroiParaMapearOTiro();
            colisaoTiroFora();
            detalhesChao.comportamento();
        }
    }
    //--------------------------------------------REAÇÕES-------------------------------------REAÇÕES--------------
    private void tacarPedra() {
        if (pedraNaMao0 && pedraNaMao1) {
            pedraNaMao0 = false;
            armas0.tacaPedra();

        }else if(pedraNaMao1 && !pedraNaMao0){
            pedraNaMao1 = false;
            armas1.tacaPedra();
        }
    }

    public void movimentosNuvens(){
        nuvens0.comportamentoDasNuvens();
        nuvens1.comportamentoDasNuvens();
        nuvens2.comportamentoDasNuvens();
        nuvens3.comportamentoDasNuvens();
    }

    public void movimentosCactos(){
        if(nivel <= 1 ) {
            inimigo0.comportamentoDosCactos();
            inimigo1.comportamentoDosCactos();
            inimigo2.comportamentoDosCactos();
        }
        if (nivel == 2) {
            inimigo0.comportamentoDosCactos();
            inimigo1.comportamentoDosCactos();
            inimigo2.comportamentoDosCactos();
            inimigo3.comportamentoDosCactos();
            inimigo4.comportamentoDosCactos();
        }
        if (nivel == 3) {
            inimigo0.comportamentoDosCactos();
            inimigo1.comportamentoDosCactos();
            inimigo2.comportamentoDosCactos();
            inimigo3.comportamentoDosCactos();
            inimigo4.comportamentoDosCactos();
            inimigo5.comportamentoDosCactos();
            inimigo6.comportamentoDosCactos();
            inimigo7.comportamentoDosCactos();
        }
    }

    public void iniciarMovimentos(){
        if(heroi.dinoVivo) {
            new Thread(heroi).start();
            new Thread(armas0).start();
            new Thread(armas1).start();
        }
    }

    public void colisaoDinoCacto(){
        if (verificaColisao(heroi.getlDino(), inimigo0.getlCacto()) ||
                verificaColisao(heroi.getlDino(), inimigo1.getlCacto()) ||
                verificaColisao(heroi.getlDino(), inimigo2.getlCacto())){
            heroi.matarDino();
            JOptionPane.showMessageDialog(null, "  Matou " + mortesInimigos + " cactos.");
            System.exit(0);
        }
    }

    public void colisaoCactoTiro(){

        // tiro 0
        if (verificaColisao(armas0.getlPedra(), inimigo0.getlCacto())) {
            inimigo0.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo1.getlCacto())) {
            inimigo1.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo2.getlCacto())) {
            inimigo2.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo3.getlCacto())) {
            inimigo3.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo4.getlCacto())) {
            inimigo4.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo5.getlCacto())) {
            inimigo5.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo6.getlCacto())) {
            inimigo6.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas0.getlPedra(), inimigo7.getlCacto())) {
            inimigo7.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesInimigos++;
        }
//        if (verificaColisao(armas0.getlPedra(), cacto8.getlCacto())) {
//            cacto8.matarCactoPorTiro();
//            armas0.pararPedra();
//            pedraNaMao0 = true;
//            mortesCactos ++;
//        }

        // Tiro 2
        if (verificaColisao(armas1.getlPedra(), inimigo0.getlCacto())) {
            inimigo0.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo1.getlCacto())) {
            inimigo1.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo2.getlCacto())) {
            inimigo2.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo3.getlCacto())) {
            inimigo3.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo4.getlCacto())) {
            inimigo4.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo5.getlCacto())) {
            inimigo5.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo6.getlCacto())) {
            inimigo6.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }
        if (verificaColisao(armas1.getlPedra(), inimigo7.getlCacto())) {
            inimigo7.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesInimigos++;
        }

    }

    public void colisaoTiroFora(){
        // Tiro sair pela direita

        if (verificaColisao(fundoForaDireita.getLfundo(), armas0.getlPedra())){
            pedraNaMao0 = true;
        }
        if (verificaColisao(fundoForaDireita.getLfundo(), armas1.getlPedra())){
            pedraNaMao1 = true;
        }
        // Tiro sair pela esquerda

        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas0.getlPedra())){
            pedraNaMao0 = true;
        }
        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas1.getlPedra())){
            pedraNaMao1 = true;
        }


    }
//-----------------------------------------------------ATUALIZAR PLACAR-------------------------------ATUALIZAR PLACAR
    public void atualizaPlacar() {
        txtPlacar.setText(String.valueOf(mortesInimigos));
        if(mortesInimigos >= 10){
            nivel = 2;
        }
        if(mortesInimigos >= 20){
            nivel = 3;
        }
    }


    public void receberPosicaoDoHeroiParaMapearOTiro(){
        posHeroiX = heroi.atualizarPosX();
        posHeroiY = heroi.atualizarPosY();
        armas0.atualizarPosHeroi(posHeroiX, posHeroiY);

        posHeroiX = heroi.atualizarPosX();
        posHeroiY = heroi.atualizarPosY();
        armas1.atualizarPosHeroi(posHeroiX, posHeroiY);
    }

    public boolean verificaColisao(Component objetoA, Component objetoB) {
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
        }
        return colidiu;
    }
}
