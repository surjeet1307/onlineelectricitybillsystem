package BillApplication;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
	JButton create,back;
	JComboBox comBox;
	JTextField textMet,userText,textName,textPass;
	
	Signup(){
		
		
		
		JLabel heading=new JLabel("Create Account");
		heading.setBounds(290,20,300,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,14));
		add(heading);
		
		JLabel accType=new JLabel("Account Type :");
		accType.setBounds(200,80,250,20);
		add(accType);
		
		comBox=new JComboBox();
		comBox.setBounds(300,80,150,20);
		comBox.addItem("Admin");
		comBox.addItem("Customer");
		add(comBox);
		
		
		
		JLabel metNum=new JLabel("Meter No :");
		metNum.setBounds(200,120,250,20);
		metNum.setVisible(false);
		add(metNum);
		
		textMet=new JTextField();
		textMet.setBounds(300, 120, 150, 20);
		textMet.setVisible(false);
		add(textMet);
		
		
		
		JLabel userName=new JLabel("User Name :");
		userName.setBounds(200,160,250,20);
		add(userName);
		
		userText=new JTextField();
		userText.setBounds(300, 160, 150, 20);
		add(userText);
		
		JLabel Name=new JLabel("Name :");
		Name.setBounds(200,200,250,20);
		add(Name);
		
		textName=new JTextField();
		textName.setBounds(300, 200, 150, 20);
		add(textName);
		
		textMet.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {}
			
			public void focusLost(FocusEvent e) {
				try {
					Conn c=new Conn();
					ResultSet r=c.s.executeQuery("select * from login where meterNo = '"+textMet.getText()+"'");
					while(r.next()) {
						textName.setText(r.getString("name"));
					}
				}catch(Exception ee) {
					System.out.println(ee);
				}
			}
		});
		
		
		JLabel Pass=new JLabel("Password :");
		Pass.setBounds(200,240,250,20);
		add(Pass);
		
		textPass=new JTextField();
		textPass.setBounds(300, 240, 150, 20);
		add(textPass);
		
		
		comBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String user=(String)comBox.getSelectedItem();
				if(user=="Customer") {
					textMet.setVisible(true);
					metNum.setVisible(true);
					textName.setEditable(false);
				}else {
					textMet.setVisible(false);
					metNum.setVisible(false);
					textName.setEditable(true);
				}
			}
		});
		
		create=new JButton("Create");
		create.setBounds(220,300,100,20);
		create.addActionListener(this);
		add(create);
		
		back=new JButton("Back");
		back.setBounds(340,300,100,20);
		back.addActionListener(this);
		add(back);
		
		ImageIcon logo=new ImageIcon("src/icon/signupImage.png");
		Image i1=logo.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel logoFr=new JLabel(i2);
		logoFr.setBounds(480, 80, 150, 150);
		add(logoFr);
		
		
		setTitle("Online Bill System");
		setSize(700,500);
		setLocation(450,200);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		 
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == create) {
			String aType=(String) comBox.getSelectedItem();
			String uName=userText.getText();
			String Name=textName.getText();
			String Pass=textPass.getText();
			String meter=textMet.getText();
			try {
				Conn c=new Conn();
				String query=null;
						if(aType=="Admin") {
							
						query =	"insert into login values('"+meter+"','"+uName+"','"+Name+"','"+Pass+"','"+aType+"')";
						}else {
							query = "update login set userName='"+uName+"', pass= '"+Pass+"', userRole='"+aType+"' where meterNo='"+meter+"'";
						}
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Account Created SuccesFully");
				setVisible(false);
				new Login();
			}catch(Exception e) {
				System.out.println(e);
			}
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new Signup();
	}

}
