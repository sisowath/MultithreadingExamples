package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Clock {       
    
    public static void main(String args[]) {               
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Clock");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            
            JPanel panel = new JPanel();
            
            JLabel label = new JLabel("",SwingConstants.CENTER);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");// source de : http://javatechniques.com/blog/dateformat-and-simpledateformat-examples/
            Date date = new Date();
            String s = sdf.format(date);
            label.setText("Time : " + s);
            label.setOpaque(true);
            label.setFont(new Font("ARIAL", Font.BOLD, 24));
            label.setForeground(Color.ORANGE);
            label.setBackground(Color.WHITE);
            
            frame.add(label, BorderLayout.NORTH);
            frame.revalidate();
            frame.repaint();
            
            new Thread(() -> {
                while(true) {
                    try {
                        label.setText("Time : " + sdf.format(new Date()));
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
            
            JButton button = new JButton("Click Me !");
            /*
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            source de : http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
            */
            button.setFont(new Font("ARIAL", Font.BOLD, 20));
            button.setForeground(Color.RED);
            button.addActionListener((ActionEvent e) -> {
                if(e.getSource() instanceof JButton) {
                    JButton btn = (JButton)e.getSource();
                    if(btn.getText().equals("Click Me !")) {
                        btn.setText("0");
                    } else {
                        btn.setText((Integer.parseInt(btn.getText()) + 1) + "");
                    }
                }
            });
            
            frame.add(button, BorderLayout.CENTER);            
        });
    }
}