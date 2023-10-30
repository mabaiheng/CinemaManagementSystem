package UI.data;

import UI.IntiJFrame;
import UI.jDialog.DeleteJDialog;
import UI.jDialog.FindJDialog;
import UI.work.AdministratorWork;
import data.packagingData.MovieInformation;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserDataUI extends AdminDataUI implements ActionListener {
    //   用户 ID、用户名、用户级别（金牌用户、银牌用户、铜牌用户）、
    //    用户注册时间、用户累计消费总金额、用户累计消费次数、用户手机号、用户邮箱；
    JMenuItem findItem = new JMenuItem("查找");
    JMenuItem deleteItem = new JMenuItem("删除");
    private Vector<UserData> userVector = new Vector<>();

//初始界面
    public UserDataUI() {
        IntiMenu();
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdministratorWork();
            }
        });
    }
    //更新数据后的界面
    public UserDataUI(Vector<UserData> tempVector){
        IntiVectorsAgain(tempVector);
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdministratorWork();
            }
        });
    }
    @Override
    public void setColumns() {
        columns.add("用户ID");
        columns.add("用户名");
        columns.add("用户级别");
        columns.add("用户注册时间");
        columns.add("用户累计消费总金额");
        columns.add("用户累计消费次数");
        columns.add("用户手机号");
        columns.add("用户邮箱");
    }
    public void IntiVectorsAgain(Vector<UserData> tempVector){

        vectors.removeAllElements();
        for (int i = 0 ; i  < tempVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(tempVector.elementAt(i).getUserID());
            vector1.add(tempVector.elementAt(i).getUserName());
            vector1.add(tempVector.elementAt(i).getUserLevel());
            vector1.add(tempVector.elementAt(i).getUserDate());
            vector1.add(tempVector.elementAt(i).getUserPayAll());
            vector1.add(tempVector.elementAt(i).getUserTimes());
            vector1.add(tempVector.elementAt(i).getUserPhoneNumber());
            vector1.add(tempVector.elementAt(i).getUserMail());
            vectors.add(vector1);
        }
    }

    @Override
    public void IntiVectors() {
        userVector = new UserReadAndWrite().read();
        for (int i = 0 ; i  < userVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(userVector.elementAt(i).getUserID());
            vector1.add(userVector.elementAt(i).getUserName());
            vector1.add(userVector.elementAt(i).getUserLevel());
            vector1.add(userVector.elementAt(i).getUserDate());
            vector1.add(userVector.elementAt(i).getUserPayAll());
            vector1.add(userVector.elementAt(i).getUserTimes());
            vector1.add(userVector.elementAt(i).getUserPhoneNumber());
            vector1.add(userVector.elementAt(i).getUserMail());
            vectors.add(vector1);
        }
    }
    private void IntiMenu(){
        jMenu.add(findItem);
        jMenu.add(deleteItem);
        findItem.addActionListener(this);
        deleteItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == findItem){
            IntiVectors();
            new FindJDialog(userVector);
            UserDataUI.this.dispose();
        } else if (source == deleteItem) {
            IntiVectors();
            new DeleteJDialog(userVector);
            UserDataUI.this.dispose();
        }
    }
}
