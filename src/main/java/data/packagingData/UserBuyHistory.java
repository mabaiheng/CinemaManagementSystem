package data.packagingData;

import com.alibaba.excel.annotation.ExcelProperty;

public class UserBuyHistory {
    @ExcelProperty("用户名")
    String userName;
    @ExcelProperty("片名")
    String movieName;
    @ExcelProperty("购买时间")
    String buyTime;
    @ExcelProperty("开始时间")
    String startTime;
    @ExcelProperty("场次")
    int projectionRoom;
    @ExcelProperty("取票码")
    String ticketCode;
    @ExcelProperty("票含量")
    int content;
    @ExcelProperty("支付金额（元）")
    float price;

    public UserBuyHistory() {
    }

    public UserBuyHistory(String userName, String movieName,
                          String buyTime, String startTime,
                          int projectionRoom, String ticketCode,
                          int content, float price) {
        this.userName = userName;
        this.movieName = movieName;
        this.buyTime = buyTime;
        this.startTime = startTime;
        this.projectionRoom = projectionRoom;
        this.ticketCode = ticketCode;
        this.content = content;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserBuyHistory{" +
                "userName='" + userName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", buyTime='" + buyTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", projectionRoom='" + projectionRoom + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getProjectionRoom() {
        return projectionRoom;
    }

    public void setProjectionRoom(int projectionRoom) {
        this.projectionRoom = projectionRoom;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}
