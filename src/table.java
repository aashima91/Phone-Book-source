import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class table extends JFrame

{
	JPanel panel;
	JScrollPane scroll;String myLogin,myPassword,url;
	DefaultListModel modeldata;
	JList listdata;
	String nama,belakang,alamat,tlpn;
	ImageIcon pict;
	JLabel all,picturelbl;
	table()

	{
		super("Phone Book");
		panel=new JPanel();
		panel.setBackground(Color.black);
		all=new JLabel("All Data in Your Phone Book :");
		all.setForeground(Color.white);
		all.setFont(new Font("Franklin Gothic Medium",Font.BOLD,22));
		pict=new ImageIcon("test.jpg");
		picturelbl=new JLabel(pict);
		myLogin="admin";
		myPassword="root";
		url="jdbc:odbc:buku telepon";
		modeldata=new DefaultListModel();
		listdata=new JList(modeldata);
		listdata.setBackground(Color.black);
		listdata.setForeground(Color.red);
		listdata.setFont(new Font("Franklin Gothic Medium",Font.BOLD,14));
		scroll=new JScrollPane();
		scroll.getViewport().add(listdata);
		Image Icon = Toolkit.getDefaultToolkit().getImage("Echo test.jpg");

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection(url,myLogin,myPassword);
			Statement stmt=con.createStatement();
			String eks="SELECT * FROM TLPN";
			ResultSet rs=stmt.executeQuery(eks);
			while (rs.next())
			{
				nama=rs.getString("NAMA_DEPAN");
				belakang=rs.getString("NAMA_BELAKANG");
				alamat=rs.getString("ALAMAT");
				tlpn=rs.getString("NO_TELEPON");
				modeldata.addElement(nama+"  "+"||"+"  "+belakang+"  "+"||"+"  "+alamat+"  "+"||"+"  "+tlpn+"\n");

			}
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException cls)
		{
			JOptionPane.showMessageDialog(null,"Cannot Find Driver","Error",JOptionPane.WARNING_MESSAGE);
		}
		catch(SQLException ql)
		{
			JOptionPane.showMessageDialog(null,ql.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
		}
		catch(NumberFormatException nf)
		{
			JOptionPane.showMessageDialog(null,nf.getMessage(),"Check Your Data",JOptionPane.WARNING_MESSAGE);
		}

			getContentPane().add(panel);
			panel.setLayout(null);
			panel.add(all);
			panel.add(scroll);
			panel.add(picturelbl);

			all.setBounds(20,10,350,20);scroll.setBounds(20,45,500,420);
			picturelbl.setBounds(530,50,195,400);

			setSize(750,540);
			setVisible(true);
			setLocation(200,100);
			setIconImage(Icon);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


	}
	public static void main(String[] args)
	{
		try
		{
			setDefaultLookAndFeelDecorated(true);
		}
		catch(Exception e)
		{}

			new table();
	}
}

