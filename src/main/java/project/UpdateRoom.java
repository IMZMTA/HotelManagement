package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice cusId;
    JTextField tfroom,tfavail,tfstatus,tfpaid,tfpending;
    JButton check,update,back;

    UpdateRoom(){

        setTitle("Update Room");
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        text.setBounds(30,20,250,30);
        add(text);

        JLabel lblId = new JLabel("Customer ID :");
        lblId.setBounds(30,80,150,20);
        add(lblId);

        cusId = new Choice();
        cusId.setBounds(200,80,150,20);
        add(cusId);

        try{
            Conn conn = new Conn();
            String query = "select * from customer";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                cusId.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number :");
        lblroom.setBounds(30,130,150,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,20);
        add(tfroom);

        JLabel lblname = new JLabel("Availablity :");
        lblname.setBounds(30,180,150,20);
        add(lblname);

        tfavail = new JTextField();
        tfavail.setBounds(200,180,150,20);
        add(tfavail);

        JLabel lblcheckIn = new JLabel("Cleaning Status :");
        lblcheckIn.setBounds(30,230,150,20);
        add(lblcheckIn);

        tfstatus = new JTextField();
        tfstatus.setBounds(200,230,150,20);
        add(tfstatus);

        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,980,450);
        setVisible(true);

    }

    public static void main(String[] args) {

        new UpdateRoom();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = cusId.getSelectedItem();
            String query = "Select * from customer where number = '"+id+"' ";
            try
            {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2 = conn.s.executeQuery("SELECT * from room where roomno = '" + tfroom.getText());
                while (rs2.next()) {
                    tfavail.setText(rs2.getString("available"));
                    tfstatus.setText(rs2.getString("clean_status"));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == update) {
            String number = cusId.getSelectedItem();
            String room = tfroom.getText();
            String avail = tfavail.getText();
            String status = tfstatus.getText();
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("Update room set available = '"+avail+"', clean_status '"+status+"' where rooomno = '"+number+"' ");

                JOptionPane.showMessageDialog(null,"Data Updated Successfully");

                setVisible(false);
                new Reception().setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        } else {

            setVisible(false);
            new Reception().setVisible(true);

        }
    }
}