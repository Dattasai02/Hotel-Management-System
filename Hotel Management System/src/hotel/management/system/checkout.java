
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.* ;
import net.proteanit.sql.*;
import java.util.Date;

public class checkout extends JFrame implements ActionListener {
    Choice ccust ;
    JLabel lroomnum ,lcheckin ,lcheckout ;
    JButton checkout , back ;
    checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel co = new JLabel("Checkout");
        co.setBounds(100,20,100,30);
        co.setForeground(Color.BLUE);
        co.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(co);
        /*******CUST ID**********/
        JLabel lid = new JLabel("Customer ID");
        lid.setBounds(30,80,100,30);
        add(lid);
        ccust = new Choice();
        ccust.setBounds(150,80,120,25);
        add(ccust);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        /*******ROOM Num**********/
        JLabel lr = new JLabel("Room Number");
        lr.setBounds(30,130,100,30);
        add(lr);
        lroomnum = new JLabel();
        lroomnum.setBounds(200,130,100,30);
        add(lroomnum);
        /*******CHECKIN time**********/
        JLabel lci = new JLabel("Checkin Time");
        lci.setBounds(30,180,100,30);
        add(lci);
        lcheckin = new JLabel();
        lcheckin.setBounds(150,180,150,30);
        add(lcheckin);
        /*******CHECKouttime**********/
        JLabel lco = new JLabel("Checkout Time");
        lco.setBounds(30,230,100,30);
        add(lco);
        Date date =new Date();
        lcheckout = new JLabel(""+date);
        lcheckout.setBounds(150,230,150,30);
        add(lcheckout);
        
        checkout = new JButton("Checkout");
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(("select * from customer"));
            while(rs.next()){
                ccust.add(rs.getString("number"));
                lroomnum.setText(rs.getString("roomnumber"));
                lcheckin.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query1 = "delete from customer where number = '"+ccust.getSelectedItem()+"' " ; 
            String query2 = "update room set availability= 'Available' where roomnumber = '"+lroomnum.getText()+"' " ; 
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    
    
    public static void main(String[] args){
        new checkout();
    } 
    
}
