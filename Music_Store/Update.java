/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import static Music_Store.Musician.b4;
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
public class Update extends Frame implements ActionListener {

    Label lu1, lu2, lu3, lu4;
    TextField tu1, tu2, tu3, tu4;
    String name, ssn;
    Button up;

    Update(String name, String ssn) {
        setSize(320, 120);
        setVisible(true);
        setResizable(false);
        setTitle("Musician Update Record");
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
        this.name = name;
        this.ssn = ssn;

        tu1 = new TextField();
        tu1.setBounds(120, 40, 100, 30);

        tu2 = new TextField();
        tu2.setBounds(120, 70, 100, 30);

        lu1 = new Label("SSN:");
        lu1.setBounds(25, 40, 80, 20);

        lu2 = new Label("NAME:");
        lu2.setBounds(25, 70, 80, 20);

        up = new Button("UPDATE");
        up.setBounds(230, 40, 70, 60);
        up.setForeground(Color.MAGENTA);
        add(lu1);
        add(lu2);
        add(tu1);
        add(tu2);
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
            stmt1.executeUpdate("update musicians set SSN='" + tu1.getText() + "' where SSN='" + ssn + "'");
            stmt2.executeUpdate("update musicians set NAME='" + tu2.getText() + "' where NAME='" + name + "'");

            JOptionPane.showMessageDialog(null, name + ", " + ssn + " Updated Successfully!! ");

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ssn + ", " + name + " not updated!!");
        }
        tu1.setText("");
        tu2.setText("");
        tu1.setFocusable(true);

        b4.setEnabled(true);
        dispose();
    }
}
