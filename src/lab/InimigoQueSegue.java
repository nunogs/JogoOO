package lab;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class InimigoQueSegue implements Runnable{
    private int tamRoboX;
    private int tamRoboY;
    private int posRoboX;
    private int posRoboY;
    private ImageIcon iRobo;
    private JLabel lRobo;
    private Integer cont;
    private int velRobo;
    private int nivel;
    private int velocidadeDoRobo;
//    private int posHeroiX;
//    private int posHeroiY;

    public InimigoQueSegue() {
    	this.tamRoboY = 128;
    	this.tamRoboX = 75;
//    	posHeroiX = 0 ;
//    	posHeroiY = 0 ;
        this.posRoboX = (int)( 1300 + (Math.random() * 1400));
        this.posRoboY = (int)( 280 + (Math.random() * 300));
        this.iRobo = new ImageIcon(getClass().getResource("res\\robo.png"));
        this.lRobo = new JLabel(this.iRobo);
        this.lRobo.setBounds(this.posRoboX, this.posRoboY, this.tamRoboX, this.tamRoboY);
        this.lRobo.setVisible(true);
        cont = 0;
        this.velRobo = (int)(1 + (Math.random() * 20));
//        this.velCactos = 8*1000;

    }

    public void atualizarMovimentosDosRobos() {
    	matarRoboPorSair();
    	movimentoDaRobo();
    	ajusteDeNivel();
    }
    
    
    public void nivelDoJogo(int nivel) {
    	this.nivel = nivel;
    }
    public void ajusteDeNivel() {
    	if (nivel <= 1) {
    		this.velocidadeDoRobo = 1;
    		seguirOheroi();
    	}else if (nivel == 2) {
    		this.velocidadeDoRobo = 1;
    		seguirOheroi();
    	}else if (nivel == 3) {
    		this.velocidadeDoRobo = 1;
    		seguirOheroi();
    		
    	}else if (nivel == 4) {
    		seguirOheroi();
    		this.velocidadeDoRobo = 1;
    		
    	}
    }
    public void seguirOheroi() {
//    	while(this.posRoboY < posHeroiY) {
//    		this.lRobo.setLocation(this.lRobo.getX(), this.lRobo.getY() + 1);
//    	}
//    	while(this.posRoboY > posHeroiY) {
//    		this.lRobo.setLocation(this.lRobo.getX(), this.lRobo.getY() - 1);
//    	}
    	
  
    }
    
    public void movimentoDaRobo() {
        if (cont == 0 || cont == velRobo) {
//            velocidadeDoCacto = 3;
            this.lRobo.setLocation((this.lRobo.getX() - velocidadeDoRobo), this.lRobo.getY());
            cont ++;
        }else{
            cont = 0;
        }
    }
    
    public void matarRoboPorSair() {
        if (this.lRobo.getX() < -lRobo.getHeight()){
            mateORobo();
        }
    }

    public void mateORobo() {
        this.lRobo.setLocation(this.posRoboX, this.posRoboY);
    }
    @Override
    public void run() {
        while (true){
            try {sleep(2 );} catch (Exception erro) {}
            atualizarMovimentosDosRobos();
            

        }
    }
    
    public void atualizarPosHeroi(int posHeroiX, int posHeroiY){
//    	this.posHeroiX = posHeroiX;
//    	this.posHeroiY = posHeroiY;
    	
    }

    // METODOS ACESSORES

    
    public JLabel getlCacto() {
        return lRobo;
    }

    public void matarCactoPorTiro() {
        mateORobo();
    }
}
