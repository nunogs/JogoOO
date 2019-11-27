package lab;

import javax.swing.*;

public class DetalhesChao{
    private int tamDetalhesX;
    private int tamDetalhesY;
    private int posDetalhesX;
    private int posDetalhesY;
    private ImageIcon iDetalhes;
    private JLabel lDetalhes;
    private Boolean iniciouOMovimento;
    private int cont;
    private int velDetalhes;


    public DetalhesChao() {
        this.tamDetalhesX = 189;
        this.tamDetalhesY = 50;
        this.posDetalhesX = 0;
        this.posDetalhesY = 370;
        this.iDetalhes = new ImageIcon(getClass().getResource("res\\detalhechao.png"));
        this.lDetalhes = new JLabel(this.iDetalhes);
        this.lDetalhes.setBounds(this.posDetalhesX, this.posDetalhesY, this.tamDetalhesX, this.tamDetalhesY);
        this.lDetalhes.setVisible(true);

    }

    public void matarDetalhePorSair(){
        if (this.lDetalhes.getX() < -50){
            this.mateOsDetalhes();
        }
    }

    public void mateOsDetalhes() {
        this.lDetalhes.setLocation(this.posDetalhesX, this.posDetalhesY);
        this.iniciouOMovimento = false;
    }
    public void movimentoDetalhes(){
        this.lDetalhes.setLocation((this.lDetalhes.getX() - velDetalhes), this.lDetalhes.getY());
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
