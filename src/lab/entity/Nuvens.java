package lab.entity;


import static java.lang.Thread.sleep;

import javax.swing.*;

public class Nuvens extends Cenario implements Runnable{
    private ImageIcon iNuvens;
    private JLabel lNuvens;
    private int cont;
    private int velNuvens;

    public Nuvens() {
    	super();
        this.tamanhoX = 88;
        this.tamanhoY = 90;
        this.posicaoX = (int)( 1300 + (Math.random() * 1280) + ( 1 + (Math.random() * 100)));
        this.velNuvens = (int)((1 + (Math.random() * 2)) + (1 + (Math.random() * 2)));
        this.posicaoY = (int)( 80 + (Math.random() * 150));
        this.iNuvens = new ImageIcon(getClass().getResource("../img/cenario/nuvens.png"));
        this.lNuvens = new JLabel(this.iNuvens);
        this.lNuvens.setBounds(this.posicaoX, this.posicaoY, this.tamanhoX, this.tamanhoY);
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
        this.lNuvens.setLocation(posicaoX, posicaoY);
    }


    public JLabel getlNuvens() {
        return lNuvens;
    }

}
