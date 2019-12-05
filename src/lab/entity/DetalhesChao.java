package lab.entity;

import javax.swing.*;

public class DetalhesChao{
    private int tamDetalhesX;
    private int tamDetalhesY;
    private int posDetalhesX;
    private int posDetalhesY;
    private ImageIcon iDetalhes;
    private JLabel lDetalhes;
    private int redutorDeVelocidade;

    public DetalhesChao() {

        this.tamDetalhesX = 2560;
        this.tamDetalhesY = 50;
        this.posDetalhesX = 0;
        this.posDetalhesY = 365;
        this.iDetalhes = new ImageIcon(getClass().getResource("../img/cenario/detalhechao.png"));
        this.lDetalhes = new JLabel(this.iDetalhes);
        this.lDetalhes.setBounds(this.posDetalhesX, this.posDetalhesY, this.tamDetalhesX, this.tamDetalhesY);
        this.lDetalhes.setVisible(true);
        this.redutorDeVelocidade =1;

    }

    public void movimentos(){
        //matar por sair
        if (this.lDetalhes.getX() < -1280){
            DetalhesSairam();
        }

        // movimento
        if (redutorDeVelocidade == 0 || redutorDeVelocidade == 1) {
            this.lDetalhes.setLocation((this.lDetalhes.getX() - 1), this.lDetalhes.getY());
            redutorDeVelocidade++;
        }else{
            redutorDeVelocidade = 0;
        }

    }

    public void DetalhesSairam() {
        this.lDetalhes.setLocation(posDetalhesX, posDetalhesY);
    }

    public JLabel getlDetalhes() {
        return lDetalhes;
    }
}
