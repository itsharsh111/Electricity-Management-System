//this class is not being used as html is not loaded properly

package elecricity.billing.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paymentBill extends JFrame implements ActionListener {
    JButton back;
    String meter;
    paymentBill(String meter){
        this.meter=meter;
        JEditorPane j =new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/online-payments");
            j.setBounds(400,150,800,600);
        }catch (Exception E){
            E.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Error!! <html>Error!! <html>Error!! <html>Error!! <html>Error!!");
        }

        JScrollPane pane = new JScrollPane(j);
        setLayout(null);
        pane.setBounds(0,70,800,500);
        add(pane);

        back=new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        add(back);

        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new payBill(meter);
    }

    public static void main(String[] args) {
        new paymentBill("");
    }
}
