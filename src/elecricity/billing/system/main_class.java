package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String accType,meter_pass;
    main_class(String accType, String meter_pass){
        this.accType=accType;
        this.meter_pass=meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);// full screen frame

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image=image1.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(image);
        JLabel imageLabel=new JLabel(image2);
        add(imageLabel);

        //add menu bar to frame
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        //items visible in menu bar
        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));

        //items in menu
        JMenuItem newCustomer=new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);

        JMenuItem customerDetails=new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImage=customerDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetail=new JMenuItem("Deposit Details");
        depositDetail.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositDetailsImage=depositDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetail.setIcon(new ImageIcon(depositDetailsImage));
        depositDetail.addActionListener(this);
        menu.add(depositDetail);

        JMenuItem calculateBill=new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculateBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBillImage=calculateBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);

        //adding one more item to menubar
        JMenu info=new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem upInfo=new JMenuItem("Update Information");
        upInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon upInfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upInfoImage=upInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upInfo.setIcon(new ImageIcon(upInfoImage));
        upInfo.addActionListener(this);
        info.add(upInfo);

        JMenuItem viewInfo=new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewInfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewInfoImage=viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        //adding one more item to menubar
        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem payBill=new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon payBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payBillImage=payBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImage));
        payBill.addActionListener(this);
        user.add(payBill);

        JMenuItem billDetails=new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon billDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image billDetailsImage=billDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImage));
        billDetails.addActionListener(this);
        user.add(billDetails);

        //adding one more item to menubar
        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem genBill=new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon genBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genBillImage=genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill);

        //adding one more item to menubar
        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem notePad=new JMenuItem("Notepad");
        notePad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notePadImg=new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notePadImage=notePadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notePad.setIcon(new ImageIcon(notePadImage));
        notePad.addActionListener(this);
        utility.add(notePad);

        JMenuItem calci=new JMenuItem("Calculator");
        calci.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calciImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calciImage=calciImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calci.setIcon(new ImageIcon(calciImage));
        calci.addActionListener(this);
        //calci.setBackground(new Color());----> if u wanna add color
        utility.add(calci);

        //adding one more item to menubar
        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem eexit=new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon eexitImg=new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image eexitImage=eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if(accType.equals("Admin")){
            menuBar.add(menu);
        }
        else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        if(msg.equals("New Customer")){
            new newCustomer();
        }
        else if(msg.equals("Customer Details")){
            new customerDetails();
        }
        else if(msg.equals("Deposit Details")){
            new depositDetails();
        }
        else if(msg.equals("Calculate Bill")){
            new calculateBill();
        }
        else if(msg.equals("View Information")){
            new viewInformation(meter_pass);
        }
        else if(msg.equals("Update Information")){
            new updateInformation(meter_pass);
        }
        else if(msg.equals("Bill Details")){
            new billDetail(meter_pass);
        }
        else if(msg.equals("Calculator")){
            //open calculator from system(laptop)
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(msg.equals("Notepad")){
            //open notepad
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill")){
            new payBill(meter_pass);
        }
        else if(msg.equals("Generate Bill")){
            new generateBill(meter_pass);
        }
    }

    public static void main(String[] args) {

        new main_class("","");
    }
}
