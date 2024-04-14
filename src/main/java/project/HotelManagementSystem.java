package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JButton next;

    HotelManagementSystem(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage();
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("Hotel Management System...");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 40));
        image.add(text);

        next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.GREEN);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 25));
        next.addActionListener(this);
        image.add(next);

        setSize(1366,565);
        setLocation(100,100);
        setVisible(true);

        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new HotelManagementSystem();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login().setVisible(true);
    }
}