import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class MainFrame extends JFrame{
    private int x,y;
    private int min,scd,msd = 0;
    private Timer tm;
    private JButton jgo = new JButton("Go!");
    private JButton jet = new JButton("Exit");
    private JButton jan = new JButton("Again");
    private JButton jup = new JButton("U");
    private JButton jdn = new JButton("D");
    private JButton jlt = new JButton("L");
    private JButton jrt = new JButton("R");
    private JLabel jlb = new JLabel("-_-");
    private JLabel tim[] = new JLabel[5];
public MainFrame(){
    init();
}
private void init(){
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(500,400);

    for(int i = 0; i < 5; i++) {
        String s = "" + i;
        tim[i]= new JLabel(s);
     }
     tim[0]= new JLabel("0");
     tim[1]= new JLabel(":");
     tim[2]= new JLabel("0");
     tim[3]= new JLabel("0");
     tim[4]= new JLabel("0");

    jgo.setBounds(0,335,70,25);
    jet.setBounds(75,335,70,25);
    jan.setBounds(150,335,70,25);
    jup.setBounds(375,325,50,25);
    jdn.setBounds(375,275,50,25);
    jlt.setBounds(425,300,50,25);
    jrt.setBounds(325,300,50,25);
    jlb.setBounds(x=250,y=150,50,50);
    tim[0].setBounds(50,20,10,10);
    tim[1].setBounds(70,20,10,10);
    tim[2].setBounds(90,20,10,10);
    tim[3].setBounds(110,20,10,10);
    tim[4].setBounds(130,20,10,10);

    this.add(jgo);
    this.add(jet);
    this.add(jan);
    this.add(jup);
    this.add(jdn);
    this.add(jlt);
    this.add(jrt);
    this.add(jlb);
    this.add(tim[0]);
    this.add(tim[1]);
    this.add(tim[2]);
    this.add(tim[3]);
    //this.add(tim[4]);

    tm = new Timer(150, new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           msd++;
           if(msd == 10) {
               msd = 0;
               scd++;
           }
           if(scd == 60){
               msd = 0;
               scd = 0;
               min++;
           }
           tim[4].setText(Integer.toString(msd));
           tim[3].setText(Integer.toString(scd % 10));
           tim[2].setText(Integer.toString(scd / 10));
           tim[0].setText(Integer.toString(min));
       }
   });

    this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

    jgo.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
           tm.start();
           if(msd == 0 && scd == 0 && min == 1){
            over();
           }
           }
       });

    jet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });

    jan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tim[4].setText(Integer.toString(msd = 0));
                tim[3].setText(Integer.toString(scd = 0));
                tim[2].setText(Integer.toString(scd = 0));
                tim[0].setText(Integer.toString(min = 0));
                tm.stop();
                jlb.setLocation(x=250,y=150);
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
public void over(){
        JOptionPane.showMessageDialog(this,"Time Over!");
        tm.stop();
}
}