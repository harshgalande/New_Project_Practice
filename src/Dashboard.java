import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        // For Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1150,1000);
        add(image);
        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        // For Menu Bar for Management
        JMenuBar mb=new JMenuBar();
       mb.setBounds(0,0,1550,30 );
      image.add(mb);
      JMenu hotel=new JMenu("HOTEL MANAGEMENT");
      hotel.setForeground(Color.RED);
      mb.add(hotel);
      // For Dropdown Items
        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);


        // For Menu Bar for Admin
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        // For Dropdown Items
        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        JMenuItem adderooms=new JMenuItem("ADD ROOMS");
        adderooms.addActionListener(this);
        admin.add(adderooms);
        JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        }else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
            
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
