package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameField, emailField, ageField, salaryField, aadhaarField, phoneField;
    JRadioButton male, female,other;
    JButton addEmployeeButton;
    JComboBox jobField;

        AddEmployee(){

            setTitle("Add Employee");
            setLayout(null);

            JLabel nameLabel = new JLabel("Name : ");
            nameLabel.setBounds(60, 20, 100, 30);
            nameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            nameLabel.setForeground(Color.BLACK);
            add(nameLabel);

            nameField = new JTextField();
            nameField.setBounds(170, 20, 300, 30);
            nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(nameField);

            JLabel emailLabel = new JLabel("Email : ");
            emailLabel.setBounds(60, 60, 100, 30);
            emailLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            emailLabel.setForeground(Color.BLACK);
            add(emailLabel);

            emailField = new JTextField();
            emailField.setBounds(170, 60, 300, 30);
            emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(emailField);

            JLabel ageLabel = new JLabel("Age : ");
            ageLabel.setBounds(60, 100, 100, 30);
            ageLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            ageLabel.setForeground(Color.BLACK);
            add(ageLabel);

            ageField = new JTextField();
            ageField.setBounds(170, 100, 300, 30);
            ageField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(ageField);

            JLabel genderLabel = new JLabel("Gender : ");
            genderLabel.setBounds(60, 140, 100, 30);
            genderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            genderLabel.setForeground(Color.BLACK);
            add(genderLabel);

            male = new JRadioButton("Male");
            male.setBounds(170, 140, 90, 30);
            male.setFont(new Font("Tahoma", Font.PLAIN, 17));
            male.setForeground(Color.BLACK);
            male.setOpaque(false);
            add(male);

            female = new JRadioButton("Female");
            female.setBounds(275, 140, 90, 30);
            female.setFont(new Font("Tahoma", Font.PLAIN, 17));
            female.setForeground(Color.BLACK);
            female.setOpaque(false);
            add(female);

            other = new JRadioButton("Other");
            other.setBounds(380, 140, 90, 30);
            other.setFont(new Font("Tahoma", Font.PLAIN, 17));
            other.setForeground(Color.BLACK);
            other.setOpaque(false);
            add(other);

            ButtonGroup group = new ButtonGroup();
            group.add(male);
            group.add(female);
            group.add(other);

            JLabel jobLabel = new JLabel("Job : ");
            jobLabel.setBounds(60, 180, 100, 30);
            jobLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            jobLabel.setForeground(Color.BLACK);
            add(jobLabel);

            String jobstr[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Services", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
            jobField = new JComboBox(jobstr);
            jobField.setBounds(170, 180, 300, 30);
            jobField.setFont(new Font("Tahoma", Font.PLAIN, 17));
            add(jobField);

            JLabel salaryLabel = new JLabel("Salary : ");
            salaryLabel.setBounds(60, 220, 100, 30);
            salaryLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            salaryLabel.setForeground(Color.BLACK);
            add(salaryLabel);

            salaryField = new JTextField();
            salaryField.setBounds(170, 220, 300, 30);
            salaryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(salaryField);

            JLabel phoneLabel = new JLabel("Phone : ");
            phoneLabel.setBounds(60, 260, 100, 30);
            phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            phoneLabel.setForeground(Color.BLACK);
            add(phoneLabel);

            phoneField = new JTextField();
            phoneField.setBounds(170, 260, 300, 30);
            phoneField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(phoneField);

            JLabel aadhaarLabel = new JLabel("Adhaar : ");
            aadhaarLabel.setBounds(60, 300, 100, 30);
            aadhaarLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            aadhaarLabel.setForeground(Color.BLACK);
            add(aadhaarLabel);

            aadhaarField = new JTextField();
            aadhaarField.setBounds(170, 300, 300, 30);
            aadhaarField.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(aadhaarField);

            addEmployeeButton = new JButton("Add Employee");
            addEmployeeButton.setBounds(170, 340, 180, 30);
            addEmployeeButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            addEmployeeButton.setForeground(Color.BLACK);
            add(addEmployeeButton);
            addEmployeeButton.addActionListener(this);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
            Image i2 = i1.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(500, 20, 300, 350);
            add(image);

            getContentPane().setBackground(Color.LIGHT_GRAY);
            setBounds(350, 200, 850, 450);
            setVisible(true);

        }

    public static void main(String[] args) {

        new AddEmployee();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String email = emailField.getText();
        String age = ageField.getText();
        String phone = phoneField.getText();
        String salary = salaryField.getText();
        String adhaar = aadhaarField.getText();

        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : null;

        String job  = (String) jobField.getSelectedItem();

        try{
            Conn conn = new Conn();
            String query = "Insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"','"+phone+"', '"+email+"','"+adhaar+"' )";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee added successfully");

            setVisible(false);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}