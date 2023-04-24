import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer, rooms, department, allemployee, customers, managerinfo, checkout, update, roomstatus, pickup, sroom, log;

    Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // New Customer Button
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10, 30, 200, 30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        // Add Rooms Button
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        // Department
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        // All Emplyoyee
        allemployee = new JButton("All Employee");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);

        add(allemployee);

        // Cutomer Info
        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        // Manager Info
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);

        // Checkout
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        // Pending/ Update Status
        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        // Room Status Status
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10, 350, 200, 30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        //Pickup Service
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        //Search Rooms
        sroom = new JButton("Search Rooms");
        sroom.setBounds(10, 430, 200, 30);
        sroom.setBackground(Color.BLACK);
        sroom.setForeground(Color.WHITE);
        sroom.addActionListener(this);
        add(sroom);

        //Logout Button
        log = new JButton("Logout");
        log.setBounds(10, 470, 200, 30);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        add(log);
        // Adds Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        setBounds(350, 200, 800, 570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if ((ae.getSource() == newcustomer)) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Rooms();
        } else if (ae.getSource()==department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource()==allemployee) {
            setVisible(false);
            new Employeeinfo();
        } else if (ae.getSource()==managerinfo) {
            setVisible(false);
            new Managerinfo();
        } else if (ae.getSource()==customers) {
            setVisible(false);
            new Customerinfo();
        } else if (ae.getSource()==sroom) {
            setVisible(false);
            new Searchroom();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateCheck();

        } else if (ae.getSource()==roomstatus) {
            setVisible(false);
            new  UpdateRoom();
            
        } else if (ae.getSource()==pickup) {
            setVisible(false);
            new Pickup();
        }else if (ae.getSource()==log){
            setVisible(false);
           // System.exit(0); For Direct Exit From the Window
            new Login();
        } else if (ae.getSource()==checkout) {
            setVisible(false);
            new Checkout();
            
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
