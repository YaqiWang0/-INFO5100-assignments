package Assignment8;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentInformationSystem extends JFrame{
	private JTable studentsTable;
	private Font font;
	private JLabel ID,firstName,lastName,gender;
	private JList<String> genderField;
	private JTextField IDfield,firstNameField,lastNameField;
	private JButton add;
	private Students stu;
	private StudentsTableModel model;
	class operationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==add) {
				int id=Integer.parseInt(IDfield.getText());
				String first=firstNameField.getText();
				String last=lastNameField.getText();
				String gender=genderField.getSelectedValue();
				boolean gender1;
				if(gender.equals("true"))
					gender1=true;
				else
					gender1=false;
				Student newstu=new Student(id, first, last, gender1);
				stu.addStudent(newstu);
		
				studentsTable.updateUI();
				
				
			}
			
		}
		
	}
	public StudentInformationSystem (Students students){
		setSize(800, 400);
		createComponent();
		Container con = getContentPane();
		this.stu=students;
		model = new StudentsTableModel(stu);
		studentsTable = new JTable(model);
		BoxLayout bp=new BoxLayout(con,BoxLayout.Y_AXIS);
		

		
	
		JScrollPane jsp = new JScrollPane(studentsTable);
		jsp.setSize(800,300);

		JPanel panel=new JPanel();
		panel.setSize(800,100);
		panel.add(ID);
		panel.add(IDfield);
		panel.add(firstName);
		panel.add(firstNameField);
		panel.add(lastName);
		panel.add(lastNameField);
		panel.add(gender);
		panel.add(genderField);
		panel.add(add);
		
		con.setLayout(bp);
		
		 
		con.add(jsp);
		con.add(panel);
		
		

		
		setVisible(true);
	}
	
	private void createComponent() {
		font = new Font("TimesRoman", Font.PLAIN, 15);
		IDfield= new JTextField(5);
		IDfield.setFont(font);
		ID=new JLabel("ID:");
		ID.setFont(font);
		firstNameField= new JTextField(5);
		firstNameField.setFont(font);
		firstName=new JLabel("firstname:");
		firstName.setFont(font);
		lastNameField= new JTextField(5);
		lastNameField.setFont(font);
		lastName=new JLabel("lastname:");
		lastName.setFont(font);
		String[] a=new String[] {"true","false"};
		genderField= new JList<>(a);
		
		
		genderField.setFont(font);
		
		gender=new JLabel("gender:");
		gender.setFont(font);
		
		add=new JButton("add");
		
		operationListener oListener=new operationListener();
		add.addActionListener(oListener);
		
		
		
	}
	public static void main(String[] args) {
		Students s = new Students();
		s.addStudent(new Student(100, "Divya", "Sharma", true));
		s.addStudent(new Student(101, "Mihir", "Salunke", false));
		new StudentInformationSystem(s);
		

	}
}
class Students {
	private Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;

	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}

class Student {
	int roll;
	String first;
	String last;
	boolean gender = false;

	public Student(int roll, String first, String last, boolean gender) {
		this.roll = roll;
		this.first = first;
		this.last = last;
		this.gender = gender;
	}
}

class StudentsTableModel implements TableModel {

	private Students students;

	public StudentsTableModel(Students students) {
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ROLL";
		}
		if (columnIndex == 1) {
			return "First";
		}
		if (columnIndex == 2)
			return "Last";
		if (columnIndex == 3)
			return "Gender";
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 3) {
			return Boolean.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.roll + "";
				}
				if (columnIndex == 1) {
					return student.first;
				}
				if (columnIndex == 2) {
					return student.last;
				}
				if (columnIndex == 3) {
					return student.gender;
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
}
