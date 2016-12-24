/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import static Music_Store.Album_producer.b4;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import javax.swing.JFrame;

/**
 *
 * @author Chinmay
 */
public class Update_song extends Frame implements ActionListener {

    Label lu1, lu2, lu3, lu4;
    TextField tu1, tu2, tu3, tu4;
    String albumid, songid, author, stitle;
    Button up;
    static Boolean fg = false;

    Update_song(String songid, String author, String stitle, String albumid) {
        setSize(320, 220);
        setVisible(true);
        setResizable(false);
        setTitle("Song Update");
        setLayout(null);
        Font fm = new Font("Georgia", Font.BOLD, 13);
        setForeground(Color.black);
        setBackground(Color.darkGray);
        setFont(fm);
        setLocation(340, 400);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (!fg) {
                    b4.setEnabled(true);
                    dispose();
                }
            }
        });

        this.albumid = albumid;
        this.songid = songid;
        this.author = author;
        this.stitle = stitle;
        tu1 = new TextField();
        tu1.setBounds(120, 40, 100, 30);

        tu2 = new TextField();
        tu2.setBounds(120, 70, 100, 30);

        tu3 = new TextField();
        tu3.setBounds(120, 100, 100, 30);

        tu4 = new TextField();
        tu4.setBounds(120, 130, 100, 30);

        lu1 = new Label("Song ID:");
        lu1.setBounds(25, 40, 80, 20);

        lu2 = new Label("Author:");
        lu2.setBounds(25, 70, 80, 20);

        lu3 = new Label("Title:");
        lu3.setBounds(25, 100, 80, 20);

        lu4 = new Label("Album ID:");
        lu4.setBounds(25, 130, 80, 20);

        up = new Button("UPDATE");
        up.setBounds(230, 40, 70, 60);
        up.setForeground(Color.MAGENTA);
        add(lu1);
        add(lu2);
        add(lu3);
        add(lu4);

        add(tu1);
        add(tu2);
        add(tu3);
        add(tu4);

        add(up);
        up.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt1.executeUpdate("update SONGS_APPEARS set SONGID=" + tu1.getText() + " where SONGID=" + songid);
            stmt2.executeUpdate("update SONGS_APPEARS set AUTHOR='" + tu2.getText() + "' where AUTHOR='" + author + "'");
            stmt3.executeUpdate("update SONGS_APPEARS set TITLE='" + tu3.getText() + "' where TITLE='" + stitle + "'");
            stmt4.executeUpdate("update SONGS_APPEARS set ALBUMIDENTIFIER=" + tu4.getText() + " where ALBUMIDENTIFIER=" + albumid);

            JOptionPane.showMessageDialog(null, songid + "," + author + "," + stitle + "," + albumid + " Updated Successfully!!");
            b4.setEnabled(true);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(albumid + "," + stitle + "," + author + "," + songid + "not updated!!");
        }
        tu1.setText("");
        tu2.setText("");
        tu3.setText("");
        tu4.setText("");

        tu1.setFocusable(true);

        dispose();
    }
}
