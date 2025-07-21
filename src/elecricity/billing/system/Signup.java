package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener{//Actionlistener bor buttons to work

    Choice loginAsCho;
    JTextField meterText, employerText, userText, nameText, passText;
    JButton create,back;
    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho=new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,125,20);
        add(loginAsCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new JTextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel employer = new JLabel("Employer id ");
        employer.setBounds(30,100,125,20);
        employer.setVisible(true);
        add(employer);

        employerText = new JTextField();
        employerText.setBounds(170,100,125,20);
        employerText.setVisible(true);
        add(employerText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

        userText = new JTextField();
        userText.setBounds(170,140,125,20);
        add(userText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText = new JTextField("");
        nameText.setBounds(170,180,125,20);
        add(nameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    database c = new database();
                    ResultSet resultSet=c.statement.executeQuery("select * from Signup where meter_numer='"+meterText.getText()+"'");
                    if(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passText = new JTextField();
        passText.setBounds(170,220,125,20);
        add(passText);

        //to change form based on Admin/customer choice
        loginAsCho.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String user=loginAsCho.getSelectedItem();
                if (user.equals("Customer")){
                    employer.setVisible(false);
                    nameText.setEditable(false);
                    employerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }
                else{
                    employer.setVisible(true);
                    employerText.setVisible(true);
                    nameText.setEditable(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        create=new JButton("Create");
        create.setBackground(new Color(66,127,219));
        create.setForeground(Color.black);
        create.setBounds(50,285,100,25);
        create.addActionListener(this);//for performing action when button is clicked
        add(create);

        back=new JButton("Back");
        back.setBackground(new Color(66,127,219));
        back.setForeground(Color.black);
        back.setBounds(180,285,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon=new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image boyImg=boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2=new ImageIcon(boyImg);
        JLabel boyLabel=new JLabel(boyIcon2);
        boyLabel.setBounds(320,30,250,250);
        add(boyLabel);

        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    //for performing action when button is clicked
    @java.lang.Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource()==create){

            //store data in backend
            //saving all user input into strings
            String sloginAs=loginAsCho.getSelectedItem();
            String susername=userText.getText();
            String sname=nameText.getText();
            String spass=passText.getText();
            String smeter=meterText.getText();

            //storing in database
            try{
                database c =new database();
                String query = null;
                if(sloginAs.equals("Admin")){
                    query="insert into Signup values('"+smeter+"','"+susername+"','"+sname+"','"+spass+"','"+sloginAs+"')";
                }
                else{
                    query="update Signup set username = '"+susername+"', password='"+spass+"', usertype='"+sloginAs+"' where meter_numer='"+smeter+"' ";
                }
                c.statement.executeUpdate(query);

                // to display success msg after storing and closing signup window
                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
