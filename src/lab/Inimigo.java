package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Inimigo {
//public class Cacto implements Runnable{
    private int tamCactoX;
    private int tamCactoY;
    private int posCactoX;
    private int posCactoY;
    private ImageIcon iCacto;
    private JLabel lCacto;
    private int cont;
    private int velCactos;

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
        velCactos = 500;
        velCactos = (int)(1 + (Math.random() * 2));

    }

    public void atualizarMovimentosDosCactos(){
    	
    	matarCactoPorSair();
    	movimentoDoCacto();

    }
    
    public void movimentoDoCacto() {
        if (cont == 0 || cont == velCactos) {
            int velocidadeDoCacto = 1;
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


    // METODOS ACESSORES

    public JLabel getlCacto() {
        return lCacto;
    }

    public void matarCactoPorTiro() {
        mateOCacto();
    }
}
