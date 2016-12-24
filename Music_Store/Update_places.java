/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import static Music_Store.Places.b4;
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
public class Update_places extends Frame implements ActionListener {

    Label lu1;
    TextField tu1;
    String place;
    Button up;

    Update_places(String place) {
        setSize(320, 120);
        setVisible(true);
        setResizable(false);
        setTitle("Places Update");
        setLayout(null);
        Font fm = new Font("Georgia", Font.BOLD, 13);
        setFont(fm);
        setLocation(340, 400);
        setForeground(Color.black);
        setBackground(Color.darkGray);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                b4.setEnabled(true);
                dispose();
            }
        });
        this.place = place;

        tu1 = new TextField();
        tu1.setBounds(120, 40, 100, 30);

        lu1 = new Label("PLACE:");
        lu1.setBounds(25, 40, 80, 20);

        up = new Button("UPDATE");
        up.setBounds(230, 40, 70, 60);
        up.setForeground(Color.MAGENTA);
        add(lu1);
        add(tu1);
        add(up);
        up.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt1.executeUpdate("update places set address='" + tu1.getText() + "' where address='" + place + "'");

            JOptionPane.showMessageDialog(null, place + " Updated Successfully!! ");

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(place + " not updated!!");
        }
        tu1.setText("");
        tu1.setFocusable(true);

        b4.setEnabled(true);
        dispose();
    }
}
