package Assignment8;


	import java.awt.BorderLayout;
import java.awt.Container;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

	enum Operation {
		ADD, SUBTRACT, MULTIPLY, DIVIDE,NUMBER,EQUALS
	}

	public class Calculator extends JFrame {

		private JTextField resultTextField;
		private JButton add, subtract, multiply, divide, compute,reset;

		private JButton numbers[];
		private Font font;
		private boolean isfirst=false;
		private boolean issecond=false;
		private boolean[] computer=new boolean[4];
		private boolean isprecompute=false;
		private boolean iscompute=false;
		private float result = 0;

		private static float first = 0;

		private static float second = 0;
		String current;

		Operation o = Operation.ADD;

		class OperationListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(JButton a:numbers) {
				if(e.getSource()==a) {
					o=Operation.NUMBER;
					JButton cur=(JButton)e.getSource();
					current=cur.getText();
				
				if(isprecompute&&!iscompute) {
					resultTextField.setText(current);
					isprecompute=false;
					isfirst=true;
					first=0;
					  first=first*10+Integer.valueOf(current);
				}
				else {
				
				if(iscompute) {
					issecond=true;
					second=second*10+Integer.valueOf(current);
				}
				else {
				  isfirst=true;
				  first=first*10+Integer.valueOf(current);
				}
				resultTextField.setText(resultTextField.getText()+current);
				
				}
				current="";
				
				break;
				
				}
				}
				if (e.getSource() == add) {
					o = Operation.ADD;
					if(issecond==true) {
						compute();
						resultTextField.setText(resultTextField.getText()+"+");
					}
					else if(!issecond&&iscompute) {
						resultTextField.setText("Syn error");
						isprecompute=true;
						reset();
					}
					else {
					computer[0]=true;
					resultTextField.setText(resultTextField.getText()+"+");
					iscompute=true;
					}
				}
				if (e.getSource() == subtract) {
					o = Operation.SUBTRACT;
					if(issecond==true) {
						compute();
						resultTextField.setText(resultTextField.getText()+"-");
					}
					else if(!issecond&&iscompute) {
						resultTextField.setText("Syn error");
						isprecompute=true;
						reset();
					}
					else {
					computer[1]=true;
					resultTextField.setText(resultTextField.getText()+"-");
					iscompute=true;
					}
				}
				if (e.getSource() == multiply) {
					o = Operation.MULTIPLY;
					if(issecond==true) {
						compute();
						resultTextField.setText(resultTextField.getText()+"*");
					}
					else if(!issecond&&iscompute) {
						resultTextField.setText("Syn error");
						isprecompute=true;
						reset();
					}
					else {
					computer[3]=true;
					resultTextField.setText(resultTextField.getText()+"*");
					iscompute=true;
					}
				}
				if (e.getSource() == divide) {
					o = Operation.DIVIDE;
					if(issecond==true) {
						compute();
						resultTextField.setText(resultTextField.getText()+"/");
					}
					else if(!issecond&&iscompute) {
						resultTextField.setText("Syn error");
						isprecompute=true;
						reset();
					}
					else {
					computer[2]=true;
					resultTextField.setText(resultTextField.getText()+"/");
					iscompute=true;
					}
					
				}
				if(e.getSource()==compute) {
					if(issecond) {
						if(computer[0]) {
							result=first+second;
							computer[0]=false;
						}
						if(computer[1]) {
							result=first-second;
							computer[1]=false;
						}
						if(computer[2]) {
							result=first/second;
							computer[2]=false;
						}
						if(computer[3]) {
							result=first*second;
							computer[3]=false;
						}
						resultTextField.setText(result + "");
						first=result;
						second=0;
						isprecompute=true;
					isfirst=false;
					issecond=false;
					iscompute=false;}
					else {
						resultTextField.setText("Syn error");
						isprecompute=true;
						reset();
					}
				}
				if(e.getSource()==reset) {
					reset();
					resultTextField.setText("");
					isprecompute=false;
				}

			}

		}

		
		public Calculator() {
			createComponents();
			setLayout();
			addComponents();
			addBehaviors();
			display();
		}
		public void compute() {
			float res=0;
			if(computer[0]) {
				res= first+second;
				computer[0]=false;
			}
			if(computer[1]) {
				res= first-second;
				computer[1]=false;
			}
			if(computer[2]) {
				res= first/second;
				computer[2]=false;
			}
			if(computer[3]) {
			res=first*second;
			computer[3]=false;
			}
			first=res;
			issecond=false;
			iscompute=true;
			
		}
		
		public void reset() {
			isfirst=false;
			issecond=false;
			for(boolean a:computer)
				a=false;
			first=0;
			second=0;
			iscompute=false;
			
			
		}

		private void addBehaviors() {
			//ComputeListener cl = new ComputeListener();
			//compute.addActionListener(cl);

			OperationListener ol = new OperationListener();
			for(JButton a:numbers) {
				a.addActionListener(ol);
			}
			add.addActionListener(ol);
			subtract.addActionListener(ol);
			multiply.addActionListener(ol);
			divide.addActionListener(ol);
			compute.addActionListener(ol);
			reset.addActionListener(ol);

		}

		private void display() {
			setSize(600, 600);
			setVisible(true);

		}

		private void addComponents() {
			Container c = getContentPane();
			c.add(resultTextField);

			JPanel whole=new JPanel(new GridLayout(1, 2,10,0));
			JPanel panel = new JPanel(new GridLayout(3, 2));
			panel.add(add);
			panel.add(subtract);
			panel.add(multiply);
			panel.add(divide);
			
			panel.add(compute);
			panel.add(reset);
			
			JPanel p = new JPanel(new GridLayout(4, 3));
			

			
			p.add(numbers[1]);
			p.add(numbers[2]);
			p.add(numbers[3]);
		
			p.add(numbers[4]);
			p.add(numbers[5]);
			p.add(numbers[6]);
		
			p.add(numbers[7]);
			p.add(numbers[8]);
			p.add(numbers[9]);
		
			p.add(numbers[0],BorderLayout.CENTER);

			whole.add(p);
			whole.add(panel);
			c.add(whole);

		}

		private void setLayout() {
			GridLayout gl = new GridLayout(2, 1,20,20);
			Container c = this.getContentPane();
			c.setLayout(gl);

		}

		private void createComponents() {
			font = new Font("TimesRoman", Font.PLAIN, 36);
			resultTextField = new JTextField(10);
			resultTextField.setFont(font);

			add = new JButton("+");
			add.setFont(font);
			subtract = new JButton("-");
			subtract.setFont(font);
			multiply = new JButton("x");
			multiply.setFont(font);
			divide = new JButton("%");
			divide.setFont(font);
			compute = new JButton("=");
			compute.setFont(font);
			reset=new JButton("AC");
			reset.setFont(font);
			

			numbers = new JButton[10];
			for (int i = 0; i < 10; i++) {
				numbers[i] = new JButton(i + "");
				numbers[i].setFont(font);
			}

		}

		public static void main(String[] args) {
			Calculator c = new Calculator();

		}

	}

