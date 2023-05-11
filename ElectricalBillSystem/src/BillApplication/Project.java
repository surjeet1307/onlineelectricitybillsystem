package BillApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Project extends JFrame implements ActionListener{
   String role,meNo;
	Project(String role , String meNo){
		this.role=role;
		this.meNo=meNo;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Online Bill System");
		ImageIcon mainImg=new ImageIcon("src/icon/elect1.jpg");
		Image i2=mainImg.getImage().getScaledInstance(1880, 850, Image.SCALE_DEFAULT);
		JLabel img=new JLabel(new ImageIcon(i2));
		add(img);
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		
		
		// Master Menu
		
		JMenu master=new JMenu("Master");
		master.setForeground(Color.BLUE);
	
		
		JMenuItem newCus=new JMenuItem("New Customers");
		newCus.addActionListener(this);
		newCus.setFont(new Font("monospaced",Font.PLAIN,10));
		ImageIcon logo1=new ImageIcon("src/icon/icon1.png");
		Image tlogo1=logo1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newCus.setIcon(new ImageIcon(tlogo1));
		newCus.setBackground(Color.WHITE);
        newCus.setMnemonic('D');
        newCus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		master.add(newCus);
		
		
		JMenuItem allCus=new JMenuItem("Customer Details");
		allCus.addActionListener(this);
		allCus.setFont(new Font("monospaced",Font.PLAIN,12));
		allCus.setBackground(Color.WHITE);
		ImageIcon logo2=new ImageIcon("src/icon/icon2.png");
		Image tlogo2=logo2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		allCus.setIcon(new ImageIcon(tlogo2));
		allCus.setMnemonic('F');
		allCus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		master.add(allCus);
		
		JMenuItem desDetail=new JMenuItem("Deposite Detail");
		desDetail.addActionListener(this);
		desDetail.setFont(new Font("monospaced",Font.PLAIN,12));
		desDetail.setBackground(Color.WHITE);
		ImageIcon logo3=new ImageIcon("src/icon/icon3.png");
		Image tlogo3=logo3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		desDetail.setIcon(new ImageIcon(tlogo3));
		desDetail.setMnemonic('R');
		desDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		master.add(desDetail);
		
		JMenuItem billCal=new JMenuItem("Calculate Bill");
		billCal.addActionListener(this);
		billCal.setFont(new Font("monospaced",Font.PLAIN,12));
		billCal.setBackground(Color.WHITE);
		ImageIcon logo4=new ImageIcon("src/icon/icon5.png");
		Image tlogo4=logo4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		billCal.setIcon(new ImageIcon(tlogo4));
		billCal.setMnemonic('B');
		billCal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		master.add(billCal);
		
		
		//Information Menu
		
		JMenu info=new JMenu("Infomation");
		info.setForeground(Color.RED);
		
		
		JMenuItem upInfo=new JMenuItem("Update Information");
		upInfo.setFont(new Font("monospaced",Font.PLAIN,12));
		upInfo.setBackground(Color.WHITE);
		ImageIcon logo5=new ImageIcon("src/icon/icon4.png");
		Image tlogo5=logo5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		upInfo.setIcon(new ImageIcon(tlogo5));
		upInfo.setMnemonic('U');
		upInfo.addActionListener(this);
		upInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
		info.add(upInfo);
		
		JMenuItem viewInfo=new JMenuItem("View Information");
		viewInfo.setFont(new Font("monospaced",Font.PLAIN,12));
		viewInfo.setBackground(Color.WHITE);
		ImageIcon logo6=new ImageIcon("src/icon/icon6.png");
		Image tlogo6=logo6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewInfo.setIcon(new ImageIcon(tlogo6));
		viewInfo.setMnemonic('I');
		viewInfo.addActionListener(this);
		viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		info.add(viewInfo);
		
		
        //User Menu
		
		JMenu user=new JMenu("User");
		user.setForeground(Color.BLUE);
		
		
		JMenuItem payBill=new JMenuItem("Pay Bill");
		payBill.setFont(new Font("monospaced",Font.PLAIN,12));
		payBill.setBackground(Color.WHITE);
		payBill.addActionListener(this);
		ImageIcon logo7=new ImageIcon("src/icon/icon4.png");
		Image tlogo7=logo7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		payBill.setIcon(new ImageIcon(tlogo7));
		payBill.setMnemonic('P');
		payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		user.add(payBill);
		
		JMenuItem detBill=new JMenuItem("Bill Detail");
		detBill.setFont(new Font("monospaced",Font.PLAIN,12));
		detBill.setBackground(Color.WHITE);
		detBill.addActionListener(this);
		ImageIcon logo8=new ImageIcon("src/icon/icon6.png");
		Image tlogo8=logo8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		detBill.setIcon(new ImageIcon(tlogo8));
		detBill.setMnemonic('O');
		detBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		user.add(detBill);
		
		
		//Report Menu
		JMenu report=new JMenu("Repot");
		report.setForeground(Color.RED);
		
		
		JMenuItem genBill=new JMenuItem("Genrate Bill");
		genBill.setFont(new Font("monospaced",Font.PLAIN,12));
	    genBill.setBackground(Color.WHITE);
	    genBill.addActionListener(this);
	    ImageIcon logo9=new ImageIcon("src/icon/icon7.png");
		Image tlogo9=logo9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		genBill.setIcon(new ImageIcon(tlogo9));
		genBill.setMnemonic('G');
		genBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		report.add(genBill);
		
		//Utility Menu
		JMenu uti=new JMenu("Utility");
		uti.setForeground(Color.BLUE);
		
		
		JMenuItem note=new JMenuItem("NotePad");
		note.setFont(new Font("monospaced",Font.PLAIN,12));
		note.setBackground(Color.WHITE);
		note.addActionListener(this);
		ImageIcon logo10=new ImageIcon("src/icon/icon12.png");
		Image tlogo10=logo10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		note.setIcon(new ImageIcon(tlogo10));
		note.setMnemonic('N');
		note.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		uti.add(note);
		
		JMenuItem cal=new JMenuItem("Calculator");
		cal.setFont(new Font("monospaced",Font.PLAIN,12));
		cal.setBackground(Color.WHITE);
		cal.addActionListener(this);
		ImageIcon logo11=new ImageIcon("src/icon/icon9.png");
		Image tlogo11=logo11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		cal.setIcon(new ImageIcon(tlogo11));
		cal.setMnemonic('M');
		cal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		uti.add(cal);
		
		
		//Exit Menu
		
		JMenu mExit=new JMenu("Exit");
		mExit.setForeground(Color.RED);
		
		
		JMenuItem exit=new JMenuItem("Exit");
		exit.setFont(new Font("monospaced",Font.PLAIN,12));
		exit.setBackground(Color.WHITE);
		ImageIcon logo12=new ImageIcon("src/icon/icon11.png");
		Image tlogo12=logo12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(tlogo12));
		exit.setMnemonic('Q');
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		mExit.add(exit);
		
		
		//all Menu
		if(role=="Admin") {
			bar.add(master);
			
		}
		else {
			
		bar.add(info);
		bar.add(user);
		bar.add(report);
		}
		bar.add(uti);
		bar.add(mExit);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Project("","");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String str=e.getActionCommand();
		if(str.equals("New Customers")) {
			new NewCustomer();
		}else if(str.equals("Deposite Detail")) {
			new DepositeDetails();
		}else if(str.equals("Calculate Bill")) {
			new CalculateBill();
		}else if(str.equals("Customer Details")) {
			new CustomerDetail();
		}else if(str.equals("View Information")) {
			new ViewInformation(meNo);
		}else if(str.equals("Exit")) {
			setVisible(false);
			new Login();
		}else if(str.equals("Update Information")) {
			new UpdateDetail(meNo);
		}else if(str.equals("Bill Detail")) {
			new BillDetail(meNo);
		}else if(str.equals("NotePad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}else if(str.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception ee) {
				System.out.println(ee);
			}
		}else if(str.equals("Pay Bill")) {
			new PayBill(meNo);
		}else if(str.equals("Genrate Bill")) {
			new GenrateBill(meNo);
		}
		
	}

}
