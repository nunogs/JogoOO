package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class App extends JFrame implements Runnable{
    //---MUDA A VELOCIDADE DO JOGO --- onde 1 é o mais rapido
    public Integer velJogo = 1;
    //---MUDA A VELOCIDADE DO JOGO ---

    protected ImageIcon iPlacar = new ImageIcon(getClass().getResource("res\\placar.png"));
    protected int mortesCactos;
    JLabel txtPlacar = new JLabel(String.valueOf(mortesCactos));

    protected JLabel placar = new JLabel(iPlacar);
    protected Fundo fundo = new Fundo();
    protected Chao chao = new Chao();
    protected DetalhesChao detalhesChao = new DetalhesChao();
    protected Cacto cacto = new Cacto();
    protected Cacto cacto1 = new Cacto();
    protected Cacto cacto2 = new Cacto();
    protected Nuvens nuvens0 = new Nuvens();
    protected Nuvens nuvens1 = new Nuvens();
    protected Nuvens nuvens2 = new Nuvens();
    protected Nuvens nuvens3 = new Nuvens();
    protected Heroi heroi= new Heroi();
    protected Tiro tiro = new Tiro();
    protected int posHeroiX;
    protected int posHeroiY;

    public App(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();
    }


    public static void main(String[] args) {
        new App();


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
        add(heroi.getlDino());
        add(tiro.getlTiro());
//        add(tiro1.getlTiro());
        add(cacto.getlCacto());
        add(cacto1.getlCacto());
        add(cacto2.getlCacto());
        add(nuvens3.getlNuvens());
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



    public void iniciarComPergunta(){
        Scanner tc = new Scanner(System.in);
        System.out.println("Deseja começar o jogo? [ s / n] ");
        String resp = tc.next().toUpperCase();
        if ("S".equals(resp)) {
            new App();
        }else{
            System.out.println("Ok, entao tchau. ");
        }
        System.out.println("fui");
    }


    public void capturaTeclado(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent tecla) {
                if (tecla.getKeyCode() == 32/*ESPAÇO*/) {
                    if (tecla.getKeyCode() == 32/*ESPAÇO*/) {
                        heroi.iniciarPulo();
                    }
                }
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.movimentoParaEsquerda(true);
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.movimentoParaDireita(true);
                }

                if (tecla.getKeyCode() == 68/* D */) {
                     tiro.setIniciarMovimentoDoTiro(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent tecla) {
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.movimentoParaEsquerda(false);
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.movimentoParaDireita(false);
                }
            }
        });
    }




    @Override
    public void run() {
        iniciarMovimentos();
        while (true){
            try {sleep(velJogo);} catch (Exception erro) {}
            atualizaPlacar();
            movimentosCactos();
            colisaoCactoTiro();
            colisaoDinoCacto();
            movimentosNuvens();
            receberPosicaoDoHeroiParaMapearOTiro();

        }
    }
    public void receberPosicaoDoHeroiParaMapearOTiro(){
        posHeroiX = heroi.atualizarPosX();
        posHeroiY = heroi.atualizarPosY();
        tiro.atualizarPosHeroi(posHeroiX, posHeroiY);
    }

    public void movimentosNuvens(){
        nuvens0.comportamentoDasNuvens();
        nuvens1.comportamentoDasNuvens();
        nuvens2.comportamentoDasNuvens();
        nuvens3.comportamentoDasNuvens();
    }

    public void movimentosCactos(){
        cacto.comportamentoDosCactos();
        cacto1.comportamentoDosCactos();
        cacto2.comportamentoDosCactos();

    }


    public void iniciarMovimentos(){
        if(heroi.dinoVivo) {
            new Thread(heroi).start();
            new Thread(tiro).start();
//            new Thread(tiro1).start();
        }
    }

    public void colisaoDinoCacto(){
        if (verificaColisao(heroi.getlDino(), cacto.getlCacto()) ||
                verificaColisao(heroi.getlDino(), cacto1.getlCacto()) ||
                verificaColisao(heroi.getlDino(), cacto2.getlCacto())){
            heroi.matarDino();
            JOptionPane.showMessageDialog(null, "  Matou " + mortesCactos + " cactos.");
            System.exit(0);
        }
    }

    public void colisaoCactoTiro(){
        // tiro 0
        if (verificaColisao(tiro.getlTiro(), cacto.getlCacto())) {
            cacto.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
        }
        if (verificaColisao(tiro.getlTiro(), cacto1.getlCacto())) {
            cacto1.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
        }
        if (verificaColisao(tiro.getlTiro(), cacto2.getlCacto())) {
            cacto2.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
        }
//        // Tiro 1
//        if (verificaColisao(tiro1.getlTiro(), cacto.getlCacto())) {
//            cacto.matarCactoPorTiro();
//            tiro1.tiroAcertou();
//            mortesCactos ++;
//        }
//        if (verificaColisao(tiro1.getlTiro(), cacto1.getlCacto())) {
//            cacto1.matarCactoPorTiro();
//            tiro1.tiroAcertou();
//            mortesCactos ++;
//        }
//        if (verificaColisao(tiro1.getlTiro(), cacto2.getlCacto())) {
//            cacto2.matarCactoPorTiro();
//            tiro1.tiroAcertou();
//            mortesCactos ++;
//        }

    }

    public void atualizaPlacar() {
        txtPlacar.setText(String.valueOf(mortesCactos));
    }

    public boolean verificaColisao(Component a, Component b) {
        int aX = a.getX();
        int aY = a.getY();
        int ladoDireitoA = aX+a.getWidth();
        int ladoEsquerdoA= aX;
        int ladoBaixoA= aY+a.getHeight();
        int ladoCimaA= aY;

        int bX = b.getX();
        int bY = b.getY();
        int ladoDireitoB = bX+b.getWidth();
        int ladoEsquerdoB= bX;
        int ladoBaixoB= bY+b.getHeight();
        int ladoCimaB= bY;

        boolean colidiu = false;
        boolean cDireita=false;
        boolean cCima=false;
        boolean cBaixo=false;
        boolean cEsquerda=false;

        if(ladoDireitoA>=ladoEsquerdoB) {
            cDireita=true;
        }
        if(ladoCimaA<=ladoBaixoB) {
            cCima=true;
        }
        if(ladoBaixoA>=ladoCimaB) {
            cBaixo=true;
        }
        if(ladoEsquerdoA<=ladoDireitoB) {
            cEsquerda=true;
        }

        if(cDireita && cEsquerda && cBaixo && cCima) {
            colidiu = true;
        }
        return colidiu;
    }
}
