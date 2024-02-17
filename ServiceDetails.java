package GUI;
import Entities.Service;
import EntityList.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ServiceDetails extends JFrame implements ActionListener{
    Font font1 = new Font("Arial",Font.BOLD,20);
    Font font2 = new Font("Arial",Font.BOLD,15);
    Font font3 = new Font("Arial",Font.BOLD,15);
    Font font4 = new Font("Arial Rounded MT Bold",Font.BOLD,36);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private Container c;
    private ImageIcon icon,img;
    private JLabel lServiceInfo,lServiceName,lServiceDate,lPatientID,lPatientName,lServiceCharges,lSearchByID,l1;
    private JTextField tfServiceDate,tfPatientID,tfPatientName,tfServiceCharges,tfSearchByID;
    private JTextArea taServiceName;
    private JButton bInsert,bRemove,bClear,bUpdate,bBack,bSearch;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String[] columns = {"Patient's ID","Patient's Name","Service Name","Service Date","Service Charge"};
    private String[] rows = new String[5];
    HomePage hp;
    ServiceList serviceList;
    DoctorList doctorList;
    StaffList staffList;
    MorgueList morgueList;
    PatientList patientList;
    public ServiceDetails(HomePage hp,ServiceList serviceList){

        this.hp = hp;
        this.serviceList = serviceList;
        insert();

        createTable();
    }

    public void insert(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20,40,1350,750);
        this.setTitle("Health Mate");

        c = this.getContentPane();
        c.setBackground(Color.White);
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());

        lServiceInfo = new JLabel("Enter Information");
        lServiceInfo.setBounds(10,10,380,32);
        lServiceInfo.setFont(font1);
        c.add(lServiceInfo);

        l1 = new JLabel("Service's Information");
        l1.setBounds(600,5,400,42);
        l1.setFont(font4);
        c.add(l1);

        lPatientID = new JLabel("Patient's ID:");
        lPatientID.setBounds(20,50,160,25);
        lPatientID.setFont(font1);
        c.add(lPatientID);

        tfPatientID = new JTextField();
        tfPatientID.setToolTipText("Enter ID");
        tfPatientID.setBounds(182,50,250,25);
        tfPatientID.setFont(font2);
        c.add(tfPatientID);

        lPatientName = new JLabel("Patient's Name:");
        lPatientName.setBounds(20,85,160,25);
        lPatientName.setFont(font1);
        c.add(lPatientName);

        tfPatientName=new JTextField();
        tfPatientName.setToolTipText("Enter Name");
        tfPatientName.setBounds(182,85,250,25);
        tfPatientName.setFont(font2);
        c.add(tfPatientName);

        lServiceName = new JLabel("Service Name:");
        lServiceName.setBounds(20,120,160,25);
        lServiceName.setFont(font1);
        c.add(lServiceName);

        taServiceName = new JTextArea();
        taServiceName.setToolTipText("Enter Service Name");
        taServiceName.setBounds(182,120,250,60);
        taServiceName.setLineWrap(true);
        taServiceName.setWrapStyleWord(true);
        taServiceName.setFont(font2);
        c.add(taServiceName);

        lServiceDate = new JLabel("Service Date:");
        lServiceDate.setBounds(20,190,160,25);
        lServiceDate.setFont(font1);
        c.add(lServiceDate);

        tfServiceDate = new JTextField();
        tfServiceDate.setToolTipText("Enter Service Date");
        tfServiceDate.setBounds(182,190,230,25);
        tfServiceDate.setFont(font2);
        c.add(tfServiceDate);
        LocalDate date = LocalDate.now();
        tfServiceDate.setText("" + date);

        lServiceCharges = new JLabel("Service Charge ");
        lServiceCharges.setBounds(20,225,160,25);
        lServiceCharges.setFont(font1);
        c.add(lServiceCharges);

        tfServiceCharges = new JTextField();
        tfServiceCharges.setToolTipText("Enter Charge");
        tfServiceCharges.setBounds(182,225,100,25);
        tfServiceCharges.setFont(font2);
        c.add(tfServiceCharges);


        bInsert = new JButton("Insert");
        bInsert.setBounds(20,450,130,30);
        bInsert.setBackground(Color.RED);
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

        img = new ImageIcon(getClass().getResource("Pictures/back.png"));

        bBack = new JButton(img);
        bBack.setBounds(1210,650,50,50);
        bBack.setCursor(cursor);
        bBack.addActionListener(this);
        bBack.setFont(font3);
        c.add(bBack);

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

        scroll = new JScrollPane(table);
        scroll.setBounds(445, 50, 870, 550);
        scroll.setBackground(Color.cyan);
        c.add(scroll);

        table.getColumnModel().getColumn(0);
        table.getColumnModel().getColumn(1);
        table.getColumnModel().getColumn(2);
        table.getColumnModel().getColumn(3);
        table.getColumnModel().getColumn(4);

        String file = ".\\Storage\\ServiceDetails.txt";

        try{


        BufferedReader reader = new BufferedReader(new FileReader(file));
        int totalLines = 0;
        while (reader.readLine() != null)
            totalLines++;
        reader.close();

        for (int i = 0; i < totalLines; i++) {
            //String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
            String line = Files.readAllLines(Paths.get(file)).get(i);
            String x = line.substring(0,15);
            if (x.equals("Patient's ID : ")) {
                rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(15); // Patient's ID
                rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(17); // Patient's Name
                rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(15); // Service Name
                rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(15); // Service Date
                rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(17); // Service Charges
                model.addRow(rows);
            }
        }

            Entities.Service service[];
            service = this.serviceList.getAllService();

            for (int i = 0; i<= service.length; i++){
                if(service[i] != null){
                    model.addRow(new Object[]{
                            service[i].getPatientID(),
                            service[i].getPatientName(),
                            service[i].getServiceName(),
                            service[i].getServiceDate(),
                            service[i].getServiceCharges(),
                    });
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

                String id = model.getValueAt(numberOfRow,0).toString();
                String name = model.getValueAt(numberOfRow,1).toString();
                String serviceName = model.getValueAt(numberOfRow,2).toString();
                String serviceDate = model.getValueAt(numberOfRow,3).toString();
                String serviceCharge = model.getValueAt(numberOfRow,4).toString();


                tfPatientID.setText(id);
                tfPatientName.setText(name);
                taServiceName.setText(serviceName);
                tfServiceDate.setText(serviceDate);
                tfServiceCharges.setText(serviceCharge);
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == bInsert){

            String id = tfPatientID.getText();
            String pname = tfPatientName.getText();
            String sname = taServiceName.getText();
            String date = tfServiceDate.getText();
            double charge  = Double.parseDouble(tfServiceCharges.getText());

            Entities.Service s = new Service(id,pname,sname,date,charge);
            serviceList.AddInfo(s);
            model.addRow(new Object[]{
                    rows[0] = s.getPatientID(),
                    rows[1] = s.getPatientName(),
                    rows[2] = s.getServiceName(),
                    rows[3] = s.getServiceDate(),
                    rows[4] = String.valueOf(s.getServiceCharges())
            });

            String file = ".\\Storage\\ServiceDetails.txt";
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

                pw.println("Patient's ID : " + id);
                pw.println("Patient's Name : " + pname);
                pw.println("Service Name : " + sname);
                pw.println("Service Date : " + date);
                pw.println("Service Charge : " + charge);
                pw.println("===============================================");
                pw.close();

            }

            catch (Exception ex) {
                System.out.println(ex);
            }
        }

        else if (e.getSource() == bClear) {
            tfPatientID.setText("");
            tfPatientName.setText("");
            taServiceName.setText("");
            tfServiceCharges.setText("");
        }

        else if (e.getSource() == bRemove){
            int selectedRow = table.getSelectedRow();

            if(selectedRow >= 0) {
                    String id = model.getValueAt(selectedRow, 0).toString();
                    serviceList.RemoveInfo(id);
                    model.removeRow(selectedRow);

                // Update the file
                try {
                    String file = ".\\Storage\\ServiceDetails.txt";
                    String tempFile = ".\\Storage\\temp.txt";

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.startsWith("Patient's ID : " + id)) {
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

            String id = tfPatientID.getText();
            String pname = tfPatientName.getText();
            String sname = taServiceName.getText();
            String date= tfServiceDate.getText();
            String charge = tfServiceCharges.getText();

            model.setValueAt(id,numberOfRow,0);
            model.setValueAt(pname,numberOfRow,1);
            model.setValueAt(sname,numberOfRow,2);
            model.setValueAt(date,numberOfRow,3);
            model.setValueAt(charge,numberOfRow,4);

            tableModuleToList();
            String file = ".\\Storage\\ServiceDetails.txt";
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

                pw.println("Patient's ID : " + id);
                pw.println("Patient's Name : " + pname);
                pw.println("Service Name : " + sname);
                pw.println("Service Date : " + date);
                pw.println("Service Charge : " + charge);
                pw.println("===============================================");
                pw.close();

            }

            catch (Exception ex) {
                System.out.println(ex);
            }

        }

        else if(e.getSource() == bSearch) {

            String file = ".\\Storage\\ServiceDetails.txt";
            String id = tfSearchByID.getText(); // ID

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the id.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                    try {
                        String ids = "Patient's ID : " + id;
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
                                    String x = lines.substring(0,15);
                                    if (x.equals("Patient's ID : ")) {
                                        rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(15); // Patient's ID
                                        rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(17); // Patient's Name
                                        rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(15); // Service Name
                                        rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(15); // Service Date
                                        rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(17); // Service Charges


                                        tfPatientID.setText(rows[0]);
                                        tfPatientName.setText(rows[1]);
                                        taServiceName.setText(rows[2]);
                                        tfServiceDate.setText(rows[3]);
                                        tfServiceCharges.setText(rows[4]);

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
    public void tableModuleToList() {
        int rows = table.getRowCount();
        ServiceList updateList = new ServiceList(200);
        for (int i = 0; i < rows; i++) {

            String id = model.getValueAt(i,0).toString();
            String pname = model.getValueAt(i,1).toString();
            String sname = model.getValueAt(i,2).toString();
            String date = model.getValueAt(i,3).toString();
            double charge = Double.parseDouble(model.getValueAt(i,4).toString());

            Service service = new Service(id, pname, sname,date,charge);
            updateList.AddInfo(service);
        }
        serviceList.setAllServices(updateList.getAllService());

    }
}