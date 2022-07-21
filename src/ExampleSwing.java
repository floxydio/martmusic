import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class ExampleSwing {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JButton b = new JButton("click");
		JTextField text = new JTextField("Login");
		JButton btnPost = new JButton("post");
		
		b.setBounds(130,100,100,40);
		text.setBounds(50,70,200,30);
		btnPost.setBounds(130,40,100,40);
		
		f.add(text);
		f.add(btnPost);
		f.add(b);
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		
		btnPost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = text.getText();
				double jumlah = 0;
				String dateOrder = "8 Agustus 2022";
				JOptionPane.showMessageDialog(btnPost, name);
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root", "");
					) {
					Class.forName("com.mysql.cj.jdbc.Driver");
										String execQuery = String.format("INSERT INTO `product`(`nama`, `jumlah`, `order_date`) VALUES ('%s','%d','%s')", name, jumlah,dateOrder);
					String query = execQuery;
					Statement sta = connection.createStatement();
					sta.executeUpdate(query);
					
					JOptionPane.showMessageDialog(btnPost, "Success Input Data");
					
				}
				catch(Exception exception) {
					System.out.println("Cannot connect DB");
				}
				
			}
		});
	}
}