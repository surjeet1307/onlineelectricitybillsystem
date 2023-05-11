package BillApplication;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.*;

public class BillDetail extends JFrame{
    String meNo;
	BillDetail(String meNo){
		this.meNo=meNo;
		setSize(700,600);
		setLocation(400,150);
		setTitle("Online Bill System");
		
		JTable table=new JTable();
		try {
			Conn c=new Conn();
			ResultSet res=c.s.executeQuery("select * from bill where meter_no='"+meNo+"'");
			table.setModel(DbUtils.resultSetToTableModel(res));
		}catch(Exception ee) {
			System.out.println(ee);
		}
		
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0,0,700,600);
		add(sp);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BillDetail("");

	}

}
