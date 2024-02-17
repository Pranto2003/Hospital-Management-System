package GUI;
import Entities.Morgue;
import EntityList.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MorgueDetails extends JFrame implements ActionListener {

    Font font1 = new Font("Arial",Font.BOLD,20);
    Font font2 = new Font("Arial",Font.PLAIN,15);
    Font font3 = new Font("Arial",Font.BOLD,15);
    Font font4 = new Font("Arial Rounded MT Bold",Font.BOLD,36);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon,img;
    private Container c;
    private JLabel lEnterInfo, lName, lID, lDateOfDeath, lCauseOfDeath, lGender, lSearchByID,l1;
    private JTextField tfName,tfID,tfDateOfDeath,tfGender,tfSearchByID;
    private JTextArea taCauseOfDeath;
    private JButton bInsert,bBack,bRemove,bSearch,bUpdate,bClear;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String[] columns = {"ID","Name","Gender","Date of Death","Cause of Death"};
    private String[] rows = new String[5];

    HomePage hp;
    MorgueList morgueList;
    ServiceList serviceList;
    DoctorList doctorList;
    StaffList staffList;
    PatientList patientList;
	public MorgueDetails(HomePage hp,MorgueList morgueList){
        this.hp = hp;
        this.morgueList = morgueList;
        insert();

        createTable();
    }
	
	public void insert(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20,40,1350,750);
        this.setTitle("Health Mate");

        c = this.getContentPane();
        c.setBackground(new Color(210, 224, 225));
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Pictures/image.png"));
        this.setIconImage(icon.getImage());
		
		lEnterInfo = new JLabel("Enter Information:");
        lEnterInfo.setBounds(10,10,380,30);
        lEnterInfo.setFont(font1);
        c.add(lEnterInfo);

        l1 = new JLabel("Morgue's Information");
        l1.setBounds(600,5,400,42);
        l1.setFont(font4);
        c.add(l1);

        lName = new JLabel("Corpse's Name:");
        lName.setBounds(20,50,190,25);
        lName.setFont(font1);
        c.add(lName);

        tfName = new JTextField();
        tfName.setToolTipText("Enter Name");
        tfName.setBounds(212,50,220,25);
        tfName.setFont(font2);
        c.add(tfName);
		
		lID = new JLabel("Corpse's ID:");
        lID.setBounds(20,85,190,25);
        lID.setFont(font1);
        c.add(lID);

        tfID = new JTextField();
        tfID.setToolTipText("Corpse's ID");
        tfID.setBounds(212,85,220,25);
        tfID.setFont(font2);
        c.add(tfID);

        lGender = new JLabel("Gender:");
        lGender.setBounds(20,120,90,25);
        lGender.setFont(font1);
        c.add(lGender);

        tfGender = new JTextField();
        tfGender.setToolTipText("Enter Gender");
        tfGender.setBounds(212,120,100,25);
        tfGender.setFont(font2);
        c.add(tfGender);

        lDateOfDeath = new JLabel("Date of Death:");
        lDateOfDeath.setBounds(20,155,200,25);
        lDateOfDeath.setFont(font1);
        c.add(lDateOfDeath);
		
		tfDateOfDeath = new JTextField();
        tfDateOfDeath.setToolTipText("Enter Date of Death");
        tfDateOfDeath.setBounds(212,155,100,25);
        tfDateOfDeath.setFont(font2);
        c.add(tfDateOfDeath);

        lCauseOfDeath = new JLabel("Cause of Death:");
        lCauseOfDeath.setBounds(20,190,150,25);
        lCauseOfDeath.setFont(font1);
        c.add(lCauseOfDeath);
		
		taCauseOfDeath = new JTextArea();
        taCauseOfDeath.setToolTipText("Enter Cause of Death");
        taCauseOfDeath.setBounds(20,220,200,80);
        taCauseOfDeath.setLineWrap(true);
        taCauseOfDeath.setWrapStyleWord(true);
        taCauseOfDeath.setFont(font2);
        c.add(taCauseOfDeath);

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

        scroll = new JScrollPane(table);
        scroll.setBounds(445, 50, 870, 550);
        scroll.setBackground(Color.cyan);
        c.add(scroll);

        table.getColumnModel().getColumn(0);
        table.getColumnModel().getColumn(1);
        table.getColumnModel().getColumn(2);
        table.getColumnModel().getColumn(3);
        table.getColumnModel().getColumn(4);

        String file = ".\\Storage\\MorgueDetails.txt";

        try{

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {

                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0,14);
                if (x.equals("Corpse's ID : ")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(14);       // Corpse's ID :
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(14); // Name        :
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(14); // Gender      :
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(15); // Date of Death :
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(16); // Cause of Death :
                    model.addRow(rows);
                }
            }

            Entities.Morgue morgues[];
            morgues = this.morgueList.getAllMorgue();

            for (int i = 0; i<= morgues.length; i++){
                if(morgues[i] != null){
                    model.addRow(new Object[]{
                            morgues[i].getID(),
                            morgues[i].getName(),
                            morgues[i].getGender(),
                            morgues[i].getDOD(),
                            morgues[i].getCOD(),
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
                String DoD = model.getValueAt(numberOfRow,3).toString();
                String gender = model.getValueAt(numberOfRow,2).toString();
                String causeofdeath = model.getValueAt(numberOfRow,4).toString();


                tfID.setText(id);
                tfName.setText(name);
                tfGender.setText(gender);
                tfDateOfDeath.setText(DoD);
                taCauseOfDeath.setText(causeofdeath);
            }
        });


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bInsert){

            String id = tfID.getText();
            String name = tfName.getText();
            String gender = tfGender.getText();
            String DOD = tfDateOfDeath.getText();
            String COD = taCauseOfDeath.getText();

            Entities.Morgue m = new Morgue(id,name,gender,DOD,COD);
            morgueList.AddInfo(m);
            model.addRow(new Object[]{
                    rows[0] = m.getID(),
                    rows[1] = m.getName(),
                    rows[2] = m.getGender(),
                    rows[3] = m.getDOD(),
                    rows[4] = m.getCOD()
            });

            String file = ".\\Storage\\MorgueDetails.txt";
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

                pw.println("Corpse's ID : " +rows[0]);
                pw.println("Name        : " + rows[1]);
                pw.println("Gender      : " + rows[2]);
                pw.println("Date of Death : " + rows[3]);
                pw.println("Cause of death : " + rows[4]);
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
            tfGender.setText("");
            tfDateOfDeath.setText("");
            taCauseOfDeath.setText("");
        }

        else if (e.getSource() == bRemove) {
    int selectedRow = table.getSelectedRow();

    if (selectedRow >= 0) {
        String id = model.getValueAt(selectedRow, 0).toString();
        morgueList.RemoveInfo(id);
        model.removeRow(selectedRow);

        // Update the file
        try {
            String file = ".\\Storage\\MorgueDetails.txt";
            String tempFile = ".\\Storage\\temp.txt";

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("Corpse's ID : " + id)) {
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
    } else {
        JOptionPane.showMessageDialog(null, "No Data is being Selected", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}

        else if (e.getSource() == bUpdate) {

            DefaultTableModel tm = (DefaultTableModel) table.getModel();
            if(table.getSelectedRowCount() == 1) {

                String id = tfID.getText();
                String name = tfName.getText();
                String gender = tfGender.getText();
                String DoD = tfDateOfDeath.getText();
                String causeofdeath = taCauseOfDeath.getText();

                tm.setValueAt(id, table.getSelectedRow(), 0);
                tm.setValueAt(name, table.getSelectedRow(), 1);
                tm.setValueAt(gender, table.getSelectedRow(), 2);
                tm.setValueAt(DoD, table.getSelectedRow(), 3);
                tm.setValueAt(causeofdeath, table.getSelectedRow(), 4);

                JOptionPane.showMessageDialog(this, "Update Successfully");
                tableModuleToList();

            }
            else {
                JOptionPane.showMessageDialog(this,"Please select a row first.");
            }

        }

        else if(e.getSource() == bSearch){

            String file = ".\\Storage\\MorgueDetails.txt";
            String id = tfSearchByID.getText(); // ID

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the id.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    String ids = "Corpse's ID : " + id;
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
                                String x = lines.substring(0,14);
                                if (x.equals("Corpse's ID : ")) {
                                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(14); // Corpse's ID
                                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(14); // Name
                                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(14); // Gender
                                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(15); // Date of Death
                                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(16); // Cause of Death

                                    tfID.setText(rows[0]);
                                    tfName.setText(rows[1]);
                                    tfGender.setText(rows[2]);
                                    tfDateOfDeath.setText(rows[3]);
                                    taCauseOfDeath.setText(rows[4]);
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
        MorgueList updateList = new MorgueList(200);
        for (int i = 0; i < rows; i++) {

            String pid = model.getValueAt(i,0).toString();
            String pname = model.getValueAt(i,1).toString();
            String gender = model.getValueAt(i,2).toString();
            String DOD = model.getValueAt(i,3).toString();
            String COD = model.getValueAt(i,4).toString();

            Morgue morgue = new Morgue(pid, pname, gender,DOD,COD);
            updateList.AddInfo(morgue);
        }
        morgueList.setAllMorgues(updateList.getAllMorgue());

    }
}


		
		
		
		

	
	