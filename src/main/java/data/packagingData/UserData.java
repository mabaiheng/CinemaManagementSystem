package data.packagingData;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Arrays;
import java.util.Date;

public class UserData {
//    用户 ID、用户名、用户级别（金牌用户、银牌用户、铜牌用户）、
//    用户注册时间、用户累计消费总金额、用户累计消费次数、用户手机号、用户邮箱；
//    历史购票信息
    @ExcelProperty("用户Id")
    String userID;
    @ExcelProperty("用户名")
    String userName;
    @ExcelProperty("用户级别")
    String userLevel;
    @ExcelProperty("用户注册时间")
    String userDate;
    @ExcelProperty("用户累计消费总金额")
    float userPayAll;
    @ExcelProperty("用户累计消费次数")
    int userTimes;
    @ExcelProperty("用户手机号")
    String userPhoneNumber;
    @ExcelProperty("用户邮箱")
    String userMail;
        public UserData(String userID, String userName, String userLevel,String userDate, String userPhoneNumber, String userMail) {
        this.userID = userID;
        this.userName = userName;
        this.userLevel = userLevel;
        this.userDate = userDate;
        this.userPhoneNumber = userPhoneNumber;
        this.userMail = userMail;
    }
    public UserData() {
    }
    @Override
    public String toString() {
        return "UserData{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userDate=" + userDate +
                ", userPayAll=" + userPayAll +
                ", userTimes=" + userTimes +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userMail='" + userMail + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public float getUserPayAll() {
        return userPayAll;
    }

    public void setUserPayAll(float userPayAll) {
        this.userPayAll = userPayAll;
    }

    public int getUserTimes() {
        return userTimes;
    }

    public void setUserTimes(int userTimes) {
        this.userTimes = userTimes;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }


}
