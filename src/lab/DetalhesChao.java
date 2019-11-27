package lab;

import javax.swing.*;

public class DetalhesChao{
    private int tamDetalhesX;
    private int tamDetalhesY;
    private int posDetalhesX;
    private int posDetalhesY;
    private ImageIcon iDetalhes;
    private JLabel lDetalhes;
    private int cont;
    private int velDetalhes;

    public DetalhesChao() {
        this.tamDetalhesX = 50;
        this.tamDetalhesY = 1280;
        this.posDetalhesX = 1280;
        this.posDetalhesY = 370;
        this.velDetalhes = 5;
        this.iDetalhes = new ImageIcon(getClass().getResource("res\\detalhechao.png"));
        this.lDetalhes = new JLabel(this.iDetalhes);
        this.lDetalhes.setBounds(this.posDetalhesX, this.posDetalhesY, this.tamDetalhesX, this.tamDetalhesY);
        this.lDetalhes.setVisible(true);

    }

    public void matarDetalhePorSair(){
        if (this.lDetalhes.getX() < -1280){
            mateODetalhe();
        }
    }

    public void mateODetalhe() {
        this.lDetalhes.setLocation(posDetalhesX, posDetalhesY);
    }

    public void movimentoDetalhes(){

        if (cont == 0 || cont == velDetalhes) {
            int velocidadeDetalhes = 1;
            this.lDetalhes.setLocation((this.lDetalhes.getX() - velocidadeDetalhes), this.lDetalhes.getY());
            cont ++;
        }else{
            cont = 0;
        }
    }

    public int getTamDetalhesX() {
        return tamDetalhesX;
    }

    public int getTamDetalhesY() {
        return tamDetalhesY;
    }

    public int getPosDetalhesX() {
        return posDetalhesX;
    }


    public int getPosDetalhesY() {
        return posDetalhesY;
    }

    public ImageIcon getiDetalhes() {
        return iDetalhes;
    }

    public JLabel getlDetalhes() {
        return lDetalhes;
    }

}
