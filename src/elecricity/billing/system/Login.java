package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    //JTextField is used to create textfield
    //Choice is used for creating dropdown
    //declaring them as global cause later they will be saved in backend database
    JTextField userText, passText;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;
    Login(){

        super("Login");
        getContentPane().setBackground(Color.white);//to change background color

        //JLabel is used to display texts and images in frame
        JLabel username = new JLabel("Username");
        username.setBounds(300,60,100,20);//manually set pos and size-->x,y,width,height
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);


        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);//manually set pos and size-->x,y,width,height
        add(password);

        passText = new JTextField();
        passText.setBounds(400,100,150,20);
        add(passText);

        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300,140,100,20);//manually set pos and size-->x,y,width,height
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);

        loginButton=new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton=new JButton("Signup");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne=new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo=profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(5,5,250,250);
        add(profileLabel);

        setSize(640,300);
        setLocation(400,200);
        setLayout(null);//telling java not to use layout manager, every position and size will be set manually
        setVisible(true);
    }

    @java.lang.Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource()==loginButton){
            //check in database for id and pass then do accordingly
            String susername=userText.getText();
            String spass=passText.getText();
            String suser = loginChoice.getSelectedItem();

            try{
                database c =new database();
                String query="select * from Signup where username ='"+susername+"' and password='"+spass+"' and usertype='"+suser+"'";
                ResultSet resultSet=c.statement.executeQuery(query);
                if(resultSet.next()){
                    String meter=resultSet.getString("meter_numer");
                    setVisible(false);
                    new main_class(suser,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==signupButton){
            setVisible(false);
            new Signup();
        }
        else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
