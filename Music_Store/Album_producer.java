/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;
import javax.swing.JOptionPane;
//import javax.swing.JFrame;

/**
 *
 * @author Chinmay
 */
public class Album_producer extends Frame implements ActionListener {

    /* @param args the command line arguments
     */
    Label albumidl, ssnl, datel, speedl, atitlel, titlel, passwordl;
    TextField albumidt, ssnt, datet, speedt, atitlet, passwordt;
    Button b1, b2, b3, passit;
    static Button close;
    static Button b4;
    TextArea ta;
    Image img;
    String pass = "cs430@SIUC";
    static Boolean fg = false;

    Album_producer() {
        setSize(900, 580);
        setVisible(true);
        setLayout(null);
        setTitle("Album Producer Record");
        setResizable(false);
        Font fn = new Font("Georgia", Font.BOLD, 12);
        setFont(fn);
        setForeground(Color.black);
        setBackground(Color.darkGray);
        setLocation(300, 130);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (!fg) {
                    dispose();
                }
            }
        });

        albumidl = new Label("ALBUM ID:");
        albumidl.setBounds(40, 450, 60, 30);

        ssnl = new Label("SSN:");
        ssnl.setBounds(205, 450, 30, 30);

        datel = new Label("Date:");
        datel.setBounds(337, 450, 35, 30);

        speedl = new Label("Speed:");
        speedl.setBounds(470, 450, 45, 30);

        atitlel = new Label("Title:");
        atitlel.setBounds(620, 450, 40, 30);

        passwordl = new Label("Password:");
        passwordl.setBounds(590, 500, 65, 30);

        albumidt = new TextField();
        albumidt.setBounds(110, 450, 90, 30);

        ssnt = new TextField();
        ssnt.setBounds(240, 450, 90, 30);

        datet = new TextField();
        datet.setBounds(375, 450, 90, 30);

        speedt = new TextField();
        speedt.setBounds(520, 450, 90, 30);

        atitlet = new TextField();
        atitlet.setBounds(660, 450, 90, 30);

        passwordt = new TextField();
        passwordt.setBounds(660, 500, 90, 30);
        passwordt.setEchoChar('*');

        b1 = new Button("ADD record");
        b1.setBounds(40, 500, 100, 50);

        b2 = new Button("DELETE record");
        b2.setBounds(150, 500, 100, 50);

        b3 = new Button("DISPLAY record");
        b3.setBounds(260, 500, 100, 50);

        b4 = new Button("UPDATE record");
        b4.setBounds(370, 500, 100, 50);

        passit = new Button("verify ME!");
        passit.setBounds(780, 500, 70, 30);

        ta = new TextArea();
        ta.setBounds(50, 80, 550, 350);
        ta.setBackground(Color.LIGHT_GRAY);
        ta.setFocusable(false);

        close = new Button("Close");
        close.setBounds(480, 500, 90, 30);

        close.setForeground(Color.white);
        close.setBackground(Color.red);

        titlel = new Label("  Sr.No      Album ID          SSN                 © DATE                SPEED              ALBUM TITLE");
        titlel.setBounds(40, 50, 550, 30);
        titlel.setForeground(Color.ORANGE);

        add(albumidl);
        add(ssnl);
        add(datel);
        add(speedl);
        add(titlel);
        add(atitlel);
        add(passwordl);
        add(passwordt);
        add(albumidt);
        add(ssnt);
        add(datet);
        add(speedt);
        add(atitlet);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(passit);
        add(close);
        add(ta);
        add(titlel);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        passit.addActionListener(this);
        close.addActionListener(this);

        // buttons disabled
        b1.setEnabled(false);
        b2.setEnabled(false);
        b4.setEnabled(false);
    }

    public void display() {
        int i = 1;
        try {
            ta.setForeground(Color.BLUE);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from ALBUM_PRODUCER");
            rs.beforeFirst();
            ta.setText("");
            while (rs.next()) {
                ta.append("    " + i + "    ||  \t" + rs.getInt(1) + "      ||\t" + rs.getString(2) + "||\t" + rs.getString(3) + "    ||   \t" + rs.getInt(4) + "    ||   \t" + rs.getString(5) + "\n");
                i++;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int i = 1;
        if (e.getSource() == passit) {

            if (pass.equals(passwordt.getText())) {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b4.setEnabled(true);
                passwordt.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Enter Correct Password!");
                passwordt.setText("");
            }

        }

        if (e.getSource() == b1) {

            String mydate;
            int myspeed;
            if (datet.getText() == null) {
                mydate = null;

            } else {
                mydate = datet.getText();
            }

            if ("".equals(speedt.getText())) {
                speedt.setText("0");
                myspeed = Integer.parseInt(speedt.getText());
            } else {
                myspeed = Integer.parseInt(speedt.getText());
            }

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt.executeUpdate("insert into ALBUM_PRODUCER  values(" + albumidt.getText() + ",'" + ssnt.getText() + "','" + mydate + "'," + myspeed + ",'" + atitlet.getText() + "')");

                JOptionPane.showMessageDialog(null, "Album ID: " + albumidt.getText() + " Inserted Successfully!");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Enter New Album ID or SSN is invalid");
                System.out.println(ex);
            }
            albumidt.setText("");
            ssnt.setText("");
            datet.setText("");
            speedt.setText("");
            atitlet.setText("");
            passwordt.setText("");
            ssnt.setFocusable(true);

        }

        if (e.getSource() == b2) {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt.executeUpdate("delete from ALBUM_PRODUCER where ALBUMIDENTIFIER=" + albumidt.getText());

                JOptionPane.showMessageDialog(null, "Album ID: " +albumidt.getText() + " Deleted Successfully!");
                albumidt.setText("");
                ssnt.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            albumidt.setText("");
            ssnt.setText("");
            datet.setText("");
            speedt.setText("");
            atitlet.setText("");

        }

        if (e.getSource() == b4) {

            b4.setEnabled(false);
            new Update_album(albumidt.getText(), ssnt.getText(), datet.getText(), speedt.getText(), atitlet.getText());
            albumidt.setText("");
            ssnt.setText("");
            datet.setText("");
            speedt.setText("");
            atitlet.setText("");

        }

        if (e.getSource() == close) {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {

                    dispose();
                }
            });
            dispose();
        }

        display();
    }
}
