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


    public void setTamChaoX(int tamChaoX) {
        this.tamChaoX = tamChaoX;
    }

    public void setTamChaoY(int tamChaoY) {
        this.tamChaoY = tamChaoY;
    }

    public void setPosChaoX(int posChaoX) {
        this.posChaoX = posChaoX;
    }

    public void setPosChaoY(int posChaoY) {
        this.posChaoY = posChaoY;
    }

    public JLabel getlChao() {
        return lChao;
    }

    public void setlChao(JLabel lChao) {
        this.lChao = lChao;
    }

    public ImageIcon getiChao() {
        return iChao;
    }

    public void setiChao(ImageIcon iChao) {
        this.iChao = iChao;
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
