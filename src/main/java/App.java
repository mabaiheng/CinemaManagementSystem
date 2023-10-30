
import UI.Login.UserLogin;
import UI.identitySelection.IdentitySelection;
import UI.work.AdministratorWork;
import UI.work.MangerWork;
import UI.work.ReceptionWork;
import UI.work.UserWork;

import java.util.Date;

public class App {
    //项目注意：1.在注册用户账号后，要输入用户信息，这时候若强行停止程序，程序会存入一个只有用户账号和密码的数据，这样是不合理的，请勿这样操作
    //2.在数据excel中第一行会出现数据全为零的情况，只是用来保护数据的，请不要恶意删除,查找时也请不要输入0，干扰程序正常运行
    //3.所有的非界面弹窗的右上角的关闭按钮都是无用的，请按照弹窗中的按钮操作
    //4.经理和前台的账户密码只会为admin，ynuinfo#777,不更改，而管理员初始密码为ynuinfo#777，但可以更改

    public static void main(String[] args) {
        //进入身份选择界面，同时为程序的入口
        new IdentitySelection();

    }
}
