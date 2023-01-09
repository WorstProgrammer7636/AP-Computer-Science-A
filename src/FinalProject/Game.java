package FinalProject;

import java.awt.Color;
import java.awt.Graphics;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Font;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Game extends Canvas implements Runnable, KeyListener, ActionListener
{
    private boolean gameIsOngoing;

    private boolean isPlacingDartMonkey;
    private boolean isPlacingNinjaMonkey;
    private boolean notEnoughMoney = false;
    private int money = 700;
    private int topBalloon = -1;
    private int currentBalloon = 0;
    private int topRound = -1;
    private int currentRound = 0;
    private int topMonkey = 0;
    private int currentMonkey = 0;
    private int playerHealth = 20;
    private int topHealth = 0;
    private boolean pause = false;
    private boolean once = true;

    private BufferedImage back;
    private int postRoundIncome = 50;
    private int width;
    private int height;
    private Color fieldColor = new Color(102,255,102);
    private javax.sound.midi.Track firstSectionTrack;
    private javax.sound.midi.Track secondSectionTrack;
    private javax.sound.midi.Track thirdSectionTrack;
    private javax.sound.midi.Track fourthSectionTrack;
    private javax.sound.midi.Track fifthSectionTrack;
    private javax.sound.midi.Track sixthSectionTrack;
    private javax.sound.midi.Track seventhSectionTrack;
    private int wait = 0;
    private int prices;

    private BalloonHorde balloonHorde;
    private MonkeyHorde monkeyHorde;
    private int round;

    public void initiateRound(int round){
        currentRound = round;
        money += postRoundIncome;
        if (round == 1){
            for (int i = 0; i < 20; i++){
                Balloon b = new Balloon(10 -(i*30), 30, 1);
                balloonHorde.add(b);
            }
        } else if (round == 2){
            for (int i = 0; i < 10; i++){
                Balloon b = new Balloon(10-(i*25), 30, 1);
                balloonHorde.add(b);
            }
            for (int i = 0; i < 10; i++){
                Balloon b = new Balloon(10-250-(i*33), 30, 2);
                balloonHorde.add(b);
            }
        } else if (round == 3){
            for (int i = 0; i < 15; i++){
                Balloon b = new Balloon(10-(i*30), 30, 2);
                balloonHorde.add(b);;
            }
            for (int i = 0; i < 5; i++){
                Balloon b = new Balloon(10-(i*55), 30, 3);
                balloonHorde.add(b);
            }
        } else if (round == 4){
            for (int i = 0; i < 15; i++){
                Balloon b = new Balloon(10-(i*40), 30, 1);
                balloonHorde.add(b);
            }

            for (int i = 0; i < 15; i++){
                Balloon b = new Balloon(10-400-(i*40), 30, 2);
                balloonHorde.add(b);
            }
            for (int i = 0; i < 15; i++){
                Balloon b = new Balloon(10-800-(i*33), 30, 3);
                balloonHorde.add(b);
            }
        } else if (round == 5){
            for (int i = 0; i < 15; i++){
                Balloon b = new Balloon(10-(i*30), 30, 2);
                balloonHorde.add(b);
            }
            for (int i = 0; i < 25; i++){
                Balloon b = new Balloon(10-330-(i*18), 30, 3);
            }
        } else if (round == 6){
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-(i*15), 30, 2));
            }
            for (int i = 0; i < 25; i++){
                balloonHorde.add(new Balloon(10-400-(i*25), 30, 3));
            }
            for (int i = 0; i < 1; i++){
                balloonHorde.add(new Balloon(10-1525-(i*45),30,4));
            }
        } else if (round == 7){
            for (int i = 0; i < 5; i++){
                balloonHorde.add(new Balloon(10-(i*45),30,4));
            }
        } else if (round == 8){
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-(i*15), 30, 2));
            }
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-400-(i*15), 30, 3));
            }
        } else if (round == 9){
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-(i*15), 30, 3));
            }
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-400-(i*15), 30, 3));
            }
        } else if (round == 10){
            for (int i = 0; i < 115; i++){
                balloonHorde.add(new Balloon(10-(i*13),30,2));
            }
            for (int i = 0; i < 15; i++){
                balloonHorde.add(new Balloon(10-1500-(i*40), 30, 4));
            }
        } else if (round == 11){
            for (int i = 0; i < 17; i++){
                balloonHorde.add(new Balloon(10-(i*40),30,4));
            }
            for (int i = 0; i < 40; i++){
                balloonHorde.add(new Balloon(10-680-(i*25),30,3));
            }
        } else if (round == 12){
            for (int i = 0; i < 30; i++){
                balloonHorde.add(new Balloon(10-(i*40),30,4));
            }
        } else if (round == 13){
            for (int i = 0; i < 15; i++){
                balloonHorde.add(new Balloon(10-(i*40),30,5));
            }

        }

        else {
            if (once){

                for (Monkey m : monkeyHorde.getMonkeyList()){
                    m.setAttackingStatus(false);
                }
                gameIsOngoing = true;
                pause = true;
                once = false;
            }
        }
    }

    public Game(int width, int height)
    {
        //set up the Canvas

        setBackground(fieldColor);
        firstSectionTrack = new javax.sound.midi.Track(0, 30, 200, 30);
        secondSectionTrack = new javax.sound.midi.Track(200, 30, 30, 400);
        thirdSectionTrack = new javax.sound.midi.Track(200, 400, 200, 30);
        fourthSectionTrack = new javax.sound.midi.Track(400, 30, 30, 400);
        fifthSectionTrack = new javax.sound.midi.Track(400, 30, 150, 30);
        sixthSectionTrack = new javax.sound.midi.Track(550, 30, 30, 200);
        seventhSectionTrack = new Track(550, 230, 250, 30);
        round = 1;
        balloonHorde = new BalloonHorde();
        monkeyHorde = new MonkeyHorde();
        initiateRound(round);
        try {
            BufferedReader brTest = new BufferedReader(new FileReader("persistentdata.txt"));
            String text = brTest.readLine();
            topRound = Integer.parseInt(text);
        } catch (IOException e){

        }

        JFrame frame = new JFrame();
        JButton button1 = new JButton("Start round");
        JButton button2 = new JButton("Pause round");
        JButton button3 = new JButton("Spawn monkey-$200");
        JButton button4 = new JButton("Spawn ninja-$500");

        button1.setBackground(Color.GREEN);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Game running");
                gameIsOngoing = true;
            }

        });

        button2.setBackground(Color.YELLOW);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Game paused");
                gameIsOngoing = false;
            }

        });

        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                isPlacingDartMonkey = true;
                currentMonkey+=1;
                System.out.println("Spawn dart monkey");
            }
        });

        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                isPlacingNinjaMonkey = true;
                currentMonkey+=1;
                System.out.println("Spawn ninja monkey");
            }
        });


        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                if ((event.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
                    Point point = event.getPoint();
                    int x = (int)point.getX();
                    int y = (int)point.getY();
                    //Block selection = new Block(x,y,0,0);

                    //place specific monkeys
                    if (isPlacingDartMonkey){
                        addDartMonkey(x, y);
                        isPlacingDartMonkey = false;

                    } else if (isPlacingNinjaMonkey){
                        addNinjaMonkey(x, y);
                        isPlacingNinjaMonkey = false;
                    }
                }
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //display buttons
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);


        //frame settings
        frame.getRootPane().setDefaultButton(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setLocation(300,300);
        frame.setVisible(true);

        setVisible(true);

        this.addKeyListener(this);

        new Thread(this).start();
    }

    public void update(Graphics window)
    {
        if (gameIsOngoing){
            paint(window);
        }
    }

    public void paint(Graphics window)
    {

        Graphics2D twoDGraph = (Graphics2D)window;
        if (back==null)
            back = (BufferedImage)(createImage(getWidth(),getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.WHITE);
        graphToBack.clearRect(690,10,740,40);


        graphToBack.setColor(fieldColor);
        graphToBack.fillRect(0,0,800,600);
        if (pause){
            graphToBack.setColor(Color.yellow);
            graphToBack.setFont(new Font("Font.Italis",25,25));
            try {
                BufferedReader brTest = new BufferedReader(new FileReader("persistentdata.txt"));
                String text = brTest.readLine();
                graphToBack.drawString("Top Round Passed: " + text, 20,500);
            } catch (IOException e){

            }


            graphToBack.setColor(Color.white);
            graphToBack.setFont(new Font("Font.PLAIN", 30, 30));
            if (playerHealth > 0)
            {
                graphToBack.drawString("You WIN!!", 300, 250);
            }
            else
            {
                graphToBack.drawString("You LOST!", 300, 250);
            }
            graphToBack.setColor(Color.red);
            graphToBack.drawString("Press R to retart",300,300);
            twoDGraph.drawImage(back, null, 0, 0);
            return;
        }
        graphToBack.setColor(Color.BLACK);
        graphToBack.drawString(String.valueOf("Money: $" + money), 700, 20);
        graphToBack.drawString(String.valueOf("Health: ♡" + playerHealth), 700, 40);
        graphToBack.drawString(String.valueOf("Round: ●" + round), 700, 60);
        for (int i = 0; i < monkeyHorde.getMonkeyList().size(); i++){
            if (balloonHorde.getBalloonList().size() > 0){
                //set initial target to first balloon
                int initialXTarget = balloonHorde.getBalloonList().get(0).getX();
                int initialYTarget = balloonHorde.getBalloonList().get(0).getY();
                monkeyHorde.getMonkeyList().get(i).setTarget(initialXTarget, initialYTarget);
                if (balloonHorde.getBalloonList().get(0).inRange(monkeyHorde.getMonkeyList().get(i))){
                    monkeyHorde.getMonkeyList().get(i).setAttackingStatus(true);
                } else {
                    monkeyHorde.getMonkeyList().get(i).setAttackingStatus(false);
                    for (int j = 0; j < balloonHorde.getBalloonList().size(); j++){
                        if (balloonHorde.getBalloonList().get(j).inRange(monkeyHorde.getMonkeyList().get(i))){
                            int xTarget = balloonHorde.getBalloonList().get(j).getX();
                            int yTarget = balloonHorde.getBalloonList().get(j).getY();
                            monkeyHorde.getMonkeyList().get(i).setTarget(xTarget, yTarget);
                            monkeyHorde.getMonkeyList().get(i).setAttackingStatus(true);
                        }
                    }
                }
            }
        }


        //make darts disappear /when collide
        for (int i = 0; i < monkeyHorde.getMonkeyList().size(); i++){
            for (int j = 0; j < monkeyHorde.getMonkeyList().get(i).getDartList().size(); j++){
                for (int k = 0; k < balloonHorde.getBalloonList().size(); k++){
                    if (monkeyHorde.getMonkeyList().get(i).getDartList().get(j).didCollide(balloonHorde.getBalloonList().get(k))){
                        int damageToDeal = monkeyHorde.getMonkeyList().get(i).getDamage();
                        Balloon b = balloonHorde.getBalloonList().get(k);
                        int health = b.getHealth();
                        if (health > damageToDeal)
                        {
                            if (round <= 4)
                                money += 5*damageToDeal;
                            else
                                money += 3*damageToDeal;
                        }
                        else{
                            if (round <= 4)
                                money += 5;
                            else
                                money += 3;
                        }
                        if (health == 5){
                            Balloon yellow = new Balloon (b.getX(),b.getY(),4);
                            balloonHorde.add(yellow);
                            balloonHorde.add(yellow);
                            balloonHorde.remove(k);
                        }
                        else{
                            b.damage(damageToDeal);
                        }
                        health = b.getHealth();
                        if (health <= 0){
                            currentBalloon += 1;
                            balloonHorde.remove(k);
                            k--;
                        }
                        monkeyHorde.getMonkeyList().get(i).removeDartAt(j);
                        j--;
                        continue;
                    }
                }
            }
        }
        //draw dart horde from each monkey
        for (Monkey monkey : monkeyHorde.getMonkeyList()){
            monkey.drawDartHorde(graphToBack);
            //monkey.getDartList().move();
            monkey.moveDarts();
        }

        if (balloonHorde.getBalloonList().size() == 0){
            round++;
            //pause game and display next round
            gameIsOngoing = false;
            initiateRound(round);
        }
        if (playerHealth <= 0){

            if (currentBalloon > topBalloon){
                topBalloon = currentBalloon;
                currentBalloon = 0;
            }
            if (currentRound > topRound){
                topRound = currentRound - 1;
                currentRound = 0;
                round = 1;
                File Old_File = new File("persistentdata.txt");
                Old_File.delete();
                File New_File = new File("persistentdata.txt");
                String Overwritten_Content = String.valueOf(topRound);
                try {
                    FileWriter Overwritten_File = new FileWriter(New_File, false);
                    Overwritten_File.write(Overwritten_Content);
                    Overwritten_File.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (currentMonkey > topMonkey){
                topMonkey = currentMonkey;
                currentMonkey = 0;

            }
            if (playerHealth > topHealth){
                topHealth = playerHealth;
                playerHealth = 20;
            }
            pause = true;
        }

        for (int i = 0; i < balloonHorde.getBalloonList().size(); i++){
            if (balloonHorde.getBalloonList().get(i).getX() > 800){
                int damageToDeduct = balloonHorde.getBalloonList().get(i).getHealth();
                playerHealth -= damageToDeduct;
                balloonHorde.remove(i);
                i--;
            }
        }

        balloonHorde.move();
        //draw balloon track
        firstSectionTrack.draw(graphToBack);
        secondSectionTrack.draw(graphToBack);
        thirdSectionTrack.draw(graphToBack);
        fourthSectionTrack.draw(graphToBack);
        fifthSectionTrack.draw(graphToBack);
        sixthSectionTrack.draw(graphToBack);
        seventhSectionTrack.draw(graphToBack);
        balloonHorde.draw(graphToBack);
        monkeyHorde.draw(graphToBack);
        if (!notEnoughMoney){
            graphToBack.setColor(fieldColor);
            graphToBack.fillRect(50,520,800,50);
            graphToBack.drawRect(50,520,800,50);
        }
        if (notEnoughMoney){
            graphToBack.setColor(fieldColor);
            graphToBack.fillRect(50,520,800,50);
            graphToBack.drawRect(50,520,800,50);
            graphToBack.setColor(Color.MAGENTA);
            graphToBack.setFont(new Font("Font.italic", 30, 30));
            graphToBack.drawString("Not enough money, needed money:" + prices, 50, 550);
        }
        twoDGraph.drawImage(back, null, 0, 0);
        wait += 8;
        //System.out.println("Wait: " + wait);
        if (wait > 3000){
            wait = 0;
            notEnoughMoney = false;
        }
    }


    public void addDartMonkey(int x, int y){
        Monkey dartMonkey = new DartMonkey(x, y);
        prices = dartMonkey.getPrice();
        if (money - prices >= 0){
            money -= prices;
            monkeyHorde.add(dartMonkey);
        }
        else{
            wait = 0;
            notEnoughMoney = true;
        }
    }

    public void addNinjaMonkey(int x, int y){
        Monkey ninjaMonkey = new NinjaMonkey(x, y);
        prices = ninjaMonkey.getPrice();
        if (money - prices >= 0){
            money -= prices;
            monkeyHorde.add(ninjaMonkey);
        }
        else{
            wait = 0;
            notEnoughMoney = true;
        }
    }


    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }

    public void keyPressed(KeyEvent e)
    {
        if (Character.toUpperCase(e.getKeyChar()) == 'R')
        {
            System.out.println("R works");
            gameIsOngoing = true;
            pause = false;
            monkeyHorde.clear();
            balloonHorde.clear();
            setBackground(fieldColor);
            balloonHorde = new BalloonHorde();
            monkeyHorde = new MonkeyHorde();
            initiateRound(round);
        }
    }

    public void keyReleased(KeyEvent e)
    {/*
    if (e.getKeyCode() == KeyEvent.VK_R)
    {
      keys[0] = false;
    }
    */
        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
        //no code needed here
    }

    public void actionPerformed(ActionEvent e){

    }

}


