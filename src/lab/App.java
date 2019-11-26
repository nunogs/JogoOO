package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class App extends JFrame implements Runnable{
    protected Fundo fundo = new Fundo();
    protected Chao chao = new Chao();
    protected Cacto cacto = new Cacto();
    protected Cacto cacto1 = new Cacto();
    protected Cacto cacto2 = new Cacto();
    protected Nuvens nuvens = new Nuvens();
    protected Nuvens nuvens1 = new Nuvens();
    protected Nuvens nuvens2 = new Nuvens();
    protected Nuvens nuvens3 = new Nuvens();
    protected Heroi heroi= new Heroi();
    protected Tiro tiro = new Tiro();
    protected JLabel lblFundo;
    protected JLabel lblCacto;
    protected JLabel lblCacto1;
    protected JLabel lblCacto2;
    protected JLabel lblNuvens;
    protected JLabel lblNuvens1;
    protected JLabel lblNuvens2;
    protected JLabel lblNuvens3;
    protected JLabel lblTiro;
    protected JLabel lblChao;
    protected JLabel lblHeroi;
    protected int posX;
    protected int posY;
    protected int mortesCactos;


    public App(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();
//        new Thread(heroi).start();
//        new Thread(tiro).start();
    }
//    public void iniciarNuvens(){
//        new Thread(cacto).start();
//        try {sleep(20);} catch (Exception erro) {}
//        new Thread(cacto1).start();
//        try {sleep(20);} catch (Exception erro) {}
//        new Thread(cacto2).start();
//    }
    public void carregarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
    }

    public void iniciarObjetos(){
        loadHeroi();
        loadTiro();
        loadCacto();
        loadCacto1();
        loadCacto2();
        loadNuvens3();
        loadNuvens1();
        loadNuvens();
        loadNuvens2();
        loadChao();
        loadFundo();
    }

    private void loadHeroi() {
        lblHeroi = heroi.getlDino();
        add(lblHeroi);
    }

    public void loadFundo(){
        lblFundo = fundo.getLfundo();
        add(lblFundo);
    }
    public void loadChao(){
        lblChao = chao.getlChao();
        add(lblChao);
    }
    public void loadCacto(){
        lblCacto = cacto.getlCacto();
        add(lblCacto);
    }
    public void loadCacto1(){
        lblCacto1 = cacto1.getlCacto();
        add(lblCacto1);
    }
    public void loadCacto2(){
        lblCacto2 = cacto2.getlCacto();
        add(lblCacto2);
    }
    public void loadNuvens(){
        lblNuvens = nuvens.getlNuvens();
        add(lblNuvens);
    }
    public void loadNuvens1(){
        lblNuvens1 = nuvens1.getlNuvens();
        add(lblNuvens1);
    }
    public void loadNuvens2(){
        lblNuvens2 = nuvens2.getlNuvens();
        add(lblNuvens2);
    }
    public void loadNuvens3(){
        lblNuvens3 = nuvens3.getlNuvens();
        add(lblNuvens3);
    }
    public void loadTiro(){
        lblTiro = tiro.getlTiro();
        add(lblTiro);
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
                        if (!(heroi.getPuloDinoS() || heroi.getPuloDinoS2() || heroi.getPuloDinoB() || heroi.getPuloDinoB2())) {
                            heroi.setPuloDinoS(true);
                            heroi.setPosAtualDinoY(heroi.lDino.getY());
                        }
                    }
                }
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.setMovEsqDinoS(true);
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.setMovDirDinoS(true);
                }

                if (tecla.getKeyCode() == 68/* D */) {
                    tiro.setTiroDado(true);
                    posX = lblHeroi.getX()+30;
                    posY = lblHeroi.getY()+30;
                    tiro.atualizarPosHeroi(posX, posY);
                }
            }

            @Override
            public void keyReleased(KeyEvent tecla) {
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.setMovEsqDinoS(false);
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.setMovDirDinoS(false);
                }
            }
        });
    }



    public static void main(String[] args) {
        new App();


    }

    @Override
    public void run() {
        iniciarMovimentos();
        while (true){
            try {sleep(1);} catch (Exception erro) {}

            movimentosCactos();
            colisaoCactoTiro();
            colisaoDinoCacto();
            colisaoCactoCacto();
            movimentosNuvens();

            heroi.atualizarMovimentosDino();

        }
    }

    public void movimentosNuvens(){
        nuvens.matarNuvemPorSair();
        nuvens.movimentoDasNuvens();

        nuvens1.matarNuvemPorSair();
        nuvens1.movimentoDasNuvens();

        nuvens2.matarNuvemPorSair();
        nuvens2.movimentoDasNuvens();

        nuvens3.matarNuvemPorSair();
        nuvens3.movimentoDasNuvens();
    }

    public void movimentosCactos(){
        matarCactos();
        cacto.movimentoDoCacto();
        cacto1.movimentoDoCacto();
        cacto2.movimentoDoCacto();
    }
    public void matarCactos(){
        cacto.matarCactoPorSair();
        cacto1.matarCactoPorSair();
        cacto2.matarCactoPorSair();
    }

    public void iniciarMovimentos(){
        if(heroi.dinoVivo) {
            new Thread(heroi).start();
            new Thread(tiro).start();
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
        if (verificaColisao(tiro.getlTiro(), cacto.getlCacto())) {
            cacto.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }
        if (verificaColisao(tiro.getlTiro(), cacto1.getlCacto())) {
            cacto1.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }
        if (verificaColisao(tiro.getlTiro(), cacto2.getlCacto())) {
            cacto2.matarCactoPorTiro();
            tiro.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }

    }
    public void colisaoCactoCacto(){
        if (verificaColisao(cacto.getlCacto(), cacto1.getlCacto())) {
            cacto.mateOCacto();
        }
        if (verificaColisao(cacto.getlCacto(), cacto2.getlCacto())) {
            cacto.mateOCacto();
        }
        if (verificaColisao(cacto1.getlCacto(), cacto2.getlCacto())) {
            cacto1.mateOCacto();
        }

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
