package BillApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class UpdateDetail extends JFrame implements ActionListener{

	JTextField tadd,tstate,tcity,temail,tphoneNo;
	
	JButton update,cancel;
	String meNo;
	UpdateDetail(String meNo){
		this.meNo=meNo;
		setSize(800,400);
		setTitle("Online Bill System");
		setLocation(400,200);
		
		
		
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		JLabel heading=new JLabel("Update Information");
		heading.setBounds(210,20,200,20);
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		p.add(heading);
		
		JLabel name=new JLabel("Name :");
		name.setBounds(100,70,150,20);
		p.add(name);
		
		JLabel tname=new JLabel("");
		tname.setBounds(180,70,150,20);
		p.add(tname);
		
		JLabel meterNo=new JLabel("Meter No :");
		meterNo.setBounds(100,100,150,20);
		p.add(meterNo);
		
		JLabel tmeterNo=new JLabel("");
		tmeterNo.setBounds(180,100,150,20);
		p.add(tmeterNo);
		
		JLabel add=new JLabel("Address :");
		add.setBounds(100,130,150,20);
		p.add(add);
		
		tadd=new JTextField();
		tadd.setBounds(180,130,150,20);
		p.add(tadd);
		
		JLabel state=new JLabel("State :");
		state.setBounds(100,160,150,20);
		p.add(state);
		
		tstate=new JTextField();
		tstate.setBounds(180,160,150,20);
		p.add(tstate);
		
		JLabel city=new JLabel("City :");
		city.setBounds(100,190,150,20);
		p.add(city);
		
		tcity=new JTextField();
		tcity.setBounds(180,190,150,20);
		p.add(tcity);
		
		JLabel email=new JLabel("Email :");
		email.setBounds(100,220,150,20);
		p.add(email);
		
		temail=new JTextField();
		temail.setBounds(180,220,150,20);
		p.add(temail);
		
		JLabel phoneNo=new JLabel("Phone No :");
		phoneNo.setBounds(100,250,150,20);
		p.add(phoneNo);
		
		tphoneNo=new JTextField();
		tphoneNo.setBounds(180,250,150,20);
		p.add(tphoneNo);
		
		update=new JButton("Update");
		update.setBounds(120,290,100,20);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		p.add(update);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(230,290,100,20);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		try {
			Conn c=new Conn();
			ResultSet r=c.s.executeQuery("select * from customer where meterNo='"+meNo+"'");
			while(r.next()) {
				tname.setText(r.getString("name"));
				tmeterNo.setText(r.getString("meterNo"));
				tadd.setText(r.getString("address"));
				tstate.setText(r.getString("email"));
				tcity.setText(r.getString("city"));
				temail.setText(r.getString("email"));
				tphoneNo.setText(r.getString("phoneNo"));
			}
		}catch(Exception ee) {
			System.out.println(ee);
		}
		
		
		setLayout(new BorderLayout());
		
		ImageIcon i1=new ImageIcon("src/icon/update.jpg");
		Image i2=i1.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT);
		JLabel img=new JLabel(new ImageIcon(i2));
		add(img,"East");
        add(p,"Center");		
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateDetail("617396");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==update) {
			String address=tadd.getText();
			String email=temail.getText();
			String phone=tphoneNo.getText();
			String state=tstate.getText();
			String city=tcity.getText();
			String query="update customer set address='"+address+"' , email='"+email+"' , phoneNo ='"+phone+"', state ='"+state+"', city='"+city+"' where meterNo= '"+meNo+"'";
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Update Sucessfully");
				setVisible(false);
				new ViewInformation(meNo);
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}else if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}

}
