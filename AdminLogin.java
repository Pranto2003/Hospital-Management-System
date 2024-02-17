package GUI;
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


public class AdminLogin extends JFrame implements ActionListener {

        Font font1 = new Font("Arial",Font.BOLD,25);
        Font font2 = new Font("Arial",Font.PLAIN,20);
        Font font3 = new Font("Arial",Font.PLAIN,15);
    Font font4 = new Font("Arial Rounded MT Bold",Font.BOLD,30);

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        private Container c;
        private ImageIcon icon,img;
        private JLabel lHeading,lFName,lLName,lusername,lPassword,lemail,l1;
        private JTextField tfFName,tfLName,tfusername,tfPassword,tfemail;
        private JButton bAdd,bBack,bDelete;
        private JTable table;
        private DefaultTableModel model;
        private JScrollPane scroll;
        private String[] columns = {"First Name","Last Name","Email","User name","Password"};
        private String[] rows = new String[5];
        StaffList staffList;
        DoctorList doctorList;
        ServiceList serviceList;
        MorgueList morgueList;
        PatientList patientList;

        AdminLogin(){
        insert();
        createTable();

        }

public void insert() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20,40,1300,700);
        this.setTitle("Health Mate");
        this.setVisible(true);
        this.setResizable(false);

        c = this.getContentPane();
        c.setBackground(new Color(111,139,206));
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());

        lHeading = new JLabel("Create New User");
        lHeading.setBounds(80,50,300,50);
        lHeading.setFont(font4);
        c.add(lHeading);

        l1 = new JLabel("User Information");
        l1.setBounds(600, 5, 400, 32);
        l1.setFont(font4);
        c.add(l1);

        lFName = new JLabel("Enter your first name:");
        lFName.setBounds(50,100,300,50);
        lFName.setFont(font1);
        c.add(lFName);

        lLName = new JLabel("Enter your last name:");
        lLName.setBounds(50,190,300,50);
        lLName.setFont(font1);
        c.add(lLName);

        lemail = new JLabel("Enter your email address:");
        lemail.setBounds(50,275,400,50);
        lemail.setFont(font1);
        c.add(lemail);

        lusername = new JLabel("Enter your username:");
        lusername.setBounds(50,365,300,50);
        lusername.setFont(font1);
        c.add(lusername);

        lPassword = new JLabel("Enter your password:");
        lPassword.setBounds(50,455,300,50);
        lPassword.setFont(font1);
        c.add(lPassword);

        tfFName = new JTextField();
        tfFName.setBounds(50,155,300,30);
        tfFName.setFont(font2);
        c.add(tfFName);

        tfLName = new JTextField();
        tfLName.setBounds(50,245,300,30);
        tfLName.setFont(font2);
        c.add(tfLName);

        tfemail = new JTextField();
        tfemail.setBounds(50,330,300,30);
        tfemail.setFont(font2);
        c.add(tfemail);

        tfusername = new JTextField();
        tfusername.setBounds(50,420,300,30);
        tfusername.setFont(font2);
        c.add(tfusername);

        tfPassword = new JTextField();
        tfPassword.setBounds(50,510,300,30);
        tfPassword.setFont(font2);
        c.add(tfPassword);

        bAdd = new JButton("Add User");
        bAdd.setBounds(50,580, 150,50);
        bAdd.setBackground(new Color(54,119,119));
        bAdd.setCursor(cursor);
        bAdd.addActionListener(this);
        bAdd.setFont(font1);
        c.add(bAdd);

        bDelete= new JButton("Delete User");
        bDelete.setBounds(205,580, 180,50);
        bDelete.setBackground(new Color(54,119,119));
        bDelete.setCursor(cursor);
        bDelete.addActionListener(this);
        bDelete.setFont(font1);
        c.add(bDelete);

        bBack = new JButton("Back");
        bBack.setBounds(1155,600, 120,50);
        bBack.setBackground(new Color(54,119,119));
        bBack.setCursor(cursor);
        bBack.addActionListener(this);
        bBack.setFont(font1);
        c.add(bBack);

        }

        public void createTable(){

                table = new JTable();

                model = new DefaultTableModel();
                model.setColumnIdentifiers(columns);
                table.setModel(model);
                table.setFont(font3);
                table.setRowHeight(30);
                table.setSelectionBackground(new Color(244, 183, 243));
                table.setBackground(Color.white);

                scroll = new JScrollPane(table);
                scroll.setBounds(405, 42, 870, 550);
                scroll.setBackground(Color.cyan);
                c.add(scroll);

                table.getColumnModel().getColumn(0);
                table.getColumnModel().getColumn(1);
                table.getColumnModel().getColumn(2);
                table.getColumnModel().getColumn(3);
                table.getColumnModel().getColumn(4);

                String file = ".\\Storage\\user_data.txt";
                try{
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                                totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                                //String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
                                String line = Files.readAllLines(Paths.get(file)).get(i);
                                String x = line.substring(0,13);
                                if (x.equals("First Name : ")) {
                                        rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); // First Name
                                        rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(13); // Last Name
                                        rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13); // Email
                                        rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(13); // Username
                                        rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(13); // Password
                                        model.addRow(rows);
                                }
                        }

                }

                catch (Exception ex) {
                        System.out.println(ex);
                }
                table.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                int numberOfRow = table.getSelectedRow();

                                String fname = model.getValueAt(numberOfRow,0).toString();
                                String lname = model.getValueAt(numberOfRow,1).toString();
                                String email = model.getValueAt(numberOfRow,2).toString();
                                String uname = model.getValueAt(numberOfRow,3).toString();
                                String pass = model.getValueAt(numberOfRow,4).toString();


                                tfFName.setText(fname);
                                tfLName.setText(lname);
                                tfemail.setText(email);
                                tfusername.setText(uname);
                                tfPassword.setText(pass);
                        }
                });


        }

       /*public static void main(String[] args) {
        SignUp frame = new SignUp();

        }*/

