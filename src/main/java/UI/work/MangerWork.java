package UI.work;

import UI.IntiJFrame;
import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import UI.identitySelection.IdentitySelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MangerWork extends IntiJFrame implements ActionListener {
    JButton jButton1 = new JButton("影片管理");
    JButton jButton2 = new JButton("排片管理");
    public MangerWork() {
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);
        //设置按钮
        setJbt();
        //设置返回菜单
        setReturnJMenuItemEvent();
    }

    private void setReturnJMenuItemEvent() {
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IdentitySelection();
            }
        });
    }

    private void setJbt() {
        jButton1.setBounds(250,100,400,50);
        jButton2.setBounds(250,250,400,50);
        jButton1.setFont(new Font("楷体",Font.PLAIN,24));
        jButton2.setFont(new Font("楷体",Font.PLAIN,24));
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source == jButton1){
             MangerWork.this.dispose();
             new MovieDataUI();
         }else if(source == jButton2){
             MangerWork.this.dispose();
             new MovieLayoutDataUI();
         }
    }
}
