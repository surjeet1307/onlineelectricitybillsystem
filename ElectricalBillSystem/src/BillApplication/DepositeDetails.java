package BillApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.*;

import javax.swing.*;

public class DepositeDetails extends JFrame implements ActionListener{
	JComboBox meterNo,mon;
	JTable table;
	JButton search,print;
	
	DepositeDetails(){
		setTitle("Online Bill System");
		
		setSize(650,450);
		setLocation(480,200);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Search by Meter No :");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		meterNo=new JComboBox();
		meterNo.setBounds(150,20,150,20);
		
		try {
			Conn c=new Conn();
			ResultSet r=c.s.executeQuery("select * from customer");
			while(r.next()) {
				meterNo.addItem(r.getString("meterNo"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		add(meterNo);
		
		JLabel heading1=new JLabel("Search by Month :");
		heading1.setBounds(350,20,150,20);
		add(heading1);
		
		mon =new JComboBox();
		mon.setBounds(460,20,150,20);
		mon.addItem("January");
		mon.addItem("February");
		mon.addItem("March");
		mon.addItem("April");
		mon.addItem("May");
		mon.addItem("June");
		mon.addItem("July");
		mon.addItem("August");
		mon.addItem("September");
		mon.addItem("October");
		mon.addItem("November");
		mon.addItem("December");
		add(mon);
		
		table=new JTable();
		
		try {
			Conn c=new Conn();
			ResultSet r=c.s.executeQuery("select * from bill");
			table.setModel(DbUtils.resultSetToTableModel(r));
			
		}catch(Exception ee) {
			System.out.println(ee);
		}
		JScrollPane sb=new JScrollPane(table);
		sb.setBounds(0	,100, 650,800);
		add(sb);
		
		search=new JButton("Search");
		search.setBounds(60,50,100,20);
		search.addActionListener(this);
		add(search);
		
		print=new JButton("Print");
		print.setBounds(170,50,100,20);
		print.addActionListener(this);
		add(print);
		
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new DepositeDetails();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			String q="select * from bill where meter_no = '"+meterNo.getSelectedItem()+"' and month = '"+mon.getSelectedItem()+"'";
			
			try {
				Conn c=new Conn();
				ResultSet r=c.s.executeQuery(q);
				table.setModel(DbUtils.resultSetToTableModel(r));
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}else if(e.getSource()==print){
			try {
				table.print();
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}
		
	}

}
