package UI.work;

import UI.IntiJFrame;
import UI.data.UserDataUI;
import UI.identitySelection.IdentitySelection;
import UI.jDialog.ChangeJDialog;
import UI.jDialog.FindJDialog;
import data.packagingData.AdminData;
import data.readAndWriteFun.AdminReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdministratorWork extends IntiJFrame implements ActionListener {
    JButton administratorPasswordChange = new JButton("修改管理员密码");
    JButton userPasswordChange = new JButton("修改用户密码");
    JButton userManage = new JButton("用户管理");

    public AdministratorWork() {
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);
        setJbt();
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IdentitySelection();
            }
        });
    }

    private void setJbt() {
        administratorPasswordChange.setBounds(200,150,400,50);
        userPasswordChange.setBounds(200,250,400,50);
        userManage.setBounds(200,350,400,50);
        administratorPasswordChange.setFont(new Font("楷体",Font.PLAIN,24));
        userPasswordChange.setFont(new Font("楷体",Font.PLAIN,24));
        userManage.setFont(new Font("楷体",Font.PLAIN,24));
        administratorPasswordChange.addActionListener(this);
        userPasswordChange.addActionListener(this);
        userManage.addActionListener(this);
        this.getContentPane().add(administratorPasswordChange);
        this.getContentPane().add(userPasswordChange);
        this.getContentPane().add(userManage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source == administratorPasswordChange){
             Vector<AdminData> temp = new AdminReadAndWrite().adminRead();
             new ChangeJDialog(temp);
         }else if (source == userManage){
             new UserDataUI();
             AdministratorWork.this.dispose();
         } else if (source == userPasswordChange) {
            Vector<AdminData> temp = new AdminReadAndWrite().read();
            new FindJDialog(temp);
         }
    }
}
