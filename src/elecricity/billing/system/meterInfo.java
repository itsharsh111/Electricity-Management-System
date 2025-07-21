package elecricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {
    JLabel heading,meterNo,meterText,meterLoc,meterType,phaseCode,billType;
    Choice meterLocCho,meterTypeCho,phaseCodeCho,billTypeCho;
    JButton submit;
    String meterNumber;
    meterInfo(String meterNumber){
        super("Meter Info");
        this.meterNumber=meterNumber;

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading=new JLabel("Meter Info");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        meterNo=new JLabel("Meter Number");
        meterNo.setBounds(50,80,100,20);
        panel.add(meterNo);

        meterText=new JLabel(meterNumber);
        meterText.setBounds(180,80,150,20);
        panel.add(meterText);

        meterLoc=new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        meterType=new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeCho = new Choice();
        meterTypeCho.add("Electric Meter");
        meterTypeCho.add("Solar Meter");
        meterTypeCho.add("Smart Meter");
        meterTypeCho.setBounds(180,160,150,20);
        panel.add(meterTypeCho);

        phaseCode=new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        billType=new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho = new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industrial");
        billTypeCho.setBounds(180,240,150,20);
        panel.add(billTypeCho);

        JLabel day=new JLabel("30 Days Billing Time....");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note1=new JLabel("Note:-");
        note1.setBounds(50,320,100,20);
        panel.add(note1);

        JLabel note2=new JLabel("By default bill is calculated for 30 days only");
        note2.setBounds(50,340,300,20);
        panel.add(note2);

        submit=new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);

        //add panel to frame using borderLayout
        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image img=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel imgLabel=new JLabel(i2);
        add(imgLabel,"East");

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeternum=meterNumber;
            String smeterLoc=meterLocCho.getSelectedItem();
            String smeterType=meterTypeCho.getSelectedItem();
            String sphaseCode=phaseCodeCho.getSelectedItem();
            String sbillType=billTypeCho.getSelectedItem();
            String sdays="30";

            String queryMeterInfo="insert into meter_info values('"+smeternum+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sdays+"')";

            //execute query
            try{
                database c = new database();
                c.statement.executeUpdate(queryMeterInfo);

                JOptionPane.showMessageDialog(null,"Meter information submitted Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
