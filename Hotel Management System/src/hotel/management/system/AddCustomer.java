
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.* ;
import java.util.Date ;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox idcombo ;
    JTextField tfnum ,tfname ,tfcountry , tfdeposit ;
    JRadioButton rbmale,rbfem ;
    Choice croom ;
    JLabel checkintime ;
    JButton add,back ; 
    
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        /************New Customer Form***********/
        JLabel ltext = new JLabel("New Customer Form");
        ltext.setBounds(100,20,300,30);
        ltext.setFont(new Font("Railway",Font.PLAIN,20));
        add(ltext);
        /************ID***********/
        JLabel lid = new JLabel("ID");
        lid .setBounds(35,80,100,20);
        lid .setFont(new Font("Railway",Font.PLAIN,20));
        add(lid );
        String opt[] = {"Aadhar Card" , "Driving license" , "Pan Card" };
        idcombo = new JComboBox(opt);
        idcombo.setBounds(200,80,150,25);
        idcombo.setBackground(Color.WHITE);
        add(idcombo);
        /************NUMBER***********/
        JLabel lnum = new JLabel("Number");
        lnum .setBounds(35,120,100,20);
        lnum .setFont(new Font("Railway",Font.PLAIN,20));
        add(lnum );
        tfnum = new JTextField();
        tfnum.setBounds(200,120,150,25);
        add(tfnum);
        /************NAME***********/
        JLabel lname = new JLabel("Name");
        lname .setBounds(35,160,100,20);
        lname .setFont(new Font("Railway",Font.PLAIN,20));
        add(lname );
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        /************GENDER***********/
        JLabel lgen = new JLabel("Gender");
        lgen .setBounds(35,200,100,20);
        lgen .setFont(new Font("Railway",Font.PLAIN,20));
        add(lgen );
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200,200,60,25);
        rbmale.setFont(new Font("Cambria",Font.ITALIC,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfem = new JRadioButton("FEMALE");
        rbfem.setBounds(270,200,100,25);
        rbfem.setFont(new Font("Cambria",Font.ITALIC,14));
        rbfem.setBackground(Color.WHITE);
        add(rbfem);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale); bg.add(rbfem);
        /************COUNTRY***********/
        JLabel lc = new JLabel("Country");
        lc .setBounds(35,240,100,20);
        lc .setFont(new Font("Railway",Font.PLAIN,20));
        add(lc );
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        /************ALLOCATED ROOM NUMBER***********/
        JLabel lalr = new JLabel("Room Number");
        lalr .setBounds(35,280,150,20);
        lalr .setFont(new Font("Railway",Font.PLAIN,20));
        add(lalr );
        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query ="Select * from room where availability ='Available '";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }  

        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        /**********8CHECKIN TIME**********/
        JLabel ldate = new JLabel("Checkin Time");
        ldate.setBounds(35,320,150,20);
        ldate.setFont(new Font("Railway",Font.PLAIN,20));
        add(ldate);
        Date date = new Date();
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Railway",Font.PLAIN,16));
        add(checkintime);
        /********DEPOSTI******/
        JLabel ldep = new JLabel("Deposit");
        ldep .setBounds(35,360,100,20);
        ldep.setFont(new Font("Railway",Font.PLAIN,20));
        add(ldep );
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        /****ADD AND BACK**/
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
       
        setBounds(350,200,800,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String)idcombo.getSelectedItem();
            String number = tfnum.getText();
            String name   = tfname.getText();
            String gender = null ;
            if(rbmale.isSelected()){
                gender="Male";
            }
            else{
                gender="Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            try{
                String query = "insert into customer values( '"+id+"','"+number+"','"+name+"' ,'"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"') ";
                String query2 = "update room set availability ='Occupied'where roomnumber ='"+room+"' ";  
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Reception();
            
        }
    }
    public static void main(String[] args){
        new AddCustomer();
    }
   
    
}
