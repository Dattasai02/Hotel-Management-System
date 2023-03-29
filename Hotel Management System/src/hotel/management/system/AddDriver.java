
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField tfname ,tfage , tfcarcomp ,tfcarmodel ,tfloc ; 
    JComboBox avcombo , gendercombo ; 
    JButton add , cancel ; 
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        /*************NAME**********/
        JLabel lroomno = new JLabel("NAME");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(60,70,120,30);
        add(lroomno);
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        /*************AGE**********/
        JLabel lavb = new JLabel("AGE");
        lavb.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavb.setBounds(60,110,120,30);
        add(lavb);
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        /*************GENDER**********/
        JLabel lrcs = new JLabel("GENDER");
        lrcs.setFont(new Font("Tahoma",Font.PLAIN,16));
        lrcs.setBounds(60,150,120,30);
        add(lrcs);
        String clop[] = { "Male" , "Female"};
        gendercombo = new JComboBox(clop);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        /*************CAR COMPANY**********/
        JLabel lprice = new JLabel("CAR COMPANY");
        lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lprice.setBounds(60,190,120,30);
        add(lprice);
        tfcarcomp = new JTextField();
        tfcarcomp.setBounds(200,190,150,30);
        add(tfcarcomp);
        /*************CAR MODEL**********/
        JLabel ltype = new JLabel("CAR MODEL");
        ltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltype.setBounds(60,230,120,30);
        add(ltype);
        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(200,230,150,30);
        add(tfcarmodel);
        /*************AVAILABILITY**********/
        JLabel lav = new JLabel("AVAILABILITY");
        lav.setFont(new Font("Tahoma",Font.PLAIN,16));
        lav.setBounds(60,270,120,30);
        add(lav);
        String avop[] = { "Available" , "Busy"};
        avcombo = new JComboBox(avop);
        avcombo.setBounds(200,270,150,30);
        avcombo.setBackground(Color.WHITE);
        add(avcombo);
        /*************LOCATION**********/
        JLabel loc = new JLabel("LOCATION");
        loc.setFont(new Font("Tahoma",Font.PLAIN,16));
        loc.setBounds(60,310,120,30);
        add(loc);
        tfloc = new JTextField();
        tfloc.setBounds(200,310,150,30);
        add(tfloc);
        
        /*************ADD DRIVER AND CANCEL**********/
        add = new JButton("ADD DRIVER");
        add.setBounds(60,370,130,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.GREEN);
        add.addActionListener(this);
        add(add);
        cancel = new JButton("CANCEL");
        cancel.setBounds(220,370,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(300,200,980,470);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company = tfcarcomp .getText();
            String model = tfcarmodel  .getText();
            String avb = (String)avcombo.getSelectedItem(); 
            String loc = tfloc.getText();
            
            try{
                Conn conn = new Conn();
                String str = "insert into driver values ('"+name+" ' ,'"+age+" ', '"+gender+" ','"+company+" ' , '"+model+" ' ,'"+avb+" ' ,'"+loc+" ')" ;
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new AddDriver();
    }
}
