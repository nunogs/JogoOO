package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Nuvens{
    private int tamNuvensX;
    private int tamNuvensY;
    private int posNuvensX;
    private int posNuvensY;
    private ImageIcon iNuvens;
    private JLabel lNuvens;
    private Boolean iniciouOMovimento;

    public Nuvens() {
        this.tamNuvensX = 88;
        this.tamNuvensY = 90;
        this.posNuvensX = (int)( 1300 + (Math.random() * 2000));
        this.posNuvensY = (int)( 80 + (Math.random() * 150));
        this.iNuvens = new ImageIcon(getClass().getResource("res\\nuvens.png"));
        this.lNuvens = new JLabel(this.iNuvens);
        this.lNuvens.setBounds(this.posNuvensX, this.posNuvensY, this.tamNuvensX, this.tamNuvensY);
        this.lNuvens.setVisible(true);
        this.iniciouOMovimento = false;

    }

    public void matarNuvemPorSair(){
        if (this.lNuvens.getX() < -50){
            mateAsNuvens();
        }
    }

    public void mateAsNuvens() {
        this.lNuvens.setLocation(posNuvensX, posNuvensY);
        this.iniciouOMovimento = false;
    }

    public void movimentoDasNuvens(){
        int velocidadeDasNuvens = 1;
        this.lNuvens.setLocation((this.lNuvens.getX() - velocidadeDasNuvens), this.lNuvens.getY());

    }

    public int getTamNuvensX() {
        return tamNuvensX;
    }

    public int getTamNuvensY() {
        return tamNuvensY;
    }

    public int getPosNuvensX() {
        return posNuvensX;
    }


    public int getPosNuvensY() {
        return posNuvensY;
    }

    public ImageIcon getiNuvens() {
        return iNuvens;
    }

    public JLabel getlNuvens() {
        return lNuvens;
    }

}
