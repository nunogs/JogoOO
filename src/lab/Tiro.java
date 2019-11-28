package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Tiro extends Heroi implements Runnable{
    private int tamTiroX;
    private int tamTiroY;
    private int posTiroX;
    private int posTiroY;
    private ImageIcon iTiro;
    private JLabel lTiro;
    private Boolean dispararPedra;

    public Tiro() {
        this.tamTiroX = 10;
        this.tamTiroY = 15;
        this.iTiro = new ImageIcon(getClass().getResource("res\\tiro.png"));
        this.lTiro = new JLabel(iTiro);
        this.dispararPedra = false;
        this.lTiro.setVisible(true);
        this.lTiro.setBounds(posTiroX, posTiroY, tamTiroX,tamTiroY);

    }

    @Override
    public void run() {
        while (true){
            try {sleep(4);} catch (Exception erro) {}
            pedraSaiu();
            movimentoTiro();
        }
    }
    public void atirou() {
        this.dispararPedra = true;
    }

    public void movimentoTiro(){
        if(dispararPedra) {
            this.lTiro.setLocation(lTiro.getX() + 10, lTiro.getY());
        }else{ //atualiza a pos do tiro apenas enquanto ele nao está em movimento
            this.lTiro.setLocation(posTiroX, posTiroY);
        }
    }

    public void pararPedra(){
        this.dispararPedra = false;
        this.lTiro.setLocation(posTiroX,posTiroY);

    }

    public void pedraSaiu(){
        if(this.lTiro.getX() > 1285 || this.lTiro.getX() < 1 ){
            pararPedra();
        }
    }


    public JLabel getlTiro() {
        return lTiro;
    }

    public void atualizarPosHeroi(int posHeroiX, int posHeroiY) {
        this.posTiroX = posHeroiX+45;
        this.posTiroY = posHeroiY+30;
    }

}
