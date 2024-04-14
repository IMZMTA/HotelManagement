package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer,rooms,department,allEmp,allCust,manager,update,checkout,roomstatus,searchRoom,logout,pickup;

    Reception(){
        setTitle("Reception");
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 300, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFont(new Font("Raleway", Font.BOLD, 20));
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 300, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFont(new Font("Raleway", Font.BOLD, 20));
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Departments");
        department.setBounds(10, 110, 300, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setFont(new Font("Raleway", Font.BOLD, 20));
        department.addActionListener(this);
        add(department);

        allEmp = new JButton("All Employees");
        allEmp.setBounds(10, 150, 300, 30);
        allEmp.setBackground(Color.BLACK);
        allEmp.setForeground(Color.WHITE);
        allEmp.setFont(new Font("Raleway", Font.BOLD, 20));
        allEmp.addActionListener(this);
        add(allEmp);

        allCust = new JButton("Customer Info");
        allCust.setBounds(10, 190, 300, 30);
        allCust.setBackground(Color.BLACK);
        allCust.setForeground(Color.WHITE);
        allCust.setFont(new Font("Raleway", Font.BOLD, 20));
        allCust.addActionListener(this);
        add(allCust);

        manager = new JButton("Manager Info");
        manager.setBounds(10, 230, 300, 30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.setFont(new Font("Raleway", Font.BOLD, 20));
        manager.addActionListener(this);
        add(manager);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 300, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Raleway", Font.BOLD, 20));
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update");
        update.setBounds(10, 310, 300, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Raleway", Font.BOLD, 20));
        update.addActionListener(this);
        add(update);

        roomstatus = new JButton("Room Status");
        roomstatus.setBounds(10, 350, 300, 30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        roomstatus.addActionListener(this);
        add(roomstatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 300, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setFont(new Font("Raleway", Font.BOLD, 20));
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 300, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setFont(new Font("Raleway", Font.BOLD, 20));
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10, 470, 300, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Raleway", Font.BOLD, 20));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(350,20,400,480);
        add(image);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Reception();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer().setVisible(true);
        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Room().setVisible(true);
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department().setVisible(true);
        }else if(ae.getSource() == allEmp){
            setVisible(false);
            new EmployeeInfo().setVisible(true);
        }else if(ae.getSource() == manager){
            setVisible(false);
            new ManagerInfo().setVisible(true);
        }else if(ae.getSource() == allCust){
            setVisible(false);
            new CustomerInfo().setVisible(true);
        }else if(ae.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom().setVisible(true);
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck().setVisible(true);
        }else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom().setVisible(true);
        }else if(ae.getSource() == pickup){
            setVisible(false);
            new DriverInfo().setVisible(true);
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new CheckOut().setVisible(true);
        }else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    }
}