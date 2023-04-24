import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Managerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Managerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Table Hedader For name
        JLabel l1=new JLabel("Name ");
        l1.setBounds(40,10,100,20);
        add(l1);

        // Table Hedader For Availbilty
        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
//
        // Table Hedader For Status
        JLabel l3=new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);

        // Table Hedader For Price
        JLabel l4=new JLabel("Job");
        l4.setBounds(400,10,100,20);
        add(l4);

        // Table Hedader For BedType
        JLabel l5=new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        // Table Hedader For BedType
        JLabel l6=new JLabel("Phone");
        l6.setBounds(670,10,100,20);
        add(l6);
        // Table Hedader For BedType
        JLabel l7=new JLabel("Email");
        l7.setBounds(790,10,100,20);
        add(l7);
        // Table Hedader For BedType
        JLabel l8=new JLabel("Aadhar");
        l8.setBounds(910,10,100,20);
        add(l8);
// Adding  a Table
        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from employee where job='Manager'");
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
        new Managerinfo();
    }
}


