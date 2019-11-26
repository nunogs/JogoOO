package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Cacto{
//public class Cacto implements Runnable{
    private int tamCactoX;
    private int tamCactoY;
    private int posCactoX;
    private int posCactoY;
    private ImageIcon iCacto;
    private JLabel lCacto;
    private Boolean iniciouOMovimento;
    private int randCacto;

    public Cacto() {
        this.tamCactoX = 88;
        this.tamCactoY = 90;
        this.posCactoX = (int)( 1300 + (Math.random() * 2500));
        this.posCactoY = 295;
//        this.randCacto =  (int)(1 + (Math.random() * 5 ));
//        this.posCactoY = (294 + randCacto);
        this.iCacto = new ImageIcon(getClass().getResource("res\\cacto.png"));
        this.lCacto = new JLabel(this.iCacto);
        this.lCacto.setBounds(this.posCactoX, this.posCactoY, this.tamCactoX, this.tamCactoY);
        this.lCacto.setVisible(true);
        this.iniciouOMovimento = false;

    }

    public void matarCactoPorSair(){
        if (this.lCacto.getX() < 500){
            mateOCacto();
        }
    }

    public void mateOCacto() {
        this.lCacto.setLocation(this.posCactoX, this.posCactoY);
        this.iniciouOMovimento = false;
    }

    public void movimentoDoCacto(){
        if (!this.iniciouOMovimento) {
////            int random = 1 + (int) (Math.random() * 800);
//            try {sleep( (int) (Math.random() * 800));} catch (Exception erro) {}

            this.iniciouOMovimento = true;
        }
        int velocidadeDoCacto = 1;
        this.lCacto.setLocation((this.lCacto.getX() - velocidadeDoCacto), this.lCacto.getY());

    }

    public int getTamCactoX() {
        return tamCactoX;
    }

    public int getTamCactoY() {
        return tamCactoY;
    }

    public int getPosCactoX() {
        return posCactoX;
    }


    public int getPosCactoY() {
        return posCactoY;
    }

    public ImageIcon getiCacto() {
        return iCacto;
    }

    public JLabel getlCacto() {
        return lCacto;
    }

    public void matarCactoPorTiro() {
        mateOCacto();
    }
}
