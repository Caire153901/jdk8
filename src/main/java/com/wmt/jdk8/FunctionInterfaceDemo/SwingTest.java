package com.wmt.jdk8.FunctionInterfaceDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame =new JFrame("My JFrame");
        JButton jButton=new JButton("My Button");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed!");
            }
        });
        //该写法与上面相同，执行时先执行下面这个写法的内容
        //其中event的类型就是事件类型，此处为ActionEvent
        jButton.addActionListener(event -> System.out.println("Button Click"));
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
