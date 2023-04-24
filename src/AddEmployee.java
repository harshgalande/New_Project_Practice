import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;

    AddEmployee() {
        setLayout(null);
        // For Name
        JLabel lblname = new JLabel("FULL NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);// For Visible
// For Text Field
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

// For Age
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);// For Visible
// Text Field For Age
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        // Gender
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);// For Visible
        // Radio Button for Female
        rbmale = new JRadioButton("Female");
        rbmale.setBounds(280, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        // Radio Button for male
        rbfemale = new JRadioButton("Male");
        rbfemale.setBounds(200, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        // Group Button Male/Female
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        // Job
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);// For Visible

        //Dropdown
        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant",};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
//  For Salary
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);// For Visible

        // Text Field for salary
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
// For Phone
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);// For Visible

        // Text Field for Phone
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
// For Email
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);// For Visible

        // Text Field for Email
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        // For Adhar
        JLabel lbladhar = new JLabel("AADHAR NO");
        lbladhar.setBounds(60, 380, 120, 30);
        lbladhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbladhar);// For Visible

        // Text Field for Adhar id
        tfadhar = new JTextField();
        tfadhar.setBounds(200, 380, 150, 30);
        add(tfadhar);

        // Submit Button
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);


        // Putting Image in Add Employee Page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent Ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String adhar = tfadhar.getText();
        String gender = null;
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name Filed Should Not Be empty!");
        }
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }
        String job = (String) cbjob.getSelectedItem();
// This Method Will Throw SQL Exepction
//        try {
//            Conn conn = new Conn();
//            String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + adhar + "')";
//            conn.s.executeQuery(query);
//            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
//            setVisible(false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            Conn conn = new Conn();
            String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + adhar + "')";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }

}
