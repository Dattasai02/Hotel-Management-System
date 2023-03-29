
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.* ;
import net.proteanit.sql.*;

public class pickup extends JFrame implements ActionListener {
    JTable table ; 
    JButton submit ,back ; 
    Choice cartype;
    pickup(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
     
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        /**********TYPE car**********/
        JLabel lbed = new JLabel("Car Type");
        lbed.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbed.setBounds(50,100,100,20);
        add(lbed);
        cartype = new Choice();
        cartype.setBounds(150,100,200,25);
        add(cartype);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartype.add(rs.getString("carmodel"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("CarType");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Availabilty");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            // rsxml .jar to fill table
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(250,150,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
               String query = "select * from driver where carmodel='"+cartype.getSelectedItem()+"' "; 
               Conn conn = new Conn();
               ResultSet rs = conn.s.executeQuery(query); ; 
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
        setVisible(false);
        new Reception();
        }
    }
    public static void main(String[] args){
        new pickup();
    }
}
