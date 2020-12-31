import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;

public class StartFrame extends JFrame{
    private JButton jst = new JButton("Start");
    private JLabel jlb = new JLabel("Eat Dots !",JLabel.CENTER);
    private JLabel mtd = new JLabel("the play method is control the Determined face to touch the dot in 1 minutes!",JLabel.CENTER);

    public StartFrame(){
        init();
    }

    private void init(){
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(450,400);

    jst.setBounds(180,300,70,25);
    jlb.setBounds(115,50,200,100);
    mtd.setBounds(0,150,450,50);
    this.add(jst);
    this.add(jlb);
    this.add(mtd);

    this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    });

    jst.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
                MainFrame mFrm = new MainFrame();
                mFrm.setVisible(true);
                StartFrame.this.dispose();
        }
    });
     }
}