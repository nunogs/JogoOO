package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Cacto implements Runnable{
    private int tamCactoX;
    private int tamCactoY;
    private int posCactoX;
    private int posCactoY;
    private ImageIcon iCacto;
    private JLabel lCacto;
    Boolean iniciouOMovimento;

    public Cacto() {
        this.tamCactoX = 88;
        this.tamCactoY = 90;
        this.posCactoX = 1300;
        this.posCactoY = 295;
        this.iCacto = new ImageIcon(getClass().getResource("res\\cacto.png"));
        this.lCacto = new JLabel(iCacto);
        this.lCacto.setBounds(posCactoX, posCactoY, tamCactoX, tamCactoY);
        this.lCacto.setVisible(true);
        this.iniciouOMovimento = false;
    }
    @Override
    public void run() {
        while (true) {
            try {sleep(1);} catch (Exception erro) {}
            try {movimentoDoCacto(); } catch (InterruptedException e) {e.printStackTrace(); }
            matarCactoPorSair();

        }
    }
    public void matarCactoPorSair(){
        if (this.lCacto.getX() < 500){
            mateOCacto();
        }
    }

    private void mateOCacto() {
        this.lCacto.setLocation(posCactoX,posCactoY);
        this.iniciouOMovimento = false;
    }

    public void movimentoDoCacto() throws InterruptedException {
        if (!this.iniciouOMovimento) {
            int random = 1 + (int) (Math.random() * 800);
            Thread.sleep(random);
        }
        this.iniciouOMovimento = true;

        int velocidadeDoCacto = 1;
        this.lCacto.setLocation((this.lCacto.getX() - velocidadeDoCacto), this.lCacto.getY());

    }

    public int getTamCactoX() {
        return tamCactoX;
    }

    public void setTamCactoX(int tamCactoX) {
        this.tamCactoX = tamCactoX;
    }

    public int getTamCactoY() {
        return tamCactoY;
    }

    public void setTamCactoY(int tamCactoY) {
        this.tamCactoY = tamCactoY;
    }

    public int getPosCactoX() {
        return posCactoX;
    }

    public void setPosCactoX(int posCactoX) {
        this.posCactoX = posCactoX;
    }

    public int getPosCactoY() {
        return posCactoY;
    }

    public void setPosCactoY(int posCactoY) {
        this.posCactoY = posCactoY;
    }

    public ImageIcon getiCacto() {
        return iCacto;
    }

    public void setiCacto(ImageIcon iCacto) {
        this.iCacto = iCacto;
    }

    public JLabel getlCacto() {
        return lCacto;
    }

    public void setlCacto(JLabel lCacto) {
        this.lCacto = lCacto;
    }


}
