package GUI;
import EntityList.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LogIn extends JFrame implements ActionListener {

    //variable declaration
    Font font = new Font("Arial",Font.BOLD,30);
    Font font1 = new Font("Arial",Font.PLAIN,25);
    Font font2 = new Font("Arial",Font.BOLD,40);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon,img;
    private Container c;
     DoctorList doctorList;
     PatientList patientList;
     StaffList staffList;
     MorgueList morgueList;
     ServiceList serviceList;
    private JLabel luserName,lPassword,imgLabel,lUserlogin;
    private JTextField tf1;
    private JButton blogin,bSignUp;
    private JPasswordField tf2;
    
	//constructor
	public LogIn(DoctorList doctorList, PatientList patientList, StaffList staffList, MorgueList morgueList, ServiceList serviceList){
        this.doctorList = doctorList;
        this.patientList = patientList;
        this.serviceList = serviceList;
        this.staffList = staffList;
        this.morgueList = morgueList;
        insert();
        this.setVisible(true);

    }
    
	public void insert(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20,40,1300,700);
        this.setTitle("Health Mate");
        this.setResizable(false);


        c = this.getContentPane();
        c.setBackground(new Color(210,224,225));
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());

        img = new ImageIcon(getClass().getResource("Pictures/image1.png"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(5,20,800, 600);
        c.add(imgLabel);

        lUserlogin = new JLabel("User Login");
        lUserlogin.setBounds(900,100,400,50);
        lUserlogin.setFont(font2);
        c.add(lUserlogin);

        luserName = new JLabel("UserName:");
        luserName.setBounds(900,200,200,40);
        luserName.setFont(font);
        c.add(luserName);

        tf1 = new JTextField("mahmud");
        tf1.setToolTipText("Enter User Name");
        tf1.setBounds(900,250,250,30);
        tf1.setFont(font1);
        c.add(tf1);

        lPassword = new JLabel("Password:");
        lPassword.setBounds(900,290,200,40);
        lPassword.setFont(font);
        c.add(lPassword);

        tf2 = new JPasswordField("1234");
        tf2.setToolTipText("Enter Password");
        tf2.setBounds(900,340,250,30);
        tf2.setFont(font1);
        c.add(tf2);

        blogin = new JButton("Login");
        blogin.setBounds(950,390, 150,50);
        blogin.setBackground(new Color(54,119,119));
        blogin.setCursor(cursor);
        blogin.addActionListener(this);
        blogin.setFont(font1);
        c.add(blogin);

        bSignUp = new JButton("Admin Login");
        bSignUp.setBounds(935,450, 180,50);
        bSignUp.setBackground(new Color(54,119,119));
        blogin.setCursor(cursor);
        bSignUp.addActionListener(this);
        bSignUp.setFont(font1);
        c.add(bSignUp);
    }

    /*public static void main(String[] args) {

        LogIn frame = new LogIn(doctorList, patientList, staffList, morgueList, serviceList);
        frame.setVisible(true);
        frame.setResizable(false);

    }*/


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == blogin)
        {

            String username = tf1.getText().toLowerCase();
            String password = String.valueOf(tf2.getPassword());
            String file = ".\\Storage\\user_data.txt";


            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(null,"Please enter all information");
            }

            else {

                try {
                    String userNameS = "Username   : " + username;
                    String passwordS = "Password   : " + password;
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line1 = Files.readAllLines(Paths.get(file)).get(i + 3);
                        if (line1.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get(file)).get((i + 4));
                            if (line2.equals(passwordS)) {
                                JOptionPane.showMessageDialog(null, "Login Successful ");
                                dispose();
                                HomePage hp = new HomePage(doctorList, patientList, staffList, morgueList, serviceList);
                                hp.setVisible(true);
                            }
                        }
                    }
                }

                catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        }

        else if (e.getSource() == bSignUp)
        {
            String username = tf1.getText().toLowerCase();
            String password = String.valueOf(tf2.getPassword());

            if(username.equals("mahmud") && password.equals("1234")) {

                dispose();
                AdminLogin fr = new AdminLogin();
                fr.setVisible(true);
            }


            else {

                JOptionPane.showMessageDialog(null, "Incorrect username or password.\n      Try again later",
                        "Health Mate",JOptionPane.WARNING_MESSAGE);

            }
        }

    }
}