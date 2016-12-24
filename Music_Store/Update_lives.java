/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import static Music_Store.Lives.b4;
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
public class Update_lives extends Frame implements ActionListener {

    Label lu1, lu2, lu3;
    TextField tu1, tu2, tu3;
    String ssn, phone, address;
    Button up;

    Update_lives(String ssn, String phone, String address) {
        setSize(320, 220);
        setVisible(true);
        setResizable(false);
        setTitle("Lives Update Record");
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
        this.ssn = ssn;
        this.phone = phone;
        this.address = address;

        tu1 = new TextField();
        tu1.setBounds(120, 40, 100, 30);

        tu2 = new TextField();
        tu2.setBounds(120, 70, 100, 30);

        tu3 = new TextField();
        tu3.setBounds(120, 100, 100, 30);

        lu1 = new Label("SSN:");
        lu1.setBounds(25, 40, 80, 20);

        lu2 = new Label("PHONE:");
        lu2.setBounds(25, 70, 80, 20);

        lu3 = new Label("ADDRESS:");
        lu3.setBounds(25, 100, 80, 20);

        up = new Button("UPDATE");
        up.setBounds(230, 40, 70, 60);
        up.setForeground(Color.MAGENTA);
        add(lu1);
        add(lu2);
        add(lu3);
        add(tu1);
        add(tu2);
        add(tu3);
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
            stmt1.executeUpdate("update LIVES set ssn='" + tu1.getText() + "' where ssn='" + ssn + "'");
            stmt2.executeUpdate("update LIVES set PHONE='" + tu2.getText() + "' where ssn='" + ssn + " ' AND ADDRESS = '" + address + "'");
            stmt3.executeUpdate("update LIVES set address='" + tu3.getText() + "' where address='" + address + "'");
            JOptionPane.showMessageDialog(null, ssn + " , " + phone + " , " + address + " Updated Successfully!! ");

         

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ssn + " , " + phone + " F, " + address + " not updated!!");
        }
        tu1.setText("");
        tu2.setText("");
        tu3.setText("");
        tu1.setFocusable(true);

        b4.setEnabled(true);
        dispose();
    }
}
