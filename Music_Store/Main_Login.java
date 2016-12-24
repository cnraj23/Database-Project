/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Store;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;


/**
 *
 * @author Chinmay
 */
public class Main_Login extends Frame implements ActionListener {

    // static TextField tt1, tt2;
    Label ll1, ll2, ll3;
    static Button bb1, b2;
    //static Checkbox cb;
    //String id = "cr", pas = "11";
    Font f;
    static Boolean fg = false;

    Main_Login() {
        setBackground(Color.darkGray);
        setSize(270, 275);
        setTitle("Welcome To . . .");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(400, 270);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (!fg) {
                    dispose();
                }
            }
        });

        f = new Font("Georgia", Font.BOLD, 14);
        setFont(f);
//        tt1 = new TextField();
//        tt1.setBounds(110, 40, 150, 30);
//
//        tt2 = new TextField();
//        tt2.setBounds(110, 80, 150, 30);
//        tt2.setEchoChar('*');
        ll1 = new Label("Notown Musical Store");
        ll1.setBounds(50, 40, 180, 20);
        ll1.setForeground(Color.white);

        ll2 = new Label("Continue As:");
        ll2.setBounds(50, 80, 180, 20);
        ll2.setForeground(Color.white);
//ll3 = new Label("");
        //ll3.setBounds(30, 110, 250, 20);
        //ll3.setForeground(Color.red);
        bb1 = new Button("CUSTOMER VIEW");
        bb1.setBounds(50, 125, 170, 50);
        bb1.setForeground(Color.BLUE);

        b2 = new Button("STAFF VIEW");
        b2.setBounds(50, 205, 170, 50);
        b2.setForeground(Color.BLUE);

//        cb = new Checkbox("log in", false);
//        cb.setBounds(40, 130, 60, 20);
//        cb.setEnabled(false);
        bb1.addActionListener(this);
        b2.addActionListener(this);
//        add(tt1);
//        add(cb);
//        add(tt2);
        //add(ll3);
        add(ll2);
        add(ll1);
        add(bb1);
        add(b2);
    }

    // Line try
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //g2d.drawLine(30, 225, 190, 225);
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(4f));
        g2d.draw(new Line2D.Double(0.2d, 190.8d, 290.1d, 190.8d));
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }

    //line try ends
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        new Main_Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // button 1
        if (e.getSource() == bb1) {
            new Customer();

//            if (id.equals(tt1.getText()) && pas.equals(tt2.getText())) {
//
//                tt1.setEnabled(false);
//                tt2.setEnabled(false);
//                bb1.setEnabled(false);
//                cb.setState(true);
//                fg = true;
//                new Staff();
//                // new Staff
//
//            } else {
//
//                ll3.setText("Incorrect Username or Password");
//                tt1.setText("");
//                tt2.setText("");
//            }
        }

        // button 2
        if (e.getSource() == b2) {
            //  new Customer();
            new Staff();
            //   new Album_producer();
            //new Musician();
        }
    }

}
