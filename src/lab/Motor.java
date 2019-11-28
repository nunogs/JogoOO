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
    protected int mortesCactos;
    JLabel txtPlacar = new JLabel(String.valueOf(mortesCactos));

    protected JLabel placar = new JLabel(iPlacar);
    protected Fundo fundo = new Fundo(0,0);
    protected Fundo fundoForaDireita = new Fundo(1280,0);
    protected Fundo fundoForaEsquerda = new Fundo(-1280,0);
    protected Chao chao = new Chao();
    protected DetalhesChao detalhesChao = new DetalhesChao();
    protected Cacto cacto = new Cacto();
    protected Cacto cacto1 = new Cacto();
    protected Cacto cacto2 = new Cacto();
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

    public Motor(){
        setFocusable(true);
        carregarJanela();
        iniciarObjetos();
        capturaTeclado();
        run();

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
        add(heroi.getlDino());
        add(armas0.getlPedra());
        add(armas1.getlPedra());
        add(cacto.getlCacto());
        add(cacto1.getlCacto());
        add(cacto2.getlCacto());
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


    public void capturaTeclado(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent tecla) {
                System.out.println(tecla.getKeyCode());
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
                if (tecla.getKeyCode() == 38 /*SETA CIMA*/) {
//                    heroi.movimentoParaCima(true);
                }

                if (tecla.getKeyCode() == 40 /*SETA BAIXO*/) {
//                    heroi.movimentoParaBaixo(true);
                }

                if (tecla.getKeyCode() == 68/* D */) {
                    tacarPedra();
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

    private void tacarPedra() {
        if (pedraNaMao0 && pedraNaMao1) {
            pedraNaMao0 = false;
            armas0.tacaPedra();

        }else if(pedraNaMao1 && !pedraNaMao0){
            pedraNaMao1 = false;
            armas1.tacaPedra();
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
            new Thread(armas0).start();
            new Thread(armas1).start();
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
        if (verificaColisao(armas0.getlPedra(), cacto.getlCacto())) {
            cacto.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesCactos ++;
        }
        if (verificaColisao(armas0.getlPedra(), cacto1.getlCacto())) {
            cacto1.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesCactos ++;
        }
        if (verificaColisao(armas0.getlPedra(), cacto2.getlCacto())) {
            cacto2.matarCactoPorTiro();
            armas0.pararPedra();
            pedraNaMao0 = true;
            mortesCactos ++;
        }

        // Tiro 2
        if (verificaColisao(armas1.getlPedra(), cacto.getlCacto())) {
            cacto.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesCactos ++;
        }
        if (verificaColisao(armas1.getlPedra(), cacto1.getlCacto())) {
            cacto1.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesCactos ++;
        }
        if (verificaColisao(armas1.getlPedra(), cacto2.getlCacto())) {
            cacto2.matarCactoPorTiro();
            armas1.pararPedra();
            pedraNaMao1 = true;
            mortesCactos ++;
        }



    }

    public void colisaoTiroFora(){
        // Tiro sair para direita

        if (verificaColisao(fundoForaDireita.getLfundo(), armas0.getlPedra())){
            pedraNaMao0 = true;
        }
        if (verificaColisao(fundoForaDireita.getLfundo(), armas1.getlPedra())){
            pedraNaMao1 = true;
        }
        // Tiro sair para esquerda

        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas0.getlPedra())){
            pedraNaMao0 = true;
        }
        if (verificaColisao(fundoForaEsquerda.getLfundo(), armas1.getlPedra())){
            pedraNaMao1 = true;
        }


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
