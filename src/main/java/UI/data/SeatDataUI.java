package UI.data;

import UI.IntiJFrame;
import UI.Login.Login;
import UI.jDialog.IntiJDialog;
import UI.jDialog.LoginJDialog;
import UI.work.ReceptionWork;
import UI.work.UserWork;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserBuyHistory;
import data.packagingData.UserData;
import data.readAndWriteFun.HistoryReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;
import org.apache.poi.util.NullLogger;
import sun.text.resources.FormatData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;


public class SeatDataUI extends IntiJFrame{
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton ZFBjbt = new JRadioButton("支付宝");
    JRadioButton WeChatjbt = new JRadioButton("微信");
    JRadioButton IDjbt = new JRadioButton("银行卡");
    JButton[][] jButtons = new JButton[12][7];
    JLabel priceJLabel = new JLabel("总价为：0元");
    JButton buyJButton = new JButton("购买");
    Vector<MovieLayoutData> movieLayoutVector = new MovieLayoutReadAndWrite().read();
    Vector<UserData> userDataVector = new UserReadAndWrite().read();
    int count = 0;
    String seatData;
    float price = 0;
    float allPrice = 0;
    int point = 0;
    //管理员查看界面
    public SeatDataUI(MovieLayoutData temp) {
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);
        //设置返回按钮
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReceptionWork();
            }
        });
        //获得所选电影的价格和作为信息
        for (int i = 0; i < movieLayoutVector.size(); i++) {
            if (temp.getMovieName().equals(movieLayoutVector.elementAt(i).getMovieName())&&
                    temp.getProjectionRoom()==movieLayoutVector.elementAt(i).getProjectionRoom()&&
                    temp.getStartTime().equals(movieLayoutVector.elementAt(i).getStartTime())) {
                seatData = temp.getSeatData();
                this.price = temp.getPrice();
            }
        }

        //将座位信息由String转换为char[][]的形式
        char[] tempData = seatData.toCharArray();
        char[][] data = new char[12][7];
        int m = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = tempData[m];
                m++;
            }
        }

        //初始化座位按钮
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                jButtons[i][j] = new JButton((j + 1) + "." + (i + 1));
                this.getContentPane().add(jButtons[i][j]);
                if (data[i][j] == '0') {
                    jButtons[i][j].setBackground(Color.white);
                    jButtons[i][j].setBounds(20 + i * 80, 30 + j * 75, 70, 30);
                    final int tempi = i;
                    final int tempj = j;

                    jButtons[i][j].setVisible(true);

                } else {
                    jButtons[i][j].setBackground(Color.RED);
                    jButtons[i][j].setBounds(20 + i * 80, 30 + j * 75, 70, 30);
                    jButtons[i][j].setVisible(true);
                }
            }
        }
    }

    //用户选择座位界面
    public SeatDataUI(String admin, MovieLayoutData temp) {
        intijFrame();
        intiSystemTray();
        this.getContentPane().setLayout(null);

        //获得所选电影的价格和座位信息
        int index = 0;
        for (int i = 0; i < movieLayoutVector.size(); i++) {
            if (temp.getMovieName().equals(movieLayoutVector.elementAt(i).getMovieName())&&
            temp.getProjectionRoom()==movieLayoutVector.elementAt(i).getProjectionRoom()&&
            temp.getStartTime().equals(movieLayoutVector.elementAt(i).getStartTime())) {
                index = i;
                seatData = temp.getSeatData();
                this.price = temp.getPrice();
            }
        }

        //获得用户的个人信息
        int userDataIndex = 0;
        for (int i = 0; i < userDataVector.size(); i++) {
            if(admin.equals(userDataVector.elementAt(i).getUserID())){
                userDataIndex = i;
            }
        }
        //根据用户的等级确定电影票单价
        if(userDataVector.elementAt(userDataIndex).getUserLevel().equals("金牌用户")){
            price = price * 0.85f;
        } else if (userDataVector.elementAt(userDataIndex).getUserLevel().equals("银牌用户")) {
            price = price * 0.95f;
        }

        //将座位信息由String转换为char[][]的形式
        char[] tempData = seatData.toCharArray();
        char[][] data = new char[12][7];
        int m = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = tempData[m];
                m++;
            }
        }

        //显示设置支付金额及支付方式的位置
        priceJLabel.setBounds(100, 600, 250, 80);
        priceJLabel.setFont(new Font("华文楷体", Font.BOLD, 18));
        this.getContentPane().add(priceJLabel);
        ZFBjbt.setBounds(400, 550, 100, 30);
        ZFBjbt.setFont(new Font("楷体", Font.BOLD, 13));
        WeChatjbt.setBounds(400, 600, 100, 30);
        WeChatjbt.setFont(new Font("楷体", Font.BOLD, 13));
        IDjbt.setBounds(400, 650, 100, 30);
        IDjbt.setFont(new Font("楷体", Font.BOLD, 13));
        ZFBjbt.setBackground(Color.YELLOW);
        WeChatjbt.setBackground(Color.YELLOW);
        IDjbt.setBackground(Color.YELLOW);


        //添加按钮事件
        final int tempIndex = index;
        final int tempUserDataIndex = userDataIndex;
        ZFBjbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(point == 1){

                }else {
                    point = 1;
                    //设置购买按钮
                    buyJButton.setBounds(600, 600, 250, 80);
                    buyJButton.setFont(new Font("华文楷体", Font.BOLD, 26));

                    //为购买添加事件
                    buyJButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (allPrice != 0) {
                                LoginJDialog loginJDialog = new LoginJDialog(7);


                                if (loginJDialog.getYesBl()) {
                                    //确定购买后，更新座位信息
                                    String innerSeatData = Arrays.deepToString(data);
                                    String result1 = innerSeatData.replaceAll(",", "");
                                    String result2 = result1.replaceAll("]", "");
                                    String result3 = result2.replaceAll("\\[", "");
                                    String result4 = result3.replaceAll("\\s", "");
                                    movieLayoutVector.elementAt(tempIndex).setSeatData(result4);
                                    new MovieLayoutReadAndWrite().write(movieLayoutVector);

                                    //获得随机电影码
                                    Random random = new Random();
                                    int[] randomArr = new int[10];
                                    for (int i = 0; i < 10; i++) {
                                        randomArr[i] = random.nextInt(10);
                                    }
                                    String randomString = Arrays.toString(randomArr);
                                    String resultA = randomString.replaceAll(",", "");
                                    String resultB = resultA.replaceAll("]", "");
                                    String resultC = resultB.replaceAll("\\[", "");
                                    String resultD = resultC.replaceAll("\\s", "");

                                    //获取购买时间
                                    Date date = new Date();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    String tempDate = simpleDateFormat.format(date);
                                    //添加购买历史
                                    Vector<UserBuyHistory> tempVector = new HistoryReadAndWrite().read();
                                    tempVector.add(new UserBuyHistory(admin, temp.getMovieName(), tempDate,
                                            temp.getStartTime(), temp.getProjectionRoom(), resultD, count, allPrice));
                                    new HistoryReadAndWrite().write(tempVector);

                                    //更新用户的购买次数，购买总金额，用户等级的数据
                                    userDataVector.elementAt(tempUserDataIndex).
                                            setUserTimes(userDataVector.elementAt(tempUserDataIndex).getUserTimes() + 1);
                                    userDataVector.elementAt(tempUserDataIndex).
                                            setUserPayAll(userDataVector.elementAt(tempUserDataIndex).getUserPayAll() + allPrice);
                                    if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 10) {
                                        userDataVector.elementAt(tempUserDataIndex).setUserLevel("金牌用户");
                                    } else if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 5) {
                                        userDataVector.elementAt(tempUserDataIndex).setUserLevel("银牌用户");
                                    }
                                    new UserReadAndWrite().write(userDataVector);

                                    new LoginJDialog(resultD);
                                    SeatDataUI.this.dispose();
                                    new UserWork(admin);
                                }
                            }else{
                                new LoginJDialog(16);
                            }
                        }

                    });
                }
            }
        });
        WeChatjbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(point == 1){

                }else {
                    point = 1;
                    buyJButton.setBounds(600, 600, 250, 80);
                    buyJButton.setFont(new Font("华文楷体", Font.BOLD, 26));

                    //为购买添加事件
                    buyJButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            LoginJDialog loginJDialog = new LoginJDialog(7);


                            if (loginJDialog.getYesBl()) {
                                //确定购买后，更新座位信息
                                String innerSeatData = Arrays.deepToString(data);
                                String result1 = innerSeatData.replaceAll(",", "");
                                String result2 = result1.replaceAll("]", "");
                                String result3 = result2.replaceAll("\\[", "");
                                String result4 = result3.replaceAll("\\s", "");
                                movieLayoutVector.elementAt(tempIndex).setSeatData(result4);
                                new MovieLayoutReadAndWrite().write(movieLayoutVector);

                                //获得随机电影码
                                Random random = new Random();
                                int[] randomArr = new int[10];
                                for (int i = 0; i < 10; i++) {
                                    randomArr[i] = random.nextInt(10);
                                }
                                String randomString = Arrays.toString(randomArr);
                                String resultA = randomString.replaceAll(",", "");
                                String resultB = resultA.replaceAll("]", "");
                                String resultC = resultB.replaceAll("\\[", "");
                                String resultD = resultC.replaceAll("\\s", "");

                                //获取购买时间
                                Date date = new Date();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                String tempDate = simpleDateFormat.format(date);
                                //添加购买历史
                                Vector<UserBuyHistory> tempVector = new HistoryReadAndWrite().read();
                                tempVector.add(new UserBuyHistory(admin, temp.getMovieName(), tempDate,
                                        temp.getStartTime(), temp.getProjectionRoom(), resultD, count, allPrice));
                                new HistoryReadAndWrite().write(tempVector);

                                //更新用户的购买次数，购买总金额，用户等级的数据
                                userDataVector.elementAt(tempUserDataIndex).
                                        setUserTimes(userDataVector.elementAt(tempUserDataIndex).getUserTimes() + 1);
                                userDataVector.elementAt(tempUserDataIndex).
                                        setUserPayAll(userDataVector.elementAt(tempUserDataIndex).getUserPayAll() + allPrice);
                                if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 10) {
                                    userDataVector.elementAt(tempUserDataIndex).setUserLevel("金牌用户");
                                } else if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 5) {
                                    userDataVector.elementAt(tempUserDataIndex).setUserLevel("银牌用户");
                                }
                                new UserReadAndWrite().write(userDataVector);

                                new LoginJDialog(resultD);
                                SeatDataUI.this.dispose();
                                new UserWork(admin);
                            }
                        }
                    });
                }
            }
        });
        IDjbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(point == 1){

                }else {
                    point = 1;
                    buyJButton.setBounds(600, 600, 250, 80);
                    buyJButton.setFont(new Font("华文楷体", Font.BOLD, 26));

                    //为购买添加事件
                    buyJButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            LoginJDialog loginJDialog = new LoginJDialog(7);


                            if (loginJDialog.getYesBl()) {
                                //确定购买后，更新座位信息
                                String innerSeatData = Arrays.deepToString(data);
                                String result1 = innerSeatData.replaceAll(",", "");
                                String result2 = result1.replaceAll("]", "");
                                String result3 = result2.replaceAll("\\[", "");
                                String result4 = result3.replaceAll("\\s", "");
                                movieLayoutVector.elementAt(tempIndex).setSeatData(result4);
                                new MovieLayoutReadAndWrite().write(movieLayoutVector);

                                //获得随机电影码
                                Random random = new Random();
                                int[] randomArr = new int[10];
                                for (int i = 0; i < 10; i++) {
                                    randomArr[i] = random.nextInt(10);
                                }
                                String randomString = Arrays.toString(randomArr);
                                String resultA = randomString.replaceAll(",", "");
                                String resultB = resultA.replaceAll("]", "");
                                String resultC = resultB.replaceAll("\\[", "");
                                String resultD = resultC.replaceAll("\\s", "");

                                //获取购买时间
                                Date date = new Date();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                String tempDate = simpleDateFormat.format(date);
                                //添加购买历史
                                Vector<UserBuyHistory> tempVector = new HistoryReadAndWrite().read();
                                tempVector.add(new UserBuyHistory(admin, temp.getMovieName(), tempDate,
                                        temp.getStartTime(), temp.getProjectionRoom(), resultD, count, allPrice));
                                new HistoryReadAndWrite().write(tempVector);

                                //更新用户的购买次数，购买总金额，用户等级的数据
                                userDataVector.elementAt(tempUserDataIndex).
                                        setUserTimes(userDataVector.elementAt(tempUserDataIndex).getUserTimes() + 1);
                                userDataVector.elementAt(tempUserDataIndex).
                                        setUserPayAll(userDataVector.elementAt(tempUserDataIndex).getUserPayAll() + allPrice);
                                if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 10) {
                                    userDataVector.elementAt(tempUserDataIndex).setUserLevel("金牌用户");
                                } else if (userDataVector.elementAt(tempUserDataIndex).getUserTimes() > 5) {
                                    userDataVector.elementAt(tempUserDataIndex).setUserLevel("银牌用户");
                                }
                                new UserReadAndWrite().write(userDataVector);

                                new LoginJDialog(resultD);
                                SeatDataUI.this.dispose();
                                new UserWork(admin);
                            }
                        }
                    });
                }
            }
        });
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserWork(admin);
            }
        });

        this.getContentPane().add(WeChatjbt);
        this.getContentPane().add(ZFBjbt);
        this.getContentPane().add(IDjbt);
        this.getContentPane().add(buyJButton);
        
        buttonGroup.add(WeChatjbt);
        buttonGroup.add(IDjbt);
        buttonGroup.add(ZFBjbt);

        //为每一个座位按钮添加事件
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                jButtons[i][j] = new JButton((j + 1) + "." + (i + 1));
                this.getContentPane().add(jButtons[i][j]);
                if (data[i][j] == '0') {
                    jButtons[i][j].setBackground(Color.white);
                    jButtons[i][j].setBounds(20 + i * 80, 30 + j * 75, 70, 30);

                    final int tempi = i;
                    final int tempj = j;

                    jButtons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if (data[tempi][tempj] == '0') {
                                count++;
                                jButtons[tempi][tempj].setBackground(Color.GREEN);
                                data[tempi][tempj] = '2';
                                allPrice = allPrice + price;
                                priceJLabel.setText("总价为：" + String.format("%.2f",allPrice) + "元"+
                                        "("+userDataVector.elementAt(tempUserDataIndex).getUserLevel()+
                                                ")");
                                Timer timer = new Timer();
                                TimerTask timerTask = new TimerTask() {
                                    @Override
                                    public void run() {
                                        jButtons[tempi][tempj].setText((tempj + 1) + "." + (tempi + 1));
                                        jButtons[tempi][tempj].setBackground(Color.white);
                                        data[tempi][tempj] = '0';
                                        if(allPrice!=0){allPrice = allPrice - price;}
                                        priceJLabel.setText("总价为：" + String.format("%.2f",allPrice) + "元"+
                                                "("+userDataVector.elementAt(tempUserDataIndex).getUserLevel()+
                                                ")");
                                        count--;
                                    }
                                };
                                timer.schedule(timerTask, 1000 * 2 *60);

                            }
                            else if (data[tempi][tempj] == '2') {
                                count--;
                                jButtons[tempi][tempj].setBackground(Color.white);
                                data[tempi][tempj] = '0';
                                allPrice = allPrice - price;
                                priceJLabel.setText("总价为：" + String.format("%.2f",allPrice) + "元"+
                                        "("+userDataVector.elementAt(tempUserDataIndex).getUserLevel()+
                                        ")");
                            }


                        }
                    });

                    jButtons[i][j].setVisible(true);

                } else {
                    jButtons[i][j].setBackground(Color.RED);
                    jButtons[i][j].setBounds(20 + i * 80, 30 + j * 75, 70, 30);
                    jButtons[i][j].setVisible(true);
                }


            }
        }
    }
}
