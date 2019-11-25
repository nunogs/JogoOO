package lab;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;


public class App extends JFrame {
    protected Fundo fundo = new Fundo();
    protected Chao chao = new Chao();
    protected Cacto cacto = new Cacto();
    protected Cacto cacto1 = new Cacto();
    protected Cacto cacto2 = new Cacto();


    protected Heroi heroi= new Heroi();
    protected JLabel lblFundo;
    protected JLabel lblCacto;
    protected JLabel lblCacto1;
    protected JLabel lblCacto2;
    protected JLabel lblChao;
    protected JLabel lblHeroi;

    public App(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        new Thread(cacto).start();
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

                }
                if (tecla.getKeyCode() == 37 /*SETA ESQUERDA*/) {
                    heroi.andarEsquerda();
                }

                if (tecla.getKeyCode() == 39 /*SETA DIREITA*/) {
                    heroi.andarDireita();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new App();


    }

}
