
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import java.sql.* ; 

public class updateroom extends JFrame implements ActionListener {
     
    Choice ccust ;
    JTextField tfroom , tfav , tfstatus ,tfpaid  ;
    JButton check,update,back ; 
    updateroom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        /*************CUST ID***/
        JLabel lid = new JLabel("Customer ID");
        lid.setBounds(30,80,100,20);
        add(lid);
        ccust = new Choice();
        ccust.setBounds(200,80,150,25);
        add(ccust);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(("select * from customer"));
            while(rs.next()){
                ccust.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*************ROOM number***/
        JLabel lr = new JLabel("Room number");
        lr.setBounds(30,120,100,20);
        add(lr);
        tfroom= new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        /*************AVAILABILTY***/
        JLabel ln = new JLabel("Availability");
        ln.setBounds(30,160,100,20);
        add(ln);
        tfav= new JTextField();
        tfav.setBounds(200,160,150,25);
        add(tfav);
        /*************cleanin status***/
        JLabel lct = new JLabel("Cleaning Status");
        lct.setBounds(30,200,100,20);
        add(lct);
        tfstatus= new JTextField();
        tfstatus.setBounds(200,200,150,25);
        add(tfstatus);
        
 
        /*******Buttons***************/
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg")); 
        JLabel image = new JLabel(i1);
        image.setBounds(450,50,500,300);
        add(image);
       
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id =ccust.getSelectedItem();
            String query ="select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("roomnumber"));
                }
                String query2="select * from room where roomnumber ='"+tfroom.getText()+"' " ;
               ResultSet rs2 = c.s.executeQuery(query2);
               while(rs2.next()){
                   tfav.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("clean_status"));
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String num = ccust.getSelectedItem();
            String room = tfroom.getText();
            String avb = tfav.getText();
            String status = tfstatus.getText();
            try{
                Conn c = new Conn();
                String query = "update room set availability='"+avb+"',clean_status='"+status+"'  where roomnumber='"+room+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully ");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
      
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new updateroom();
    }
}
