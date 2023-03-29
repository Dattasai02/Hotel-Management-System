
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import java.sql.* ; 

public class updatecheck extends JFrame implements ActionListener {
     
    Choice ccust ;
    JTextField tfroom , tfname , tfcheckin ,tfpaid  ;
    JButton check,update,back ; 
    updatecheck(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        /*************NAME***/
        JLabel ln = new JLabel("Name");
        ln.setBounds(30,160,100,20);
        add(ln);
        tfname= new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        /*************checkin time***/
        JLabel lct = new JLabel("Checkin Time");
        lct.setBounds(30,200,100,20);
        add(lct);
        tfcheckin= new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);
        /*************Amount Paid***/
        JLabel lat = new JLabel("Amount Paid");
        lat.setBounds(30,240,100,20);
        add(lat);
        tfpaid= new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
        /*******Buttons***************/
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg")); 
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                    
                }
               
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String num = ccust.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            try{
                Conn c = new Conn();
                String query = "update customer set roomnumber='"+room+"' ,name='"+name+"',checkintime='"+checkin+"' ,deposit='"+deposit+"' where roomnumber='"+num+"' "  ;
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
        new updatecheck();
    }
}
