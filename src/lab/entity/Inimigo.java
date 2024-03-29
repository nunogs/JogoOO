package lab.entity;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Inimigo extends Personagem implements Runnable{
    
    private ImageIcon iRobo;
    private JLabel lRobo;
    private Integer cont;
    private int velRobo;
    private int nivel;
    private int velocidadeDoRobo;

    public Inimigo() {
    	super();
    	this.tamanhoY = 128;
    	this.tamanhoX = 75;

        this.posicaoX = (int)( 1300 + (Math.random() * 1400));
        this.posicaoY = (int)( 280 + (Math.random() * 300));
        this.iRobo = new ImageIcon(getClass().getResource("../img/inimigo/robo.png"));
        this.lRobo = new JLabel(this.iRobo);
        this.lRobo.setBounds(this.posicaoX, this.posicaoY, this.tamanhoX, this.tamanhoY);
        this.lRobo.setVisible(true);
        cont = 0;
        this.velRobo = (int)(1 + (Math.random() * 20));
//        this.velCactos = 8*1000;

    }

    public void atualizarMovimentosDosRobos() {
    	matarRoboPorSair();
    	movimentoDaRobo();
    	ajusteDeNivel();
    }
    
    
    public void nivelDoJogo(int nivel) {
    	this.nivel = nivel;
    }
    public void ajusteDeNivel() {
    	if (nivel <= 1) {
    		this.velocidadeDoRobo = 1;
    	}else if (nivel == 2) {
    		this.velocidadeDoRobo = 2;
    	}else if (nivel == 3) {
    		this.velocidadeDoRobo = 2;
    	}else if (nivel == 4) {
    		this.velocidadeDoRobo = 3;
    	}
    }

    
    public void movimentoDaRobo() {
        if (cont == 0 || cont == velRobo) {
//            velocidadeDoCacto = 3;
            this.lRobo.setLocation((this.lRobo.getX() - velocidadeDoRobo), this.lRobo.getY());
            cont ++;
        }else{
            cont = 0;
        }
    }
    
    public void matarRoboPorSair() {
        if (this.lRobo.getX() < -lRobo.getHeight()){
            mateORobo();
        }
    }

    public void mateORobo() {
        this.lRobo.setLocation(this.posicaoX, this.posicaoY);
    }
    @Override
    public void run() {
        while (true){
            try {sleep(2/*NAO MECHE NESSA POHA*/);} catch (Exception erro) {}
            atualizarMovimentosDosRobos();
            

        }
    }
    

    // METODOS ACESSORES

    
    public JLabel getlInimigo() {
        return lRobo;
    }

    public void matarInimigoPorTiro() {
        mateORobo();
    }
}
