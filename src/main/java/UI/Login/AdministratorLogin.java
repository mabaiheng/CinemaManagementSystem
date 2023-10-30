package UI.Login;

import UI.identitySelection.IdentitySelection;
import UI.jDialog.LoginJDialog;
import UI.work.AdministratorWork;
import data.packagingData.AdminData;
import data.readAndWriteFun.AdminReadAndWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdministratorLogin extends Login implements ActionListener {

    //重写界面标题
    @Override
    public void setTitlejLable() {
        titleJLabel = new JLabel("管理员登录",SwingConstants.CENTER);
    }

    //重写是按钮事件
    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == loginJButton){
            //获取用户的输入数据
            admin = adminJTextField.getText();
            password = passwordJTextField.getText();
            Vector<AdminData> tempvector = new AdminReadAndWrite().adminRead();

            if (admin.equals(tempvector.elementAt(0).getName())&&
                    password.equals(tempvector.elementAt(0).getPassword())) {

                new AdministratorWork();
                AdministratorLogin.this.dispose();

            }
            else{
                //验证失败，跳出提示窗口
                new LoginJDialog(0);

            }
        }
        else if(source == quitJButton){
            dispose();
            new IdentitySelection();
        }
    }
}
