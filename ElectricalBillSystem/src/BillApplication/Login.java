package BillApplication;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener{

	 JButton login,cancel,signup;
	 JTextField name;
	 JPasswordField pass;
	 JComboBox box;
	Login(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		
		
		
		JLabel userName=new JLabel("UserName :");
		userName.setBounds(350,80,100,20);
		add(userName);
		
		name=new JTextField();
		name.setBounds(450,80,120,20);
		add(name);
		
		JLabel userPass=new JLabel("Password :");
		userPass.setBounds(350,120,100,20);
		add(userPass);
		
		pass=new JPasswordField();
		pass.setBounds(450,120,120,20);
		add(pass);
		
		JLabel userLoginas=new JLabel("Login As :");
		userLoginas.setBounds(350,160,100,20);
		add(userLoginas);
		
		box=new JComboBox();
		box.setBounds(450,160,100,20);
		box.addItem("Admin");
		box.addItem("Customer");
		add(box);
		
		ImageIcon ilogin=new ImageIcon("src/icon/login.png");
		Image i1=ilogin.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
		
		login=new JButton("Login",new ImageIcon(i1));
		login.setBounds(350,230,100,20);
		login.addActionListener(this);
		add(login);
		
		ImageIcon icancel=new ImageIcon("src/icon/cancel.jpg");
		Image i2=icancel.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
		
		cancel=new JButton("Cancel",new ImageIcon(i2));
		cancel.setBounds(470,230,100,20);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon isignup=new ImageIcon("src/icon/signup.png");
		Image i3=isignup.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
		
		signup=new JButton("SignUp",new ImageIcon(i3));
		signup.addActionListener(this);
		signup.setBounds(400,270,100,20);
		
		add(signup);
		
		ImageIcon mainImg=new ImageIcon("src/icon/second.jpg");
		Image tMain=mainImg.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		
		ImageIcon t=new ImageIcon(tMain);
		JLabel img=new JLabel(t);
		img.setBounds(0, 50, 250, 250);
		add(img);
		
		
		setTitle("Online Bill System");
		setSize(700,500);
		setLocation(450,200);
		setVisible(true);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== login) {
			
			String user=name.getText();
			String usPass=new String(pass.getPassword());
			String role=(String)box.getSelectedItem();
			
			try {
				
			Conn c=new Conn();
			String query="select * from login where userName= '"+user+"' and pass='"+usPass+"' and userRole='"+role+"'";
			ResultSet res=c.s.executeQuery(query);
			if(res.next()) {
				String meter=res.getString("meterNo");
				setVisible(false);
				new Project(role,meter);
			}else {
				JOptionPane.showMessageDialog(null,"Invalid Username Or Passowrd");
				name.setText("");
				pass.setText("");
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Login();
	}

}
