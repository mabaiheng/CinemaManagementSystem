package data.packagingData;

import com.alibaba.excel.annotation.ExcelProperty;

public class AdminData {
    @ExcelProperty("用户名")
    private String name;
    @ExcelProperty("密码")
    private String password;

    public AdminData() {
    }

    public AdminData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminData{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
