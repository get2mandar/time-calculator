package blog.panditmandar.code.timecalc.data;

public class CsvDataReader implements DataReader {

	@Override
	public String[] readSourceData(String sourceData) {
		// TODO Auto-generated method stub
		return sourceData.split(",");
	}

}
