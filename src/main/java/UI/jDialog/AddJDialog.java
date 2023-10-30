package UI.jDialog;

import UI.Login.UserLogin;
import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import data.packagingData.AdminData;
import data.packagingData.MovieInformation;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.function.LongFunction;

public class AddJDialog extends IntiJDialog{
    JButton sureJbt = new JButton("确定");
    JButton returnJbt = new JButton("返回");
    Boolean noBl = false;
     public AddJDialog(Vector<?> vector) {

        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);
         Class<?> aClass = vector.get(0).getClass();
         if (aClass.equals(MovieLayoutData.class)) {
             movieLayoutDataAdd((Vector<MovieLayoutData>) vector);
         }else if (aClass.equals(AdminData.class)) {
             //用户添加
             adminDataAdd((Vector<AdminData>) vector);
         }else if(aClass.equals(MovieInformation.class)){
             movieInformationAdd((Vector<MovieInformation>) vector);
         }

        jDialog.setVisible(true);
    }


    private void movieInformationAdd(Vector<MovieInformation> vector) {
        movieVector = vector;
        //初始化界面，元件位置。大小。事件
        JLabel movieNameJLabel = new JLabel("片名:");
        JLabel directorJLabel = new JLabel("导演:");
        JLabel leadingRoleJLabel = new JLabel("主演:");
        JLabel synopsisJLabel = new JLabel("剧情简介:");
        JLabel durationJLabel = new JLabel("时长:");
        JTextField movieNameJText = new JTextField();
        JTextField directorNameJText = new JTextField();
        JTextField leadingRoleJText = new JTextField();
        JTextField synopsisJText = new JTextField();
        JTextField durationJText = new JTextField();
        movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        directorJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        leadingRoleJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        synopsisJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        durationJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        movieNameJLabel.setBounds(200,30,40,30);
        directorJLabel.setBounds(200,90,40,30);
        leadingRoleJLabel.setBounds(200,150,40,30);
        synopsisJLabel.setBounds(170,210,80,30);
        durationJLabel.setBounds(200,270,40,30);
        movieNameJText.setBounds(260,30,200,30);
        directorNameJText.setBounds(260,90,200,30);
        leadingRoleJText.setBounds(260,150,200,30);
        synopsisJText.setBounds(260,210,200,30);
        durationJText.setBounds(260,270,200,30);
        jDialog.getContentPane().add(movieNameJLabel);
        jDialog.getContentPane().add(directorJLabel);
        jDialog.getContentPane().add(leadingRoleJLabel);
        jDialog.getContentPane().add(synopsisJLabel);
        jDialog.getContentPane().add(durationJLabel);
        jDialog.getContentPane().add(movieNameJText);
        jDialog.getContentPane().add(synopsisJText);
        jDialog.getContentPane().add(directorNameJText);
        jDialog.getContentPane().add(leadingRoleJText);
        jDialog.getContentPane().add(durationJText);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {@Override
            public void actionPerformed(ActionEvent e) {
                    //获取用户输入
                     String movieName = movieNameJText.getText();
                     String director = directorNameJText.getText();
                     String leadingRole = leadingRoleJText.getText();
                     String synopsis = synopsisJText.getText();
                     String duration = durationJText.getText();

                     if(movieName.isEmpty()||director.isEmpty()||leadingRole.isEmpty()||synopsis.isEmpty()||duration.isEmpty()){
                         //输入为空
                         new LoginJDialog(2);
                     }
                     else {

                         Boolean yesBl = true;
                         for (int i = 0; i < movieVector.size(); i++) {
                             if(movieName.equals(movieVector.elementAt(i).getMovieName())){
                                 yesBl = false;
                             }
                         }
                         if(!yesBl){
                             //excel中已经有了该电影
                             new LoginJDialog(2);
                         }else {
                             //标准化形式
                             int tempDuration = new Integer(duration);
                             //添加数据
                             movieVector.add(new MovieInformation(movieName, director, leadingRole, synopsis, tempDuration));
                             new MovieReadAndWrite().write(movieVector);
                             jDialog.dispose();
                             new LoginJDialog(1);
                             new MovieDataUI();
                         }
                     }
            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieDataUI();
            }
        });
    }
    private void adminDataAdd(Vector<AdminData> vector) {
        
        adminVector = vector;

        //设置元件的属性
        JLabel adminJLabel = new JLabel("账号:");
        JLabel passwordJLabel = new JLabel("密码:");
        JLabel addJLabel = new JLabel("添加账户和密码：");
        JTextField adminJTextField = new JTextField();
        JTextField passwordJTextField = new JTextField();
        adminJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        passwordJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        addJLabel.setFont(new Font("华文楷体",Font.PLAIN,17));
        adminJLabel.setBounds(200,30,40,30);
        passwordJLabel.setBounds(200,90,40,30);
        adminJTextField.setBounds(260,30,200,30);
        passwordJTextField.setBounds(260,90,200,30);
        addJLabel.setBounds(50,90,200,30);
        jDialog.getContentPane().add(adminJLabel);
        jDialog.getContentPane().add(passwordJLabel);
        jDialog.getContentPane().add(adminJTextField);
        jDialog.getContentPane().add(passwordJTextField);
        jDialog.getContentPane().add(addJLabel);

        //为按钮添加事件
        sureJbt.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            //获取用户输入
            String admin = adminJTextField.getText();
            String password = passwordJTextField.getText();

            if(admin.isEmpty()||password.isEmpty()){
                //判断输入是否为空
                new LoginJDialog(2);
            } else if (!admin.matches("(\\w|\\d){5,}")||
                    !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,16}$")) {
                //判断输入是否符合规则
                new LoginJDialog(10);
            } else {
                //判断输入是否重复
                boolean bl = true;
                for (int i = 0; i < adminVector.size(); i++) {
                    if(admin.equals(adminVector.elementAt(i).getName())){
                        bl = false;
                        break;
                    }
                }

                if(bl){
                    //进入个人数据输入窗口
                    Vector<UserData> userDataVector = new  UserReadAndWrite().read();
                    AddJDialog addJDialog = new AddJDialog(userDataVector, admin);
                    if(addJDialog.getNoBl()){
                        adminVector.add(new AdminData(admin,password));
                        new AdminReadAndWrite().write(adminVector);
                        jDialog.dispose();
                        new LoginJDialog(1);
                    }

                } else {
                    new LoginJDialog(11);
                }

            }
        }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();

            }
        });
    }
    private void movieLayoutDataAdd(Vector<MovieLayoutData> vector) {
        movieLayoutVector = vector;
        //初始化界面
        JLabel movieNameJLabel = new JLabel("电影名:");
        JLabel projectionRoomJLabel = new JLabel("播放室:");
        JLabel startTimeJLabel = new JLabel("开始播放时间：");
        JLabel priceJLabel = new JLabel("价格：");
        JLabel addJLabel = new JLabel("增加排场信息");
        JTextField movieNameText = new JTextField();
        JTextField projectionRoomText = new JTextField();
        JTextField startTimeText = new JTextField();
        JTextField priceText = new JTextField();
        movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        projectionRoomJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        startTimeJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        priceJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        addJLabel.setFont(new Font("华文楷体",Font.PLAIN,17));
        movieNameJLabel.setBounds(200,30,100,30);
        projectionRoomJLabel.setBounds(200,90,100,30);
        startTimeJLabel.setBounds(200,150,100,30);
        priceJLabel.setBounds(200,210,100,30);
        movieNameText.setBounds(300,30,200,30);
        projectionRoomText.setBounds(300,90,200,30);
        startTimeText.setBounds(300,150,200,30);
        priceText.setBounds(300,210,200,30);
        addJLabel.setBounds(50,90,200,30);
        jDialog.getContentPane().add(movieNameText);
        jDialog.getContentPane().add(movieNameJLabel);
        jDialog.getContentPane().add(priceText);
        jDialog.getContentPane().add(projectionRoomText);
        jDialog.getContentPane().add(startTimeJLabel);
        jDialog.getContentPane().add(priceJLabel);
        jDialog.getContentPane().add(projectionRoomJLabel);
        jDialog.getContentPane().add(startTimeText);
        jDialog.getContentPane().add(addJLabel);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            //获取输入
            String movieName = movieNameText.getText();
            String projectionRoom = projectionRoomText.getText();
            String price = priceText.getText();
            String startTime = startTimeText.getText();

            Boolean bl = true;
            Vector<MovieInformation> movieInformationVector = new MovieReadAndWrite().read();
            for (int i = 0; i < movieInformationVector.size(); i++) {
                if(movieName.equals(movieInformationVector.elementAt(i).getMovieName())){
                   bl = false;
                }
            }

            if(movieName.isEmpty()||projectionRoom.isEmpty()||price.isEmpty()||startTime.isEmpty()){
               //输入为空
                new LoginJDialog(2);
            }else if (!startTime.matches("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})" +
                    "-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)" +
                    "(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$")){
                //时间输入不合法
                new LoginJDialog(15);
            } else if(bl){
                new LoginJDialog(17);
            }
            else {

                int tempProjectionRoom = new Integer(projectionRoom);
                float tempPrice = new Integer(price).floatValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
               //格式化输入
                Date parseStartTime = new Date();
                try {
                    parseStartTime = simpleDateFormat.parse(startTime);
                } catch (ParseException ex) {
                    try {
                        parseStartTime = simpleDateFormat1.parse(startTime);
                    } catch (ParseException exc) {

                    }
                }

                Date endDate = new Date();
                Vector<MovieInformation> temp = new MovieReadAndWrite().read();
                for(int i = 0; i < temp.size(); i++) {
                    if (temp.elementAt(i).getMovieName().equals(movieName)) {
                        endDate.setTime(parseStartTime.getTime()+(long)temp.elementAt(i).getDuration()*60*1000);;
                    }
                }

                if((tempProjectionRoom>5||tempProjectionRoom<=0)){
                    //放映室输入错误
                        new LoginJDialog(14);
                }else {
                    String seatData = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    movieLayoutVector.add(new MovieLayoutData(movieName,tempProjectionRoom,startTime,simpleDateFormat.format(endDate),tempPrice,seatData));
                    new MovieLayoutReadAndWrite().write(movieLayoutVector);
                    jDialog.dispose();
                    new MovieLayoutDataUI();
                }
            }
        }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieLayoutDataUI();
            }
        });
    }
    
    public AddJDialog(Vector<UserData> vector,String admin){
        userVector = vector;
        //设置元件的属性
        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);
        JLabel userName = new JLabel("用户名:");
        JLabel userPhoneNumber = new JLabel("用户手机号:");
        JLabel userMail = new JLabel("用户邮箱:");
        JLabel addJLabel = new JLabel("添加用户信息:");
        JTextField userNameJTextField = new JTextField();
        JTextField userPhoneNumberJTextField = new JTextField();
        JTextField userMailJTextField = new JTextField();
        addJLabel.setFont(new Font("华文楷体",Font.PLAIN,14));
        userName.setFont(new Font("楷体",Font.PLAIN,14));
        userPhoneNumber.setFont(new Font("楷体",Font.PLAIN,14));
        userMail.setFont(new Font("楷体",Font.PLAIN,14));
        addJLabel.setBounds(50,90,200,30);
        userName.setBounds(160,90,80,30);
        userPhoneNumber.setBounds(160,150,80,30);
        userMail.setBounds(160,210,80,30);
        userNameJTextField.setBounds(260,90,200,30);
        userPhoneNumberJTextField.setBounds(260,150,200,30);
        userMailJTextField.setBounds(260,210,200,30);
        jDialog.getContentPane().add(addJLabel);
        jDialog.getContentPane().add(userName);
        jDialog.getContentPane().add(userNameJTextField);
        jDialog.getContentPane().add(userPhoneNumberJTextField);
        jDialog.getContentPane().add(userPhoneNumber);
        jDialog.getContentPane().add(userMailJTextField);
        jDialog.getContentPane().add(userMail);

        //为按钮添加事件
        sureJbt.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            //获取用户输入
            String userName = userNameJTextField.getText();
            String userPhone = userPhoneNumberJTextField.getText();
            String userMail = userMailJTextField.getText();
            //获得用户注册时间
            Date userDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
            String date = simpleDateFormat.format(userDate);

            if(userName.isEmpty()||userPhone.isEmpty()||userMail.isEmpty()){
                //是否用空
                new LoginJDialog(2);
            }else if(!userPhone.matches("^1[3-9]\\d{9}$")||
                    !userMail.matches("^[1-9]\\d{4,10}@qq\\.com$")){
                //手机号和账户的输入是否合法
                new LoginJDialog(12);
            }
            else {
                noBl = true;
                //匹配成功
                userVector.add(new UserData(admin,userName,"铜牌用户",date,userPhone,userMail));
                new UserReadAndWrite().write(userVector);
                jDialog.dispose();
            }
        }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //未输入用户数据，所以见原先添入的用户账户和密码删除

                jDialog.dispose();
            }
        });
        jDialog.setVisible(true);
    }

    public Boolean getNoBl() {
        return noBl;
    }
}
