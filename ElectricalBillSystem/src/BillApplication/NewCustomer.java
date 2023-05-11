package BillApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class NewCustomer extends JFrame implements ActionListener{
	
	JTextField name,add,state,city,email,phoneNo;
	JButton next,cancel;
	JLabel tmeterNo;
	NewCustomer(){
		setTitle("Online Bill System");
		
		setSize(700,500);
		setLocation(440,200);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		
		JLabel heading=new JLabel("New Customer");
		heading.setBounds(250,20,200,50);
		heading.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(heading);
		
		JLabel cusName=new JLabel("Name :");
		cusName.setBounds(200,100,150,20);
		p.add(cusName);
		
		name=new JTextField();
		name.setBounds(300,100,150,20);
		p.add(name);
		
		
		JLabel meterNo=new JLabel("Meter No :");
		meterNo.setBounds(200,130,150,20);
		p.add(meterNo);
		
	    tmeterNo=new JLabel("");
		tmeterNo.setBounds(300,130,150,20);
		p.add(tmeterNo);
		
		Random ran=new Random();
		long no=ran.nextLong()%1000000;
		tmeterNo.setText(""+Math.abs(no));
		
		JLabel cusAdd=new JLabel("Address :");
		cusAdd.setBounds(200,160,150,20);
		p.add(cusAdd);
		
		add=new JTextField();
		add.setBounds(300,160,150,20);
		p.add(add);
		
		JLabel cusState=new JLabel("State :");
		cusState.setBounds(200,190,150,20);
		p.add(cusState);
		
		state=new JTextField();
		state.setBounds(300,190,150,20);
		p.add(state);
		
		JLabel cusCity=new JLabel("City :");
		cusCity.setBounds(200,220,150,20);
		p.add(cusCity);
		
		city=new JTextField();
		city.setBounds(300,220,150,20);
		p.add(city);
		
		JLabel cusEmail=new JLabel("Email :");
		cusEmail.setBounds(200,250,150,20);
		p.add(cusEmail);
		
		email=new JTextField();
		email.setBounds(300,250,150,20);
		p.add(email);
		
		JLabel cusPhoneno=new JLabel("Phone No :");
		cusPhoneno.setBounds(200,280,150,20);
		p.add(cusPhoneno);
		
		phoneNo=new JTextField();
		phoneNo.setBounds(300,280,150,20);
		p.add(phoneNo);
		
		
		next=new JButton("Next");
		next.setBounds(220,320,100,20);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(330,320,100,20);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		add(p,"Center");
		
		ImageIcon i1=new ImageIcon("src/icon/hicon1.jpg");
		Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		JLabel img=new JLabel(new ImageIcon(i2));
		add(img,"West");
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==next) {
			String userName=name.getText();
			String userAdd=add.getText();
			String userState=state.getText();
			String userCity=city.getText();
			String userEmail=email.getText();
			String userPhoneno=phoneNo.getText();
			String userMeter=tmeterNo.getText();
			String query1="insert into customer values('"+userName+"','"+userMeter+"','"+userAdd+"','"+userState+"','"+userCity+"','"+userPhoneno+"','"+userEmail+"')";
			String query2="insert into login values('"+userMeter+"','','"+userName+"','','')";
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Details added succesfully");
				setVisible(false);
				new MeterInfo(userMeter);
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();

	}

}
