package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice cusId;
    JTextField tfroom,tfname,tfcheckIn,tfpaid,tfpending;
    JButton check,update,back;

    UpdateCheck(){

        setTitle("Update Check");
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        text.setBounds(90,20,200,30);
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
        lblroom.setBounds(30,120,150,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,20);
        add(tfroom);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30,160,150,20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,20);
        add(tfname);

        JLabel lblcheckIn = new JLabel("CheckIn Time :");
        lblcheckIn.setBounds(30,200,150,20);
        add(lblcheckIn);

        tfcheckIn = new JTextField();
        tfcheckIn.setBounds(200,200,150,20);
        add(tfcheckIn);

        JLabel lblpaid = new JLabel("Amount Paid :");
        lblpaid.setBounds(30,240,150,20);
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,20);
        add(tfpaid);

        JLabel lblpending = new JLabel("Pending Amount :");
        lblpending.setBounds(30,280,150,20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,20);
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(30,320,100,25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,320,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,320,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage();
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,980,500);
        setVisible(true);

    }

    public static void main(String[] args) {

        new UpdateCheck();

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
                        tfname.setText(rs.getString("name"));
                        tfcheckIn.setText(rs.getString("time"));
                        tfpaid.setText(rs.getString("deposit"));
                    }
                    ResultSet rs2 = conn.s.executeQuery("SELECT * from room where roomno = '" + tfroom.getText());
                    while (rs2.next()) {
                        String price = rs2.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                        tfpending.setText("" + amountPaid);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            } else if (ae.getSource() == update) {
                String number = cusId.getSelectedItem();
                String room = tfroom.getText();
                String name = tfname.getText();
                String checkIn = tfcheckIn.getText();
                String deposit = tfpaid.getText();
                try{
                    Conn conn = new Conn();
                    conn.s.executeUpdate("Update customer set room = '"+room+"', name = '"+name+"', time = '"+checkIn+"', deposit = '"+deposit+"' where roomno = '"+number+"' ");

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