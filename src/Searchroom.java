import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Searchroom extends JFrame implements ActionListener {
    JTable table ;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    Searchroom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

     JLabel text=new JLabel("Search for Rooms");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));
     text.setBounds(400,30,200,30);
     add(text);

     JLabel lblbed=new JLabel("Bed Type");
     lblbed.setBounds(50,100,100,20);
     add(lblbed);
     bedType=new JComboBox(new String[]{"Single Bed","Double Bed"});
     bedType.setBounds(150,100,150,25);
     bedType.setBackground(Color.WHITE);
     add(bedType);

     available=new JCheckBox("Only Display Available");
     available.setBounds(650,100,150,25);
     available.setBackground(Color.WHITE);
     add(available);
        // Table Hedader For name
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);

        // Table Hedader For Availbilty
        JLabel l2=new JLabel("Availabilty");
        l2.setBounds(170,160,100,20);
        add(l2);
//
        // Table Hedader For Status
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);

        // Table Hedader For Price
        JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);

        // Table Hedader For BedType
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
// Adding  a Table
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }
        // Submit Button
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        // Back Button
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
        try{
            String query1="select * from room where bed_type='"+bedType.getSelectedItem()+"'";
            String query2="select * from room where availablility='Available' And bed_type='"+bedType.getSelectedItem()+"'";
            Conn conn=new Conn();
            ResultSet rs;
            if (available.isSelected()){
            rs=conn.s.executeQuery(query2);
            }else {
        rs=conn.s.executeQuery(query1);
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        }else {
        setVisible(false);
        new Reception();
    }
    }
    public static void main(String[] args) {
        new Searchroom();
    }
}

