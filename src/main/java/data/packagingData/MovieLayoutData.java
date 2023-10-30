package data.packagingData;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Arrays;
import java.util.Date;

public class MovieLayoutData {
    //片名，放映室，播放时段，价格
    @ExcelProperty("片名")
    String movieName;
    @ExcelProperty("放映室")
    int projectionRoom;
    @ExcelProperty("开始时间")
    String startTime;
    @ExcelProperty("结束时间")
    String endTime;
    @ExcelProperty("价格")
    float price;
    @ExcelProperty("座位信息")
    String seatData;
    public MovieLayoutData() {
    }

    public MovieLayoutData(String movieName, int projectionRoom, String startTime, String endTime, float price,String seatData) {
        this.movieName = movieName;
        this.projectionRoom = projectionRoom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.seatData = seatData;
    }


    public String getSeatData() {
        return seatData;
    }

    public void setSeatData(String seatData) {
        this.seatData = seatData;
    }

    @Override
    public String toString() {
        return "MovieLayoutData{" +
                "movieName='" + movieName + '\'' +
                ", projectionRoom=" + projectionRoom +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", price=" + price +
                ", seatData=" + seatData +
                '}';
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getProjectionRoom() {
        return projectionRoom;
    }

    public void setProjectionRoom(int projectionRoom) {
        this.projectionRoom = projectionRoom;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
