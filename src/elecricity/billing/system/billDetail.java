package elecricity.billing.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class billDetail extends JFrame {
    String meter;
    billDetail(String meter){
        this.meter=meter;
        setSize(700,650);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();
        try{
            database c= new database();
            String query_bill="select * from bill where meter_numer='"+meter+"'";
            ResultSet resultSet=c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception E){
            E.printStackTrace();
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,0,700,650);
        add(scrollPane);

        setVisible(true);
    }
    public static void main(String[] args) {
        new billDetail("");
    }
}
