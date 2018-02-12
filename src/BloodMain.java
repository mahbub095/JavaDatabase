import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BloodMain extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField bgroup;
	private JTextField address;
	private JTextField phone;
	private JTextField ref;
	private JTextField willing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodMain frame = new BloodMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	


	Connection c =null;
	private JTextField blodgroup;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField na;
	private JTextField bg;
	private JTextField ad;
	private JTextField ph;
	private JTextField re;
	private JTextField wi;
	private JTable updatetable;
	
	
	public BloodMain() throws SQLException {
		
		c = DriverManager.getConnection("JDBC:sqlite:D:\\Java Project\\BLOODDONATION\\Blood.sqlite");
		JOptionPane.showMessageDialog( null , " Connect Sucessfully ");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1050, 750);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("File");
		menuBar.add(mnNew);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNew.add(mntmNew);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mnNew.add(mntmUpdate);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNew.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodDonation = new JLabel("Blood Donation");
		lblBloodDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodDonation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblBloodDonation.setBounds(116, 29, 617, 43);
		contentPane.add(lblBloodDonation);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tabbedPane.setBounds(10, 83, 906, 418);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Panel", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Donation Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(118, 22, 564, 48);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(33, 81, 140, 33);
		panel.add(lblName);
		
		name = new JTextField();
		name.setBounds(214, 86, 180, 28);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBloodGroup.setBounds(33, 125, 140, 33);
		panel.add(lblBloodGroup);
		
		bgroup = new JTextField();
		bgroup.setColumns(10);
		bgroup.setBounds(214, 130, 180, 28);
		panel.add(bgroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(33, 166, 140, 33);
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(214, 171, 180, 28);
		panel.add(address);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPhone.setBounds(33, 210, 140, 33);
		panel.add(lblPhone);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(214, 215, 180, 28);
		panel.add(phone);
		
		JLabel lblReference = new JLabel("Reference");
		lblReference.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblReference.setBounds(33, 259, 140, 33);
		panel.add(lblReference);
		
		ref = new JTextField();
		ref.setColumns(10);
		ref.setBounds(214, 264, 180, 28);
		panel.add(ref);
		
		JLabel lblWilling = new JLabel("Willing");
		lblWilling.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWilling.setBounds(403, 81, 140, 33);
		panel.add(lblWilling);
		
		willing = new JTextField();
		willing.setColumns(10);
		willing.setBounds(584, 86, 180, 28);
		panel.add(willing);
		
		JButton AddDonar = new JButton("Add Donar");
		AddDonar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nam3=name.getText();
				String bloodgrp=bgroup.getText();
				String addres=address.getText();
				String phon=phone.getText();
				String refrence=ref.getText();
				String willin=willing.getText();
				
				String query=" insert into Blooddoner (Name,Bgroup,Address,Phone,Reference,willing) " + " values ('"+nam3+"','"+bloodgrp+"','"+addres+"','"+phon+"','"+refrence+"','"+willin+"') ";
				
				try {
					Statement st = c.createStatement();
					
					st.execute(query);
					JOptionPane.showMessageDialog(null, "DoNer Add Suceessful");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		AddDonar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		AddDonar.setBounds(584, 210, 140, 23);
		panel.add(AddDonar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Blood Group");
		label.setBounds(65, 32, 103, 22);
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(label);
		
		blodgroup = new JTextField();
		blodgroup.setBounds(227, 35, 86, 20);
		blodgroup.setColumns(10);
		panel_1.add(blodgroup);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bloodgrp=blodgroup.getText();
				
                String query1="select * from Blooddoner where bgroup='"+bloodgrp +"'";
				
				try {
					Statement st1 = c.createStatement();
					
					st1.execute(query1);
					ResultSet rs= st1.executeQuery(query1);
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSearch.setBounds(490, 34, 89, 23);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 496, 337);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(401, 5, 1, 1);
		panel_3.setLayout(null);
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("Add Donation Information");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label_1.setBounds(118, 22, 564, 48);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_2.setBounds(33, 81, 140, 33);
		panel_3.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(214, 86, 180, 28);
		panel_3.add(textField);
		
		JLabel label_3 = new JLabel("Blood Group");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_3.setBounds(33, 125, 140, 33);
		panel_3.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 130, 180, 28);
		panel_3.add(textField_1);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_4.setBounds(33, 166, 140, 33);
		panel_3.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 171, 180, 28);
		panel_3.add(textField_2);
		
		JLabel label_5 = new JLabel("Phone");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_5.setBounds(33, 210, 140, 33);
		panel_3.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 215, 180, 28);
		panel_3.add(textField_3);
		
		JLabel label_6 = new JLabel("Reference");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_6.setBounds(33, 259, 140, 33);
		panel_3.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(214, 264, 180, 28);
		panel_3.add(textField_4);
		
		JLabel label_7 = new JLabel("Willing");
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_7.setBounds(403, 81, 140, 33);
		panel_3.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(584, 86, 180, 28);
		panel_3.add(textField_5);
		
		JButton button = new JButton("Add Donar");
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button.setBounds(584, 210, 140, 23);
		panel_3.add(button);
		
		JLabel label_8 = new JLabel("Name");
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_8.setBounds(10, 24, 140, 33);
		panel_2.add(label_8);
		
		na = new JTextField();
		na.setColumns(10);
		na.setBounds(191, 28, 180, 28);
		panel_2.add(na);
		
		JLabel label_9 = new JLabel("Blood Group");
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_9.setBounds(10, 68, 140, 33);
		panel_2.add(label_9);
		
		bg = new JTextField();
		bg.setColumns(10);
		bg.setBounds(191, 72, 180, 28);
		panel_2.add(bg);
		
		JLabel label_10 = new JLabel("Address");
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_10.setBounds(10, 112, 140, 33);
		panel_2.add(label_10);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(191, 116, 180, 28);
		panel_2.add(ad);
		
		JLabel label_11 = new JLabel("Phone");
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_11.setBounds(10, 174, 140, 33);
		panel_2.add(label_11);
		
		ph = new JTextField();
		ph.setColumns(10);
		ph.setBounds(191, 178, 180, 28);
		panel_2.add(ph);
		
		JLabel label_12 = new JLabel("Reference");
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_12.setBounds(10, 239, 140, 33);
		panel_2.add(label_12);
		
		re = new JTextField();
		re.setColumns(10);
		re.setBounds(191, 243, 180, 28);
		panel_2.add(re);
		
		JLabel label_13 = new JLabel("Willing");
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_13.setBounds(411, 24, 140, 33);
		panel_2.add(label_13);
		
		wi = new JTextField();
		wi.setColumns(10);
		wi.setBounds(568, 28, 180, 28);
		panel_2.add(wi);
		
		JButton button_1 = new JButton("Update Donar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nam1=na.getText();
				String bloodgrp1=bg.getText();
				String addres1=ad.getText();
				String phon1=ph.getText();
				String refrence1=re.getText();
				String willin1=wi.getText();
				
				String query5="Update Blooddoner Set Name='"+ nam1 +"',Bgroup='"+ bloodgrp1 +"',Address='"+ addres1 +"',Phone='"+phon1 +"',Reference='"+refrence1 +"',willing='"+willin1 +"'   where Name= '"+nam1+"'";
				
				try {
					Statement st5 = c.createStatement();
					
					st5.execute(query5);
					JOptionPane.showMessageDialog(null, "DoNer  Update Suceessful");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button_1.setBounds(547, 179, 180, 23);
		panel_2.add(button_1);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				try {
					
					
					String query2="select * from Blooddoner"; 
					Statement st2 = c.createStatement();
					
					//st2.execute(query2);
					ResultSet rs2= st2.executeQuery(query2);
					
					
					updatetable.setModel(DbUtils.resultSetToTableModel(rs2));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnShow.setBounds(547, 246, 140, 23);
		panel_2.add(btnShow);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(69, 388, 365, -100);
		panel_2.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row=updatetable.getSelectedRow();
				String n =  updatetable.getModel().getValueAt(row,0).toString();
				String query4="select * from Blooddoner where Name ='"+n+"'";
				
				try {
					Statement st4=c.createStatement();
					ResultSet re4=st4.executeQuery(query4);
					
					while (re4.next()){
						na.setText(re4.getString("Name"));
						bg.setText(re4.getString("Bgroup"));
						ad.setText(re4.getString("Address"));
						ph.setText(re4.getString("Phone"));
						re.setText(re4.getString("Reference"));
						wi.setText(re4.getString("Willing"));
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					
					
					
				}
				
				
				
				
				
			}
		});
		updatetable.setBounds(92, 299, 419, 103);
		panel_2.add(updatetable);
	}
}
