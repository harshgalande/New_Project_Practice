import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Customerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Table Hedader For name
        JLabel l1=new JLabel("Document Type  ");
        l1.setBounds(10,10,100,20);
        add(l1);

        // Table Hedader For Availbilty
        JLabel l2=new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);
//
        // Table Hedader For Status
        JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);

        // Table Hedader For Price
        JLabel l4=new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);

        // Table Hedader For BedType
        JLabel l5=new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
        // Table Hedader For BedType
        JLabel l6=new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
        // Table Hedader For BedType
        JLabel l7=new JLabel("Checkin Time");
        l7.setBounds(760,10,100,20);
        add(l7);
        // Table Hedader For BedType
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);
// Adding  a Table
        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }
        // Back Button
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Customerinfo();
    }
}



