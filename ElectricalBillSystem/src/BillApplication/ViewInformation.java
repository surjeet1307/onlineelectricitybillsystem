package BillApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class ViewInformation extends JFrame implements ActionListener{
     String meNo;
     JButton cancel;
   ViewInformation(String meNo){
	   this.meNo=meNo;
	   setSize(700,550);
	   setLocation(400,200);
	   setTitle("Online Bill System");
	   getContentPane().setBackground(Color.WHITE);
	   setLayout(null);
	   
	   JLabel heading =new JLabel("Information");
	   heading.setBounds(280, 20, 150, 20);
	   heading.setFont(new Font("Tahoma",Font.BOLD,20));
	   add(heading);
	   
	   JLabel name=new JLabel("Name :");
	   name.setBounds(120,80,150,20);
	   add(name);
	   
	   JLabel tname=new JLabel("");
	   tname.setBounds(200,80,150,20);
	   add(tname);
	   
	   JLabel meterNo=new JLabel("Meter No :");
	   meterNo.setBounds(120,130,150,20);
	   add(meterNo);
	   
	   JLabel tmeterNo=new JLabel(meNo);
	   tmeterNo.setBounds(200,130,150,20);
	   add(tmeterNo);
	   
	   JLabel address=new JLabel("Address :");
	   address.setBounds(120,180,150,20);
	   add(address);
	   
	   JLabel taddress=new JLabel("");
	   taddress.setBounds(200,180,200,20);
	   add(taddress);
	   
	   JLabel state=new JLabel("State :");
	   state.setBounds(120,230,150,20);
	   add(state);
	   
	   JLabel tstate=new JLabel("");
	   tstate.setBounds(200,230,200,20);
	   add(tstate);
	   
	   JLabel city=new JLabel("City :");
	   city.setBounds(370,80,150,20);
	   add(city);
	   
	   JLabel tcity=new JLabel("");
	   tcity.setBounds(450,80,150,20);
	   add(tcity);

	   JLabel email=new JLabel("Email :");
	   email.setBounds(370,130,150,20);
	   add(email);
	   
	   JLabel temail=new JLabel("");
	   temail.setBounds(450,130,150,20);
	   add(temail);
	   
	   JLabel phone=new JLabel("Phone No :");
	   phone.setBounds(370,180,150,20);
	   add(phone);
	   
	   JLabel tphone=new JLabel("");
	   tphone.setBounds(450,180,150,20);
	   add(tphone);
	   
	   cancel=new JButton("Cancel");
	   cancel.setBounds(300,300,100,20);
	   cancel.setBackground(Color.BLACK);
	   cancel.addActionListener(this);
	   cancel.setForeground(Color.WHITE);
	   add(cancel);
	   
	   ImageIcon i1=new ImageIcon("src/icon/viewcustomer.jpg");
	   Image i2=i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
	   JLabel img=new JLabel(new ImageIcon(i2));
	   img.setBounds(20,300,400,200);
	   add(img);
	   
	   try {
		   Conn c=new Conn();
		   ResultSet r=c.s.executeQuery("select * from customer where meterNo='"+meNo+"'");
		   while(r.next()) {
			   tname.setText(r.getString("name"));
			   taddress.setText(r.getString("address"));
			   tstate.setText(r.getString("state"));
			   tcity.setText(r.getString("city"));
			   temail.setText(r.getString("email"));
			   tphone.setText(r.getString("phoneNo"));
		   }
		   
	   }catch(Exception ee) {
		   System.out.println(ee);
	   }
	   
	   setVisible(true);
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ViewInformation("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}

}
