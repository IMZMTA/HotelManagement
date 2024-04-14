package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;

    SearchRoom(){
        setTitle("Search Room");
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Bed - Type :");
        lblbed.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedType = new JComboBox(new String[]{"Single", "Double"});
        bedType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bedType.setBounds(150, 100, 150, 25);
        add(bedType);

        available = new JCheckBox("Only display Available Rooms.");
        available.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        available.setBackground(Color.lightGray);
        available.setBounds(650, 100, 250, 20);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availablity");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price ");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed - Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(10,180,1000,300);
        add(table);

        try{
            Conn conn = new Conn();
            String query = "Select * from room";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){

            }
        }catch(Exception e){
            System.out.println(e);
        }

        submit = new JButton("Submit");
        submit.setBounds(350, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(530, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {

        new SearchRoom();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String type = (String) bedType.getSelectedItem();
            System.out.println(type);
            try{
                Conn conn = new Conn();
                String query1 = "Select * from room where bed_type = '"+type+" '";
                String query2 = "Select * from room where available = 'Available' and bed_type = '"+type+" '";
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Reception().setVisible(true);
        }
    }
}