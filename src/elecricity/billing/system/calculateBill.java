package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculateBill extends JFrame implements ActionListener {
    JLabel meterNum,name,nameText,address,addressText,unitConsumed,month;
    JTextField unitConsumedText;
    Choice meterNumCho,monthCho;
    JButton submit,cancel;
    calculateBill(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        meterNum=new JLabel("Meter Number");
        meterNum.setBounds(50,80,100,20);
        panel.add(meterNum);

        meterNumCho=new Choice();
        //retrieving meter numbers from dataset
        try{
            database c = new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                meterNumCho.add(resultSet.getString("meter_numer"));

            }
        }catch(Exception E){
            E.printStackTrace();
        }
        meterNumCho.setBounds(180,80,100,20);
        panel.add(meterNumCho);

        name=new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText=new JLabel("");
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        address=new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText=new JLabel("");
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        //getting name and address according to meter number from database
        try{
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_numer='"+meterNumCho.getSelectedItem()+"'");
            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        //update name and address in frame when changing meter number from dropdown
        meterNumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    database c=new database();
                    ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_numer='"+meterNumCho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        unitConsumed=new JLabel("Units Consumed:");
        unitConsumed.setBounds(50,200,100,20);
        panel.add(unitConsumed);

        unitConsumedText=new JTextField();
        unitConsumedText.setBounds(180,200,150,20);
        panel.add(unitConsumedText);

        month=new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho=new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(180,240,150,20);
        panel.add(monthCho);

        submit=new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image img=i1.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel imgLabel = new JLabel(i2);
        add(imgLabel,"East");

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeterNo=meterNumCho.getSelectedItem();
            String sunit=unitConsumedText.getText();
            String smonth =monthCho.getSelectedItem();

            //calculate bill
            int totalBill=0;
            int units=Integer.parseInt(sunit);
            String query_tax="select * from tax";

            try{
                database c = new database();
                ResultSet resultSet=c.statement.executeQuery(query_tax);
                while(resultSet.next()){
                    totalBill+=units*Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill+=Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill+=Integer.parseInt(resultSet.getString("service_tax"));
                    totalBill+=Integer.parseInt(resultSet.getString("swacch_bharat"));
                    totalBill+=Integer.parseInt(resultSet.getString("fixed_tax"));
                }
            }catch(Exception E){
                E.printStackTrace();
            }

            //storing data in bill database
            String query_total_bill="insert into bill values ('"+smeterNo+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";
            try{
                database c = new database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null,"Customer Bill updated Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new calculateBill();
    }
}
