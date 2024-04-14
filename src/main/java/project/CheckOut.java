package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {

    Choice custId;
    JLabel tfRoomno,tfCheckIn,tfCheckOut;
    JButton checkout,back;

    CheckOut(){

        setTitle("Check Out");
        setLayout(null);

        JLabel text = new JLabel("Check Out");
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setForeground(Color.BLUE);
        text.setBounds(100,20,150,30);
        add(text);

        JLabel lblId = new JLabel("Customer Id :");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblId.setForeground(Color.BLUE);
        lblId.setBounds(30,80,150,30);
        add(lblId);

        custId = new Choice();
        custId.setBounds(190,80,150,30);
        add(custId);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel tick = new JLabel(i3);
        tick.setBounds(360,80,20,20);
        add(tick);

        JLabel lblroom = new JLabel("Room Number :");
        lblroom.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblroom.setForeground(Color.BLUE);
        lblroom.setBounds(30,130,150,30);
        add(lblroom);

        tfRoomno = new JLabel();
        tfRoomno.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfRoomno.setForeground(Color.BLUE);
        tfRoomno.setBounds(190,130,150,30);
        add(tfRoomno);

        JLabel lblCheckin = new JLabel("CheckIn Time :");
        lblCheckin.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCheckin.setForeground(Color.BLUE);
        lblCheckin.setBounds(30,180,150,30);
        add(lblCheckin);

        tfCheckIn = new JLabel();
        tfCheckIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfCheckIn.setForeground(Color.BLUE);
        tfCheckIn.setBounds(190,180,210,30);
        add(tfCheckIn);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer");
            while (rs.next()){
                custId.add(rs.getString("number"));
                tfRoomno.setText(rs.getString("room"));
                tfCheckIn.setText(rs.getString("time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblCheckOut = new JLabel("CheckOut Time :");
        lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCheckOut.setForeground(Color.BLUE);
        lblCheckOut.setBounds(30,230,150,30);
        add(lblCheckOut);

        Date date = new Date();
        tfCheckOut = new JLabel(""+date);
        tfCheckOut.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfCheckOut.setForeground(Color.BLUE);
        tfCheckOut.setBounds(190,230,210,30);
        add(tfCheckOut);

        checkout = new JButton("Check Out");
        checkout.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,150,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,280,150,30);
        back.addActionListener(this);
        add(back);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);

        JLabel image = new JLabel(i6);
        image.setBounds(410,60,400,250);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 840, 400);
        setVisible(true);
    }

    public static void main(String[] args) {

        new CheckOut();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkout){
            try{
                String query1 = "Delete from customer where number = '"+custId+"'";
                String query2 = "Update room set available = 'Available' where roomno = '"+tfRoomno+"'";
                Conn conn = new Conn();
                conn.s.executeQuery(query1);
                conn.s.executeQuery(query2);

                JOptionPane.showMessageDialog(null,"CheckOut Done");

                setVisible(false);
                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
}