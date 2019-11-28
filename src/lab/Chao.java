package lab;

import javax.swing.*;

public class Chao {
    private int tamChaoX;
    private int tamChaoY;
    private int posChaoX;
    private int posChaoY;
    private ImageIcon iChao;
    private JLabel lChao;


    public Chao() {
        tamChaoX = 1280;
        tamChaoY = 10;
        posChaoX = 0;
        posChaoY = 360;
        iChao = new ImageIcon(getClass().getResource("res\\chao.png"));
        lChao = new JLabel(iChao);
        this.lChao.setBounds(getPosChaoX(), getPosChaoY(), getTamChaoX(), getTamChaoY());
        lChao.setVisible(true);
    }

    public JLabel getlChao() {
        return lChao;
    }

    public int getTamChaoX() {
        return tamChaoX;
    }

    public int getTamChaoY() {
        return tamChaoY;
    }

    public int getPosChaoX() {
        return posChaoX;
    }

    public int getPosChaoY() {
        return posChaoY;
    }
}
