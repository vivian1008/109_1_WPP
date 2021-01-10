import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class MovingObject extends JFrame {
    private Container cp;
    private JButton add= new JButton("add");
    private JButton exit= new JButton("exit");
    private JPanel p1=new JPanel();
    private JPanel ground=new JPanel();

public MovingObject() {
    //super("MovingObject",true,true,true,true);
    init();
}
    private void init() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(10, 10, 600, 570);
        this.setBackground(new Color(20, 90, 100));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.add(ground,BorderLayout.CENTER);
        cp.add(p1,BorderLayout.NORTH);
        p1.add(add);
        p1.add(exit);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fish fish1=new Fish();
                ground.add(fish1);
                //sub sub=new sub();
                //Thread subT=new Thread(sub);
                //ground.add(sub);
                //subT.start();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
