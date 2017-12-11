import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


class IntroFrame extends JFrame implements ActionListener {
	JPanel panel;
	private int speed;
   public IntroFrame(String name){
	   super(name);
	   super.setSize(500, 200);
	   super.setResizable(false);
	   MyButton but1 = new MyButton("Начать игру");
	   but1.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent ae){
			   int cell_size = 20;
				Snake sn = new Snake(cell_size);
				Fruit fr = new Fruit(sn);
				Direction dir = new Direction();
				Game_Manager game_manager = new Game_Manager(fr, sn, dir, cell_size,speed);
				setvisible();
		   }
	   });
	   panel = new JPanel();
	   ButtonGroup group = new ButtonGroup();
	   JRadioButton easy = new JRadioButton("Easy",false);
	   easy.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent ae){
			   speed = 150;
		   }
	   });
	   JRadioButton medium = new JRadioButton("Medium",false);
	   medium.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent ae){
			   speed = 100;
		   }
	   });
	   JRadioButton hard = new JRadioButton("Hard",false);
	   hard.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent ae){
			   speed = 40;
		   }
	   });
	   group.add(easy);
	   group.add(medium);
	   group.add(hard);
	  super.setLayout(new FlowLayout());
	   add(but1);
	   panel.add(easy);
	   panel.add(medium);
	   panel.add(hard);
	   add(panel);
	   
   }
   public void setvisible(){
	   super.setVisible(false);
   }

public void actionPerformed(ActionEvent ae) {
	
}
}
class MyButton extends JButton{
	public MyButton(String name){
		super(name);
	}
}
