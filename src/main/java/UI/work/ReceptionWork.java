package UI.work;

import UI.IntiJFrame;
import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import UI.identitySelection.IdentitySelection;
import UI.jDialog.FindJDialog;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserBuyHistory;
import data.readAndWriteFun.HistoryReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ReceptionWork extends IntiJFrame implements ActionListener {

    JButton movieDataJbt = new JButton("当前上映的电影信息");
    JButton movieLayoutJbt = new JButton("当前上映的电影排场信息");
    JButton buyJbt = new JButton("购买电影票");
    public ReceptionWork() {
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);
        //设置按钮位置，大小，事件
        setJbt();

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
        movieLayoutJbt.setBounds(200,150,400,50);
        movieDataJbt.setBounds(200,250,400,50);
        buyJbt.setBounds(200,350,400,50);
        movieDataJbt.setFont(new Font("楷体",Font.PLAIN,24));
        buyJbt.setFont(new Font("楷体",Font.PLAIN,24));
        movieLayoutJbt.setFont(new Font("楷体",Font.PLAIN,24));
        movieLayoutJbt.addActionListener(this);
        movieDataJbt.addActionListener(this);
        buyJbt.addActionListener(this);
        this.getContentPane().add(movieDataJbt);
        this.getContentPane().add(movieLayoutJbt);
        this.getContentPane().add(buyJbt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == movieDataJbt){
            new MovieDataUI(1);
        } else if (source == movieLayoutJbt) {
            ReceptionWork.this.dispose();
            Vector<MovieLayoutData> tempVector = new MovieLayoutReadAndWrite().read();
            String tempStr = "0";
            new MovieLayoutDataUI(tempVector,tempStr);
        } else if (source == buyJbt) {
            Vector<UserBuyHistory> tempVector = new HistoryReadAndWrite().read();
            new FindJDialog(tempVector,1);

        }
    }
}
