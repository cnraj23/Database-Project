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
public class Song_Appear extends Frame implements ActionListener {

    /* @param args the command line arguments
     */
    Label songidl, authl, stitlel, albml, titlel, passwordl;
    TextField albmt, autht, songidt, stitlet, passwordt;
    Button b1, b2, b3, passit;
    static Button close;
    static Button b4;
    TextArea ta;
    String pass = "cs430@SIUC";
    static Boolean fg = false;

    Song_Appear() {
        setSize(900, 580);
        setVisible(true);
        setLayout(null);
        setTitle("Song Appear Record");
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

        songidl = new Label("SONG ID:");
        songidl.setBounds(40, 450, 60, 30);

        authl = new Label("AUTHOR:");
        authl.setBounds(195, 450, 60, 30);

        stitlel = new Label("Title:");
        stitlel.setBounds(357, 450, 35, 30);

        albml = new Label("Album ID:");
        albml.setBounds(490, 450, 60, 30);

        passwordl = new Label("Password:");
        passwordl.setBounds(590, 500, 65, 30);

        songidt = new TextField();
        songidt.setBounds(100, 450, 90, 30);

        autht = new TextField();
        autht.setBounds(260, 450, 90, 30);

        stitlet = new TextField();
        stitlet.setBounds(395, 450, 90, 30);

        albmt = new TextField();
        albmt.setBounds(550, 450, 90, 30);

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

        titlel = new Label("  Sr.No      Song ID          Author                 Title                Album ID");
        titlel.setBounds(40, 50, 550, 30);
        titlel.setForeground(Color.ORANGE);

        add(albml);
        add(authl);
        add(stitlel);
        add(songidl);
        add(songidt);
        add(autht);
        add(stitlet);
        add(albmt);
        add(passwordl);
        add(passwordt);
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
            ResultSet rs = stmt.executeQuery("select * from SONGS_APPEARS");
            rs.beforeFirst();
            ta.setText("");
            while (rs.next()) {
                ta.append("    " + i + "    ||  \t" + rs.getInt(1) + "      ||\t" + rs.getString(2) + "||\t" + rs.getString(3) + "    ||   \t" + rs.getInt(4) + "\n");
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

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt.executeUpdate("insert into SONGS_APPEARS  values(" + songidt.getText() + ",'" + autht.getText() + "','" + stitlet.getText() + "'," + albmt.getText() + ")");

                JOptionPane.showMessageDialog(null, "Song ID: " + songidt.getText() + " Inserted Successfully!");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Enter New Album ID or SSN is invalid");
                System.out.println(ex);
            }
            albmt.setText("");
            songidt.setText("");
            autht.setText("");
            stitlet.setText("");
            passwordt.setText("");
            songidt.setFocusable(true);

        }

        if (e.getSource() == b2) {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt.executeUpdate("delete from SONGS_APPEARS where SONGID =" + songidt.getText());

                JOptionPane.showMessageDialog(null, "SONG ID: " + songidt.getText() + " Deleted Successfully!");
                albmt.setText("");
                songidt.setText("");
                autht.setText("");
                stitlet.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            albmt.setText("");
            songidt.setText("");
            autht.setText("");
            stitlet.setText("");

        }

        if (e.getSource() == b4) {

            b4.setEnabled(false);
            new Update_song(songidt.getText(), autht.getText(), stitlet.getText(), albmt.getText());
            albmt.setText("");
            songidt.setText("");
            autht.setText("");
            stitlet.setText("");

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
