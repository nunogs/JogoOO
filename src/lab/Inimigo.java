package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

//public class Inimigo {
public class Inimigo implements Runnable{
    private int tamCactoX;
    private int tamCactoY;
    private int posCactoX;
    private int posCactoY;
    private ImageIcon iCacto;
    private JLabel lCacto;
    private Integer cont;
    private int velCactos;
    private int nivel;
    private int velocidadeDoCacto;

    public Inimigo() {
        this.tamCactoX = 88;
        this.tamCactoY = 90;
        this.posCactoX = (int)( 1300 + (Math.random() * 1400));
        this.posCactoY = (int)( 280 + (Math.random() * 300));
        this.iCacto = new ImageIcon(getClass().getResource("res\\cacto.png"));
        this.lCacto = new JLabel(this.iCacto);
        this.lCacto.setBounds(this.posCactoX, this.posCactoY, this.tamCactoX, this.tamCactoY);
        this.lCacto.setVisible(true);
        cont = 0;
        this.velCactos = (int)(1 + (Math.random() * 20));
//        this.velCactos = 8*1000;

    }

    public void atualizarMovimentosDosCactos() {
    	matarCactoPorSair();
    	movimentoDoCacto();
    	ajusteDeNivel();
    }
    
    
    public void nivelDoJogo(int nivel) {
    	this.nivel = nivel;
    }
    public void ajusteDeNivel() {
    	if (nivel <= 1) {
    		this.velocidadeDoCacto = 1;
    	}else if (nivel == 2) {
    		this.velocidadeDoCacto = 1;
    	}else if (nivel == 3) {
    		this.velocidadeDoCacto = 2;
    	}else if (nivel == 4) {
    		this.velocidadeDoCacto = 3;
    	}
    }
    
    public void movimentoDoCacto() {
        if (cont == 0 || cont == velCactos) {
//            velocidadeDoCacto = 3;
            this.lCacto.setLocation((this.lCacto.getX() - velocidadeDoCacto), this.lCacto.getY());
            cont ++;
        }else{
            cont = 0;
        }
    }
    
    public void matarCactoPorSair() {
        if (this.lCacto.getX() < -lCacto.getHeight()){
            mateOCacto();
        }
    }

    public void mateOCacto() {
        this.lCacto.setLocation(this.posCactoX, this.posCactoY);
    }
    @Override
    public void run() {
        while (true){
            try {sleep(2/*NAO MECHE NESSA POHA*/);} catch (Exception erro) {}
            atualizarMovimentosDosCactos();

        }
    }

    // METODOS ACESSORES

    public JLabel getlCacto() {
        return lCacto;
    }

    public void matarCactoPorTiro() {
        mateOCacto();
    }
}
