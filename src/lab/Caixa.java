package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Caixa implements Runnable{
    private int tamCaixaX;
    private int tamCaixaY;
    private int posCaixaX;
    private int posCaixaY;
    private ImageIcon iCaixa;
    private JLabel lCaixa;
    private Integer cont;
    private int velCaixa;
    private int nivel;
    private int velocidadeDoCaixa;

    public Caixa() {
        this.tamCaixaX = 52;
        this.tamCaixaY = 52;
        this.posCaixaX = (int)( 1300 + (Math.random() * 1400));
        this.posCaixaY = (int)( 280 + (Math.random() * 300));
        this.iCaixa = new ImageIcon(getClass().getResource("res\\caixa.png"));
        this.lCaixa = new JLabel(this.iCaixa);
        this.lCaixa.setBounds(this.posCaixaX, this.posCaixaY, this.tamCaixaX, this.tamCaixaY);
        this.lCaixa.setVisible(true);
        cont = 0;
        this.velCaixa = (int)(1 + (Math.random() * 20));
//        this.velCactos = 8*1000;

    }

    public void atualizarMovimentosDaCaixa() {
    	matarCaixaPorSair();
    	movimentoDoCaixa();
    	ajusteDeNivel();
    }
    
    
    public void nivelDoJogo(int nivel) {
    	this.nivel = nivel;
    }
    public void ajusteDeNivel() {
    	if (nivel <= 1) {
    		this.velocidadeDoCaixa = 1;
    	}else if (nivel == 2) {
    		this.velocidadeDoCaixa = 1;
    	}else if (nivel == 3) {
    		this.velocidadeDoCaixa = 2;
    	}else if (nivel == 4) {
    		this.velocidadeDoCaixa = 3;
    	}
    }
    
    public void movimentoDoCaixa() {
        if (cont == 0 || cont == velCaixa) {
//            velocidadeDoCacto = 3;
            this.lCaixa.setLocation((this.lCaixa.getX() - velocidadeDoCaixa), this.lCaixa.getY());
            cont ++;
        }else{
            cont = 0;
        }
    }
    
    public void matarCaixaPorSair() {
        if (this.lCaixa.getX() < -lCaixa.getHeight()){
            mateOCaixa();
        }
    }

    public void mateOCaixa() {
        this.lCaixa.setLocation(this.posCaixaX, this.posCaixaY);
    }
    @Override
    public void run() {
        while (true){
            try {sleep(2/*NAO MECHE NESSA POHA*/);} catch (Exception erro) {}
            atualizarMovimentosDaCaixa();

        }
    }

    // METODOS ACESSORES

    public JLabel getlCaixa() {
        return lCaixa;
    }

    public void matarCaixaPorTiro() {
        mateOCaixa();
    }
}
