package GUI;
import Entities.*;
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

 public class StaffDetails extends JFrame implements ActionListener {

    Font font1 = new Font("Arial",Font.BOLD,20);
    Font font2 = new Font("Arial",Font.PLAIN,15);
    Font font3 = new Font("Arial",Font.BOLD,15);
    Font font4 = new Font("Arial Rounded MT Bold",Font.BOLD,36);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon,img;
    private Container c;
    private JLabel lEnterInfo,lName,lID,lAge,lGender,lDateOfBirth,lBloodGroup,lPhoneNo,lDesignation,lQualification,lSalary,lSearchByID,l1;
    private JTextField tfName,tfID,tfAge,tfGender,tfDateOfBirth,tfBloodGroup,tfPhoneNo,tfDesignation,tfQualification,tfSalary,tfSearchByID;
    private JButton bInsert,bBack,bRemove,bSearch,bUpdate,bClear;
    private JTable table;
    private DefaultTableModel model;
    StaffList staffList;
     DoctorList doctorList;
     ServiceList serviceList;
     MorgueList morgueList;
     PatientList patientList;
    HomePage hp;
    private String[] columns = {"ID", "Name","Age","Gender","Date Of Birth","Blood Group","Phone Number","Designation","Qualification","Salary"};
    private String[] rows = new String[10];
    public StaffDetails(HomePage hp,StaffList staffList){
        this.hp = hp;
        this.staffList = staffList;
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

        l1 = new JLabel("Stuff's Information");
        l1.setBounds(600, 5, 400, 42);
        l1.setFont(font4);
        c.add(l1);

        lName = new JLabel("Staff's Name:");
        lName.setBounds(20,50,160,25);
        lName.setFont(font1);
        c.add(lName);

        tfName = new JTextField();
        tfName.setToolTipText("Enter Name");
        tfName.setBounds(182,50,250,25);
        tfName.setFont(font2);
        c.add(tfName);

        lID = new JLabel("Staff's ID:");
        lID.setBounds(20,85,160,25);
        lID.setFont(font1);
        c.add(lID);

        tfID = new JTextField();
        tfID.setToolTipText("Enter ID");
        tfID.setBounds(182,85,250,25);
        tfID.setFont(font2);
        c.add(tfID);

        lAge = new JLabel("Age:");
        lAge.setBounds(20,120,50,25);
        lAge.setFont(font1);
        c.add(lAge);

        tfAge = new JTextField();
        tfAge.setToolTipText("Enter Age");
        tfAge.setBounds(75,120,80,25);
        tfAge.setFont(font2);
        c.add(tfAge);

        lBloodGroup = new JLabel("Blood Group:");
        lBloodGroup.setBounds(185,120,130,25);
        lBloodGroup.setFont(font1);
        c.add(lBloodGroup);

        tfBloodGroup = new JTextField();
        tfBloodGroup.setToolTipText("Enter Blood Group");
        tfBloodGroup.setBounds(317,120,80,25);
        tfBloodGroup.setFont(font2);
        c.add(tfBloodGroup);

        lDateOfBirth = new JLabel("Date of Birth:");
        lDateOfBirth.setBounds(20,155,150,25);
        lDateOfBirth.setFont(font1);
        c.add(lDateOfBirth);

        tfDateOfBirth = new JTextField();
        tfDateOfBirth.setToolTipText("Enter Date Of Birth");
        tfDateOfBirth.setBounds(175,155,100,25);
        tfDateOfBirth.setFont(font2);
        c.add(tfDateOfBirth);

        lGender = new JLabel("Gender:");
        lGender.setBounds(20,190,90,25);
        lGender.setFont(font1);
        c.add(lGender);

        tfGender = new JTextField();
        tfGender.setToolTipText("Enter Gender");
        tfGender.setBounds(175,190,100,25);
        tfGender.setFont(font2);
        c.add(tfGender);

        lPhoneNo = new JLabel("Phone Number:");
        lPhoneNo.setBounds(20,225,150,25);
        lPhoneNo.setFont(font1);
        c.add(lPhoneNo);

        tfPhoneNo = new JTextField();
        tfPhoneNo.setToolTipText("Enter Phone Number");
        tfPhoneNo.setBounds(175,225,130,25);
        tfPhoneNo.setFont(font2);
        c.add(tfPhoneNo);

        lDesignation = new JLabel("Designation:");
        lDesignation.setBounds(20,260,150,25);
        lDesignation.setFont(font1);
        c.add(lDesignation);

        tfDesignation = new JTextField();
        tfDesignation.setToolTipText("Enter Designation");
        tfDesignation.setBounds(175,260,150,25);
        tfDesignation.setFont(font2);
        c.add(tfDesignation);

        lQualification = new JLabel("Qualification:");
        lQualification.setBounds(20,295,150,25);
        lQualification.setFont(font1);
        c.add(lQualification);

        tfQualification = new JTextField();
        tfQualification.setToolTipText("Enter Qualification");
        tfQualification.setBounds(175,295,200,25);
        tfQualification.setFont(font2);
        c.add(tfQualification);

        lSalary = new JLabel("Salary:");
        lSalary.setBounds(20,325,100,25);
        lSalary.setFont(font1);
        c.add(lSalary);

        tfSalary = new JTextField();
        tfSalary.setToolTipText("Enter Salary");
        tfSalary.setBounds(175,325,100,25);
        tfSalary.setFont(font2);
        c.add(tfSalary);

        img = new ImageIcon(getClass().getResource("Pictures/back.png"));

        bBack = new JButton(img);
        bBack.setBounds(1210,650,50,50);
        bBack.setCursor(cursor);
        bBack.addActionListener(this);
        bBack.setFont(font3);
        c.add(bBack);

        bInsert = new JButton("Insert");
        bInsert.setBounds(20,450,130,30);
        bInsert.setBackground(new Color(54,119,119));
        bInsert.setCursor(cursor);
        bInsert.addActionListener(this);
        bInsert.setFont(font3);
        c.add(bInsert);

        bRemove = new JButton("Delete");
        bRemove.setBounds(155,450,130,30);
        bRemove.setBackground(new Color(54,119,119));
        bRemove.setCursor(cursor);
        bRemove.addActionListener(this);
        bRemove.setFont(font3);
        c.add(bRemove);

        bUpdate = new JButton("Update");
        bUpdate.setBounds(20,490,130,30);
        bUpdate.setBackground(new Color(54,119,119));
        bUpdate.setCursor(cursor);
        bUpdate.addActionListener(this);
        bUpdate.setFont(font3);
        c.add(bUpdate);

        bClear = new JButton("Clear");
        bClear.setBounds(155,490,130,30);
        bClear.setBackground(new Color(54,119,119));
        bClear.setCursor(cursor);
        bClear.addActionListener(this);
        bClear.setFont(font3);
        c.add(bClear);

        lSearchByID = new JLabel("Search By ID:");
        lSearchByID.setBounds(20,650,120,30);
        lSearchByID.setFont(font3);
        c.add(lSearchByID);

        tfSearchByID = new JTextField();
        tfSearchByID.setToolTipText("Enter ID");
        tfSearchByID.setBounds(145,650,200,30);
        tfSearchByID.setFont(font2);
        c.add(tfSearchByID);

        bSearch = new JButton("Search");
        bSearch.setBounds(350,650,120,30);
        bSearch.setBackground(new Color(54,119,119));
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


        String file = ".\\Storage\\StaffDetails.txt";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {

                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0,13);
                if (x.equals("Staff's ID : ")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); // Staff's ID
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(14); // Staff's Name
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13); // Age
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(8); // Gender
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(15); // Date of Birth
                    rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(13); // Blood Group
                    rows[6] = Files.readAllLines(Paths.get(file)).get((i + 6)).substring(14); // Phone Number
                    rows[7] = Files.readAllLines(Paths.get(file)).get((i + 7)).substring(14); // Designation
                    rows[8] = Files.readAllLines(Paths.get(file)).get((i + 8)).substring(15); // Qualification
                    rows[9] = Files.readAllLines(Paths.get(file)).get((i + 9)).substring(8);//Salary
                    model.addRow(rows);
                }
            }

            Entities.Staff staffs[];
            staffs = this.staffList.getAllStaff();

            for (int i = 0; i <= staffs.length; i++) {
                if (staffs[i] != null) {
                    model.addRow(new Object[]{
                            staffs[i].getID(),
                            staffs[i].getName(),
                            staffs[i].getAge(),
                            staffs[i].getGender(),
                            staffs[i].getDOB(),
                            staffs[i].getBG(),
                            staffs[i].getPhoneNo(),
                            staffs[i].getDesignation(),
                            staffs[i].getQualification(),
                            staffs[i].getSalary()
                    });
                }
            }

        }

        catch (Exception ex) {
            System.out.println(ex);
        }

       /* try {

        }
        catch (Exception ex){
            System.out.println(ex);
        }*/

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int numberOfRow = table.getSelectedRow();

                String id = model.getValueAt(numberOfRow, 0).toString();
                String name = model.getValueAt(numberOfRow, 1).toString();
                int age = Integer.parseInt(model.getValueAt(numberOfRow, 2).toString());
                String gender = model.getValueAt(numberOfRow, 5).toString();
                String DoB = model.getValueAt(numberOfRow, 3).toString();
                String bg = model.getValueAt(numberOfRow, 6).toString();
                String PhNo = model.getValueAt(numberOfRow, 4).toString();
                String d = model.getValueAt(numberOfRow, 7).toString();
                String qualification = model.getValueAt(numberOfRow, 8).toString();
                double salary = Double.parseDouble(model.getValueAt(numberOfRow, 10).toString());


                tfID.setText(id);
                tfName.setText(name);
                tfAge.setText(String.valueOf(age));
                tfGender.setText(gender);
                tfDateOfBirth.setText(DoB);
                tfPhoneNo.setText(PhNo);
                tfBloodGroup.setText(bg);
                tfDesignation.setText(d);
                tfQualification.setText(qualification);
                tfSalary.setText(String.valueOf(salary));
            }
        });
    }

     @Override
     public void actionPerformed(ActionEvent e) {

         if(e.getSource() == bInsert){

             String id = tfID.getText();
             String name = tfName.getText();
             int age = Integer.parseInt(tfAge.getText());
             String gender = tfGender.getText();
             String DoB = tfDateOfBirth.getText();
             String Bg = tfBloodGroup.getText();
             String PhoneNo = tfPhoneNo.getText();
             String de = tfDesignation.getText();
             String q = tfQualification.getText();
             double salary = Double.parseDouble(tfSalary.getText());

             Entities.Staff s = new Entities.Staff(id,name,age,gender,DoB,Bg,PhoneNo,de,q,salary);
             staffList.AddInfo(s);
             model.addRow(new Object[]{
                     rows[0] = s.getID(),
                     rows[1] = s.getName(),
                     rows[2] = String.valueOf(s.getAge()),
                     rows[3] = s.getGender(),
                     rows[4] = s.getDOB(),
                     rows[5] = s.getBG(),
                     rows[6] = s.getPhoneNo(),
                     rows[7] = s.getDesignation(),
                     rows[8] = s.getQualification(),
                     rows[9] = String.valueOf(s.getSalary())
             });

             String file = ".\\Storage\\StaffDetails.txt";
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

                 pw.println("Staff's ID : " + id);
                 pw.println("Staff's Name : " + name);
                 pw.println("Age        : " + age);
                 pw.println("Gender : " + gender);
                 pw.println("Date of Birth : " + DoB);
                 pw.println("Blood Group : " + Bg);
                 pw.println("Phone Number : " + PhoneNo);
                 pw.println("Designation  : " + de);
                 pw.println("Qualification : " + q);
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
             tfGender.setText("");
             tfDateOfBirth.setText("");
             tfBloodGroup.setText("");
             tfPhoneNo.setText("");
             tfDesignation.setText("");
             tfQualification.setText("");
             tfSalary.setText("");
         }

         else if (e.getSource() == bRemove){
             int selectedRow = table.getSelectedRow();

             if(selectedRow != 0) {
                     String id = model.getValueAt(selectedRow, 0).toString();
                     staffList.RemoveInfo(id);
                     model.removeRow(selectedRow);

                 // Update the file
                 try {
                     String file = ".\\Storage\\StaffDetails.txt";
                     String tempFile = ".\\Storage\\temp.txt";

                     BufferedReader reader = new BufferedReader(new FileReader(file));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                     String line;
                     while ((line = reader.readLine()) != null) {
                         if (!line.startsWith("Staff's ID : " + id)) {
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

             String id = tfID.getText();
             String name= tfName.getText();
             int age = Integer.parseInt(tfAge.getText());
             String gender = tfGender.getText();
             String DoB = tfDateOfBirth.getText();
             String bg = tfBloodGroup.getText();
             String PhNo = tfPhoneNo.getText();
             String d = tfDesignation.getText();
             String as = tfQualification.getText();
             double salary = Double.parseDouble(tfSalary.getText());

             model.setValueAt(id,numberOfRow,0);
             model.setValueAt(name,numberOfRow,1);
             model.setValueAt(age,numberOfRow,2);
             model.setValueAt(gender,numberOfRow,3);
             model.setValueAt(DoB,numberOfRow,4);
             model.setValueAt(bg,numberOfRow,5);
             model.setValueAt(PhNo,numberOfRow,6);
             model.setValueAt(d,numberOfRow,7);
             model.setValueAt(as,numberOfRow,8);
             model.setValueAt(salary,numberOfRow,9);
             tableModuleToList();


         }

         else if(e.getSource() == bSearch){

             String file = ".\\Storage\\StaffDetails.txt";
             String id = tfSearchByID.getText(); // ID

             if (id.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Please enter the id.", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
             } else {

                 try {
                     String ids = "Staff's ID : " + id;
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
                                 String x = lines.substring(0,13);
                                 if (x.equals("Staff's ID : ")) {
                                     rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); // Staff's ID
                                     rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(14); // Staff's Name
                                     rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13); // Age
                                     rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(8); // Gender
                                     rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(15); // Date of Birth
                                     rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(13); // Blood Group
                                     rows[6] = Files.readAllLines(Paths.get(file)).get((i + 6)).substring(14); // Phone Number
                                     rows[7] = Files.readAllLines(Paths.get(file)).get((i + 7)).substring(14); // Designation
                                     rows[8] = Files.readAllLines(Paths.get(file)).get((i + 8)).substring(15); // Qualification
                                     rows[9] = Files.readAllLines(Paths.get(file)).get((i + 9)).substring(8);//Salary

                                     tfID.setText(rows[0]);
                                     tfName.setText(rows[1]);
                                     tfAge.setText(rows[2]);
                                     tfGender.setText(rows[3]);
                                     tfDateOfBirth.setText(rows[4]);
                                     tfPhoneNo.setText(rows[6]);
                                     tfBloodGroup.setText(rows[5]);
                                     tfDesignation.setText(rows[7]);
                                     tfQualification.setText(rows[8]);
                                     tfSalary.setText(rows[9]);
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
        StaffList updateList = new StaffList(200);
        for( int i = 0; i<rows; i++) {
            String id = model.getValueAt(i, 0).toString();
            String name = model.getValueAt(i, 1).toString();
            int age = Integer.parseInt(model.getValueAt(i, 2).toString());
            String gender = model.getValueAt(i, 5).toString();
            String DoB = model.getValueAt(i, 3).toString();
            String bg = model.getValueAt(i, 6).toString();
            String PhoneNo = model.getValueAt(i, 4).toString();
            String d = model.getValueAt(i, 7).toString();
            String qualification = model.getValueAt(i, 8).toString();
            double salary = Double.parseDouble(model.getValueAt(i, 10).toString());

            Staff staff = new Staff(id, name, age, gender, DoB, bg, PhoneNo, d, qualification, salary);
            updateList.AddInfo(staff);
        }
        staffList.setAllStaffs(updateList.getAllStaff());
    }



 }