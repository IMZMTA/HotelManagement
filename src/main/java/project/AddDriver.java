package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JTextField tfname,tfage,tfcompany,comCarModel,tfloc;
    JComboBox comboBox,tfgender;
    JButton addDriver,cancel;

    AddDriver(){
        setLayout(null);

        JLabel text = new JLabel("Add Driver");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(150,20,150,20);
        add(text);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(60,80,160,30);
        add(lblNewLabel);

        tfname = new JTextField();
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfname.setBounds(220,80,230,30);
        add(tfname);

        JLabel lblage = new JLabel("Age :");
        lblage.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblage.setBounds(60,130,150,30);
        add(lblage);

        tfage = new JTextField();
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfage.setBounds(220,130,230,30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblgender.setBounds(60,180,150,30);
        add(lblgender);

        String genderCombo[] = {"Male", "Female","Others"};
        tfgender = new JComboBox(genderCombo);
        tfgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tfgender.setBounds(220,180,230,30);
        add(tfgender);

        JLabel company = new JLabel("Car Company :");
        company.setFont(new Font("Tahoma", Font.BOLD, 20));
        company.setBounds(60,230,150,30);
        add(company);

        tfcompany = new JTextField();
        tfcompany.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfcompany.setBounds(220,230,230,30);
        add(tfcompany);

        JLabel lblbedType = new JLabel("Car Model :");
        lblbedType.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblbedType.setBounds(60,280,150,30);
        add(lblbedType);

        comCarModel = new JTextField();
        comCarModel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comCarModel.setBounds(220,280,230,30);
        add(comCarModel);

        JLabel available = new JLabel("Available :");
        available.setFont(new Font("Tahoma", Font.BOLD, 20));
        available.setBounds(60,330,150,30);
        add(available);

        String combo[] = {"Available","Occupied","Others"};
        comboBox = new JComboBox(combo);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox.setBounds(220,330,230,30);
        add(comboBox);

        JLabel loc = new JLabel("Location : ");
        loc.setFont(new Font("Tahoma", Font.BOLD, 20));
        loc.setBounds(60,380,150,30);
        add(loc);

        tfloc = new JTextField();
        tfloc.setFont(new Font("Tahoma",Font.PLAIN,20));
        tfloc.setBounds(220,380,230,30);
        add(tfloc);

        addDriver = new JButton("Add Driver");
        addDriver.setFont(new Font("Tahoma", Font.BOLD, 20));
        addDriver.setBounds(75,430,170,30);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancel.setBounds(255,430,170,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(470, 30, 450, 350);
        add(image);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,980,530);
        setVisible(true);
    }

    public static void main(String[] args) {

        new AddDriver();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addDriver){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) tfgender.getSelectedItem();
            String company = tfcompany.getText();
            String model = comCarModel.getText();
            String available = (String) comboBox.getSelectedItem();
            String location = tfloc.getText();

            try{
                Conn conn = new Conn();
                String query = "Insert into driver values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Driver Added");

                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
        }
    }
}