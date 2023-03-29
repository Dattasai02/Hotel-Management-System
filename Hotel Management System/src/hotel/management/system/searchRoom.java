
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.* ;
import net.proteanit.sql.*;

public class searchRoom extends JFrame implements ActionListener {
    JTable table ; 
    JButton submit ,back ; 
    JComboBox bed_type ; 
    JCheckBox av ; 
    searchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
     
        JLabel text = new JLabel("Search for Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        /**********BED TYPE**********/
        JLabel lbed = new JLabel("Bed Type");
        lbed.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbed.setBounds(50,100,100,20);
        add(lbed);
        String bt[] = { "Single Bed " , "Double Bed "};
        bed_type = new JComboBox(bt);
        bed_type.setBounds(150,100,150,25);
        bed_type.setBackground(Color.WHITE);
        add(bed_type);
        /*******Available**/
        av=new JCheckBox("Only display Available");
        av.setBounds(650,100,150,25);
        av.setBackground(Color.WHITE);
        add(av);
                
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
               String query1 = "select * from room where bedtype='"+bed_type.getSelectedItem()+"' "; 
               String query2 = "select * from room where availability='Available ' AND bedtype='"+bed_type.getSelectedItem()+"'  "; 
               Conn conn = new Conn();
               ResultSet rs ; 
               if(av.isSelected()){
                   rs=conn.s.executeQuery(query2);
               }
               else{
                   rs=conn.s.executeQuery(query1);
               }
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
        new searchRoom();
    }
}
