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
import javax.swing.JFrame;

/**
 *
 * @author Chinmay
 */
public class Customer extends Frame implements ActionListener {

    /* @param args the command line arguments
     */
    Label artistl, albuml, songl, titlel;
    static TextField artistt, albumt, songt;
    Button b1, b2, b3, clearb;
    static Button logout;
    static Button b4;
    TextArea ta;

    Customer() {
        setSize(800, 480);
        setVisible(true);
        setLayout(null);
        setTitle("Customer View");
        setResizable(false);
        Font fn = new Font("Georgia", Font.BOLD, 12);
        setFont(fn);
        setForeground(Color.black);
        setBackground(Color.darkGray);
        setLocation(300, 130);

        artistl = new Label("Artist:");
        artistl.setBounds(460, 80, 50, 30);

        albuml = new Label("Album :");
        albuml.setBounds(460, 140, 50, 30);

        songl = new Label("Song :");
        songl.setBounds(460, 200, 50, 30);

        artistt = new TextField();
        artistt.setBounds(510, 80, 90, 30);

        albumt = new TextField();
        albumt.setBounds(510, 140, 90, 30);

        songt = new TextField();
        songt.setBounds(510, 200, 90, 30);

        b1 = new Button("Search By Artist");
        b1.setBounds(620, 80, 105, 30);

        b2 = new Button("Search By Album");
        b2.setBounds(620, 140, 105, 30);

        b3 = new Button("Search By Song");
        b3.setBounds(620, 200, 105, 30);

        // clear
        clearb = new Button("Display All");
        clearb.setBounds(620, 260, 105, 30);

        ta = new TextArea();
        ta.setBounds(50, 80, 400, 350);
        ta.setBackground(Color.LIGHT_GRAY);
        ta.setFocusable(false);

        logout = new Button("CLOSE");
        logout.setBounds(510, 260, 95, 30);

        logout.setForeground(Color.white);
        logout.setBackground(Color.red);

        titlel = new Label("Sr.No          ARTIST                        ALBUM                          SONG TITLE");
        titlel.setBounds(40, 50, 400, 30);
        titlel.setForeground(Color.ORANGE);

        add(albuml);
        add(artistl);
        add(songl);
        add(albumt);
        add(artistt);
        add(songt);

        add(b1);
        add(b2);
        add(b3);
        add(clearb);

        add(logout);
        add(ta);
        add(titlel);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        clearb.addActionListener(this);

        logout.addActionListener(this);
        
        // enable / disable 
        //artistt.setEditable(false);
        //artistt.setFocusable(false);
        //artistt.setVisible(false);
        
    }

    public void display() {
        int i = 1;
        try {
            ta.setForeground(Color.BLUE);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from CUSTOMERVIEW");
            rs.beforeFirst();
            ta.setText("");
            while (rs.next()) {
                ta.append(" " + i + "    " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n");
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
// Search Artist
        if (e.getSource() == b1) {
            try {
                System.out.println(artistt.getText());

                ta.setForeground(Color.BLUE);
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from CUSTOMERVIEW where NAME ='" + artistt.getText() + "'");
                //rs.beforeFirst();
                ta.setText(" ");
                while (rs.next()) {
                    ta.append(" " + i + "    " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n");
                    i++;
                    songt.setText("");
                    albumt.setText("");
                    artistt.setText("");

                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
            songt.setText("");
            albumt.setText("");
            artistt.setText("");

        }

        // Search Album 
        if (e.getSource() == b2) {
            try {

                System.out.println(albumt.getText());

                ta.setForeground(Color.BLUE);
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from CUSTOMERVIEW where ALBUM_NAME ='" + albumt.getText() + "'");
                rs.beforeFirst();
                ta.setText(" ");
                while (rs.next()) {
                    ta.append(" " + i + "    " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n");
                    i++;

                    songt.setText("");
                    albumt.setText("");
                    artistt.setText("");
                }

            } catch (Exception ex) {
                System.out.println(ex);
                songt.setText("");
                albumt.setText("");
                artistt.setText("");

            }

        }   // Album Search ends here

        // Search Song 
        if (e.getSource() == b3) {
            try {

                System.out.println(songt.getText());

                ta.setForeground(Color.BLUE);
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from CUSTOMERVIEW where SONG_NAME ='" + songt.getText() + "'");
                rs.beforeFirst();
                ta.setText(" ");
                while (rs.next()) {
                    ta.append(" " + i + "    " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n");
                    i++;

                    songt.setText("");
                    albumt.setText("");
                    artistt.setText("");
                }

            } catch (Exception ex) {
                System.out.println(ex);
                songt.setText("");
                albumt.setText("");
                artistt.setText("");

            }

        }   // Song Search ends here

        // clear
        if (e.getSource() == clearb) {
            try {

                ta.setText(" ");
                songt.setText("");
                albumt.setText("");
                artistt.setText("");
                display();
                
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        // clear ends

        if (e.getSource()
                == logout) {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {

                    dispose();
                }
            });
          //  Main_Login.tt1.setEnabled(true);
            //Main_Login.tt2.setEnabled(true);
            Main_Login.bb1.setEnabled(true);
            //Main_Login.cb.setState(false);
            //Main_Login.tt2.setText("");
            Main_Login.fg = false;
            dispose();
        }

        //    display();
    }
}
