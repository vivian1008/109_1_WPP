import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;

public class MainFrame extends JFrame{
    private int x,y;
    private JButton jst = new JButton("Start");
    private JButton jet = new JButton("Exit");
    private JButton jan = new JButton("Again");
    private JButton jup = new JButton("Up");
    private JButton jdn = new JButton("Down");
    private JButton jlt = new JButton("Left");
    private JButton jrt = new JButton("Right");
    private JLabel jlb = new JLabel("@");
public MainFrame(){
    init();
}
private void init(){
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(450,400);

    jst.setBounds(10,300,70,25);
    jet.setBounds(90,300,70,25);
    jan.setBounds(170,300,70,25);
    jup.setBounds(330,310,70,25);
    jdn.setBounds(330,250,70,25);
    jlt.setBounds(370,280,70,25);
    jrt.setBounds(280,280,70,25);
    jlb.setBounds(x=200,y=150,50,50);

    this.add(jst);
    this.add(jet);
    this.add(jan);
    this.add(jup);
    this.add(jdn);
    this.add(jlt);
    this.add(jrt);
    this.add(jlb);

    this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

    jet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });

    jup.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(x,y = y-10);
        }
    });
    jdn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(x,y = y + 10);
        }
    });
    jlt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(x = x-10 ,y);
        }
    });
    jrt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(x = x+10 ,y);
        }
    });
}
}
