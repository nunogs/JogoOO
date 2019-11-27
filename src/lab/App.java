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


    ImageIcon iPlacar = new ImageIcon(getClass().getResource("res\\placar.png"));


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
    protected Tiro tiro1 = new Tiro();
    protected JLabel lblFundo;
    protected JLabel lblCacto;
    protected JLabel lblCacto1;
    protected JLabel lblCacto2;
    protected JLabel lblNuvens;
    protected JLabel lblNuvens1;
    protected JLabel lblNuvens2;
    protected JLabel lblNuvens3;
    protected JLabel lblTiro;
    protected JLabel lblTiro1;
    protected JLabel lblChao;
    protected JLabel lblHeroi;
    protected JLabel placar = new JLabel(iPlacar);
    protected int posX;
    protected int posY;
    protected int mortesCactos;
    JLabel txtPlacar = new JLabel(String.valueOf(mortesCactos));

    public App(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();
        new Thread(heroi).run();
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
        loadPlacar();
        loadHeroi();
        loadTiro();
        loadTiro1();
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

    private void loadPlacar() {
        placar.setVisible(true);
        placar.setBounds(100,20,150,120);
        txtPlacar.setVisible(true);
//        txtPlacar.setBorder(10,10);
        txtPlacar.setBounds(60,25,90,50);
        Font fonteGeral = new Font("Arial", Font.BOLD, 50);
        txtPlacar.setFont(fonteGeral);
        placar.add(txtPlacar);
        add(placar);

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
    public void loadTiro1(){
        lblTiro1 = tiro1.getlTiro();
        add(lblTiro1);
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
                        if (!(heroi.getPuloDinoS() ||
                                heroi.getPuloDinoS2() ||
                                heroi.getPuloDinoB() ||
                                heroi.getPuloDinoB2())) {

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
                     tiro1.setIniciarMovimentoDoTiro(true);
                     posX = lblHeroi.getX() + 30;
                     posY = lblHeroi.getY() + 30;
                     tiro1.atualizarPosHeroi(posX, posY);


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
            try {sleep(velJogo);} catch (Exception erro) {}
            atualizaPlacar();
            movimentosCactos();
            colisaoCactoTiro();
            colisaoDinoCacto();
            movimentosNuvens();

//            heroi.atualizarMovimentosDino();

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
            new Thread(tiro1).start();
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
        // Tiro 1
        if (verificaColisao(tiro1.getlTiro(), cacto.getlCacto())) {
            cacto.matarCactoPorTiro();
            tiro1.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }
        if (verificaColisao(tiro1.getlTiro(), cacto1.getlCacto())) {
            cacto1.matarCactoPorTiro();
            tiro1.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }
        if (verificaColisao(tiro1.getlTiro(), cacto2.getlCacto())) {
            cacto2.matarCactoPorTiro();
            tiro1.tiroAcertou();
            mortesCactos ++;
            System.out.println(mortesCactos);
        }



    }

    public void atualizaPlacar() {
        txtPlacar.setText(String.valueOf(mortesCactos));
    }

    public void atirar(){
        int tiro = 0;

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
