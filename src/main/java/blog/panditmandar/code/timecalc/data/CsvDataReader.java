package blog.panditmandar.code.timecalc.data;

import org.springframework.stereotype.Component;

@Component
public class CsvDataReader implements SourceReader {

	@Override
	public String[] readSourceData(String sourceData) {
		// TODO Auto-generated method stub
		return sourceData.split(",");
	}

}
