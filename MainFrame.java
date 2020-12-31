import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class MainFrame extends JFrame{
    private int x,y;
    private int min,scd = 0;
    private Timer tm;
    private JButton jgo = new JButton("Go!");
    private JButton jet = new JButton("Exit");
    private JButton jan = new JButton("Again");
    private JButton jup = new JButton("Up");
    private JButton jdn = new JButton("Down");
    private JButton jlt = new JButton("Left");
    private JButton jrt = new JButton("Right");
    private JLabel jlb = new JLabel("-_-",JLabel.CENTER);
    private Container cp;
    private JPanel jpl = new JPanel();
    private JPanel jpl3 = new JPanel();
    private JLabel tim[] = new JLabel[4];
public MainFrame(){
    init();
}
private void init(){
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(500,400);
    cp=this.getContentPane();
    cp.setLayout(new BorderLayout());

    for(int i = 0; i < 4; i++) {
        String s = "" + i;
        tim[i]= new JLabel(s);
     }
     tim[0]= new JLabel("0");
     tim[1]= new JLabel(":");
     tim[2]= new JLabel("0");
     tim[3]= new JLabel("0");

    jgo.setSize(70,25);
    jet.setSize(70,25);
    jan.setSize(70,25);
    jup.setSize(50,25);
    jdn.setSize(50,25);
    jlt.setSize(50,25);
    jrt.setSize(50,25);
    jlb.setBounds(x=20,y=20,50,50);

    jpl3.add(jgo);
    jpl3.add(jet);
    jpl3.add(jan);
    jpl3.add(jup);
    jpl3.add(jdn);
    jpl3.add(jlt);
    jpl3.add(jrt);
    this.add(jlb);
    jpl.add(tim[0]);
    jpl.add(tim[1]);
    jpl.add(tim[2]);
    jpl.add(tim[3]);
        
    cp.add(jpl, BorderLayout.NORTH);
    cp.add(jpl3, BorderLayout.SOUTH);
    jpl.setLayout(new GridLayout(1,4,2,2));
    jpl3.setLayout(new GridLayout(1,7,1,1));

    

    tm = new Timer(200, new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           scd++;
           if(scd==60) {
               scd=0;
               min++;
           }
           tim[3].setText(Integer.toString(scd % 10));
           tim[2].setText(Integer.toString(scd / 10));
           tim[0].setText(Integer.toString(min % 10) );
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