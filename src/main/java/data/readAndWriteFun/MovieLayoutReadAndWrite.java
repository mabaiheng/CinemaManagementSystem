package data.readAndWriteFun;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import data.packagingData.MovieInformation;
import data.packagingData.MovieLayoutData;

import java.util.Vector;

public class MovieLayoutReadAndWrite {
    String fileName = "src/main/java/data/excel/movieLayoutData.xlsx";
    Vector<MovieLayoutData> readVector = new Vector<>();

    public void write(Vector<MovieLayoutData> vector) {
        EasyExcel.write(fileName, data.packagingData.MovieLayoutData.class).sheet().doWrite(vector);
    }

    public Vector<MovieLayoutData> read() {
        EasyExcel.read(fileName, MovieLayoutData.class, new AnalysisEventListener<MovieLayoutData>() {
            @Override
            public void invoke(MovieLayoutData movieLayoutData, AnalysisContext analysisContext) {
                readVector.add(movieLayoutData);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        return readVector;
    }
}