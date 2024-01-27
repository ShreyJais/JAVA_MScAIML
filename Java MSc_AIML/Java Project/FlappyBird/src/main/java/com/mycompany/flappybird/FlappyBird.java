package com.mycompany.flappybird;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public final class FlappyBird implements ActionListener,KeyListener{
     public static void main(String[] args) throws Exception {
        flappybird = new FlappyBird();
    }

    public static FlappyBird flappybird;
    public BirdRenderer renderer;
    public Rectangle bird;
    public int ticks, yMotion, score;
    public ArrayList<Rectangle> obstaclesList;
    public Random random;
    public boolean gameOver, gameStarted;

    public final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 800;

    public FlappyBird() {

        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);
        renderer = new BirdRenderer();
        random = new Random();

        jframe.add(renderer);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setTitle("Flappy Bird Game");
        jframe.setVisible(true);

        bird = new Rectangle(SCREEN_WIDTH / 2 - 10, SCREEN_HEIGHT / 2 - 10, 20, 20);
        obstaclesList = new ArrayList<>();

        addObstacle(true);
        addObstacle(true);
        addObstacle(true);
        addObstacle(true);

        timer.start();
    }

    public void addObstacle(boolean startGame) {

        int space = 300;
        int width = 100;
        int height = 50 + random.nextInt(300); // Min height 50, max height 300.

        if (startGame) {

            obstaclesList.add(new Rectangle(SCREEN_WIDTH + width + obstaclesList.size() * 300, SCREEN_HEIGHT - height - 120, width, height)); // Place
                                                                                                                    // a
                                                                                                                    // column/pipe.
            obstaclesList.add(new Rectangle(SCREEN_WIDTH + width + (obstaclesList.size() - 1) * 300, 0, width, SCREEN_HEIGHT - height - space)); // Place
                                                                                                                       // a
                                                                                                                       // column/pipe.
        } else {

            obstaclesList.add(new Rectangle(obstaclesList.get(obstaclesList.size() - 1).x + 600, SCREEN_HEIGHT - height - 120, width, height)); // Place
                                                                                                                       // a
                                                                                                                       // column/pipe.
            obstaclesList.add(new Rectangle(obstaclesList.get(obstaclesList.size() - 1).x, 0, width, SCREEN_HEIGHT - height - space)); // Place a
                                                                                                              // column/pipe.
        }

    }

    public void paintObstacle(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker().darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }

    public void makeJump() {

        if (gameOver) {
            bird = new Rectangle(SCREEN_WIDTH / 2 - 10, SCREEN_HEIGHT / 2 - 10, 20, 20);
            obstaclesList.clear();
            yMotion = 0;
            score = 0;
            addObstacle(true);
            addObstacle(true);
            addObstacle(true);
            addObstacle(true);
            gameOver = false;
        }

        if (!gameStarted) {
            gameStarted = true;
        } else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }
            yMotion -= 10;
        }
    }

    // To render multiple times, use our Renderer.
      @Override
    public void actionPerformed(ActionEvent arg0) {
        int speed = 10;
        ticks++;
        if (gameStarted) {
            for (int i = 0; i < obstaclesList.size(); i++) {
                Rectangle obstacle = obstaclesList.get(i);
                obstacle.x -= speed;
            }
            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            for (int i = 0; i < obstaclesList.size(); i++) {
                Rectangle obstacle = obstaclesList.get(i);
                if (obstacle.x + obstacle.width < 0) {
                    obstaclesList.remove(obstacle);
                    if (obstacle.y == 0) {
                        addObstacle(false);
                    }
                }
            }

            bird.y += yMotion;

            for (Rectangle obstacle : obstaclesList) {

                if (obstacle.y == 0 && bird.x + bird.width / 2 > obstacle.x + obstacle.width / 2 - 10 && bird.x + bird.width / 2 < obstacle.x + obstacle.width / 2 + 10) {

                    score++;
                }

                if (obstacle.intersects(bird)) {

                    gameOver = true;

                    if (bird.x <= obstacle.x) {

                        bird.x = obstacle.x - bird.width;

                    } else {
                        
                        if (obstacle.y != 0) {
                            
                            bird.y = obstacle.y - bird.height;

                        } else if (bird.y < obstacle.height) {
                            
                            bird.y = obstacle.height;
                        }
                    }
                }
            }

            if (bird.y > SCREEN_HEIGHT - 120 || bird.y < 0) {

                gameOver = true;
            }

            if (bird.y + yMotion >= SCREEN_HEIGHT - 120) {

                bird.y = SCREEN_HEIGHT - 120 - bird.height;
            }
        }
        renderer.repaint();
    }

    public void repaint(Graphics g) {
        // Background Color.
        g.setColor(Color.cyan);
        g.fillRect(0, 0, SCREEN_HEIGHT, SCREEN_WIDTH);

        // Add Ground.
        g.setColor(Color.orange);
        g.fillRect(0, SCREEN_HEIGHT - 120, SCREEN_WIDTH, 120);

        // Add Grass.
        g.setColor(Color.green);
        g.fillRect(0, SCREEN_HEIGHT - 120, SCREEN_WIDTH, 20);

        // Bird (player) icon.
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.height, bird.width);

        for (Rectangle obstacle : obstaclesList) {

            paintObstacle(g, obstacle);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 80));

        if (!gameStarted) {

            g.drawString("Click to Begin", 75, SCREEN_HEIGHT / 2 - 50);
        }

        if (gameOver) {

            g.drawString("Game Over", 100, SCREEN_HEIGHT / 2 - 50);
        }

        if (!gameOver && gameStarted) {

            g.drawString(String.valueOf(score), SCREEN_WIDTH / 2 - 25, 100);
        }
    }


      @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_SPACE) {
            makeJump();
        }
    }

      @Override
    public void keyTyped(KeyEvent e) {}
      @Override
    public void keyReleased(KeyEvent e) {}
    
}