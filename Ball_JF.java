
import javax.swing.JFrame;
public class Ball_JF extends JFrame {
	public Ball_JF(){
		this.setTitle("Logic");       
		this.setBounds(100,100,800,600);        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		Ball_JP jp=new Ball_JP();
		jp.run_run();       
		this.add(jp);       
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		new Ball_JF();

	}

}