package BillApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.*;

import javax.swing.*;

public class CustomerDetail extends JFrame implements ActionListener{
	
	JTable table;
	JButton print;
	
	CustomerDetail(){
		setTitle("Online Bill System");
		
		setSize(1200,800);
		setLocation(200,10);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		table =new JTable();
		
		
		try {
			Conn c=new Conn();
			ResultSet r=c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(r));
			
		}catch(Exception ee) {
			System.out.println(ee);
		}
		JScrollPane sb=new JScrollPane(table);
		sb.setBounds(0	,0, 1200,740);
		add(sb);
		
		print=new JButton("Print");
		print.setBounds(550,720,100,20);
		print.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(print,"South");
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new CustomerDetail();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==print) {
			try {
				table.print();
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}
		
	}

	

}
