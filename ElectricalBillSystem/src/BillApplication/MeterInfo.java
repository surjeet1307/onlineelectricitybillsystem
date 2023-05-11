package BillApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class MeterInfo extends JFrame implements ActionListener{
	JLabel days,note,tmeterNo;
	JButton submit,cancel;
	
	JComboBox meLoc,meType,phCode,biType;
    String mNo;
	MeterInfo(String mNo){
		this.mNo=mNo;
		setSize(700,500);
		setLocation(440,200);
		setTitle("Online Bill System");
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		
		JLabel heading=new JLabel("Meter Infomation");
		heading.setBounds(250,20,200,50);
		heading.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(heading);
		
		JLabel meterNo=new JLabel("Meter No :");
		meterNo.setBounds(150,100,150,20);
		p.add(meterNo);
		
		tmeterNo=new JLabel(mNo);
		tmeterNo.setBounds(250,100,150,20);
		p.add(tmeterNo);
		
		
		JLabel meterLoc=new JLabel("Meter Location :");
		meterLoc.setBounds(150,130,150,20);
		p.add(meterLoc);
		
	     meLoc=new JComboBox();
	     meLoc.setBounds(250, 130, 150, 20);
	     meLoc.addItem("Outside");
	     meLoc.addItem("Inside");
	     p.add(meLoc);
		
		JLabel meterType=new JLabel("Meter Type :");
		meterType.setBounds(150,160,150,20);
		p.add(meterType);
		
		 meType=new JComboBox();
		 meType.setBounds(250, 160, 150, 20);
		 meType.addItem("Electric Meter");
		 meType.addItem("Solar Meter");
		 meType.addItem("Smart Meter");
	     p.add(meType);
		
		JLabel phaseCode=new JLabel("Phase Code :");
		phaseCode.setBounds(150,190,150,20);
		p.add(phaseCode);
		
		 phCode=new JComboBox();
		 phCode.setBounds(250, 190, 150, 20);
		 phCode.addItem("011");
		 phCode.addItem("022");
		 phCode.addItem("033");
		 phCode.addItem("044");
		 phCode.addItem("055");
		 phCode.addItem("066");
		 phCode.addItem("077");
		 phCode.addItem("088");
		 phCode.addItem("099");
	     p.add(phCode);
		
		JLabel billType=new JLabel("Bill Type :");
		billType.setBounds(150,220,150,20);
		p.add(billType);
		
		 biType=new JComboBox();
		 biType.setBounds(250, 220, 150, 20);
		 biType.addItem("Normal");
		 biType.addItem("Commercial");
	     p.add(biType);
		
		JLabel Days=new JLabel("Days :");
		Days.setBounds(150,250,150,20);
		p.add(Days);
		
		days=new JLabel("30");
		days.setBounds(250,250,150,20);
		p.add(days);
		
		JLabel Note=new JLabel("Note :");
		Note.setBounds(150,280,150,20);
		p.add(Note);
		
		note=new JLabel("By Default Bill is calculated for 30 days only");
		note.setBounds(250,280,250,20);
		p.add(note);
		
		
		submit=new JButton("Submit");
		submit.setBounds(220,320,100,20);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		p.add(submit);
		
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
		if(ae.getSource()==submit) {
			String meterNo=mNo;
			String meterLoc=(String)meLoc.getSelectedItem();
			String meterType=(String)meType.getSelectedItem();
			String phaseCode=(String)phCode.getSelectedItem();
			String billType=(String)biType.getSelectedItem();
			String days="30";
			String query="insert into meterInfo values('"+meterNo+"','"+meterLoc+"','"+meterType+"','"+phaseCode+"','"+billType+"','"+days+"')";
			
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Details added succesfully");
				setVisible(false);
				
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		new MeterInfo();

	}

}
