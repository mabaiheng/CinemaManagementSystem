package data.packagingData;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Vector;

public class MovieInformation {
//片名、导演、主演、剧情简介、时长
    @ExcelProperty("片名")
    String movieName;
    @ExcelProperty("导演")
    String director;
    @ExcelProperty("主演")
    String leadingRole;
    @ExcelProperty("剧情简介")
    String synopsis;
    @ExcelProperty("时长(min)")
    int duration;

    public MovieInformation(String movieName, String director, String leadingRole, String synopsis, int duration) {
        this.movieName = movieName;
        this.director = director;
        this.leadingRole = leadingRole;
        this.synopsis = synopsis;
        this.duration = duration;
    }

    public MovieInformation() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLeadingRole() {
        return leadingRole;
    }

    public void setLeadingRole(String leadingRole) {
        this.leadingRole = leadingRole;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
