package data.readAndWriteFun;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import data.packagingData.UserData;

import java.util.Vector;

public class UserReadAndWrite {
    String fileName = "src/main/java/data/excel/userData.xlsx";
    Vector<UserData> readVector = new Vector<>();

    public void write(Vector<UserData> writeVector) {
        EasyExcel.write(fileName, UserData.class).sheet().doWrite(writeVector);
    }

    public Vector<UserData> read() {

            EasyExcel.read(fileName, UserData.class, new AnalysisEventListener<UserData>() {

                @Override
                public void invoke(UserData userData, AnalysisContext analysisContext) {
                    readVector.add(userData);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                }
            }).sheet().doRead();

        return readVector;
        }
}