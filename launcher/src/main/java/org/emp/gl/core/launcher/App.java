package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.ButtonViewer;
import org.emp.gl.gui.WatchViewer;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {

    static {
        Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WatchViewer w1 = new WatchViewer();
                w1.setVisible(true);
                Lookup.getInstance().register(WatchViewer.class,w1);
                w1.setLocation(200, 100);
                WatchViewer w2 = new WatchViewer();
                w2.setVisible(true);
                w2.setLocation(600, 100);
                ButtonViewer buttonViewer=new ButtonViewer();
                buttonViewer.setVisible(true);
                buttonViewer.getjButton1().addActionListener(e -> {
                    WatchViewer watchViewer=Lookup.getInstance().getService(WatchViewer.class);
                    if(!watchViewer.getIsSec()){
                        JLabel ss = new JLabel();
                        JLabel sep1 = new JLabel();
                        ss.setVisible(true);
                        sep1.setVisible(true);
                        ss.setFont(new java.awt.Font("Consolas", 1, 48));
                        sep1.setFont(new java.awt.Font("Consolas", 1, 48));
                        watchViewer.setSs(ss);
                        watchViewer.setSep1(sep1);
                        watchViewer.getContentPane().add(sep1);
                        watchViewer.getContentPane().add(ss);
                        watchViewer.setIsSec(true);
                        watchViewer.setSize(300, 100);
                    }

                });
            }
        });
    }

}
