package BillApplication;

import java.awt.*;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
	Splash(){
		setTitle("Online Bill System");
		ImageIcon i1=new ImageIcon("src/icon/elect.jpg");
		Image i2=i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		setVisible(true);
		for(int i=0;i<=600;i=i+2) {
			
			setSize(i,i);
			setLocation(1100-i,750-i);
			try {
				Thread.sleep(1);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		setVisible(true);
		t=new Thread(this);
		t.start();
	}
	
	public void run() {
		try {
			Thread.sleep(3000);
			setVisible(false);
			//login frame
			new Login();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[]  arg) {
		new Splash();
	}
}
