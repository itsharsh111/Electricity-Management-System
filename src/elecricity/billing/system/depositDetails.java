package elecricity.billing.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class depositDetails extends JFrame implements ActionListener {
    Choice searchMeterCho,searchMonthCho;
    JButton search,print,close;
    JTable table;
    depositDetails(){
        super("Deposit Details");
        getContentPane().setBackground(new Color(192,186,254));

        JLabel searchMeter = new JLabel("Search by meter number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho=new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        //get meternumber from database
        try{
            database c = new database();
            ResultSet resultSet=c.statement.executeQuery("select * from bill");
            while(resultSet.next()){
                searchMeterCho.add(resultSet.getString("meter_numer"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        //search by name
        JLabel searchMonth = new JLabel("Search by Month");
        searchMonth.setBounds(400,20,100,20);
        add(searchMonth);

        searchMonthCho=new Choice();
        searchMonthCho.setBounds(520,20,150,20);
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        add(searchMonthCho);

        table = new JTable();
        //to display whole table into frame
        try{
            database c = new database();
            ResultSet resultSet=c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception E){
            E.printStackTrace();
        }

        //to scroll through table
        JScrollPane scrollPane= new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);

        search = new JButton("Search");
        search.setBackground(Color.WHITE);
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBackground(Color.WHITE);
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        close = new JButton("Close");
        close.setBackground(Color.WHITE);
        close.setBounds(600,70,80,20);
        close.addActionListener(this);
        add(close);

        setSize(700,500);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String querySearch="select * from bill where meter_numer = '"+searchMeterCho.getSelectedItem()+"' or month='"+searchMonthCho.getSelectedItem()+"'";
            try{
                database c = new database();
                ResultSet resultSet=c.statement.executeQuery(querySearch);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new depositDetails();
    }
}
