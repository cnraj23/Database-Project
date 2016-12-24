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
public class Staff extends Frame implements ActionListener {

    /* @param args the command line arguments
     */
    Label ll1;
    //Label namel, rolll, titlel;
    //TextField namet, rollt;
    //Button b1, b2, b3;
    static Button musician, inst, plays, song_app, tele_home, lives, places, perform, albm_prod;
    static Button logout;
    //static Button b4;
    //TextArea ta;

    Staff() {
        setSize(330, 375);
        setVisible(true);
        setLayout(null);
        setTitle("Staff Record");
        setResizable(false);
        Font fn = new Font("Georgia", Font.BOLD, 12);
        setFont(fn);
        setForeground(Color.black);
        setBackground(Color.darkGray);
        setLocation(400, 270);

        ll1 = new Label("Select Table :");
        ll1.setBounds(30, 60, 180, 20);
        ll1.setForeground(Color.white);
        ll1.setFont(new Font("Georgia", Font.BOLD, 20));
//        namel = new Label("Name:");
//        namel.setBounds(40, 450, 50, 30);
//
//        rolll = new Label("Roll NO:");
//        rolll.setBounds(190, 450, 70, 30);
//
//        namet = new TextField();
//        namet.setBounds(90, 450, 90, 30);
//
//        rollt = new TextField();
//        rollt.setBounds(260, 450, 90, 30);
//        b1 = new Button("ADD record");
//        b1.setBounds(40, 500, 100, 50);
//
//        b2 = new Button("DELETE record");
//        b2.setBounds(150, 500, 100, 50);
//
//        b3 = new Button("DISPLAY record");
//        b3.setBounds(260, 500, 100, 50);
//
//        b4 = new Button("UPDATE record");
//        b4.setBounds(370, 500, 100, 50);
// Edit table buttons
        musician = new Button("Musician");
        musician.setBounds(30, 120, 105, 30);

        inst = new Button("Instruments");
        inst.setBounds(30, 160, 105, 30);

        plays = new Button("Plays");
        plays.setBounds(30, 200, 105, 30);

        song_app = new Button("Song Appears");
        song_app.setBounds(30, 240, 105, 30);

        tele_home = new Button("Telephone Home");
        tele_home.setBounds(180, 280, 105, 30);

        lives = new Button("Lives");
        lives.setBounds(180, 120, 105, 30);

        places = new Button("Places");
        places.setBounds(180, 160, 105, 30);

        perform = new Button("Perform");
        perform.setBounds(180, 200, 105, 30);

        albm_prod = new Button("Album Producer");
        albm_prod.setBounds(180, 240, 105, 30);
// table buttons ends here

//        ta = new TextArea();
//        ta.setBounds(50, 80, 400, 350);
//        ta.setBackground(Color.LIGHT_GRAY);
//        ta.setFocusable(false);
//
        logout = new Button("Close");
        logout.setBounds(30, 280, 105, 30);

        logout.setForeground(Color.white);
        logout.setBackground(Color.red);
//        titlel = new Label("Sr.No          ARTIST                        ALBUM                          SONG TITLE");
//        titlel.setBounds(40, 50, 400, 30);
//        titlel.setForeground(Color.ORANGE);

//        add(namel);
//        add(rolll);
//        add(namet);
//        add(rollt);
//        add(b1);
//        add(b2);
//        add(b3);
//        add(b4);
        // table buttons
        add(musician);
        add(inst);
        add(plays);
        add(song_app);
        add(tele_home);
        add(lives);
        add(places);
        add(perform);
        add(albm_prod);
        add(ll1);
        // table buttons end here
        add(logout);
//        add(ta);
//        add(titlel);
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//        b4.addActionListener(this);
        //table button actionlistenr 
        musician.addActionListener(this);
        inst.addActionListener(this);
        plays.addActionListener(this);
        song_app.addActionListener(this);
        tele_home.addActionListener(this);
        lives.addActionListener(this);
        places.addActionListener(this);
        perform.addActionListener(this);
        albm_prod.addActionListener(this);

        // table buttons end here
        logout.addActionListener(this);
    }

//    public void display() {
//        int i = 1;
//        try {
//            ta.setForeground(Color.BLUE);
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = stmt.executeQuery("select * from musicians");
//            rs.beforeFirst();
//            ta.setText("");
//            while (rs.next()) {
//                ta.append("     \t" + i + "\t\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\n");
//                i++;
//            }
//            rs.close();
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int i = 1;
//        if (e.getSource() == b1) {
//            try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
//                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                stmt.executeUpdate("insert into musicians values(" + rollt.getText() + ",'" + namet.getText() + "')");
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            rollt.setText("");
//            namet.setText("");
//            rollt.setFocusable(true);
//        }
//
//        if (e.getSource() == b2) {
//            try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
//                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                stmt.executeUpdate("delete from musicians where ssn=" + rollt.getText());
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            namet.setText(" ");
//            rollt.setText(" ");
//            rollt.setFocusable(true);
//        }
//
//        if (e.getSource() == b4) {
//            b4.setEnabled(false);
        logout.setEnabled(true);
//            new Update(namet.getText(), rollt.getText());
//            rollt.setText(" ");
//            namet.setText(" ");
//        }

        // Table buttons functions
        // Musicians
        if (e.getSource() == musician) {

            new Musician();

        }

        // Instruments
        if (e.getSource() == inst) {

            new Instruments();

        }

        // Plays
        if (e.getSource() == plays) {

            new Plays();

        }

        // Song Appears
        if (e.getSource() == song_app) {

            new Song_Appear();

        }

        // Telephone Home
        if (e.getSource() == tele_home) {

            new Tele_home();

        }

        // Lives
        if (e.getSource() == lives) {

            new Lives();

        }

        // Places
        if (e.getSource() == places) {

            new Places();

        }

        // Perform
        if (e.getSource() == perform) {

            new Perform();

        }

        // Album Producer
        if (e.getSource() == albm_prod) {

            new Album_producer();

        }

        // Table Buttons functions end here
        if (e.getSource() == logout) {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {

                    dispose();
                }
            });
            // Main_Login.tt1.setEnabled(true);
            // Main_Login.tt2.setEnabled(true);
            Main_Login.bb1.setEnabled(true);
            // Main_Login.cb.setState(false);
            // Main_Login.tt2.setText("");
            Main_Login.fg = false;
            dispose();
            //    display();
        }

    }
}
