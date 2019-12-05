package lab.entity;

import javax.swing.*;

public class DetalhesChao extends Cenario{
    private ImageIcon iDetalhes;
    private JLabel lDetalhes;
    private int redutorDeVelocidade;

    public DetalhesChao() {
    	super();
        this.tamanhoX = 2560;
        this.tamanhoY = 50;
        this.posicaoX = 0;
        this.posicaoY = 365;
        this.iDetalhes = new ImageIcon(getClass().getResource("../img/cenario/detalhechao.png"));
        this.lDetalhes = new JLabel(this.iDetalhes);
        this.lDetalhes.setBounds(this.posicaoX, this.posicaoY, this.tamanhoX, this.tamanhoY);
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
        this.lDetalhes.setLocation(posicaoX, posicaoY);
    }
    

    public JLabel getlDetalhes() {
        return lDetalhes;
    }
}
