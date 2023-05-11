package BillApplication;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;
public class PayBill extends JFrame implements ActionListener{
	
	JComboBox mon;
	JButton pay,cancel;
	String meNo;
	PayBill(String meNo){
		this.meNo=meNo;
		setSize(800,500);
		setLocation(400,200);
		setTitle("Online Bill System");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading=new JLabel("Pay Bill");
		heading.setBounds(350,20,150,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		
		JLabel meterNo=new JLabel("Meter No :");
		meterNo.setBounds(250,90,150,20);
		add(meterNo);
		
		JLabel tmeterNo=new JLabel(meNo);
		tmeterNo.setBounds(350,90,150,20);
		add(tmeterNo);
		
		JLabel name=new JLabel("Name :");
		name.setBounds(250,130,130,20);
		add(name);
		
		JLabel tname=new JLabel("MeterNo");
		tname.setBounds(350,130,150,20);
		add(tname);
		
		JLabel month=new JLabel("Month :");
		month.setBounds(250,170,150,20);
		add(month);
		
		mon =new JComboBox();
		mon.setBounds(350,170,150,20);
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
		
		JLabel units=new JLabel("Units :");
		units.setBounds(250,210,150,20);
		add(units);
		
		JLabel tunits=new JLabel("");
		tunits.setBounds(350,210,150,20);
		add(tunits);
		
		JLabel totalBill=new JLabel("Total Bill :");
		totalBill.setBounds(250,250,150,20);
		add(totalBill);
		
		JLabel ttotalBill=new JLabel("");
		ttotalBill.setBounds(350,250,150,20);
		add(ttotalBill);
		
		JLabel status=new JLabel("Status :");
		status.setBounds(250,290,150,20);
		add(status);
		
		JLabel tstatus=new JLabel("");
		tstatus.setBounds(350,290,150,20);
		add(tstatus);
		
		pay=new JButton("Pay");
		pay.setBounds(270,350,100,20);
		pay.setForeground(Color.WHITE);
		pay.setBackground(Color.BLACK);
		pay.addActionListener(this);
		add(pay);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(380,350,100,20);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this);
		add(cancel);
		
		try {
			Conn c=new Conn();
			ResultSet res=c.s.executeQuery("select * from customer where meterNo='"+meNo+"'");
			while(res.next()) {
				tname.setText(res.getString("name"));
			}
			
			ResultSet res2=c.s.executeQuery("select * from bill where meter_no ='"+meNo+"' and month ='January'");
			while(res2.next()) {
				
				tunits.setText(res2.getString("units"));
				ttotalBill.setText(res2.getString("totalbill"));
				tstatus.setText(res2.getString("status"));
				if(res2.getString("status").equals("Paid")){
	                   pay.setVisible(false);
                     }else {
	                         pay.setVisible(true);
                       }
			}
			
		}catch(Exception ee) {
			System.out.println(ee);
		}
		
		
		
		mon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					Conn c=new Conn();
					
					ResultSet res2=c.s.executeQuery("select * from bill where meter_no ='"+meNo+"' and month ='"+mon.getSelectedItem()+"'");
					while(res2.next()) {
						
						tunits.setText(res2.getString("units")==""?"0":res2.getString("units"));
						ttotalBill.setText(res2.getString("totalbill"));
						tstatus.setText(res2.getString("status"));
						if(res2.getString("status").equals("Paid")){
			                   pay.setVisible(false);
		                        }else {
			                         pay.setVisible(true);
		                          }
					}
					
				}catch(Exception ee) {
					System.out.println(ee);
				}
				
			}
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PayBill("617396");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pay) {
			String quert="update bill set status='Paid' where meter_no='"+meNo+"' and month='"+mon.getSelectedItem()+"'";
			try {
				Conn c=new Conn();
				c.s.executeUpdate(quert);
			    JOptionPane.showMessageDialog(null, "Payment Sucessfully");
			    setVisible(false);
			}catch(Exception ee) {
				System.out.println(ee);
			}
			
		}else if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}

}
