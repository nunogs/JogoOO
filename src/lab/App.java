package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;


public class App extends JFrame {
    protected Fundo fundo = new Fundo();
    protected Chao chao = new Chao();
    protected Cacto cacto = new Cacto();
    protected Cacto cacto1 = new Cacto();
    protected Cacto cacto2 = new Cacto();
    protected Heroi heroi= new Heroi();
    protected Tiro tiro = new Tiro();


    protected JLabel lblFundo;
    protected JLabel lblCacto;
    protected JLabel lblCacto1;
    protected JLabel lblCacto2;
    protected JLabel lblTiro;
    protected JLabel lblChao;
    protected JLabel lblHeroi;

    public App(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        new Thread(cacto).start();
        new Thread(heroi).start();
        new Thread(tiro).start();
    }
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
        loadCacto();loadCacto1();loadCacto2();
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

}
