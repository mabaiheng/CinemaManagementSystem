package data.readAndWriteFun;

import UI.work.AdministratorWork;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import data.packagingData.AdminData;

import java.util.Vector;

public class AdminReadAndWrite {
    Vector<data.packagingData.AdminData> readVector = new Vector<>();
    String userFileName = "src/main/java/data/excel/userAdminData.xlsx";
    String AdministratorFileName = "src/main/java/data/excel/AdministratorAdminData.xlsx";

    String readAdmin;
    String readPassword;
    Boolean compareBool = false;
    public void write(Vector<AdminData> vector){

       EasyExcel.write(userFileName, AdminData.class).sheet().doWrite(vector);
    }

    public void adminWrite(Vector<AdminData> vector){

        EasyExcel.write(AdministratorFileName, AdminData.class).sheet().doWrite(vector);
    }
    public Vector<AdminData> adminRead(){
        EasyExcel.read(AdministratorFileName, AdminData.class, new AnalysisEventListener<AdminData>() {
            @Override
            public void invoke(AdminData adminData, AnalysisContext analysisContext) {
                readVector.add(adminData);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        return readVector;
    }
    public Vector<AdminData> read(){
        EasyExcel.read(userFileName, AdminData.class, new AnalysisEventListener<AdminData>() {
            @Override
            public void invoke(AdminData adminData, AnalysisContext analysisContext) {
                readVector.add(adminData);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        return readVector;
    }
    public Boolean compareRead(String admin,String password){
        EasyExcel.read(userFileName, data.packagingData.AdminData.class, new AnalysisEventListener<data.packagingData.AdminData>() {
            @Override
            public void invoke(data.packagingData.AdminData adminData, AnalysisContext analysisContext) {
            readAdmin = adminData.getName();
            readPassword = adminData.getPassword();
            if(readAdmin.equals(admin)&&readPassword.equals(password)){
                compareBool = true;
            }
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        return compareBool;
    }

    public Vector<data.packagingData.AdminData> getReadVector() {
        return readVector;
    }

    public void setReadVector(Vector<data.packagingData.AdminData> readVector) {
        this.readVector = readVector;
    }

    public String getReadAdmin() {
        return readAdmin;
    }

    public void setReadAdmin(String readAdmin) {
        this.readAdmin = readAdmin;
    }

    public String getReadPassword() {
        return readPassword;
    }

    public void setReadPassword(String readPassword) {
        this.readPassword = readPassword;
    }
}
