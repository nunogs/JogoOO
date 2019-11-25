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
    private Boolean iniciouOMovimento;

    public Cacto() {
        this.tamCactoX = 88;
        this.tamCactoY = 90;
        this.posCactoX = 1300;
        this.posCactoY = 295;
        this.iCacto = new ImageIcon(getClass().getResource("res\\cacto.png"));
        this.lCacto = new JLabel(this.iCacto);
        this.lCacto.setBounds(this.posCactoX, this.posCactoY, this.tamCactoX, this.tamCactoY);
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

}
