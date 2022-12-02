package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.*;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class OuterSpace extends Canvas implements KeyListener, Runnable
{
    private int lives = 3;
    private int score;
    private Timer alienTimer;
    private int alienInterval;

    private Ship ship;
    private Alien alienOne;
    private Alien alienTwo;

    private AlienHorde topHorde;
    private AlienHorde bottomHorde;
    private Bullets shots;
    private Bullets alienShots;

    private boolean[] keys;
    private BufferedImage back;
    private boolean pause;
    private boolean lost;
    private boolean won;

    public OuterSpace()
    {
        setBackground(Color.black);
        keys = new boolean[6];

        //instantiate other instance variables
        //Ship, Alien
        ship = new Ship(450, 450, 3);
        topHorde = new AlienHorde(10);
        bottomHorde = new AlienHorde(10);
        for (int i = 0; i < 10; i++){
            Alien alien = new Alien((i * 45) + 1, 10, 30, 30, 1);
            topHorde.add(alien);
        }
        for (int i = 0; i < 10; i++){
            Alien alien = new Alien((i * 45) + 1, 70, 30, 30, 1);
            bottomHorde.add(alien);
        }

        shots = new Bullets();
        alienShots = new Bullets();

        setVisible(true);
        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D)window;
        if (back==null)
            back = (BufferedImage)(createImage(getWidth(),getHeight()));
        Graphics graphToBack = back.createGraphics();
        if (lost){
            graphToBack.setColor(Color.BLACK);
            graphToBack.fillRect(0,0,800,600);
            graphToBack.setColor(Color.RED);
            graphToBack.drawString("You lost!", 400, 230);
            graphToBack.drawString("Your final score was: " + score, 400, 245);
            twoDGraph.drawImage(back, null, 0, 0);
        } else if (won){
            graphToBack.setColor(Color.BLACK);
            graphToBack.fillRect(0,0,800,600);
            graphToBack.setColor(Color.RED);
            graphToBack.drawString("You Won! Game Over", 400, 230);
            graphToBack.drawString("Your final score was: " + score, 400, 245);
            twoDGraph.drawImage(back, null, 0, 0);
        }
        else if (pause){
            graphToBack.setColor(Color.BLACK);
            graphToBack.fillRect(0,0,800,600);
            graphToBack.setColor(Color.RED);
            graphToBack.drawString("Lives: " + lives, 400, 230);
            graphToBack.setColor(Color.GREEN);
            graphToBack.drawString("Press R to resume game", 400, 245);
            twoDGraph.drawImage(back, null, 0, 0);
            ship.setX(450);
            ship.setY(450);
            if (keys[5]){
                pause = false;
            }
        } else {
            paint(window);
        }

    }

    public void paint( Graphics window )
    {

        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D)window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back==null)
            back = (BufferedImage)(createImage(getWidth(),getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("StarFighter ", 25, 50 );
        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0,0,800,600);

        //score and lives
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(30, 30 - 10, 150, 15);
        graphToBack.setColor(Color.BLACK);
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(650, 30 - 10, 130, 15);
        graphToBack.setColor(Color.BLACK);
        graphToBack.drawString(String.valueOf("Lives: " + lives), 30, 30);
        graphToBack.drawString(String.valueOf("Score: " + score), 650, 30);

        //add code to move Ship, Alien, etc.
        if (keys[0] && ship.getX() > 10)
        {
            ship.move("LEFT");
        }

        if (keys[1] && ship.getX() < 700){
            ship.move("RIGHT");
        }

        if (keys[2] && ship.getY() > 10){
            ship.move("UP");
        }

        if (keys[3] && ship.getY() < 500){
            ship.move("DOWN");
        }

        if (keys[4]){
            shots.add(new Ammo(ship.getX() + 22, ship.getY(), 5));
            keys[4] = false;
        }

        //draw ship ammo
        for (Ammo a : shots.getList()){
            a.draw(graphToBack);
            a.move("UP");
        }

        //draw alien ammo
        for (Ammo a : alienShots.getList()){
            a.draw(graphToBack, Color.RED);
            a.move("DOWN");
        }

        //Ship hits alien
        List<Alien> topAliens = topHorde.getAliens();
        List<Alien> bottomAliens = bottomHorde.getAliens();
        for (Alien a: topAliens){
            if (ship.didCollide(a)){
                lives--;
                if (lives == 0){
                    //game over
                    lost = true;
                } else {
                    //pause
                    alienShots.clear();
                    pause = true;
                }
            }
        }

        for (Alien a: bottomAliens){
            if (ship.didCollide(a)){
                lives--;
                if (lives == 0){
                    //game over
                    lost = true;
                } else {
                    //pause
                    alienShots.clear();
                    pause = true;
                }
            }
        }

        //check for collision from ship ammo to alien
        int topHitAmmoIndex = topHorde.calcHits(shots.getList());
        int bottomHitAmmoIndex = bottomHorde.calcHits(shots.getList());


        if (topHitAmmoIndex != -1){
            shots.remove(topHitAmmoIndex);
            score += 10;
        }

        if (bottomHitAmmoIndex != -1){
            shots.remove(bottomHitAmmoIndex);
            score += 10;
        }

        //check for collision from alien ammo to ship

        for (int i = 0; i < alienShots.getList().size(); i++){
            if (alienShots.getList().get(i).didCollide(ship)){
                alienShots.remove(i);
                i--;
                lives--;
                if (lives == 0){
                    //game over
                    lost = true;
                } else {
                    //pause
                    alienShots.clear();
                    pause = true;
                }
            }
        }

        //check for win/game over
        if (topHorde.getAliens().size() == 0 && bottomHorde.getAliens().size() == 0){
            won = true;
        }

        topHorde.move("LEFT");
        bottomHorde.move("RIGHT");

        topHorde.draw(graphToBack);
        bottomHorde.draw(graphToBack);
        shots.cleanUpEdges();
        alienShots.cleanUpEdges();

        //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
        ship.draw(graphToBack);

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_R){
            keys[5] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_R){
            keys[5] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
        //no code needed here
    }

    public void run()
    {
        try
        {
            new Task().run();
            while(true)
            {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }

    public class Task extends TimerTask{
        Timer timer = new Timer();
        @Override
        public void run(){
            int delay = 150 + (new Random().nextInt(2)) * 650;
            timer.schedule(new Task(), delay);
            int ammoSpeed = 2; //ammo speed for testing
            if (alienShots.getList().size() <= 10){
                try {
                    int randomHorde = (int)(Math.random() * 2);
                    if (randomHorde == 0){
                        //top horde
                        List<Alien> aliens = topHorde.getAliens();
                        int size = aliens.size();
                        int randomAlienIndex = (int)(Math.random() * size);

                        //spawn ammo
                        int alienX = aliens.get(randomAlienIndex).getX();
                        int alienY = aliens.get(randomAlienIndex).getY();
                        Ammo enemyRound = new Ammo(alienX, alienY, ammoSpeed);

                        //add bullet to alienshots
                        alienShots.add(enemyRound);
                    } else {
                        //bottom Horde
                        List<Alien> aliens = bottomHorde.getAliens();
                        int size = aliens.size();
                        int randomAlienIndex = (int)(Math.random() * size);

                        //spawn ammo
                        int alienX = aliens.get(randomAlienIndex).getX();
                        int alienY = aliens.get(randomAlienIndex).getY();
                        Ammo enemyRound = new Ammo(alienX, alienY, ammoSpeed);

                        //add bullet to alienshots
                        alienShots.add(enemyRound);
                    }
                } catch (Exception e){
                    //nothing happens
                }
            }

        }
    }



}

