import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroomno,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // For Add Rooms
        JLabel heading =new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        //For Room Number
        JLabel lblroomno =new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
         tfroomno=new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);
        // Room Available
        JLabel lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        String availableoptions[]={"Available","Occupied"};
         availablecombo=new JComboBox(availableoptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        JLabel lblclean =new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        String cleanleoptions[]={"Cleaned","Dirty"};
         cleancombo=new JComboBox(cleanleoptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        JLabel lblprice =new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
         tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lbltype =new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        String typeoptions[]={"Single Bed","Double Bed"};
         typecombo=new JComboBox(typeoptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);
// Add Button
         add=new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        // Cancel Biutton
         cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        // Image Adding
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);


        setBounds(330,200,940,470);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
    if (ae.getSource()==add){
        String roomnumber=tfroomno.getText();
        String availablilty=(String) availablecombo.getSelectedItem();
        String status=(String)  cleancombo.getSelectedItem();
        String price=tfprice.getText();
        String type=(String) typecombo.getSelectedItem();
         try {
        Conn conn=new Conn();
        String str="insert into room values('" + roomnumber + "','" + availablilty + "','" + status+ "','" + price + "','" + type + "')";
             conn.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"New Room Added Successfully !");
             setVisible(false);
         }catch (Exception e){
             e.printStackTrace();
         }

    } else {
        setVisible(false);
    }
    }
    public static void main(String[] args) {
        new AddRooms();

    }
}
