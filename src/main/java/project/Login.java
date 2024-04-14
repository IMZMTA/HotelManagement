package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField usertext;
    JPasswordField passtext;
    JButton login,cancel;

        Login(){
            setTitle("Login");
            setLayout(null);

            JLabel user = new JLabel("Username : ");
            user.setBounds(20,30,100,30);
            user.setFont(new Font("Times New Roman",Font.BOLD,18));
            add(user);

            usertext = new JTextField();
            usertext.setBounds(130,30,200,30);
            add(usertext);

            JLabel pass = new JLabel("Password : ");
            pass.setBounds(20,80,100,30);
            pass.setFont(new Font("Times New Roman",Font.BOLD,18));
            add(pass);

            passtext = new JPasswordField();
            passtext.setBounds(130,80,200,30);
            add(passtext);

            login = new JButton("Login");
            login.setBounds(20,135,100,30);
            login.setFont(new Font("Times New Roman",Font.BOLD,18));
            login.setBackground(Color.DARK_GRAY);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);
            
            cancel = new JButton("Cancel");
            cancel.setBounds(170,135,100,30);
            cancel.setFont(new Font("Times New Roman",Font.BOLD,18));
            cancel.setBackground(Color.DARK_GRAY);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            add(cancel);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
            Image i2 = i1.getImage().getScaledInstance(195,220,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(380,10,200,200);
            add(image);

            getContentPane().setBackground(Color.LIGHT_GRAY);
            setBounds(500, 200, 600, 300);
            setVisible(true);

        }

    public static void main(String[] args) {

        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            String username = usertext.getText();
            String password = passtext.getText();
            try{
                Conn conn = new Conn();
                String query = "SELECT * FROM login WHERE username='"+username+"' and password='"+password+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
}