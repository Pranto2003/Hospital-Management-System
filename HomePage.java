package GUI;

import EntityList.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    Font font1 = new Font("Arial",Font.BOLD,30);
    Font font2 = new Font("Arial",Font.PLAIN,20);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon,img;
    private Container c;
    DoctorList doctorList;
    PatientList patientList;
    StaffList staffList;
    MorgueList morgueList;
    ServiceList serviceList;
    HomePage hp;
    LogIn li;
    private JButton bDoctorDetails,bPatientDetails,bStaffDetails,bServiceDetails,bMorgueDetails,bBack;

    HomePage(DoctorList doctorList, PatientList patientList, StaffList staffList, MorgueList morgueList, ServiceList serviceList){
        this.doctorList = doctorList;
        this.patientList = patientList;
        this.serviceList = serviceList;
        this.staffList = staffList;
        this.morgueList = morgueList;
        //this.li = li;

        insert();
        this.setVisible(true);


    }
    public void insert() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20, 40, 900, 700);
        this.setTitle("Health Mate");
        this.setResizable(false);

        c = this.getContentPane();
        c.setBackground(new Color(210, 224, 225));
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());


        bStaffDetails = new JButton("Staff Details");
        bStaffDetails.setBounds(200,150, 400,50);
        bStaffDetails.setBackground(new Color(54,119,119));
        bStaffDetails.setCursor(cursor);
        bStaffDetails.addActionListener(this);
        bStaffDetails.setFont(font1);
        c.add(bStaffDetails);

        bDoctorDetails = new JButton("Doctor Details");
        bDoctorDetails.setBounds(200,220, 400,50);
        bDoctorDetails.setBackground(new Color(54,119,119));
        bDoctorDetails.setCursor(cursor);
        bDoctorDetails.addActionListener(this);
        bDoctorDetails.setFont(font1);
        c.add(bDoctorDetails);

        bPatientDetails = new JButton("Patient Details");
        bPatientDetails.setBounds(200,290, 400,50);
        bPatientDetails.setBackground(new Color(54,119,119));
        bPatientDetails.setCursor(cursor);
        bPatientDetails.addActionListener(this);
        bPatientDetails.setFont(font1);
        c.add(bPatientDetails);

        bServiceDetails = new JButton("Service Details");
        bServiceDetails.setBounds(200,360, 400,50);
        bServiceDetails.setBackground(new Color(54,119,119));
        bServiceDetails.setCursor(cursor);
        bServiceDetails.addActionListener(this);
        bServiceDetails.setFont(font1);
        c.add(bServiceDetails);

        bMorgueDetails = new JButton("Morgue Details");
        bMorgueDetails.setBounds(200,430, 400,50);
        bMorgueDetails.setBackground(new Color(54,119,119));
        bMorgueDetails.setCursor(cursor);
        bMorgueDetails.addActionListener(this);
        bMorgueDetails.setFont(font1);
        c.add(bMorgueDetails);
		
		bBack = new JButton("LogOut");
		bBack.setBounds(670,600,100,40);
        bBack.setBackground(new Color(54,119,119));
        bBack.setCursor(cursor);
        bBack.addActionListener(this);
        bBack.setFont(font2);
        c.add(bBack);



    }

    /*public static void main(String[] args) {

        HomePage frame = new HomePage(doctorList, patientList, staffList, morgueList, serviceList);
        frame.setVisible(true);
        frame.setResizable(false);

    }*/

    public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bStaffDetails){

           //JOptionPane.showMessageDialog(null, "You have clicked Stuff List button ");
            dispose();
            StaffDetails sl = new StaffDetails(hp,staffList);
            sl.setVisible(true);
            hp.setVisible(false);
        }
		
		else if(e.getSource() == bDoctorDetails){

           //JOptionPane.showMessageDialog(null, "You have clicked Doctor List button ");
		   dispose();
           DoctorDetails dl = new DoctorDetails(hp,doctorList);
           dl.setVisible(true);
		    
        }
		
		else if(e.getSource() == bPatientDetails){

           //JOptionPane.showMessageDialog(null, "You have clicked Patient List button ");
		   dispose();
           PatientDetails pd = new PatientDetails(hp,patientList);
           pd.setVisible(true);
		    
        }
		
		else if(e.getSource() == bServiceDetails){

           //JOptionPane.showMessageDialog(null, "You have clicked Service List button ");
		   dispose();
           ServiceDetails serd = new ServiceDetails(hp,serviceList);
           serd.setVisible(true);
		    
        }

        else if(e.getSource() == bMorgueDetails){

            //JOptionPane.showMessageDialog(null, "You have clicked Morgue List button ");
            dispose();
            MorgueDetails md = new MorgueDetails(hp,morgueList);
            md.setVisible(true);


        }
			
        else if(e.getSource() == bBack){
            dispose();
            LogIn li = new LogIn(doctorList, patientList, staffList, morgueList, serviceList);
            li.setVisible(true);


        }


    }
}