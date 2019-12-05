package lab.entity;

import static java.lang.Thread.sleep;

import javax.swing.*;

public class Nuvens implements Runnable{
    private int tamNuvensX;
    private int tamNuvensY;
    private int posNuvensX;
    private int posNuvensY;
    private ImageIcon iNuvens;
    private JLabel lNuvens;
    private int cont;
    private int velNuvens;

    public Nuvens() {
        this.tamNuvensX = 88;
        this.tamNuvensY = 90;
        this.posNuvensX = (int)( 1300 + (Math.random() * 1280) + ( 1 + (Math.random() * 100)));
        this.velNuvens = (int)((1 + (Math.random() * 2)) + (1 + (Math.random() * 2)));
        this.posNuvensY = (int)( 80 + (Math.random() * 150));
        this.iNuvens = new ImageIcon(getClass().getResource("../img/cenario/nuvens.png"));
        this.lNuvens = new JLabel(this.iNuvens);
        this.lNuvens.setBounds(this.posNuvensX, this.posNuvensY, this.tamNuvensX, this.tamNuvensY);
        this.lNuvens.setVisible(true);
        cont = 0;

    }

    public void comportamentoDasNuvens(){
        //matar nuvem por sair
        if (this.lNuvens.getX() < -50){
            mateAsNuvens();
        }

        // movimento das nuvens
        if (cont == 0 || cont == velNuvens) {
            int velocidadeDasNuvens = 1;
            this.lNuvens.setLocation((this.lNuvens.getX() - velocidadeDasNuvens), this.lNuvens.getY());
            cont ++;
        }else{
            cont = 0;
        }

    }
    
    @Override
    public void run() {
        while (true) {
            try {sleep(2);} catch (Exception erro) {}
            
            comportamentoDasNuvens();

        }
    }

    public void mateAsNuvens() {
        this.lNuvens.setLocation(posNuvensX, posNuvensY);
    }


    public JLabel getlNuvens() {
        return lNuvens;
    }

}
