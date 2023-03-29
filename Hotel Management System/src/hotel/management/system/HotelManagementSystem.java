
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){ // constructor created 
        setSize(1024,683); // size same as image 
        //setLocation(100,100);
        setLayout(null) ; // bydefault borderlayout is used , we change it to null
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hms1.jpg"));
        // to get image , we use classloader and getresource...and give url of image .
        JLabel image = new JLabel(i1) ; //jlabel to perform anything on frame
        image.setBounds(0,0,1024,683); //locx ,locy ,len , bre (wrt to frame)
        add(image);  // pasting image on frame
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM ");
        text.setBounds(20 , 550 ,1000 , 90) ; 
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.BOLD,40));
        image.add(text); // to add on text on image
        
        JButton next = new JButton("Next");
        next.setBounds(804,550,150,50);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        
        next.setFont(new Font("serif",Font.ITALIC,40));
        image.add(next);
        
        setVisible(true); 
        
        while(true){  // dipper --show and hide
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem() ;  // object created .
    }   
}
  