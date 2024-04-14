package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JTextField tfroom,tfprice;
    JComboBox combo,cleancombo,bedcombo;
    JButton addroom,cancel;

        AddRooms(){
            setTitle("Add Rooms");
            setLayout(null);

            JLabel text = new JLabel("Add Room");
            text.setFont(new Font("Tahoma", Font.BOLD, 20));
            text.setBounds(150,20,150,20);
            add(text);

            JLabel lblNewLabel = new JLabel("Room Number:");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblNewLabel.setBounds(60,80,160,30);
            add(lblNewLabel);

            tfroom = new JTextField();
            tfroom.setFont(new Font("Tahoma", Font.PLAIN, 20));
            tfroom.setBounds(220,80,200,30);
            add(tfroom);

            JLabel lblavailable = new JLabel("Available :");
            lblavailable.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblavailable.setBounds(60,130,150,30);
            add(lblavailable);

            String availOptions[] = {"Available","Occupied","Reserved"};
            combo = new JComboBox(availOptions);
            combo.setFont(new Font("Tahoma", Font.PLAIN, 20));
            combo.setBounds(220,130,200,30);
            add(combo);

            JLabel lblclean = new JLabel("Room Status :");
            lblclean.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblclean.setBounds(60,180,150,30);
            add(lblclean);

            String cleanOptions[] = {"Cleaned","Dirty","In-Process"};
            cleancombo = new JComboBox(cleanOptions);
            cleancombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
            cleancombo.setBounds(220,180,200,30);
            add(cleancombo);

            JLabel lblbedType = new JLabel("Bed Type :");
            lblbedType.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblbedType.setBounds(60,220,150,30);
            add(lblbedType);

            String bedOptions[] = {"Single","Double"};
            bedcombo = new JComboBox(bedOptions);
            bedcombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
            bedcombo.setBounds(220,220,200,30);
            add(bedcombo);

            JLabel price = new JLabel("Price :");
            price.setFont(new Font("Tahoma", Font.BOLD, 20));
            price.setBounds(60,260,150,30);
            add(price);

            tfprice = new JTextField();
            tfprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
            tfprice.setBounds(220,260,200,30);
            add(tfprice);

            addroom = new JButton("Add Room");
            addroom.setFont(new Font("Tahoma", Font.BOLD, 20));
            addroom.setBounds(60,300,150,30);
            addroom.addActionListener(this);
            add(addroom);

            cancel = new JButton("Cancel");
            cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
            cancel.setBounds(220,300,200,30);
            cancel.addActionListener(this);
            add(cancel);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
            Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(440, 30, 450, 320);
            add(image);

            getContentPane().setBackground(Color.LIGHT_GRAY);
            setBounds(330,200,940,470);
            setVisible(true);
        }

    public static void main(String[] args) {

        new AddRooms();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addroom){
            String room = tfroom.getText();
            String price = tfprice.getText();
            String avail = (String) combo.getSelectedItem();
            String clean = (String) cleancombo.getSelectedItem();
            String bedtype = (String) bedcombo.getSelectedItem();

            try{
                Conn conn = new Conn();
                String query = "Insert into room values('"+room+"','"+avail+"','"+clean+"','"+price +"','"+bedtype+" ')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Room Added");

                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
        }
    }
}