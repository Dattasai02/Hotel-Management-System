
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCust ,rooms ,dept , allem , custinfo ,maninfo , checkout , update , roomstatus , pickup , searchroom , logout; 
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*********CUSTOMER FORM*************/
        newCust = new JButton("New Customer Form");
        newCust.setBounds(10,30,200,30);
        newCust.setBackground(Color.BLACK);
        newCust.setForeground(Color.WHITE);
        newCust.addActionListener(this);
        add(newCust);
        /*********ROOMS*************/
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        /*********dept*************/
        dept = new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.addActionListener(this);
        add(dept);
        /*********all employee*************/
        allem = new JButton("All employee");
        allem.setBounds(10,150,200,30);
        allem.setBackground(Color.BLACK);
        allem.setForeground(Color.WHITE);
        allem.addActionListener(this);
        add(allem);
        /*********Customer Info*************/
        custinfo = new JButton("Customer Info");
        custinfo.setBounds(10,190,200,30);
        custinfo.setBackground(Color.BLACK);
        custinfo.setForeground(Color.WHITE);
        custinfo.addActionListener(this);
        add(custinfo);
        /*********Manager Info*************/
        maninfo = new JButton("Manager Info");
        maninfo.setBounds(10,230,200,30);
        maninfo.setBackground(Color.BLACK);
        maninfo.setForeground(Color.WHITE);
        maninfo.addActionListener(this);
        add(maninfo);
        /*********Checkout*************/
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        /*********Update Status*************/
        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        /*********Room Status*************/
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        /*********Pickup Service*************/
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        /*********Search Rooms*************/
        searchroom = new JButton("Search Rooms");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        /*********Logout*************/
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg")); 
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCust){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==dept){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==allem){
            setVisible(false);
            new employeeinfo();
        }
        else if(ae.getSource()==maninfo){
            setVisible(false);
            new managerinfo();
        }
        else if(ae.getSource()==custinfo){
            setVisible(false);
            new customerinfo();
        }
        else if(ae.getSource()==searchroom){
            setVisible(false);
            new searchRoom();
        }
        /*********/
        else if(ae.getSource()==checkout){
            setVisible(false);
            new checkout();
            
        }
        else if(ae.getSource()==roomstatus){
            setVisible(false);
            new updateroom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new updatecheck();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new pickup();
            
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
    
}
