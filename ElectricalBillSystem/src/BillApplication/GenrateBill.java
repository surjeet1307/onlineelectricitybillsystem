package BillApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class GenrateBill extends JFrame implements ActionListener{
    
	JComboBox mon;
	JTextArea area;
	String meNo;
	JButton gen;
	
	GenrateBill(String meNo){
		this.meNo=meNo;
		setSize(500,800);
		setLocation(450,30);
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		add(panel,"North");
		
		JLabel heading=new JLabel("Genrate Bill : ");
		heading.setBounds(200,20,150,20);
		panel.add(heading);
		
		mon =new JComboBox();
		mon.setBounds(300,20,150,20);
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
		panel.add(mon);
		
		JLabel meterNo=new JLabel(" "+meNo);
		panel.add(meterNo);
		
		gen=new JButton("Genrate");
		gen.addActionListener(this);
		add(gen,"South");
		
		
		 area=new JTextArea(50,15);
		area.setText("\n\n\t-------Click on the-------\n\t-------Button-------\n\t-------to Genrate Bill-------\n\t");
		area.setFont(new Font("Senserif",Font.ITALIC,18));
		
		JScrollPane pane=new JScrollPane(area);
		add(pane,"Center");
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenrateBill("617396");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==gen) {
			try {
				Conn c=new Conn();
				
				area.setText("\t             PSPCL\n\t Your Bill Receipt Here \n");
				
				ResultSet res=c.s.executeQuery("select * from customer where meterNo='"+meNo+"'");
				if(res.next()) {
					area.append("\n           Name :      "+res.getString("name"));
					area.append("\n           Meter No : "+res.getString("meterNo"));
					area.append("\n           Address  : "+res.getString("address"));
					area.append("\n           State :"+res.getString("state"));
					area.append("\n           City :"+res.getString("city"));
					area.append("\n           Phone No :"+res.getString("phoneNo"));
					area.append("\n           Email :"+res.getString("email"));
					area.append("\n-------------------------------------------------------");
				}
				
				res=c.s.executeQuery("select * from meterInfo where meterNo='"+meNo+"'");
//				
				if(res.next()) {
					
					area.append("\n           Meter Location :"+res.getString("meterLoc"));
					area.append("\n           Meter Type :"+res.getString("meterType"));
					area.append("\n           Phase Code :"+res.getString("phaseCode"));
					area.append("\n           Bill Type :"+res.getString("billType"));
					area.append("\n           Days :"+res.getString("days"));
					area.append("\n-------------------------------------------------------");
					
				}
				
				res=c.s.executeQuery("select * from tax");
				
                   if(res.next()) {
					
					area.append("\n           Cost per unit :"+res.getString("cost_per_unit"));
					area.append("\n           Meter rent :"+res.getString("meter_rent"));
					area.append("\n           Service charge :"+res.getString("service_charge"));
					area.append("\n           Service tax  :"+res.getString("service_tax"));
					area.append("\n           Swacch Bharat Cess :"+res.getString("swacch_bharat_cess"));
					area.append("\n           Fixed tax :"+res.getString("fixed_tax"));
					area.append("\n-------------------------------------------------------");
					
				}
                   
                   res=c.s.executeQuery("select * from bill where meter_no='"+meNo+"' and month='"+mon.getSelectedItem()+"'");
                   if(res.next() && res.getString("status").equals("Paid")) {
                    area.append("\n           Month :"+res.getString("month"));
   					area.append("\n           Units :"+res.getString("units"));
   					area.append("\n           Total Bill :"+res.getString("totalbill"));
   					
   					area.append("\n-------------------------------------------------------");   
                   }else {
   					area.append("\n           No Bill");
                   }
				
				
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}
		
	}

}
