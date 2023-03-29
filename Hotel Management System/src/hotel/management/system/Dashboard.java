
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null); 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ; 
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("DECCAN SERAI WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Cambria",Font.BOLD,46));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(500,200,350,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT") ;  // MENU  
        hotel.setForeground(Color.red);
        hotel.setFont(new Font("roboto",Font.BOLD,20));
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION") ; 
        reception.setFont(new Font("serif",Font.BOLD,15));
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN") ;          // MENU 
        admin.setForeground(Color.blue);
        admin.setFont(new Font("roboto",Font.BOLD,20));
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE") ; 
        addemployee.setFont(new Font("serif",Font.BOLD,15));
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS") ; 
        addrooms.setFont(new Font("serif",Font.BOLD,15));
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS") ; 
        adddrivers.setFont(new Font("serif",Font.BOLD,15));
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        setVisible(true);
           
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Dashboard();
    }
}
