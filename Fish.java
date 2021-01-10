import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Random;

public class Fish extends JLabel{
    private Random rd;
    private Timer t1;
    private int x,y,w=40;
    private boolean flag=true;
    public Fish(){
        this.setText(".");
        init();
    }
    private void init() {
        rd=new Random();
        x=rd.nextInt(500);
        y=rd.nextInt(500);
        this.setBounds(x,y,w,w);

        if(rd.nextInt(10)%2==0){
            flag=true;
        }else {
            flag=false;
        }
        t1=new Timer(rd.nextInt(500)+50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(flag) {
                    if(x-10>0){
                        Fish.this.setLocation(x-=10,y);
                    }else {
                        flag=!flag;
                    }
                }else {
                    if(x+10<570){
                        Fish.this.setLocation(x+=10,y);
                    }else {
                        flag=!flag;
                    }
                }
            }
        });
        t1.start();
    }
}
