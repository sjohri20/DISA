package Codes;

import java.awt.BorderLayout;
//import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Codes.GenomicLength;

public class Upload
{
	//DECLARATION OF VARIABLES
	public static String name=null;
	
	//CONSTRUCTOR
	public Upload(JTabbedPane frame)
	{
				//SETTING PANEL FOR TAB
				frame.setTabPlacement(1);
				final JPanel panel = new JPanel();
				frame.add(panel, "Upload File");
				JButton open = new JButton("Open A File");
				panel.add(open);
				open.setToolTipText("Only .txt files supported");
				final JTabbedPane f = frame;
				open.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//CODE FOR CHOOSING A .TXT FILE FROM FILES IN COMPUTER
						JFileChooser fc = new JFileChooser();
						f.add(fc);
						int value = fc.showOpenDialog(f);
						File file = null;
						if(value == JFileChooser.APPROVE_OPTION)
						{
						  file = fc.getSelectedFile();  
						  //System.out.println(file.getPath());
						  FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "*.txt", "txt", "text");
						  fc.setFileFilter(filter);
						  name= file.getAbsolutePath();
						  char[] chararray=name.toCharArray();
						  String hr="";
								 for(int i=0;i<chararray.length;i++)
								 {
									 if(chararray[i]=='\\')
									 {
										 chararray[i]='/';
										 
									 }
									 hr=hr+chararray[i];
								 }
						  //CODE FOR CALCULATING % OF ATGC AND GENELENGTH
						  GenomicLength genelength = new GenomicLength(hr);
						  double[] array = genelength.getGL();
						     //CODE FOR DISPLAY OF THE FILE 
						  	 JTextArea text = new JTextArea();
						  	 text.setColumns(20);
						  	 text.setRows(10);
						  	 text.setLayout(null);
							 JScrollPane scroll = new JScrollPane (text);   //INSERTING A SCROLL
							 scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
							 scroll.setVisible(true);
							 scroll.setBounds(20,20,50,50);
							 panel.add(scroll);
							 text.setLineWrap(true);
							 text.setEditable(false);
							 text.setVisible(true);

							 //LABELS FOR DISPLAY OF ATGC CONTEXT
							 JLabel l1 = new JLabel("%A                              ");
							 JLabel l2 = new JLabel("%T                              ");
							 JLabel l3 = new JLabel("%C                              ");
							 JLabel l4 = new JLabel("%G                              ");
							 
							 //TEXTFIELDS FOR DISPLAYING ATGC CONTENT
							 JTextField tx1 = new JTextField();
							 tx1.setText(Double.toString(array[0]));
							 JTextField tx2 = new JTextField();
							 tx2.setText(Double.toString(array[1]));
							 JTextField tx3 = new JTextField();
							 tx3.setText(Double.toString(array[2]));
							 JTextField tx4 = new JTextField();
							 tx4.setText(Double.toString(array[3]));

							 panel.add(scroll, BorderLayout.CENTER);
							 panel.add(l1, BorderLayout.PAGE_END);
							 panel.add(tx1, BorderLayout.PAGE_END);
							 panel.add(l2, BorderLayout.PAGE_END);
							 panel.add(tx2, BorderLayout.PAGE_END);
							 panel.add(l3, BorderLayout.PAGE_END);
							 panel.add(tx3, BorderLayout.PAGE_END);
							 panel.add(l4, BorderLayout.PAGE_END);
							 panel.add(tx4, BorderLayout.PAGE_END);
							 BufferedReader in = null;
							 try 
							 {
								 in = new BufferedReader(new FileReader(file));
							 } 
							 catch (FileNotFoundException e1) 
							 {
							// TODO Auto-generated catch block
								 e1.printStackTrace();
							 }
							 String line = null;
							 try 
							 {
								 line = in.readLine();
							 } 
							 catch (IOException e1) 
							 {
							// TODO Auto-generated catch block
								 e1.printStackTrace();
							 }
							 while(line != null)
							 {
								 text.append(line + "\n");
								 try 
								 	{
									 line = in.readLine();
								 	} 
								 catch (IOException e1) 
								 {
							// TODO Auto-generated catch block
									 e1.printStackTrace();
								 }
							 }
						}
						
					}
				});
				while (name==null)
				{
					String s = getName();
					if (s!=null)
					{
						open.setEnabled(false);
					}
				}
	}

	public static void main(String[] args)
	{
		//Function();
	}
	public String getName()
	{
		//System.out.print("");
		return name;
	}
}


