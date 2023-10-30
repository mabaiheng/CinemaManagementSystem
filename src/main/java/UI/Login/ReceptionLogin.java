package UI.Login;

import UI.identitySelection.IdentitySelection;
import UI.jDialog.LoginJDialog;
import UI.work.ReceptionWork;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReceptionLogin extends Login{

    //重写界面标题
    @Override
    public void setTitlejLable() {
        titleJLabel = new JLabel("前台登录");
    }
    ////重写按钮事件
    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if(source == loginJButton){
            //获取用户的输入数据
            admin = adminJTextField.getText();
            password = passwordJTextField.getText();
            String adminA = "admin";
            String passwordA = "ynuinfo#777";

            if (admin.equals(adminA)&&password.equals(passwordA)) {

                new ReceptionWork();
                ReceptionLogin.this.dispose();

            }else{
                //验证失败，跳出提示窗口
                new LoginJDialog(0);
            }
        }else if(source == quitJButton){
            dispose();
            new IdentitySelection();
        }
    }
}
