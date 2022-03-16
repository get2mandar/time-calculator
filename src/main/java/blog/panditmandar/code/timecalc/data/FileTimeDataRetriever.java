package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.TimeValueFormat;
import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;

public class FileTimeDataRetriever extends TimeDataRetriever {

	protected FileTimeDataRetriever(String sourceData, TimeValueFormat timeValueFormat,
			TimeValueSeperator timeValueSeperator) {
		super(sourceData);
		super.setTimeValueFormat(timeValueFormat);
		super.setTimeValueSeperator(timeValueSeperator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<SingleTime> retrieveTimeData() {
		// TODO Auto-generated method stub
		return null;
	}

}
