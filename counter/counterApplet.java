package counter;

import java.applet.*;
import  java.awt.event.*;
import javax.swing.*;

public class counterApplet extends Applet{
    private Counter counter = new Counter();
    private JTextField display = new JTextField(4);
    public void init() {
        add(new JLabel("value:"));
        add(display);
        display.setText(Integer.toString(counter.value()));
        JButton button = new JButton("something");
        add(button);

        button.addActionListener(new MyActionListener());
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            //System.out.print("click");
            counter.increment();

        }
   }
    static class Counter {
        private int value;

        public void increment() {
            value++;
        }
        JMenuBar menuBar = new JMenuBar()

        public int value() {
            return value;
        }

    } }
