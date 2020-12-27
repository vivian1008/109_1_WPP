import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;

public class StartFrame extends JFrame{
    private JButton jst = new JButton("Start");
    private JLabel jlb = new JLabel("Eat Dots !");

    public StartFrame(){
        init();
    }

    private void init(){
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(450,400);

    jst.setBounds(200,300,70,25);
    jlb.setBounds(200,50,200,100);
    this.add(jst);
    this.add(jlb);

    this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    });

    jst.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
                MainFrame mFrm = new MainFrame();
                mFrm.setVisible(true);
        }
    });
     }
}