import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.System;
import java.lang.Runtime;
import java.io.IOException;

public class bukutelepon extends JFrame implements ActionListener

{

		JPanel paneltombol;
		JMenuBar menubuku;
		JMenu filemenu,searchmenu,helpmenu;
		JMenuItem openitem,saveitem,deleteitem,exititem,namesearch,addresssearch,helpitem,aboutitem;
		JButton openbtn,savebtn,deletebtn,exitbtn;
		JLabel picturelbl;ImageIcon lblimage;Icon openicn,saveicn,deleteicn,exiticn;
		String url,myLogin,myPassword;
		Runtime rtm;Process p;

		bukutelepon()

		{

			super("Phone Book by the_outsider");
			paneltombol=new JPanel();
			paneltombol.setBackground(Color.black);
			menubuku=new JMenuBar();
			menubuku.setBackground(Color.blue);
			filemenu=new JMenu("File");
			filemenu.setForeground(Color.red);
			filemenu.setFont(new Font("Franklin Gothic Medium",Font.BOLD,14));
			menubuku.add(filemenu);
			searchmenu=new JMenu("Search");
			searchmenu.setForeground(Color.red);
			searchmenu.setFont(new Font("Franklin Gothic Medium",Font.BOLD,14));
			menubuku.add(searchmenu);
			helpmenu=new JMenu("Help");
			helpmenu.setForeground(Color.red);
			helpmenu.setFont(new Font("Franklin Gothic Medium",Font.BOLD,14));
			menubuku.add(helpmenu);
			openitem=new JMenuItem("Open");
			openitem.setBackground(Color.blue);
			openitem.setForeground(Color.red);
			openitem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			filemenu.add(openitem);
			saveitem=new JMenuItem("Save");
			saveitem.setBackground(Color.blue);
			saveitem.setForeground(Color.red);
			saveitem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			filemenu.add(saveitem);
			deleteitem=new JMenuItem("Delete");
			deleteitem.setBackground(Color.blue);
			deleteitem.setForeground(Color.red);
			deleteitem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			filemenu.add(deleteitem);
			exititem=new JMenuItem("Exit");
			exititem.setBackground(Color.blue);
			exititem.setForeground(Color.red);
			exititem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			filemenu.add(exititem);
			namesearch=new JMenuItem("Search by Name");
			namesearch.setBackground(Color.blue);
			namesearch.setForeground(Color.red);
			namesearch.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			searchmenu.add(namesearch);
			addresssearch=new JMenuItem("Search by Address");
			addresssearch.setBackground(Color.blue);
			addresssearch.setForeground(Color.red);
			addresssearch.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			searchmenu.add(addresssearch);
			helpitem=new JMenuItem("Help");
			helpitem.setBackground(Color.blue);
			helpitem.setForeground(Color.red);
			helpitem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			helpmenu.add(helpitem);
			aboutitem=new JMenuItem("About");
			aboutitem.setBackground(Color.blue);
			aboutitem.setForeground(Color.red);
			aboutitem.setFont(new Font("Franklin Gothic Medium",Font.BOLD,12));
			helpmenu.add(aboutitem);
			openicn=new ImageIcon("button_hover.jpg");
			openbtn=new JButton(openicn);
			saveicn=new ImageIcon("button_normal.jpg");
			savebtn=new JButton(saveicn);
			deleteicn=new ImageIcon("button_pressed.jpg");
			deletebtn=new JButton(deleteicn);
			exiticn=new ImageIcon("button_hover2.jpg");
			exitbtn=new JButton(exiticn);
			lblimage=new ImageIcon("Wu Minator.jpg");
			picturelbl=new JLabel(lblimage);
			Image Icon = Toolkit.getDefaultToolkit().getImage("Echo test.jpg");
			url="jdbc:odbc:buku telepon";myLogin="admin";myPassword="root";

			getContentPane().add(paneltombol);
			paneltombol.setLayout(null);

			paneltombol.add(menubuku);
			paneltombol.add(openbtn);
			paneltombol.add(savebtn);
			paneltombol.add(deletebtn);
			paneltombol.add(exitbtn);
			paneltombol.add(picturelbl);

			openbtn.setBounds(610,50,120,30);savebtn.setBounds(610,120,120,30);
			deletebtn.setBounds(610,190,120,30);exitbtn.setBounds(610,260,120,30);
			picturelbl.setBounds(5,50,600,450);menubuku.setBounds(5,5,140,30);

			openbtn.addActionListener(this);
			savebtn.addActionListener(this);
			deletebtn.addActionListener(this);
			exitbtn.addActionListener(this);
			openitem.addActionListener(this);saveitem.addActionListener(this);deleteitem.addActionListener(this);
			exititem.addActionListener(this);namesearch.addActionListener(this);addresssearch.addActionListener(this);
			helpitem.addActionListener(this);aboutitem.addActionListener(this);


			setSize(750,540);
			setVisible(true);
			setLocation(200,100);
			setIconImage(Icon);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

		public void actionPerformed(ActionEvent ae)

		{
			Object objekpencet=ae.getSource();

			if((objekpencet==openbtn)||(objekpencet==openitem))
			{
				try
				{
					rtm=Runtime.getRuntime();
					p=rtm.exec("java table");
				}
				catch(IOException exp)
				{
					JOptionPane.showMessageDialog(null,"Cannot Find table.java,Please Check the File","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			if((objekpencet==deletebtn)||(objekpencet==deleteitem))
			{
				String del=JOptionPane.showInputDialog(null,"Enter 'First Name' From the Data You Want to Delete");
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection(url,myLogin,myPassword);
					Statement stmt=con.createStatement();
					String hapus="DELETE FROM TLPN WHERE NAMA_DEPAN="+"'"+del+"'";
					stmt.executeUpdate(hapus);
					JOptionPane.showMessageDialog(null,"The Record of "+ del+" has Been Delete","Delete Complete",JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(null,nf.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			if((objekpencet==saveitem)||(objekpencet==savebtn))
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection(url,myLogin,myPassword);
					Statement stmt=con.createStatement();
					String nama=JOptionPane.showInputDialog(null,"Enter First Name","Name");
					String belakang=JOptionPane.showInputDialog(null,"Enter Last Name","Name");
					String alamat=JOptionPane.showInputDialog(null,"Enter Address","Address");
					String nmrtlpn=JOptionPane.showInputDialog(null,"Enter Phone Number","Phone Number");
					String semua="INSERT INTO TLPN VALUES"+"("+"'"+nama+"'"+","+"'"+belakang+"'"+","+"'"+alamat+"'"+","+"'"+nmrtlpn+"'"+")";
					stmt.executeUpdate(semua);
					JOptionPane.showMessageDialog(null,"Your Data Has been Added to the Database","Success",JOptionPane.INFORMATION_MESSAGE);
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
			}
			else
			if((objekpencet==exititem)||(objekpencet==exitbtn))
			{
				if(JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Exit?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				System.exit(0);
			}
			else
			if(objekpencet==namesearch)
			{
				String carinama=JOptionPane.showInputDialog(null,"Name to search??","");
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection(url,myLogin,myPassword);
					Statement stmt=con.createStatement();
					String cari="SELECT * FROM TLPN WHERE NAMA_DEPAN = "+"'"+carinama+"'";
					ResultSet rs=stmt.executeQuery(cari);
					rs.next();
					String hasil=rs.getString("NAMA_DEPAN");
					String hasil2=rs.getString("NAMA_BELAKANG");
					String hasil3=rs.getString("ALAMAT");
					String hasil4=rs.getString("NO_TELEPON");
					JOptionPane.showMessageDialog(null,hasil+"||"+hasil2+"||"+hasil3+"||"+hasil4,"Search Complete",JOptionPane.INFORMATION_MESSAGE);
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
			}
			else
			if(objekpencet==addresssearch)
			{
				String alamat=JOptionPane.showInputDialog(null,"Address to search??","");
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection(url,myLogin,myPassword);
					Statement stmt=con.createStatement();
					String carialamat="SELECT * FROM TLPN WHERE ALAMAT LIKE "+"'%"+alamat+"'";
					ResultSet rs=stmt.executeQuery(carialamat);
					rs.next();
					String hasil=rs.getString("NAMA_DEPAN");
					String hasil2=rs.getString("NAMA_BELAKANG");
					String hasil3=rs.getString("ALAMAT");
					String hasil4=rs.getString("NO_TELEPON");
					JOptionPane.showMessageDialog(null,hasil+"||"+hasil2+"||"+hasil3+"||"+hasil4,"Search Complete",JOptionPane.INFORMATION_MESSAGE);
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
			}

			else
			if(objekpencet==helpitem)
			{}
			else
			if(objekpencet==aboutitem)
			JOptionPane.showMessageDialog(null,"Made by AASHIMA","About",JOptionPane.INFORMATION_MESSAGE);


		}

		public static void main(String[] args)

		{
			try
			{
				setDefaultLookAndFeelDecorated(true);
			}
			catch(Exception e)
			{}

			new bukutelepon();
		}

}

