/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineexaminationsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author jayde
 */
public class tc {
    JFrame window;
    JLabel counterLabel;
    Timer timer;
    int sec;
    int min;
    String ddsec,ddmin;
    
    DecimalFormat dFormat = new DecimalFormat("00");
    
    public static void main(String [] args){
        new tc();    
    }
    
    public tc(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setDefaultCloseOperation(300,230,200,100);
        window.setLayout(null);
        
        counterLabel = new JLabel("") ;
        counterLabel.setBounds(300,230,200,100);
        
        window.add(counterLabel);
        window.setVisible(true); 
        
        counterLabel.setText("01:00");
        sec = 0;
        min = 1;
        reverse();
        timer.start();
        
    }
    
    public void reverse(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec--;
                ddsec = dFormat.format(sec);
                ddmin = dFormat.format(min);
                counterLabel.setText(ddmin+":"+ddsec);
                
                if(sec == -1)
                {
                    sec = 59;
                    min--;
                    ddsec = dFormat.format(sec);
                    ddmin = dFormat.format(min);
                }
                if(min == 0 && sec ==0)
                {
                    timer.stop();
                }
                        
        
            }
            
            
        });
    }
    
}
