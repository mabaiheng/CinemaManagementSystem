package UI.work;

import UI.IntiJFrame;
import UI.data.HistoryDataUI;
import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import UI.identitySelection.IdentitySelection;
import UI.jDialog.ChangeJDialog;
import UI.jDialog.FindJDialog;
import data.packagingData.AdminData;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserBuyHistory;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.HistoryReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserWork extends IntiJFrame implements ActionListener {
    String admin;
    Vector<AdminData> adminVector = new AdminReadAndWrite().read();
    JButton changeJbt = new JButton("修改密码");
    JButton findJbt = new JButton("查看电影");
    JButton getJbt = new JButton("取出电影票");
    JButton historyJbt = new JButton("查看购买历史");
    JButton movieJbt = new JButton("查看电影信息");
    public UserWork(String admin) {
        this.admin = admin;
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);
        //初始化按钮位置，大小，事件
        setJbt();
        //设置返回菜单
        intiReturnJMenuItem();
    }

    private void intiReturnJMenuItem() {
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IdentitySelection();
            }
        });
    }

    private void setJbt() {
        changeJbt.setBounds(200,400,400,50);
        findJbt.setBounds(200,160,400,50);
        getJbt.setBounds(200,240,400,50);
        historyJbt.setBounds(200,320,400,50);
        movieJbt.setBounds(200,80,400,60);
        changeJbt.setFont(new Font("楷体",Font.PLAIN,24));
        findJbt.setFont(new Font("楷体",Font.PLAIN,24));
        getJbt.setFont(new Font("楷体",Font.PLAIN,24));
        historyJbt.setFont(new Font("楷体",Font.PLAIN,24));
        movieJbt.setFont(new Font("楷体",Font.PLAIN,24));
        this.getContentPane().add(movieJbt);
        this.getContentPane().add(changeJbt);
        this.getContentPane().add(findJbt);
        this.getContentPane().add(getJbt);
        this.getContentPane().add(historyJbt);
        findJbt.addActionListener(this);
        changeJbt.addActionListener(this);
        getJbt.addActionListener(this);
        historyJbt.addActionListener(this);
        movieJbt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == changeJbt){
            new ChangeJDialog(admin,adminVector);
        } else if (source == findJbt) {
            dispose();
            Vector<MovieLayoutData> tempVector = new MovieLayoutReadAndWrite().read();
            new MovieLayoutDataUI(tempVector,admin);
        } else if (source == getJbt) {
            Vector<UserBuyHistory> userBuyHistories = new HistoryReadAndWrite().read();
            new FindJDialog(userBuyHistories);
        } else if (source == historyJbt) {
            Vector<UserBuyHistory> userBuyHistories = new HistoryReadAndWrite().read();
            Vector<UserBuyHistory> vectors = new Vector<>();
            //获取匹配admin的数据
            for (int i = 0; i < userBuyHistories.size(); i++) {
               if(admin.equals(userBuyHistories.elementAt(i).getUserName())){
                   vectors.add(userBuyHistories.elementAt(i));
               }
            }
             new HistoryDataUI(vectors);

        } else if (source == movieJbt) {
             new MovieDataUI(1);
        }
    }
}
