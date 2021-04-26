package site.pwjworks.corejava.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class talkingClock {
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is" + Instant.ofEpochMilli(e.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
}
