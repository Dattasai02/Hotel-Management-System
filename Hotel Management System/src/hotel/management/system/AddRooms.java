
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tfroom , tfprice ; 
    JComboBox avcombo ,cleancombo , typecombo ; 
    JButton add , cancel ; 
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        /*************ROOMNUMBER**********/
        JLabel lroomno = new JLabel("ROOM NUMBER");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(60,80,120,30);
        add(lroomno);
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        /*************ROOMAVAILABLE**********/
        JLabel lavb = new JLabel("AVAILABLE");
        lavb.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavb.setBounds(60,130,120,30);
        add(lavb);
        String avop[] = { "Available" , "Occupied"};
        avcombo = new JComboBox(avop);
        avcombo.setBounds(200,130,150,30);
        avcombo.setBackground(Color.WHITE);
        add(avcombo);
        /*************ROOMCLEANSTATUS**********/
        JLabel lrcs = new JLabel("CLEAN STATUS");
        lrcs.setFont(new Font("Tahoma",Font.PLAIN,16));
        lrcs.setBounds(60,180,120,30);
        add(lrcs);
        String clop[] = { "Cleaned" , "Not Cleaned"};
        cleancombo = new JComboBox(clop);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        /*************ROOMPRICE**********/
        JLabel lprice = new JLabel("ROOM PRICE");
        lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lprice.setBounds(60,230,120,30);
        add(lprice);
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        /*************BED TYPE**********/
        JLabel ltype = new JLabel("BED TYPE");
        ltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltype.setBounds(60,280,120,30);
        add(ltype);
        String bt[] = { "Single Bed" , "Double Bed"};
        typecombo = new JComboBox(bt);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        /*************ADD ROOMS AND CANCEL**********/
        add = new JButton("ADD ROOM");
        add.setBounds(60,350,130,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.GREEN);
        add.addActionListener(this);
        add(add);
        cancel = new JButton("CANCEL");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg")); 
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(330,200,940,470);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnum = tfroom.getText();
            String available = (String)avcombo.getSelectedItem();
            String clean = (String)cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)typecombo.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String str = "insert into room values ('"+roomnum+" ' ,'"+available+" ', '"+clean+" ','"+price+" ' , '"+type+" ')" ;
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
