package com.java;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame
{
    JTextField guess, bestscore, totalguess;
    ButtonListener buttonListener;
    ButtonListener2 buttonListener2;
    ButtonListener3 buttonListener3;
    JLabel inputlabel,guesslabel,trylabel,bestscorelabel,totalguesslabel,imglabel;

    int rand= (int)(Math.random()*100);
    int count=0;
    public Main()
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        guesslabel = new JLabel("Guess!");
        guesslabel.setForeground(Color.BLACK);
        guesslabel.setFont(new Font("Georgia",Font.BOLD,23));
        guesslabel.setSize(270,20);
        guesslabel.setLocation(160,70);

        inputlabel=new JLabel("Enter a number between 1-100");
        inputlabel.setFont(new Font("Georgia",Font.PLAIN,15));
        inputlabel.setSize(250,20);
        inputlabel.setLocation(110,90);

        trylabel = new JLabel("");
        trylabel.setFont(new Font("Georgia",Font.PLAIN,14));
        trylabel.setSize(270,20);
        trylabel.setLocation(140,160);

        guess = new JTextField(10);
        guess.setSize(50,30);
        guess.setLocation(170,120);

        bestscore = new JTextField(10);
        bestscore.setSize(30,20);
        bestscore.setLocation(10,10);

        bestscorelabel = new JLabel("High Score");
        bestscorelabel.setFont(new Font("Georgia",Font.PLAIN,14));
        bestscorelabel.setSize(270,20);
        bestscorelabel.setLocation(50,10);

        totalguess = new JTextField(10);
        totalguess.setSize(30,20);
        totalguess.setLocation(300,10);

        totalguesslabel = new JLabel("Number of Guesses");
        totalguesslabel .setFont(new Font("Georgia",Font.PLAIN,14));
        totalguesslabel.setSize(270,20);
        totalguesslabel.setLocation(340,10);

        imglabel = new JLabel("");
        imglabel.setIcon(new ImageIcon("download.png"));
        imglabel.setBounds(280,10,500,350);

        JButton guessbutton =new JButton("Enter");
        guessbutton.setSize(100,30);
        guessbutton.setLocation(150,190);
        guessbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener = new ButtonListener();
        guessbutton.addActionListener(buttonListener);

        JButton giveupbutton = new JButton("Quit");
        giveupbutton.setSize(100,30);
        giveupbutton.setLocation(90,240);
        giveupbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener2 = new ButtonListener2();
        giveupbutton.addActionListener(buttonListener2);

        JButton playagainbutton = new JButton("Play Again!");
        playagainbutton.setSize(100,30);
        playagainbutton.setLocation(200,240);
        playagainbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener3 = new ButtonListener3();
        playagainbutton.addActionListener(buttonListener3);

        c.add(bestscorelabel);
        c.add(totalguesslabel);
        c.add(trylabel);
        c.add(imglabel);
        c.add(guesslabel);
        c.add(inputlabel);
        c.add(guess);
        c.add(bestscore);
        c.add(totalguess);
        c.add(guessbutton);
        c.add(giveupbutton);
        c.add(playagainbutton);

        bestscore.setEditable(false);
        totalguess.setEditable(false);
        setTitle("Mini Game: Guess the Number");
        setSize(500,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(guess.getText());
            count=count+1;
            if(a<rand)
            {
                trylabel.setText(a+" is low, try again!!");
            }
            else if(a>rand)
            {
                trylabel.setText(a+" is high, try again!!");
            }
            else
            {
                trylabel.setText("Your guess is correct, You win!!");
                if(count<bestScore)
                {
                    bestScore=count;
                    bestscore.setText(bestScore+"");
                }
                else {
                    bestscore.setText("" + bestScore);
                }
                guess.setEditable(false);
            }

            guess.requestFocus();
            guess.selectAll();
            totalguess.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            totalguess.setText("");
            trylabel.setText("The correct answer is "+rand+"!!");
            guess.setText("");
            guess.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            guess.setText("");
            totalguess.setText("");
            trylabel.setText("");
            totalguess.setText("");
            count=0;
            guess.setEditable(true);
            guess.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}