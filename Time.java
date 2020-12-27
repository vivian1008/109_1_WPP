import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Time extends JFrame {
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JButton pause = new JButton("Pause");
    private JButton go = new JButton("Go");
    private JButton reset = new JButton("Reset");
    private JButton exit = new JButton("Exit");
    private Timer t1;
    private JLabel lab[] = new JLabel[8];
    private Container cp;
    private int hr=0;
    private int min=0;
    private int ss=0;

    public Time() {
        init();
    }
    private void init() {
        this.setTitle("碼表");
        this.setLayout(null);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(400, 150, 430, 300);
        for(int i=0;i<8;i++  ) {
            String s="" +i;
            lab[i]= new JLabel(s);
        }
        lab[0]= new JLabel(" 0");
        lab[1]= new JLabel("0");
        lab[2]= new JLabel(":");
        lab[3]= new JLabel("0");
        lab[4]= new JLabel("0");
        lab[5]= new JLabel(":");
        lab[6]= new JLabel("0");
        lab[7]= new JLabel("0");
        p1.add(lab[0]);
        p1.add(lab[1]);
        p1.add(lab[2]);
        p1.add(lab[3]);
        p1.add(lab[4]);
        p1.add(lab[5]);
        p1.add(lab[6]);
        p1.add(lab[7]);
        p1.setLayout(new GridLayout(1,8,5,5));
        cp.add(p1, BorderLayout.CENTER);
        cp.add(p2, BorderLayout.SOUTH);

        t1=new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ss++;
                if(ss==60) {
                    ss=0;
                    min++;
                    if(min==60){
                        min=0;
                        hr++;
                    }
                }
                lab[7].setText(Integer.toString(ss % 10));
                    lab[6].setText(Integer.toString(ss / 10));
                lab[4].setText(Integer.toString(min%10) );
                lab[3].setText(Integer.toString(min/10 ));
                lab[1].setText(Integer.toString(hr%10) );
                lab[0].setText(Integer.toString(hr/10 ));
            }
        });



        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });

            reset.setBounds(10, 170, 80, 25);
            p2.add(reset);
            reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    lab[7].setText(Integer.toString(ss=0 ));
                    lab[6].setText(Integer.toString(ss =0));
                    lab[4].setText(Integer.toString(min=0) );
                    lab[3].setText(Integer.toString(min=0 ));
                    lab[1].setText(Integer.toString(hr=0) );
                    lab[0].setText(Integer.toString(hr=0 ));
                }
            });
    
            pause.setBounds(120, 170, 80, 25);
            pause.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                t1.stop();
                }
            });
            p2.add(pause);
    
            go.setBounds(220, 170, 80, 25);
            go.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                t1.start();
                }
            });
            p2.add(go);



        exit.setBounds(320, 170, 80, 25);
        p2.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

    }
}