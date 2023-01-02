package com.rahcode.inventoryjava;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Products{
	public JPanel panel;
	private JPanel panelInventory;
	private JTextField inventory_search;
	private JPanel panelAdd;
	private JTextField add_type_text;
	private JTextField add_model_text;
	private JTextField add_quantity_text;
	private JTextField add_cost_text;
	private JPanel panelTable;
	private JPanel panelEdit;
	private JTextField edit_type_text;
	private JTextField edit_model_text;
	private JTextField edit_quantity_text;
	private JTextField edit_cost_text;

	private App app=new App();

	public Products() {
	}

	public JPanel index(Boolean darkTheme) throws FontFormatException, IOException{
		panel = new JPanel();
		panel.setBackground(app.colors(darkTheme,9));
		panel.setBounds(10, 11, 1214, 364);
		panel.setLayout(null);

		inventory(darkTheme);
		return(panel);
	}

	public void inventory(Boolean darkTheme) throws FontFormatException, IOException{
		panelInventory = new JPanel();
		panelInventory.setBackground(app.colors(darkTheme,9));
		panelInventory.setBounds(10, 11, 1214, 364);
		panel.add(panelInventory);
		panelInventory.setLayout(null);
		
		JLabel inventory_title = new JLabel("inventory");
		inventory_title.setHorizontalAlignment(SwingConstants.CENTER);
		inventory_title.setBounds(0, 46, 1214, 55);
		inventory_title.setFont(app.fonts(3,36));
		inventory_title.setForeground(app.colors(darkTheme,5));
		panelInventory.add(inventory_title);
		
		JLabel inventory_subtitle = new JLabel("java");
		inventory_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		inventory_subtitle.setBounds(0, 97, 1214, 21);
		inventory_subtitle.setFont(app.fonts(1,14));
		inventory_subtitle.setForeground(app.colors(darkTheme,6));
		panelInventory.add(inventory_subtitle);
		
		JButton inventory_button = new JButton("Add a product");
		inventory_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(app.session(app.config()[0],app.config()[1],2)>=2){
					panelInventory.setVisible(false);
					try {
						add(darkTheme);
					} catch (FontFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					app.auth();
				}
			}
		});
		inventory_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inventory_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inventory_button.setBackground(app.colors(darkTheme,1));
			}
		});
		inventory_button.setBounds(250, 170, 160, 57);
		inventory_button.setBackground(app.colors(darkTheme,1));
		inventory_button.setForeground(Color.WHITE);
		inventory_button.setFont(app.fonts(2,16));
		panelInventory.add(inventory_button);	

		JButton inventory_table_button = new JButton("View table");
		inventory_table_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInventory.setVisible(false);
				try {
					table(darkTheme);
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		inventory_table_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inventory_table_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inventory_table_button.setBackground(app.colors(darkTheme,1));
			}
		});
		inventory_table_button.setForeground(Color.WHITE);
		inventory_table_button.setFont(app.fonts(2,16));
		inventory_table_button.setBackground(app.colors(darkTheme,1));
		inventory_table_button.setBounds(480, 170, 160, 57);
		panelInventory.add(inventory_table_button);
		
		inventory_search = new JTextField();
		inventory_search.setBounds(250, 290, 218, 57);
		inventory_search.setForeground(app.colors(darkTheme,6));
		inventory_search.setFont(app.fonts(1,16));
		inventory_search.setBackground(app.colors(darkTheme,8));
		panelInventory.add(inventory_search);
		inventory_search.setColumns(10);
		inventory_search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JButton inventory_search_button = new JButton("Search");
		inventory_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(search(inventory_search.getText(),2)==0){
					JOptionPane.showMessageDialog(null,"Product not found","M E S S A G E",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		inventory_search_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inventory_search_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inventory_search_button.setBackground(app.colors(darkTheme,1));
			}
		});
		inventory_search_button.setBounds(480, 290, 218, 57);
		inventory_search_button.setFont(app.fonts(2,16));
		inventory_search_button.setBackground(app.colors(darkTheme,1));
		inventory_search_button.setForeground(Color.WHITE);
		panelInventory.add(inventory_search_button);
	}

	public void add(Boolean darkTheme) throws FontFormatException, IOException{
		panelAdd = new JPanel();
		panelAdd.setBackground(app.colors(darkTheme,9));
		panelAdd.setBounds(10, 11, 1214, 364);
		panelAdd.setLayout(null);
		panel.add(panelAdd);
		
		JLabel add_title = new JLabel("Add");
		add_title.setHorizontalAlignment(SwingConstants.CENTER);
		add_title.setBounds(10, 0, 1214, 55);
		add_title.setForeground(app.colors(darkTheme,5));
		add_title.setFont(app.fonts(3,36));
		panelAdd.add(add_title);
		
		JLabel add_subtitle = new JLabel("Product");
		add_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		add_subtitle.setBounds(10, 51, 1214, 21);
		add_subtitle.setForeground(app.colors(darkTheme,6));
		add_subtitle.setFont(app.fonts(1,14));
		panelAdd.add(add_subtitle);
		
		JButton add_button = new JButton("Add");
		add_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				add_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				add_button.setBackground(app.colors(darkTheme,1));
			}
		});
		add_button.setBounds(450, 303, 336, 45);
		add_button.setFont(app.fonts(2,16));
		add_button.setBackground(app.colors(darkTheme,1));
		add_button.setForeground(Color.WHITE);
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			int i=0;
				try {
				i=newProduct(id(app.productsDB),add_type_text.getText(),add_model_text.getText(),add_quantity_text.getText(),add_cost_text.getText(),app.productsDB);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if(i==1){
				panelAdd.setVisible(false);
				panelInventory.setVisible(true);
			}

			}
		});
		panelAdd.add(add_button);

		JPanel add_type = new JPanel();
		add_type.setBounds(269, 130, 336, 69);
		add_type.setBackground(app.colors(darkTheme,8));
		panelAdd.add(add_type);
		add_type.setLayout(null);
		
		JLabel add_type_label = new JLabel("Type/Brand");
		add_type_label.setBounds(10, 5, 316, 23);
		add_type.add(add_type_label);
		add_type_label.setForeground(app.colors(darkTheme,6));
		add_type_label.setFont(app.fonts(1,16));
		
		add_type_text = new JTextField();
		add_type_text.setBounds(10, 24, 316, 37);
		add_type.add(add_type_text);
		add_type_text.setFont(app.fonts(1,16));
		add_type_text.setBackground(app.colors(darkTheme,8));
		add_type_text.setForeground(app.colors(darkTheme,6));
		add_type_text.setColumns(10);
		add_type_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel add_model = new JPanel();
		add_model.setBounds(629, 130, 336, 69);
		add_model.setBackground(app.colors(darkTheme,8));
		panelAdd.add(add_model);
		add_model.setLayout(null);
		
		JLabel add_model_label = new JLabel("Model");
		add_model_label.setBounds(10, 5, 316, 23);
		add_model.add(add_model_label);
		add_model_label.setForeground(app.colors(darkTheme,6));
		add_model_label.setFont(app.fonts(1,16));
		
		add_model_text = new JTextField();
		add_model_text.setBounds(10, 24, 316, 37);
		add_model.add(add_model_text);
		add_model_text.setForeground(app.colors(darkTheme,6));
		add_model_text.setFont(app.fonts(1,16));
		add_model_text.setBackground(app.colors(darkTheme,8));
		add_model_text.setColumns(10);
		add_model_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel add_quantity = new JPanel();
		add_quantity.setBounds(269, 223, 336, 69);
		add_quantity.setBackground(app.colors(darkTheme,8));
		panelAdd.add(add_quantity);
		add_quantity.setLayout(null);
		
		JLabel add_quantity_label = new JLabel("Quantity");
		add_quantity_label.setBounds(10, 5, 316, 23);
		add_quantity.add(add_quantity_label);
		add_quantity_label.setForeground(app.colors(darkTheme,6));
		add_quantity_label.setFont(app.fonts(1,16));
		
		add_quantity_text = new JTextField();
		add_quantity_text.setBounds(10, 24, 316, 37);
		add_quantity.add(add_quantity_text);
		add_quantity_text.setBackground(app.colors(darkTheme,8));
		add_quantity_text.setForeground(app.colors(darkTheme,6));
		add_quantity_text.setFont(app.fonts(1,16));
		add_quantity_text.setText("1");
		add_quantity_text.setColumns(10);
		add_quantity_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel add_cost = new JPanel();
		add_cost.setBounds(629, 223, 336, 69);
		add_cost.setBackground(app.colors(darkTheme,8));
		panelAdd.add(add_cost);
		add_cost.setLayout(null);
		
		JLabel add_cost_label = new JLabel("Cost");
		add_cost_label.setBounds(10, 5, 316, 23);
		add_cost.add(add_cost_label);
		add_cost_label.setForeground(app.colors(darkTheme,6));
		add_cost_label.setFont(app.fonts(1,16));
		
		add_cost_text = new JTextField();
		add_cost_text.setBounds(10, 24, 316, 37);
		add_cost.add(add_cost_text);
		add_cost_text.setForeground(app.colors(darkTheme,6));
		add_cost_text.setFont(app.fonts(1,16));
		add_cost_text.setBackground(app.colors(darkTheme,8));
		add_cost_text.setText("1");
		add_cost_text.setColumns(10);
		add_cost_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	}

	public void table(Boolean darkTheme) throws FontFormatException, IOException{
		panelTable = new JPanel();
		panelTable.setBackground(app.colors(darkTheme,9));
		panelTable.setBounds(10, 11, 1214, 364);
		panel.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane table_scroll = new JScrollPane();
		table_scroll.setBounds(0, 0, 1205, 355);
		panelTable.add(table_scroll);
		
		JTable table_table = new JTable();
		table_table.setSelectionForeground(app.colors(darkTheme,6));
		table_table.setSelectionBackground(app.colors(darkTheme,8));
		table_table.setRowHeight(62);
		table_table.setForeground(app.colors(darkTheme,6));
		table_table.setFont(app.fonts(1,16));
		table_table.setBackground(app.colors(darkTheme,9));
		table_table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "TYPE", "MODEL", "QTY", "$"}
			},
			new String[] {
				"", "", "", "", ""
			}
		));
		table_table.getColumnModel().getColumn(0).setMaxWidth(25);
		table_table.getColumnModel().getColumn(3).setMaxWidth(75);
		table_table.getColumnModel().getColumn(4).setMaxWidth(45);
		table_scroll.setViewportView(table_table);

		fillTable((DefaultTableModel)table_table.getModel());
		
		JPanel table_info = new JPanel();
		table_info.setBackground(app.colors(darkTheme,9));
		table_scroll.setRowHeaderView(table_info);
		table_info.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel table_info_label = new JLabel("Total quantity: "+total(1));
		table_info_label.setForeground(app.colors(darkTheme,6));
		table_info_label.setFont(app.fonts(1,16));
		table_info.add(table_info_label);
		
		JLabel table_info_label_1 = new JLabel("Total cost: "+total(2));
		table_info_label_1.setForeground(app.colors(darkTheme,6));
		table_info_label_1.setFont(app.fonts(1,16));
		table_info.add(table_info_label_1);
		
		JButton table_info_button = new JButton("Edit");
		table_info_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				table_info_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				table_info_button.setBackground(app.colors(darkTheme,1));
			}
		});
		table_info_button.setForeground(Color.WHITE);
		table_info_button.setBackground(app.colors(darkTheme,1));
		table_info_button.setFont(app.fonts(2,16));
		table_info_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(app.session(app.config()[0],app.config()[1],2)>=2){
					String id=JOptionPane.showInputDialog(null,"Insert the ID of the product to edit","I N P U T",JOptionPane.QUESTION_MESSAGE);
					panelTable.setVisible(false);
					try {
						edit(darkTheme,id);
					} catch (FontFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					app.auth();
				}
			}
		});
		table_info.add(table_info_button);
		
		JButton table_info_button_1 = new JButton("Delete");
		table_info_button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				table_info_button_1.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				table_info_button_1.setBackground(app.colors(darkTheme,1));
			}
		});
		table_info_button_1.setBackground(app.colors(darkTheme,1));
		table_info_button_1.setFont(app.fonts(2,16));
		table_info_button_1.setForeground(Color.WHITE);
		table_info_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(app.session(app.config()[0],app.config()[1],2)>=2){
					delete();
				}
				else{
					app.auth();
				}
			}
		});
		table_info.add(table_info_button_1);
	}

	public void edit(Boolean darkTheme,String id) throws FontFormatException, IOException{
		panelEdit = new JPanel();
		panelEdit.setBackground(app.colors(darkTheme,9));
		panelEdit.setBounds(10, 11, 1214, 364);
		panelEdit.setLayout(null);
		panel.add(panelEdit);
		
		JLabel edit_title = new JLabel("Edit");
		edit_title.setHorizontalAlignment(SwingConstants.CENTER);
		edit_title.setBounds(10, 0, 1214, 55);
		edit_title.setForeground(app.colors(darkTheme,5));
		edit_title.setFont(app.fonts(3,36));
		panelEdit.add(edit_title);
		
		JLabel edit_subtitle = new JLabel("Product");
		edit_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		edit_subtitle.setBounds(10, 51, 1214, 21);
		edit_subtitle.setForeground(app.colors(darkTheme,6));
		edit_subtitle.setFont(app.fonts(1,14));
		panelEdit.add(edit_subtitle);
		
		JButton edit_button = new JButton("Edit");
		edit_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_button.setBackground(app.colors(darkTheme,3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edit_button.setBackground(app.colors(darkTheme,1));
			}
		});
		edit_button.setBounds(450, 303, 336, 45);
		edit_button.setFont(app.fonts(2,16));
		edit_button.setBackground(app.colors(darkTheme,1));
		edit_button.setForeground(Color.WHITE);
		edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args={id,edit_type_text.getText()
					,edit_model_text.getText()
					,edit_quantity_text.getText()
					,edit_cost_text.getText()};
				
				upd(args);
			}
		});
		panelEdit.add(edit_button);

		JPanel edit_type = new JPanel();
		edit_type.setBounds(269, 130, 336, 69);
		edit_type.setBackground(app.colors(darkTheme,8));
		panelEdit.add(edit_type);
		edit_type.setLayout(null);
		
		JLabel edit_type_label = new JLabel("Type/Brand");
		edit_type_label.setBounds(10, 5, 316, 23);
		edit_type.add(edit_type_label);
		edit_type_label.setForeground(app.colors(darkTheme,6));
		edit_type_label.setFont(app.fonts(1,16));
		
		edit_type_text = new JTextField();
		edit_type_text.setBounds(10, 24, 316, 37);
		edit_type.add(edit_type_text);
		edit_type_text.setFont(app.fonts(1,16));
		edit_type_text.setBackground(app.colors(darkTheme,8));
		edit_type_text.setForeground(app.colors(darkTheme,6));
		edit_type_text.setColumns(10);
		edit_type_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel edit_model = new JPanel();
		edit_model.setBounds(629, 130, 336, 69);
		edit_model.setBackground(app.colors(darkTheme,8));
		panelEdit.add(edit_model);
		edit_model.setLayout(null);
		
		JLabel edit_model_label = new JLabel("Model");
		edit_model_label.setBounds(10, 5, 316, 23);
		edit_model.add(edit_model_label);
		edit_model_label.setForeground(app.colors(darkTheme,6));
		edit_model_label.setFont(app.fonts(1,16));
		
		edit_model_text = new JTextField();
		edit_model_text.setBounds(10, 24, 316, 37);
		edit_model.add(edit_model_text);
		edit_model_text.setForeground(app.colors(darkTheme,6));
		edit_model_text.setFont(app.fonts(1,16));
		edit_model_text.setBackground(app.colors(darkTheme,8));
		edit_model_text.setColumns(10);
		edit_model_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel edit_quantity = new JPanel();
		edit_quantity.setBounds(269, 223, 336, 69);
		edit_quantity.setBackground(app.colors(darkTheme,8));
		panelEdit.add(edit_quantity);
		edit_quantity.setLayout(null);
		
		JLabel edit_quantity_label = new JLabel("Quantity");
		edit_quantity_label.setBounds(10, 5, 316, 23);
		edit_quantity.add(edit_quantity_label);
		edit_quantity_label.setForeground(app.colors(darkTheme,6));
		edit_quantity_label.setFont(app.fonts(1,16));
		
		edit_quantity_text = new JTextField();
		edit_quantity_text.setBounds(10, 24, 316, 37);
		edit_quantity.add(edit_quantity_text);
		edit_quantity_text.setBackground(app.colors(darkTheme,8));
		edit_quantity_text.setForeground(app.colors(darkTheme,6));
		edit_quantity_text.setFont(app.fonts(1,16));
		edit_quantity_text.setText("1");
		edit_quantity_text.setColumns(10);
		edit_quantity_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JPanel edit_cost = new JPanel();
		edit_cost.setBounds(629, 223, 336, 69);
		edit_cost.setBackground(app.colors(darkTheme,8));
		panelEdit.add(edit_cost);
		edit_cost.setLayout(null);
		
		JLabel edit_cost_label = new JLabel("Cost");
		edit_cost_label.setBounds(10, 5, 316, 23);
		edit_cost.add(edit_cost_label);
		edit_cost_label.setForeground(app.colors(darkTheme,6));
		edit_cost_label.setFont(app.fonts(1,16));
		
		edit_cost_text = new JTextField();
		edit_cost_text.setBounds(10, 24, 316, 37);
		edit_cost.add(edit_cost_text);
		edit_cost_text.setForeground(app.colors(darkTheme,6));
		edit_cost_text.setFont(app.fonts(1,16));
		edit_cost_text.setBackground(app.colors(darkTheme,8));
		edit_cost_text.setText("1");
		edit_cost_text.setColumns(10);
		edit_cost_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		update(id);
	}

	public int newProduct(String id,String type,String model,String quantity,String cost,File file) throws IOException{		
		try{
			quantity=String.valueOf(Integer.parseInt(quantity));
			cost=String.valueOf(Integer.parseInt(cost));
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Your values quantity and cost must be integers", "E R R O R", JOptionPane.ERROR_MESSAGE);
			return(0);
		}
		if(!file.exists()){
			file.createNewFile();
		}
		
		app.wri=new FileWriter(file,true);
		app.pri=new PrintWriter(app.wri);
		
		app.pri.println(id+"\n"+type+"\n"+model+"\n"+quantity+"\n"+cost);
		
		app.pri.close();
		app.wri.close();
		return(1);
	}

	public String id(File file){
		String id=null,newId="1";
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			app.rea=new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);
		
		do{
			try {
				id=app.buf.readLine();
				app.buf.readLine();
				app.buf.readLine();
				app.buf.readLine();
				app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id!=null){
				newId=String.valueOf(Integer.parseInt(id)+1);
			}
		}while(id!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return(newId);
	}

	public String total(int op){
		String id=null,q="0",c="0",totalQ="0",totalC="0";
		int qua=0,cos=0;

		if(!app.productsDB.exists()){
			try {
				app.productsDB.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);
		
		do{
			try {
				id=app.buf.readLine();
				app.buf.readLine();
				app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(q!=null&&c!=null){
				qua+=Integer.parseInt(q);
				cos+=Integer.parseInt(c)*Integer.parseInt(q);
			}
		}while(id!=null);		

		totalQ=String.valueOf(qua);
		totalC=String.valueOf(cos);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch(op){
			case 1:
				return(totalQ);
			case 2:
				return(totalC);
			default:
				return("0");
		}
	}

	public void delete(){
		String idDel=JOptionPane.showInputDialog(null,"Insert the ID of the product to delete","I N P U T",JOptionPane.QUESTION_MESSAGE);
		
		if(search(idDel,1)==1){
			if(JOptionPane.showConfirmDialog(null,"Do you want to delete this product?","C O N F I R M", 0)==0){
				del(idDel);
				JOptionPane.showMessageDialog(null,"The product has been deleted","M E S S A G E",JOptionPane.INFORMATION_MESSAGE);
				app.productsDB.delete();
				app.productsTEMP.renameTo(app.productsDB);
				panelTable.setVisible(false);
				panelInventory.setVisible(true);
			}
		}else{
			JOptionPane.showMessageDialog(null,"There is not a product with that ID","M E S S A G E",JOptionPane.ERROR_MESSAGE);
		}
	}

	public int search(String sea,int op){
		String id=null,t=null,m=null,q=null,c=null;
		int found=0;

		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);

		do{
			try {
				id=app.buf.readLine();
				t=app.buf.readLine();
				m=app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id!=null){
				if(op==1&&id.equals(sea)){
					JOptionPane.showMessageDialog(null,
					"Product info:\n"
					+"\nID: "+id
					+"\nTYPE: "+t
					+"\nMODEL: "+m
					+"\nQUANTITY: "+q
					+"\nCOST: "+c,
					"P R O D U C T",JOptionPane.INFORMATION_MESSAGE);
					found=1;
				}
				if(op==2&&(t.contains(sea)||m.contains(sea))){
					JOptionPane.showMessageDialog(null,
					"Product info:\n"
					+"\nID: "+id
					+"\nTYPE: "+t
					+"\nMODEL: "+m
					+"\nQUANTITY: "+q
					+"\nCOST: "+c,
					"P R O D U C T",JOptionPane.INFORMATION_MESSAGE);
					found=1;
				}
			}
		}while(id!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return(found);
	}

	public void del(String idDel){
		String id=null,t=null,m=null,q=null,c=null;

		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);

		do{
			try {
				id=app.buf.readLine();
				t=app.buf.readLine();
				m=app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id!=null&&!id.equals(idDel)){
				try {
					newProduct(id,t,m,q,c,app.productsTEMP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}while(id!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String idUpd){
		if(search(idUpd,1)==1){
			updateText(idUpd);
		}else{
			JOptionPane.showMessageDialog(null,"There is not a product with that ID","M E S S A G E",JOptionPane.ERROR_MESSAGE);
			panelEdit.setVisible(false);
			panelTable.setVisible(true);
		}
	}

	public void updateText(String idSea){
		String id=null,t=null,m=null,q=null,c=null;

		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);

		do{
			try {
				id=app.buf.readLine();
				t=app.buf.readLine();
				m=app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id!=null&&id.equals(idSea)){
				edit_type_text.setText(t);
				edit_model_text.setText(m);
				edit_quantity_text.setText(q);
				edit_cost_text.setText(c);
			}
		}while(id!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upd(String[] args){
		String id=null,t=null,m=null,q=null,c=null;

		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);

		do{
			try {
				id=app.buf.readLine();
				t=app.buf.readLine();
				m=app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id!=null&&!id.equals(args[0])){
				try {
					newProduct(id,t,m,q,c,app.productsTEMP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(id!=null){
				int ok=1;
				try {
					ok=newProduct(args[0],args[1],args[2],args[3],args[4],app.productsTEMP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(ok==0){
					try {
						newProduct(id,t,m,q,c,app.productsTEMP);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					panelEdit.setVisible(false);
					panelInventory.setVisible(true);
					JOptionPane.showMessageDialog(null,"The product has been edited","M E S S A G E",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}while(id!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		app.productsDB.delete();
		app.productsTEMP.renameTo(app.productsDB);
	}

	public void fillTable(DefaultTableModel model){
		String i=null,t=null,m=null,q=null,c=null;

		if(!app.productsDB.exists()){
			try {
				app.productsDB.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			app.rea=new FileReader(app.productsDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.buf=new BufferedReader(app.rea);

		do{
			try {
				i=app.buf.readLine();
				t=app.buf.readLine();
				m=app.buf.readLine();
				q=app.buf.readLine();
				c=app.buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i!=null){
				model.addRow(new Object[]{i,t,m,q,c});
			}
		}while(i!=null);

		try {
			app.buf.close();
			app.rea.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
