package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Bugs extends Heroi implements Runnable{
    private int tamPedraX;
    private int tamPedraY;
    private int posPedraX;
    private int posPedraY;
    private ImageIcon iPedra;
    private JLabel lPedra;
    private Boolean dispararPedra;
    private Boolean pedraNaMao;

    public Bugs() {
        this.tamPedraX = 10;
        this.tamPedraY = 15;
        this.iPedra = new ImageIcon(getClass().getResource("res\\bug.png"));
        this.lPedra = new JLabel(iPedra);
        this.dispararPedra = false;
        this.lPedra.setVisible(true);
        this.lPedra.setBounds(posPedraX, posPedraY, tamPedraX, tamPedraY);
        this.pedraNaMao = true;

    }

    @Override
    public void run() {
        while (true){
            try {sleep(5);} catch (Exception erro) {}
            pedraSaiu();
            movimentoTiro();
        }
    }
    public void tacaPedra() {
        this.dispararPedra = true;
        this.pedraNaMao = false;
    }

    public void movimentoTiro(){
        if(dispararPedra) {
            this.lPedra.setLocation(lPedra.getX() + 10, lPedra.getY());
        }else{ //atualiza a pos do tiro apenas enquanto ele nao está em movimento
            this.lPedra.setLocation(posPedraX, posPedraY);
        }
    }

    public void pararPedra(){
        this.dispararPedra = false;
        this.pedraNaMao = true;
        this.lPedra.setLocation(posPedraX, posPedraY);

    }

    public void pedraSaiu(){
        if(this.lPedra.getX() > 1285 || this.lPedra.getX() < 1 ){
            pararPedra();
        }
    }

    public JLabel getlTiro() {
        return lPedra;
    }

    public void atualizarPosHeroi(int posHeroiX, int posHeroiY) {
        this.posPedraX = posHeroiX+50;
        this.posPedraY = posHeroiY+75;
    }

	public Boolean getPedraNaMao() {
		return pedraNaMao;
	}


}
