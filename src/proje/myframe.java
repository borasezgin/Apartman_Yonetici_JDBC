package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class myframe extends JFrame implements ActionListener {

	  	JButton buton = new JButton();
	    JButton buton1 = new JButton();
	    JButton buton2 = new JButton();
        
	    
	    String columns[] = { "daireNo", "daire_sakini", "cocuk_sayisi","is","memleket","aidat_borcu","telefon_no"};

	    String data[][] = new String[10][7];

	
	

		myframe()throws SQLException {
			
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartman?user=root&password=//your password//");
	        Statement st = c.createStatement();

	        ResultSet rs = st.executeQuery("SELECT * FROM homes_info");
	        
	        

	        int i = 0;
	        
	        while (rs.next()) {
	            int no = rs.getInt("daireNo");
	            String isim = rs.getString("daire_sakini");
	            String cocuk = rs.getString("cocuk_sayisi");
	            String job = rs.getString("is");
	            String kutuk = rs.getString("memleket");
	            int borc = rs.getInt("aidat_borcu");
	            String telefon = rs.getString("telefon_no");

	            data[i][0] = no + "";
	            data[i][1] = isim;
	            data[i][2] = cocuk;
	            data[i][3] = job;
	            data[i][4] = kutuk;
	            data[i][5] = borc + "";
	            data[i][6] = telefon ;


	            i++;
	        }
	        
	        DefaultTableModel model = new DefaultTableModel(data, columns);


	        
	        buton.setText("UPDATE ");
			buton.setBounds(0,0,100, 100);
	        buton.setLocation(100, 400);
	        buton.setFont(new Font("Comic Sans",Font.BOLD,20));
	        buton.setForeground(Color.blue);
	        
	        
	        buton1.setText("En cok borcu olani goster");
	        buton1.setBounds(0,0,100, 100);
	        buton1.setLocation(400, 400);
	        buton1.setFont(new Font("Comic Sans",Font.BOLD,12));
	        buton1.setForeground(Color.blue);


	        buton2.setText("Kisi silme icin tiklayiniz");
	        buton2.setBounds(0,0,100, 100);
	        buton2.setLocation(700, 400);
	        buton2.setFont(new Font("Comic Sans",Font.BOLD,12));
	        buton2.setForeground(Color.blue);

	        
	        JTable table = new JTable(model);

	        table.setShowGrid(true);
	        table.setShowVerticalLines(true);


	        JPanel p = new JPanel();

	        JScrollPane pane = new JScrollPane(table);

	        pane.setPreferredSize(new Dimension(1000,500));


	        

	        
	        setSize(1000,1000);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        
	        
	        add(p,BorderLayout.NORTH);


	        p.add(pane);

	        
	        add(buton,BorderLayout.CENTER);
	        add(buton1,BorderLayout.WEST);
	        add(buton2,BorderLayout.EAST);
	        buton.addActionListener(this);
	        buton2.addActionListener(this);
	        buton1.addActionListener(this);

	        
	        setVisible(true);	       

		}
		
		
		
		
		

		
		
		
		
		public static void main(String[] args) throws SQLException {
			myframe f = new myframe();

		}

	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == buton) {
				
			
			    

			    
			    try
		        {
		        
		            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartman?user=root&password=1986bora");
			        Statement st = c.createStatement();
		            
		           
				    String input = JOptionPane.showInputDialog("guncellemek istediginiz kisinin daire no giriniz :");
					
				    for(int row = 0; row < data.length; row++) {
						for(int column = 0; column < data[row].length; column++) {
							if(input.equals(data[row][0])) {
					          

								Scanner scan = new Scanner(System.in);

					            System.out.println("Daire sakini : ");
					            String name = scan.nextLine();

					            System.out.println("Cocuk sayisi");
					            int cocuk = scan.nextInt();

					            System.out.println("işi : ");
					            String is = scan.nextLine();

					            System.out.println("Memleket : ");
					            String memleket = scan.nextLine();

					            System.out.println("Aidat borcu : ");
					            int borc = scan.nextInt();

					            System.out.println("Telefon No : ");
					            String telefon = scan.nextLine();
								
								
							    String sql = "UPDATE homes_info " +
							            "SET daire_sakini = name , cocuk_sayisi = cocuk ,is = is , memleket = memleket , aidat_borcu = borc , telefon_no = telefon WHERE id ="+input;
							    		st.executeUpdate(sql);
								
							}
						}
				    }
				    System.out.println("its done");
		            
		            
		            
		        } 
		        catch (Exception b) {
		            b.printStackTrace();
		        }
			    
			    
			    
			    
			    
			    // istedigimiz row da ki kisinin degerlerinin yazdirir
			   
			    /*
			    for(int row = 0; row < data.length; row++) {
					for(int column = 0; column < data[row].length; column++) {
						if(input.equals(data[row][1])) {
							
							
							
							System.out.println("Daire no= "+data[row][0]);
							System.out.println("Daire sakini= "+data[row][1]);
							System.out.println("Cocuk no= "+data[row][2]);
							System.out.println("Is= "+data[row][3]);
							System.out.println("Memleket= "+data[row][4]);
							System.out.println("Borc= "+data[row][5]);
							System.out.println("Telefon= "+data[row][6]);
							break;


						}
					}
					
			}
			    */
		}
			
			
			
			
			if(e.getSource() == buton2) {

				
				
		
		        try
		        {
		        
		            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartman?user=root&password=1986bora");
			        Statement st = c.createStatement();
		            
		           
		            String input = JOptionPane.showInputDialog("silmek istediginiz kisinin daire no giriniz :");
					
				    for(int row = 0; row < data.length; row++) {
						for(int column = 0; column < data[row].length; column++) {
							if(input.equals(data[row][0])) {
					          
								st.execute("DELETE FROM homes_info WHERE daireNo = " +input);
								
							}
						}
				    }
				    System.out.println("its done");
		            
		            
		            
		        } 
		        catch (Exception b) {
		            b.printStackTrace();
		        }
				
				
				
				
		        
		        
		        //borcu olmayan kisiler
		        
				/*
				
				
				for(int row = 0; row < data.length; row++) {
					if(data[row][5].equals("0")) {
						JOptionPane.showMessageDialog(null,"Borcu olmayan kisiler : " + data[row][1]);
					}			 

				}
				
				*/
				
				
				
			}
			
			
			
			
			
			
			
			if(e.getSource()== buton1) {
				
				
				
				
				
				
				String maxborclu=data[0][5];
				String maxborcluIsim=data[0][1];

				
				for(int row = 1; row < data.length; row++) {
					if(Integer.parseInt(data[row][5])> Integer.parseInt(maxborclu)) {
						maxborclu=data[row][5];		//yeni borc
						maxborcluIsim=data[row][1]; //yeni isim
						

						
					}			 

				}
			   
				
					JOptionPane.showMessageDialog(null, "Max borclu kisi: " + maxborcluIsim + "\nMax borc: " + maxborclu);  
					
					
					
					
					
				
			}
			
			
			
			
			
			
			
			
			
	

	}
	


}
