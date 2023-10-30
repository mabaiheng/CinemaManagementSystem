package UI.Login;

import UI.jDialog.AddJDialog;
import UI.jDialog.LoginJDialog;
import UI.work.UserWork;
import data.packagingData.AdminData;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class UserLogin extends Login {
    private Vector<AdminData> adminDataVector = new AdminReadAndWrite().read();
    private Vector<UserData> userDataVector = new  UserReadAndWrite().read();
    int count = 0;
    JButton resettingJButton = new JButton("重置");

    public UserLogin() {
        addResettingJButton();
    }

    //添加重置密码按钮
    private void addResettingJButton() {
        resettingJButton.setFont(new Font("楷体",Font.PLAIN,20));
        springLayout.putConstraint(SpringLayout.NORTH,resettingJButton,0,SpringLayout.NORTH,loginJButton);
        springLayout.putConstraint(SpringLayout.WEST,resettingJButton,20,SpringLayout.EAST,loginJButton);
        resettingJButton.addActionListener(this);
        centerJPanel.add(resettingJButton);
    }

    //重写界面标题
    @Override
    public void setTitlejLable() {
        titleJLabel = new JLabel("用户登录",SwingConstants.CENTER);
    }

    //重写退出按钮，改为注册按钮
    @Override
    public void setQuitJButton() {quitJButton = new JButton("注册");}

    ////重写按钮事件
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

            if (source == loginJButton) {

                count++;
                if(count < 5){
                admin = adminJTextField.getText();
                password = passwordJTextField.getText();
                if (excelData.compareRead(admin, password)) {
                   //匹配成功
                    UserLogin.this.dispose();
                    new UserWork(admin);
                } else {
                    new LoginJDialog(0);
                }
                }else {
                    //5次错误输入
                    new LoginJDialog(6);
                }
            } else if (source == quitJButton) {
                //注册账户
                new AddJDialog(adminDataVector);
            } else if (source == resettingJButton) {
                admin = adminJTextField.getText();
                if(admin.isEmpty()){
                    new LoginJDialog(4);
                }else {
                    //修改密码
                    Boolean bl = true;
                    Vector<AdminData> adminData = new AdminReadAndWrite().read();
                    for (int i = 0; i < adminData.size(); i++) {
                        if (admin.equals(adminData.elementAt(i).getName())) {
                            new LoginJDialog(admin, i);
                            bl = false;
                        }
                    }
                    if(bl){new LoginJDialog(4);}
                }
            }
    }
}
