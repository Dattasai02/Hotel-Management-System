
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.* ;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfage,tfsal,tfph,tfem ,tfaad ; 
    JRadioButton rbmale , rbfem ; 
    JButton submit ; 
    JComboBox cbjob ; 
    
    AddEmployee(){
        setLayout(null);
        /*************NAME**********/
        JLabel lname=new JLabel("NAME") ; 
        lname.setBounds(60,30,120,30);
        lname.setFont(new Font("Cambria",Font.BOLD,17));
        add(lname);
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        /*************AGE**********/
        JLabel lage=new JLabel("AGE") ; 
        lage.setBounds(60,80,120,30);
        lage.setFont(new Font("Cambria",Font.BOLD,17));
        add(lage);
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        /*************GENDER**********/
        JLabel lgen=new JLabel("GENDER") ; 
        lgen.setBounds(60,130,120,30);
        lgen.setFont(new Font("Cambria",Font.BOLD,17));
        add(lgen);
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Cambria",Font.ITALIC,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfem = new JRadioButton("FEMALE");
        rbfem.setBounds(280,130,100,30);
        rbfem.setFont(new Font("Cambria",Font.ITALIC,14));
        rbfem.setBackground(Color.WHITE);
        add(rbfem);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale); bg.add(rbfem); // buttongroup makes only one select
        /*************JOB**********/
        JLabel ljob=new JLabel("JOB") ; 
        ljob.setBounds(60,180,120,30);
        ljob.setFont(new Font("Cambria",Font.BOLD,17));
        add(ljob);
        String str[] = {"Front Desk Clerks" , "Manager" , "Accountant" , "Kitchen staff" , "Waiters" , "Room Service" } ; 
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        /*************SALARY**********/
        JLabel lsal=new JLabel("SALARY") ; 
        lsal.setBounds(60,280,120,30);
        lsal.setFont(new Font("Cambria",Font.BOLD,17));
        add(lsal);
        tfsal = new JTextField();
        tfsal.setBounds(200,280,150,30);
        add(tfsal);
        /*************PHONE**********/
        JLabel lph=new JLabel("PHONE") ; 
        lph.setBounds(60,230,120,30);
        lph.setFont(new Font("Cambria",Font.BOLD,17));
        add(lph);
        tfph = new JTextField();
        tfph.setBounds(200,230,150,30);
        add(tfph);
        /*************EMAIL**********/
        JLabel lem=new JLabel("EMAIL") ; 
        lem.setBounds(60,330,120,30);
        lem.setFont(new Font("Cambria",Font.BOLD,17));
        add(lem);
        tfem = new JTextField();
        tfem.setBounds(200,330,150,30);
        add(tfem);
        /*************AADHAR**********/
        JLabel laad=new JLabel("AADHAR") ; 
        laad.setBounds(60,380,120,30);
        laad.setFont(new Font("Cambria",Font.BOLD,17));
        add(laad);
        tfaad = new JTextField();
        tfaad.setBounds(200,380,150,30);
        add(tfaad);
        /*************BUTTON**********/
        submit = new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.GREEN);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true) ; 
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsal.getText();
        String phone = tfph.getText() ; 
        String email = tfem.getText();
        String aadhar = tfaad.getText();
        String job = (String)cbjob.getSelectedItem(); // typecasting becoz it returns object         
        String gender = null ; 
        if(rbmale.isSelected()){
            gender="Male";
        }
        else if(rbfem.isSelected()){
            gender="Female";
        }
        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+aadhar+"','"+email+"','"+aadhar+"')" ;
            conn.s.executeUpdate(query); // dml uses execute update
            JOptionPane.showMessageDialog(null , "Employee added successfully.");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
    
}
