import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Rooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2= i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        // Table Hedader For name
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);

        // Table Hedader For Availbilty
        JLabel l2=new JLabel("Availabilty");
        l2.setBounds(120,10,100,20);
        add(l2);
//
        // Table Hedader For Status
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);

        // Table Hedader For Price
        JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);

        // Table Hedader For BedType
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        add(l5);
// Adding  a Table
        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }
        // Back Button
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Reception();
    }
    public static void main(String[] args) {
        new Rooms();
    }
}
