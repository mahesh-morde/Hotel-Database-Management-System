package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add_Employee extends JFrame implements ActionListener{
	
	JTextField tfname, tfage, tfsalary, tfmail, tfphon,tfaadhar;
	JRadioButton rbmale, rbfemale;
	JButton submit, cancel;
	JComboBox cbjob;
	
 	Add_Employee(){
		
		setLayout(null);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 30, 150, 30);
		add(tfname);
		
		JLabel lblage = new JLabel("Age");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200, 80, 150, 30);
		add(tfage);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200, 130, 70, 30);
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280, 130, 70, 30);
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lbljob = new JLabel("Job");
		lbljob.setBounds(60,180,120,30);
		lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lbljob);
		
		String str[] = { "Front Dest Clearks", "Porters", "HouseKeeping", "Kitchen Staff","Room Keeping","Manager","Accountant", "Waiters/Waitress","Chefs"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200, 180, 150, 30);
		add(cbjob);
		
		JLabel lbsalary = new JLabel("Salary");
		lbsalary.setBounds(60,230,120,30);
		lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lbsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(200, 230, 150, 30);
		add(tfsalary);
		
		JLabel lbphon = new JLabel("Phon No");
		lbphon.setBounds(60,280,120,30);
		lbphon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lbphon);
		
		tfphon = new JTextField();
		tfphon.setBounds(200, 280, 150, 30);
		add(tfphon);
		
		JLabel lblemail = new JLabel("E- Mail");
		lblemail.setBounds(60,330,120,30);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblemail);
		
		tfmail = new JTextField();
		tfmail.setBounds(200, 330, 150, 30);
		add(tfmail);
		
		JLabel lblaadhar = new JLabel("Adhar No");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200, 380, 150, 30);
		add(tfaadhar);
		
		submit= new JButton("Submit");
		submit.setBounds(200, 434 , 150, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(50, 434 , 150, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("src/icons/tenth.jpg");
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 60, 450, 370);
		add(image);
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(350, 200, 850, 540);
		setVisible(true);
	}
 	
 	@Override
	public void actionPerformed(ActionEvent ae) {
 		if(ae.getSource() == submit) {
		String name = tfname.getText();
		String age = tfage.getText();
		String email = tfmail.getText();
		String salary = tfsalary.getText();
		String phon = tfphon.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		
		if(rbmale.isSelected()) {
			gender = "Male";
		}else {rbfemale.isSelected();
			gender = "Female";
		}
		
		String  job = (String) cbjob.getSelectedItem();
		
		if (name.equals("") || age.equals("") || email.equals("") || salary.equals("") || phon.equals("") || aadhar.equals("") || gender.equals("") || job.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter All Fields");
			return;
		}
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phon+"','"+email+"','"+aadhar+"')";
			
			c.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Employee Added Sucessfully");
			
			setVisible(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}else if(ae.getSource()==cancel) {
		setVisible(false);
 	}
 }

	public static void main(String[] args) {
		new Add_Employee();

	}

}
