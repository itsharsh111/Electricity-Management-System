package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {
    JLabel heading,customerName, meterNum ,add, city, state,email,phone,meterText;
    JTextField nameText, addText, cityText,stateText,emailText,phoneText;
    JButton next,cancel;
    newCustomer(){
        super("New Customer");

        //creating a panel, this time we gonna add elements in panel
        JPanel panel=new JPanel();
        panel.setLayout(null);
        add(panel);
        panel.setBackground(new Color(252,186,3));

        heading=new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        customerName=new JLabel("Customer Name");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText=new JTextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum=new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meterText=new JLabel();
        meterText.setBounds(180,120,150,20);
        panel.add(meterText);

        //generating 6 digit random number for meter number
        Random ran = new Random();
        long num=ran.nextLong() % 1000000;
        meterText.setText(""+ Math.abs(num));

        add=new JLabel("Address");
        add.setBounds(50,160,100,20);
        panel.add(add);

        addText=new JTextField();
        addText.setBounds(180,160,150,20);
        panel.add(addText);

        city=new JLabel("City");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText=new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state=new JLabel("State");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText=new JTextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email=new JLabel("Email");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText=new JTextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phone=new JLabel("Phone");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText=new JTextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);//to get to know when button is pressed
        panel.add(next);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        //setting position of panel in frame
        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image img=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel imgLabel=new JLabel(i2);
        add(imgLabel,"West");

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String sname=nameText.getText();
            String smeter=meterText.getText();
            String saddress=addText.getText();
            String scity=cityText.getText();
            String sstate=stateText.getText();
            String semail=emailText.getText();
            String sphone=phoneText.getText();

            String queryCustomer="insert into new_customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+semail+"','"+sphone+"')";
            String querySignup="insert into Signup values('"+smeter+"','','"+sname+"','','')";

            //execute query
            try{a
                database c = new database();
                c.statement.executeUpdate(queryCustomer);
                c.statement.executeUpdate(querySignup);

                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new meterInfo(smeter);

            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
