package GUI;

import Entities.Doctor;
import EntityList.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class DoctorDetails extends JFrame implements ActionListener {

    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("Arial", Font.PLAIN, 15);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial Rounded MT Bold", Font.BOLD, 36);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon, img;
    private Container c;
    private JLabel lEnterInfo, lName, lID, lAge, lGender, lSpecialist, lSalary, lRoomNum, lQualification, lSearchByID, lBloodGroup, lDateOfBirth, l1, lPhoneNo;
    private JTextField tfName, tfID, tfAge, tfGender, tfSpecialist, tfSalary, tfRoomNum, tfQualification, tfSearchByID, tfBloodGroup, tfDateOfBirth, tfPhoneNo;
    private JButton bInsert, bBack, bRemove, bSearch, bUpdate, bClear;
    private JTable table;
    private DefaultTableModel model;
    private String[] columns = {"Doctor's ID", "Doctor's Name", "Age", "Date Of Birth",
            "Phone Number", "Gender", "Blood Group", "Specilist", "Qualification", "Room No.", "Salary"};
    private String[] rows = new String[11];
    DoctorList doctorList;
    StaffList staffList;
    ServiceList serviceList;
    MorgueList morgueList;
    PatientList patientList;
    HomePage hp;

    public DoctorDetails(HomePage hp,DoctorList doctorList) {

        this.doctorList = doctorList;

        this.hp = hp;
        insert();

        createTable();
    }

    public void insert() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20, 40, 1350, 750);
        this.setTitle("Health Mate");

        c = this.getContentPane();
        c.setBackground(new Color(210, 224, 225));
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());

        lEnterInfo = new JLabel("Enter Information:");
        lEnterInfo.setBounds(10, 10, 380, 30);
        lEnterInfo.setFont(font1);
        c.add(lEnterInfo);

        l1 = new JLabel("Doctor's Information");
        l1.setBounds(600, 5, 400, 42);
        l1.setFont(font4);
        c.add(l1);

        lName = new JLabel("Doctor's Name:");
        lName.setBounds(20, 50, 160, 25);
        lName.setFont(font1);
        c.add(lName);

        tfName = new JTextField();
        tfName.setToolTipText("Enter Name");
        tfName.setBounds(182, 50, 250, 25);
        tfName.setFont(font2);
        c.add(tfName);

        lID = new JLabel("Doctor's ID:");
        lID.setBounds(20, 85, 160, 25);
        lID.setFont(font1);
        c.add(lID);

        tfID = new JTextField();
        tfID.setToolTipText("Enter ID");
        tfID.setBounds(182, 85, 250, 25);
        tfID.setFont(font2);
        c.add(tfID);

        lAge = new JLabel("Age:");
        lAge.setBounds(20, 120, 50, 25);
        lAge.setFont(font1);
        c.add(lAge);

        tfAge = new JTextField();
        tfAge.setToolTipText("Enter Age");
        tfAge.setBounds(75, 120, 80, 25);
        tfAge.setFont(font2);
        c.add(tfAge);

        lBloodGroup = new JLabel("Blood Group:");
        lBloodGroup.setBounds(185, 120, 130, 25);
        lBloodGroup.setFont(font1);
        c.add(lBloodGroup);

        tfBloodGroup = new JTextField();
        tfBloodGroup.setToolTipText("Enter Blood Group");
        tfBloodGroup.setBounds(317, 120, 80, 25);
        tfBloodGroup.setFont(font2);
        c.add(tfBloodGroup);

        lDateOfBirth = new JLabel("Date of Birth:");
        lDateOfBirth.setBounds(20, 155, 150, 25);
        lDateOfBirth.setFont(font1);
        c.add(lDateOfBirth);

        tfDateOfBirth = new JTextField();
        tfDateOfBirth.setToolTipText("Enter Date Of Birth");
        tfDateOfBirth.setBounds(175, 155, 100, 25);
        tfDateOfBirth.setFont(font2);
        c.add(tfDateOfBirth);

        lGender = new JLabel("Gender:");
        lGender.setBounds(20, 190, 90, 25);
        lGender.setFont(font1);
        c.add(lGender);

        tfGender = new JTextField();
        tfGender.setToolTipText("Enter Gender");
        tfGender.setBounds(175, 190, 100, 25);
        tfGender.setFont(font2);
        c.add(tfGender);


        lSpecialist = new JLabel("Specialist:");
        lSpecialist.setBounds(20, 225, 100, 25);
        lSpecialist.setFont(font1);
        c.add(lSpecialist);

        tfSpecialist = new JTextField();
        tfSpecialist.setToolTipText("Enter Specialist");
        tfSpecialist.setBounds(175, 225, 150, 25);
        tfSpecialist.setFont(font2);
        c.add(tfSpecialist);

        lQualification = new JLabel("Qualification:");
        lQualification.setBounds(20, 260, 150, 25);
        lQualification.setFont(font1);
        c.add(lQualification);

        tfQualification = new JTextField();
        tfQualification.setToolTipText("Enter Qualification");
        tfQualification.setBounds(175, 260, 200, 25);
        tfQualification.setFont(font2);
        c.add(tfQualification);

        lSalary = new JLabel("Salary:");
        lSalary.setBounds(20, 295, 100, 25);
        lSalary.setFont(font1);
        c.add(lSalary);

        tfSalary = new JTextField();
        tfSalary.setToolTipText("Enter Salary");
        tfSalary.setBounds(175, 295, 100, 25);
        tfSalary.setFont(font2);
        c.add(tfSalary);

        lRoomNum = new JLabel("Room Number:");
        lRoomNum.setBounds(20, 330, 150, 25);
        lRoomNum.setFont(font1);
        c.add(lRoomNum);

        tfRoomNum = new JTextField();
        tfRoomNum.setToolTipText("Enter RoomNumber");
        tfRoomNum.setBounds(175, 330, 100, 25);
        tfRoomNum.setFont(font2);
        c.add(tfRoomNum);

        lPhoneNo = new JLabel("Phone Number:");
        lPhoneNo.setBounds(20, 365, 150, 25);
        lPhoneNo.setFont(font1);
        c.add(lPhoneNo);

        tfPhoneNo = new JTextField();
        tfPhoneNo.setToolTipText("Enter Phone Number");
        tfPhoneNo.setBounds(175, 365, 120, 25);
        tfPhoneNo.setFont(font2);
        c.add(tfPhoneNo);

        img = new ImageIcon(getClass().getResource("Pictures/back.png"));

        bBack = new JButton(img);
        bBack.setBounds(1210,650,50,50);
        bBack.setCursor(cursor);
        bBack.addActionListener(this);
        bBack.setFont(font3);
        c.add(bBack);

        bInsert = new JButton("Insert");
        bInsert.setBounds(20, 450, 130, 30);
        bInsert.setBackground(new Color(54, 119, 119));
        bInsert.setCursor(cursor);
        bInsert.addActionListener(this);
        bInsert.setFont(font3);
        c.add(bInsert);

        bRemove = new JButton("Delete");
        bRemove.setBounds(155, 450, 130, 30);
        bRemove.setBackground(new Color(54, 119, 119));
        bRemove.setCursor(cursor);
        bRemove.addActionListener(this);
        bRemove.setFont(font3);
        c.add(bRemove);

        bUpdate = new JButton("Update");
        bUpdate.setBounds(20, 490, 130, 30);
        bUpdate.setBackground(new Color(54, 119, 119));
        bUpdate.setCursor(cursor);
        bUpdate.addActionListener(this);
        bUpdate.setFont(font3);
        c.add(bUpdate);

        bClear = new JButton("Clear");
        bClear.setBounds(155, 490, 130, 30);
        bClear.setBackground(new Color(54, 119, 119));
        bClear.setCursor(cursor);
        bClear.addActionListener(this);
        bClear.setFont(font3);
        c.add(bClear);

        lSearchByID = new JLabel("Search By ID:");
        lSearchByID.setBounds(20, 650, 120, 30);
        lSearchByID.setFont(font3);
        c.add(lSearchByID);

        tfSearchByID = new JTextField();
        tfSearchByID.setToolTipText("Enter ID");
        tfSearchByID.setBounds(145, 650, 200, 30);
        tfSearchByID.setFont(font2);
        c.add(tfSearchByID);

        bSearch = new JButton("Search");
        bSearch.setBounds(350, 650, 120, 30);
        bSearch.setBackground(new Color(54, 119, 119));
        bSearch.setCursor(cursor);
        bSearch.addActionListener(this);
        bSearch.setFont(font3);
        c.add(bSearch);

    }

    public void createTable() {

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font2);
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(244, 183, 243));
        table.setBackground(Color.white);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(445, 50, 870, 550);
        scroll.setBackground(Color.cyan);
        c.add(scroll);

        table.getColumnModel().getColumn(0);
        table.getColumnModel().getColumn(1);
        table.getColumnModel().getColumn(2);
        table.getColumnModel().getColumn(3);
        table.getColumnModel().getColumn(4);
        table.getColumnModel().getColumn(5);
        table.getColumnModel().getColumn(6);
        table.getColumnModel().getColumn(7);
        table.getColumnModel().getColumn(8);
        table.getColumnModel().getColumn(9);
        table.getColumnModel().getColumn(10);

        String file = ".\\Storage\\DoctorDetails.txt";

        try{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int totalLines = 0;
        while (reader.readLine() != null)
            totalLines++;
        reader.close();

        for (int i = 0; i < totalLines; i++) {
            //String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
            String line = Files.readAllLines(Paths.get(file)).get(i);
            String x = line.substring(0, 11);
            if (x.equals("Doctor's ID")) {
                rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(14); // Doctor's ID
                rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(16); // Doctor's Name
                rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(16); // Age
                rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(16); // Date of Birth
                rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(16); // Phone Number
                rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(8);  // Gender
                rows[6] = Files.readAllLines(Paths.get(file)).get((i + 6)).substring(15); // Blood Group
                rows[7] = Files.readAllLines(Paths.get(file)).get((i + 7)).substring(15); // Specialist
                rows[8] = Files.readAllLines(Paths.get(file)).get((i + 8)).substring(15); // Qualification
                rows[9] = Files.readAllLines(Paths.get(file)).get((i + 9)).substring(15); // Room No. :
                rows[10] = Files.readAllLines(Paths.get(file)).get((i + 10)).substring(8);// Salary
                model.addRow(rows);
            }
        }

            Entities.Doctor doctors[];
            doctors = this.doctorList.getAllDoctor();

            for (int i = 0; i <= doctors.length; i++) {
                if (doctors[i] != null) {
                    model.addRow(new Object[]{
                            doctors[i].getID(),
                            doctors[i].getName(),
                            doctors[i].getAge(),
                            doctors[i].getDOB(),
                            doctors[i].getPhoneNo(),
                            doctors[i].getGender(),
                            doctors[i].getBG(),
                            doctors[i].getSpecialist(),
                            doctors[i].getQualification(),
                            doctors[i].getRoomNum(),
                            doctors[i].getSalary()
                    });
                }
            }
    }

            catch(Exception ex) {
                  System.out.println(ex);}


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int numberOfRow = table.getSelectedRow();

                String id = model.getValueAt(numberOfRow, 0).toString();
                String name = model.getValueAt(numberOfRow, 1).toString();
                String age = model.getValueAt(numberOfRow, 2).toString();
                String DoB = model.getValueAt(numberOfRow, 3).toString();
                String PhNo = model.getValueAt(numberOfRow, 4).toString();
                String gender = model.getValueAt(numberOfRow, 5).toString();
                String bg = model.getValueAt(numberOfRow, 6).toString();
                String s = model.getValueAt(numberOfRow, 7).toString();
                String qualification = model.getValueAt(numberOfRow, 8).toString();
                String rn = model.getValueAt(numberOfRow, 9).toString();
                String salary = model.getValueAt(numberOfRow, 10).toString();

                tfID.setText(id);
                tfName.setText(name);
                tfAge.setText(age);
                tfDateOfBirth.setText(DoB);
                tfPhoneNo.setText(PhNo);
                tfGender.setText(gender);
                tfBloodGroup.setText(bg);
                tfSpecialist.setText(s);
                tfQualification.setText(qualification);
                tfRoomNum.setText(rn);
                tfSalary.setText(salary);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == bInsert){

            String id = tfID.getText();
            String name = tfName.getText();
            int age = Integer.parseInt(tfAge.getText());
            String DOB = tfDateOfBirth.getText();
            String PhoneNo = tfPhoneNo.getText();
            String gender = tfGender.getText();
            String Bg = tfBloodGroup.getText();
            String specialist = tfSpecialist.getText();
            String qualification = tfQualification.getText();
            int rm = Integer.parseInt(tfRoomNum.getText());
            double salary = Double.parseDouble(tfSalary.getText());

            Entities.Doctor d = new Doctor(id,name,age,gender,DOB,Bg,PhoneNo,specialist,qualification,rm,salary);
            doctorList.AddInfo(d);
            model.addRow(new Object[]{
                    rows[0] = d.getID(),
                    rows[1] = d.getName(),
                    rows[2] = String.valueOf(d.getAge()),
                    rows[3] = d.getDOB(),
                    rows[4] = d.getPhoneNo(),
                    rows[5] = d.getGender(),
                    rows[6] = d.getBG(),
                    rows[7] = d.getSpecialist(),
                    rows[8] = d.getQualification(),
                    rows[9] = String.valueOf(d.getRoomNum()),
                    rows[10]= String.valueOf(d.getSalary())
            });

            String file = ".\\Storage\\DoctorDetails.txt";
            //String temp = ".\\Storage\\temp.txt";

                // To input data in the table
                try {

                    File files = new File(file);
                    if (!files.exists()) {
                        files.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println("Doctor's ID : " + id);
                    pw.println("Doctor's Name : " + name);
                    pw.println("Age           : " + age);
                    pw.println("Date Of Birth : " + DOB);
                    pw.println("Phone Number  : " + PhoneNo);
                    pw.println("Gender : " + gender);
                    pw.println("Blood Group   : " + Bg);
                    pw.println("Specialist    : " + specialist);
                    pw.println("Qualification : " + qualification);
                    pw.println("Room no.      : " + rm);
                    pw.println("Salary : " + salary);
                    pw.println("===============================================");
                    pw.close();


            }

            catch (Exception ex) {
                System.out.println(ex);
            }
        }

        else if (e.getSource() == bClear) {
            tfID.setText("");
            tfName.setText("");
            tfAge.setText("");
            tfDateOfBirth.setText("");
            tfPhoneNo.setText("");
            tfGender.setText("");
            tfBloodGroup.setText("");
            tfSpecialist.setText("");
            tfQualification.setText("");
            tfRoomNum.setText("");
            tfSalary.setText("");
        }

        else if (e.getSource() == bRemove){

            int selectedRow = table.getSelectedRow();

            if(selectedRow >= 0) {
                    String id = model.getValueAt(selectedRow, 0).toString();
                    doctorList.RemoveInfo(id);
                    model.removeRow(selectedRow);

                // Update the file
                try {
                    String file = ".\\Storage\\DoctorDetails.txt";
                    String tempFile = ".\\Storage\\temp.txt";

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.startsWith("Doctor's ID : " + id)) {
                            writer.write(line + System.lineSeparator());
                        }
                    }

                    writer.close();
                    reader.close();

                    Files.delete(Paths.get(file));
                    Files.move(Paths.get(tempFile), Paths.get(file));
                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"No Data is being Selected","Warning",JOptionPane.WARNING_MESSAGE);
            }


        }

        else if (e.getSource() == bUpdate) {

            int numberOfRow = table.getSelectedRow();
            tableModuleToList();

            String id = tfID.getText();
            String name= tfName.getText();
            String age = tfAge.getText();
            String DoB = tfDateOfBirth.getText();
            String PhoneNo = tfPhoneNo.getText();
            String gender = tfGender.getText();
            String bg = tfBloodGroup.getText();
            String s = tfSpecialist.getText();
            String as = tfQualification.getText();
            String rn = tfRoomNum.getText();
            String salary = tfSalary.getText();

            model.setValueAt(id,numberOfRow,0);
            model.setValueAt(name,numberOfRow,1);
            model.setValueAt(age,numberOfRow,2);
            model.setValueAt(DoB,numberOfRow,3);
            model.setValueAt(PhoneNo,numberOfRow,4);
            model.setValueAt(gender,numberOfRow,5);
            model.setValueAt(bg,numberOfRow,6);
            model.setValueAt(s,numberOfRow,7);
            model.setValueAt(as,numberOfRow,8);
            model.setValueAt(rn,numberOfRow,9);
            model.setValueAt(salary,numberOfRow,10);

        }

        else if(e.getSource() == bSearch){

            String file = ".\\Storage\\DoctorDetails.txt";
            String id = tfSearchByID.getText(); // ID

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the id.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    String ids = "Doctor's ID : " + id;
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get(file)).get(i);
                        if (line.equals(ids)) {
                            JOptionPane.showMessageDialog(null, "ID matched.", "HealthCare",
                                    JOptionPane.INFORMATION_MESSAGE);

                            for (int j = i; j <= totalLines; j++) {

                                String lines = Files.readAllLines(Paths.get(file)).get(i);
                                String x = lines.substring(0, 14);
                                if (x.equals("Doctor's ID : ")) {
                                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(14); // Doctor's ID
                                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(16); // Doctor's Name
                                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(16); // Age
                                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(16); // Date of Birth
                                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(16); // Phone Number
                                    rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(8);  // Gender
                                    rows[6] = Files.readAllLines(Paths.get(file)).get((i + 6)).substring(15); // Blood Group
                                    rows[7] = Files.readAllLines(Paths.get(file)).get((i + 7)).substring(15); // Specialist
                                    rows[8] = Files.readAllLines(Paths.get(file)).get((i + 8)).substring(15); // Qualification
                                    rows[9] = Files.readAllLines(Paths.get(file)).get((i + 9)).substring(15); //Room Number
                                    rows[10] = Files.readAllLines(Paths.get(file)).get((i + 10)).substring(8);//Salary

                                    tfID.setText(rows[0]);
                                    tfName.setText(rows[1]);
                                    tfAge.setText(rows[2]);
                                    tfDateOfBirth.setText(rows[3]);
                                    tfPhoneNo.setText(rows[4]);
                                    tfGender.setText(rows[5]);
                                    tfBloodGroup.setText(rows[6]);
                                    tfSpecialist.setText(rows[7]);
                                    tfQualification.setText(rows[8]);
                                    tfRoomNum.setText(rows[9]);
                                    tfSalary.setText(rows[10]);
                                    break;
                                }
                                break;
                            }

                        }

                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        }

        else if (e.getSource() == bBack){
            dispose();
            HomePage hp = new HomePage(doctorList, patientList, staffList, morgueList, serviceList);
            hp.setVisible(true);
        }
    }

    public void tableModuleToList(){
        int rows = table.getRowCount();
        DoctorList updateList = new DoctorList(200);
        for( int i = 0; i<rows; i++) {

            String id = model.getValueAt(i, 0).toString();
            String name = model.getValueAt(i, 1).toString();
            int age = Integer.parseInt(model.getValueAt(i, 2).toString());
            String gender = model.getValueAt(i, 5).toString();
            String DoB = model.getValueAt(i, 3).toString();
            String bg = model.getValueAt(i, 6).toString();
            String PhoneNo = model.getValueAt(i, 4).toString();
            String specilist = model.getValueAt(i,7).toString();
            String qualification = model.getValueAt(i,8).toString();
            int rn = Integer.parseInt(model.getValueAt(i,9).toString());
            double salary = Double.parseDouble(model.getValueAt(i,10).toString());

            Doctor doctor = new Doctor(id, name, age, DoB,PhoneNo,gender,bg,specilist,qualification,rn,salary);
            updateList.AddInfo(doctor);
        }
        doctorList.setAllDoctors(updateList.getAllDoctor());
    }
}

		
		
		
		

	
	