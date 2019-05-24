package life;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameOfLife extends JFrame {

    int n, m, gen;
    Model model;
    Graphics2D big;

    BufferedImage bi = new BufferedImage(5, 5, BufferedImage.TYPE_INT_RGB);

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setVisible(true);
        Random rand = new Random();
        this.n = rand.nextInt(10) + 5;
        this.m = rand.nextInt(20) + 30;
        init();
    }

    public void paint(Graphics g){
        update(g);
    }

    public void update(Graphics g){
        Graphics g2 = (Graphics2D) g;

        big.setColor(Color.white);
        big.clearRect(0, 0, 600, 650);
        big.setColor(Color.BLACK);
        int x_pad = 25;
        int y_pad = 90;
        int step = 550 / this.n;
        big.drawString("Generation #" + gen, 30, 80);
        big.drawString("Alive: " + model.count, 230, 80);
        big.drawString("Matrix: " + this.n + "x" + this.n, 430, 80);
        for ( int x = 0; x < n; x += 1) {
            for (int y = 0; y < n; y += 1) {
                if(model.generated[x][y] == 'O'){
                    big.fillRect(x_pad + x * step, y_pad + y * step, step, step);
                }
                big.drawRect(x_pad + x * step, y_pad + y * step, step, step);
            }
        }
        g2.drawImage(bi, 0, 0, this);
    }

    public void init(){
        bi = (BufferedImage) createImage(600, 650);
        big = bi.createGraphics();
        model = new Model(n);
        gen = 1;
        while(model.count != 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
            model.generate_next();
            gen++;
        }
    }
}