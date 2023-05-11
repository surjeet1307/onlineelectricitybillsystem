package BillApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class CalculateBill extends JFrame implements ActionListener{
	
	JComboBox tmeterNo,tmon;
	JButton submit,cancel;
	JLabel tname,tadd;
	JTextField tunits; 
	
	CalculateBill(){
		setSize(650,450);
		setLocation(480,200);
		setTitle("Online Bill System");
		
		JPanel p=new JPanel();
		p.setBackground(new Color(173,216,230));
		p.setLayout(null);
		add(p);
		
		JLabel heading=new JLabel("Calculate Bill");
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		heading.setBounds(200, 30, 150, 20);
		p.add(heading);
		
		JLabel meterNo=new JLabel("Meter No :");
		meterNo.setBounds(150, 90, 150, 20);
		p.add(meterNo);
		
		tmeterNo=new JComboBox();
		tmeterNo.setBounds(250, 90, 150, 20);
		
		try {
			Conn c=new Conn();
			ResultSet r=c.s.executeQuery("select * from customer");
			while(r.next()) {
				tmeterNo.addItem(r.getString("meterNo"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

		
		
		p.add(tmeterNo);
		
		JLabel name=new JLabel("Name :");
		name.setBounds(150, 120, 150, 20);
		p.add(name);
		
		
		tname=new JLabel("");
		tname.setBounds(250, 120, 150, 20);
		p.add(tname);
		
		JLabel add=new JLabel("Address :");
		add.setBounds(150, 150, 150, 20);
		p.add(add);
		
		 tadd=new JLabel("");
		tadd.setBounds(250, 150, 150, 20);
		p.add(tadd);
		String q="select * from customer where meterNo='"+tmeterNo.getSelectedItem()+"'";
		try {
		   Conn c=new Conn();
		   ResultSet r=c.s.executeQuery(q);
		   while(r.next()) {
			   tname.setText(r.getString("name"));
			   tadd.setText(r.getString("address"));
		   }
		}catch(Exception e) {
			System.out.println(e);
		}
		tmeterNo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					   Conn c=new Conn();
					   ResultSet r=c.s.executeQuery("select * from customer where meterNo='"+tmeterNo.getSelectedItem()+"'");
					   while(r.next()) {
						   tname.setText(r.getString("name"));
						   tadd.setText(r.getString("address"));
					   }
					}catch(Exception ee) {
						System.out.println(ee);
					}
			
			}
		});
		
		
		JLabel units=new JLabel("Units :");
		units.setBounds(150, 180, 150, 20);
		p.add(units);
		
		tunits=new JTextField();
		tunits.setBounds(250, 180, 150, 20);
		p.add(tunits);
		
		JLabel mon=new JLabel("Month :");
		mon.setBounds(150, 210, 150, 20);
		p.add(mon);
		
		tmon=new JComboBox();
		tmon.setBounds(250, 210, 150, 20);
		tmon.addItem("January");
		tmon.addItem("February");
		tmon.addItem("March");
		tmon.addItem("April");
		tmon.addItem("May");
		tmon.addItem("June");
		tmon.addItem("July");
		tmon.addItem("August");
		tmon.addItem("September");
		tmon.addItem("October");
		tmon.addItem("November");
		tmon.addItem("December");
		p.add(tmon);
		
		submit =new JButton("Submit");
		submit.setBounds(180, 280, 100, 20);
		submit.addActionListener(this);;
		p.add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(290, 280, 100, 20);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		add(p,"Center");
		
		ImageIcon i1=new ImageIcon("src/icon/hicon1.jpg");
		Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
	    
		
		add(new JLabel(new ImageIcon(i2)),"West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			
		String meNo=(String)tmeterNo.getSelectedItem();
		
	
		String unit=tunits.getText();
		String mon=(String)tmon.getSelectedItem();
		
		int totalBill=0;
		int units=Integer.parseInt(unit);
		String q1="select * from tax";
		try {
			Conn c=new Conn();
			ResultSet res=c.s.executeQuery(q1);
			while(res.next()) {
				totalBill+= units*Integer.parseInt(res.getString("cost_per_unit"));
				totalBill+=Integer.parseInt(res.getString("meter_rent"));
				totalBill+=Integer.parseInt(res.getString("service_charge"));
				totalBill+=Integer.parseInt(res.getString("service_tax"));
				totalBill+=Integer.parseInt(res.getString("swacch_bharat_cess"));
				totalBill+=Integer.parseInt(res.getString("fixed_tax"));
			}
			
		}catch(Exception ee) {
			System.out.println(ee);
		}
		
		String q2="insert into bill values('"+meNo+"','"+mon+"','"+unit+"','"+totalBill+"','Not Paid')";
		
		try {
			Conn c=new Conn();
			c.s.executeUpdate(q2);
			JOptionPane.showMessageDialog(null, "Data Added");
		}catch(Exception ee) {
			System.out.println(ee);
		}
		
		
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}
	

	public static void main(String[] args) {
		
		new CalculateBill();
		
		

	}

	

}
