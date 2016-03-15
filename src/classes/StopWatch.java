package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StopWatch {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("ARIAL", Font.BOLD, 20));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setForeground(Color.ORANGE);
        
        frame.add(label, BorderLayout.NORTH);
        
        frame.revalidate();
        frame.repaint();
        
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 120;//interval signifie le nombre de secondes
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int minute = interval/60;                
                label.setText(minute + " : " + (interval-(60*minute)));
                --interval;
                if(interval == 1)
                    timer.cancel();
            }
        }, delay, period);
    }
}
/*
    inspirée de : http://stackoverflow.com/questions/14393423/how-to-make-a-countdown-timer-in-java
*/