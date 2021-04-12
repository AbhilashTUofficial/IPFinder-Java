package com.ipfinder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main extends JFrame implements ActionListener {
    TextField enterUrl,IP;
    Button getIP, hack;
    String url;

    Main(){
        setBounds(200,50,400,400);
        setTitle("IP Address Finder - Hack NASA!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(null);
        setResizable(false);

        enterUrl=new TextField("www.google.com",25);
        enterUrl.setFont(new Font("Arial",Font.BOLD,18));
        enterUrl.setBounds(46,100,300,30);

        getIP=new Button("Get IP Address");
        getIP.addActionListener(this);
        getIP.setBounds(60,150,100,40);


        hack =new Button("Hack");
        hack.addActionListener(this);
        hack.setBounds(220,150,100,40);


        IP=new TextField(25);
        IP.setFont(new Font("Arial",Font.BOLD,18));
        IP.setBounds(46,216,300,30);

        add(enterUrl);
        add(getIP);
        add(hack);
        add(IP);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getIP){
            try {
                url=enterUrl.getText();
                InetAddress ia=InetAddress.getByName(url);
                String ip=ia.getHostAddress();
                IP.setText(ip);
            } catch (UnknownHostException e1) {
                JOptionPane.showMessageDialog(this,e1.toString());
            }

        }
        if(e.getSource()==hack){
            url=enterUrl.getText();
            try{
                JOptionPane.showMessageDialog(this,"Successful! "+url+" Is Hacked");
            }catch(Exception e2){

            }
        }
    }

    public static void main(String[] args) {
	new Main();
    }


}
//JOptionPane.showMessageDialog(this,ip);
// this open-up a dialog box