public void actionPerformed(ActionEvent e) {

        String fname = tfFName.getText();
        String lname = tfLName.getText();
        String mail = tfemail.getText().toLowerCase();
        String uname = tfusername.getText();
        String pass = tfPassword.getText();


        if(e.getSource() == bAdd) {


           if (fname.isEmpty() || lname.isEmpty() || mail.isEmpty() || uname.isEmpty() || pass.isEmpty()) {
           JOptionPane.showMessageDialog(null, "Please fill up all information");
           }

           else {
              try {
                   File file = new File(".\\Storage\\user_data.txt");
                   if (!file.exists()) {
                   file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println("First Name : " + fname);
        pw.println("Last Name  : " + lname);
        pw.println("Email      : " + mail);
        pw.println("Username   : " + uname);
        pw.println("Password   : " + pass);
        pw.println("===============================================");
        pw.close();

        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
        "Registration Complete", JOptionPane.INFORMATION_MESSAGE);

        }

        catch (Exception ex) {
        System.out.print(ex);
        }

        }
        }

       else if (e.getSource() == bDelete){

            String file = ".\\Storage\\user_data.txt";
            String temp = ".\\Storage\\temp.txt";
            if (table.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a data to delete", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                File oldFile = new File(file);
                File newFile = new File(temp);

                int q = 0;

                try {

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i < totalLines; i++) {
                        String line = Files.readAllLines(Paths.get(file)).get(i);
                        String x = line.substring(0, 13);
                        if (x.equals("First Name : ")) {
                            String pname = Files.readAllLines(Paths.get(file)).get(i);
                            if (pname.substring(13).equals(removeUser)) {
                                q = i;
                            }
                        }
                    }
                } catch (Exception ex) {
                    return;
                }

                try {

                    FileWriter fw = new FileWriter(temp, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int j = 0; j < totalLines; j++) {
                        String line = Files.readAllLines(Paths.get(file)).get(j);
                        String x = line.substring(0, 13);

                        if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))) {
                            String fn = Files.readAllLines(Paths.get(file)).get(j);
                            pw.println("#Removed! " + fn);
                        } else {
                            String fn = Files.readAllLines(Paths.get(file)).get(j);
                            pw.println(fn);
                        }
                    }
                    pw.flush();
                    pw.close();
                    fr.close();
                    br.close();
                    bw.close();
                    fw.close();

                    JOptionPane.showMessageDialog(null, "Information Successfully Deleted.",
                            "Health Mate", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    System.out.print(ex);
                }

                oldFile.delete();
                File dump = new File(file);
                newFile.renameTo(dump);
            }
        }

        else if(e.getSource() == bBack){
        dispose();
        LogIn li = new LogIn(doctorList, patientList, staffList, morgueList, serviceList);
        li.setVisible(true);

        }


        }


}
