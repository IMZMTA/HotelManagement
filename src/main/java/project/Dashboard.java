package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
        String user;
        JMenu hotel,admin;
        JMenuItem addEmp,addRoom,reception,addDriver;
        Dashboard(String username){
            this.user = username;

            setTitle("Dashboard");
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1500, 1000);
            add(image);

            JLabel text = new JLabel("Paradise Point Welcomes You");
            text.setBounds(500, 80, 1000, 50);
            text.setFont(new Font("Tahoma", Font.BOLD, 40));
            text.setForeground(Color.GREEN);
            image.add(text);

            JMenuBar menuBar = new JMenuBar();
            menuBar.setBounds(0, 0, 1500, 30);
            image.add(menuBar);

            hotel = new JMenu("Hotel Management");
            hotel.setForeground(Color.RED);
            menuBar.add(hotel);

            reception = new JMenuItem("Reception");
            reception.setForeground(Color.RED);
            reception.addActionListener(this);
            hotel.add(reception);

            admin = new JMenu("Admin");
            admin.setForeground(Color.BLUE);
            menuBar.add(admin);

            addEmp = new JMenuItem("Add Employee");
            addEmp.setForeground(Color.BLUE);
            addEmp.addActionListener(this);
            admin.add(addEmp);

            addRoom = new JMenuItem("Add Room");
            addRoom.setForeground(Color.BLUE);
            addRoom.addActionListener(this);
            admin.add(addRoom);

            addDriver = new JMenuItem("Add Driver");
            addDriver.setForeground(Color.BLUE);
            addDriver.addActionListener(this);
            admin.add(addDriver);

            getContentPane().setBackground(Color.LIGHT_GRAY);
            setBounds(10, 10, 1500, 1000);
            setVisible(true);

        }

    public static void main(String[] args) {

            new Dashboard("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Room")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Driver")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
}