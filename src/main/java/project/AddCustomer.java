package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfCustomerName,tfNumber,tfCountry,tfdeposit;
    JComboBox comboId;
    JRadioButton male,female;
    Choice croom;
    JLabel checkInTime,lblcheck;
    JButton add,back;

    AddCustomer(){
        setTitle("Add Customer");
        setLayout(null);

        JLabel text = new JLabel("New Customer Form ");
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text.setBounds(90, 10, 300, 30);
        add(text);

        JLabel lblid = new JLabel("ID :");
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblid.setBounds(10, 50, 150, 30);
        add(lblid);

        String optionsId[] = {"Aadhaar Id","Pan Card","Voter Id","Driving License","Passport"};
        comboId = new JComboBox(optionsId);
        comboId.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboId.setBounds(170,50,200,30);
        add(comboId);

        JLabel lblnumbers = new JLabel("Number :");
        lblnumbers.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblnumbers.setBounds(10, 90, 150, 30);
        add(lblnumbers);

        tfNumber = new JTextField();
        tfNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        tfNumber.setBounds(170,90,200,30);
        add(tfNumber);

        JLabel lblCustomerName = new JLabel("Customer Name :");
        lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCustomerName.setForeground(Color.BLACK);
        lblCustomerName.setBounds(10, 130, 150, 30);
        add(lblCustomerName);

        tfCustomerName = new JTextField();
        tfCustomerName.setFont(new Font("Tahoma", Font.BOLD, 16));
        tfCustomerName.setBounds(170,130,200,30);
        add(tfCustomerName);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setBounds(10, 170, 150, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.BOLD, 16));
        male.setBounds(170,170,90,30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.BOLD, 16));
        female.setBounds(280,170,90,30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblcountry.setBounds(10, 210, 150, 30);
        add(lblcountry);

        tfCountry = new JTextField();
        tfCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        tfCountry.setBounds(170,210,200,30);
        add(tfCountry);

        JLabel lblroom = new JLabel("Room Number :");
        lblroom.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblroom.setBounds(10, 250, 150, 30);
        add(lblroom);

        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query = "Select * from room where available = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        croom.setFont(new Font("Tahoma", Font.BOLD, 16));
        croom.setBounds(170,250,200,30);
        add(croom);


        lblcheck = new JLabel("Check In Time :   ");
        lblcheck.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblcheck.setBounds(10, 290, 150, 30);
        add(lblcheck);

        Date date = new Date();
        
        checkInTime = new JLabel("" + date);
        checkInTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkInTime.setBounds(170, 290, 200, 30);
        add(checkInTime);

        JLabel lbldeposit = new JLabel("Deposit :");
        lbldeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbldeposit.setBounds(10, 330, 150, 30);
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        tfdeposit.setBounds(170,330, 200,30);
        add(tfdeposit);

        add = new JButton("Add");
        add.setFont(new Font("Tahoma", Font.BOLD, 20));
        add.setBounds(10,380,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setBounds(170,380,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(380,420,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400,10,380,420);
        add(image);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(350, 200, 800, 500);
        setVisible(true);
    }

    public static void main(String[] args) {

        new AddCustomer();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = tfCustomerName.getText();
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : null;
            String country = tfCountry.getText();
            String room = croom.getSelectedItem();
            String time = checkInTime.getText();
            String deposit = tfdeposit.getText();

            try{
                Conn conn = new Conn();
                String query = "INSERT INTO customer (id, number, name, gender, country, room, time, deposit) " +
                        "VALUES ('"+id+"','"+number+"', '"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"' )";


                String q1 = "Update room set available = 'Occupied' where roomno = '"+room+"' ";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"New Customer Added succesfully");

                setVisible(false);
                new Reception();

            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
}