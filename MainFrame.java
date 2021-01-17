import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.Random;

public class MainFrame extends JFrame{
    private Random rd;
    private boolean flag=true;
    private int x,y,u,v;
    private int min,scd,msd = 0;
    private Timer tm,tm2;
    private JButton jgo = new JButton("Go!");
    private JButton jet = new JButton("Exit");
    private JButton jan = new JButton("Again");
    private JButton jup = new JButton("U");
    private JButton jdn = new JButton("D");
    private JButton jlt = new JButton("L");
    private JButton jrt = new JButton("R");
    private JLabel jlb = new JLabel("-_-");
    private JLabel jdt = new JLabel(".");
    private JLabel tim[] = new JLabel[5];
public MainFrame(){
    init();
}
private void init(){
    rd=new Random();
    x=rd.nextInt(500);
    y=rd.nextInt(500);
    this.setLayout(null);
    this.setLocation(100,50);
    this.setSize(x = 500,y = 400);
   

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
    jlb.setBounds(u = 250,v = 150,50,50);
    jdt.setBounds(x = 300, y = 200,50,50);
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
    this.add(jdt);

    if(rd.nextInt(10)%2==0){
        flag=true;
    }else {
        flag=false;
    }


    tm = new Timer(100, new ActionListener() {
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
               over();
               tm.stop();
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
           tm2 = new Timer(rd.nextInt(500), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(flag) {
                    if(x-10>0){
                        jdt.setLocation(x-=10,y);
                    }else if(y-10>0){
                        jdt.setLocation(x,y-=20);
                    }else {
                        flag=!flag;
                    }
                }else {
                    if(x+10<400){
                        jdt.setLocation(x+=10,y);
                    }else if(y+10<500){
                        jdt.setLocation(x,y+=20);
                    }else {
                        flag=!flag;
                    }
                }
            }
        });
        tm2.start();
        if(u == x && v == y){
            win();
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
                jlb.setLocation(u=250,v=150);
                jdt.setLocation(300,200);
            }
        });


    jup.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(u,v = v-10);
            if(u == x && v == y){
                win();
            }
        }
    });

    jdn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(u,v = v + 10);
            if(u == x && v == y){
                win();
            }
        }
    });

    jlt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(u = u-10 ,v);
            if(u == x && v == y){
                win();
            }
        }
    });

    jrt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            jlb.setLocation(u = u+10 ,v);
            if(u == x && v == y){
                win();
            }
        }
    });
      
}
public void over(){
        JOptionPane.showMessageDialog(this,"Time Over!");
}
public void win(){
    tm.stop();
    JOptionPane.showMessageDialog(this,"You Win!");
    MainFrame.this.dispose();
    MainFrame mFrm = new MainFrame();
    mFrm.setVisible(true);
}
}
