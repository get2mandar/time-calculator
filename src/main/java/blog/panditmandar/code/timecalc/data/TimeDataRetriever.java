package blog.panditmandar.code.timecalc.data;

import blog.panditmandar.code.timecalc.constant.TimeValueFormat;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;

public abstract class TimeDataRetriever implements DataRetriever {

	private String sourceData;
	private TimeValueFormat timeValueFormat;
	private TimeValueSeperator timeValueSeperator;

	protected TimeDataRetriever(String sourceData) {
		this.sourceData = sourceData;
	}

	protected void setTimeValueFormat(TimeValueFormat timeValueFormat) {
		this.timeValueFormat = timeValueFormat;
	}

	protected void setTimeValueSeperator(TimeValueSeperator timeValueSeperator) {
		this.timeValueSeperator = timeValueSeperator;
	}

	public String getSourceData() {
		return sourceData;
	}

	public TimeValueFormat getTimeValueFormat() {
		return timeValueFormat;
	}

	public TimeValueSeperator getTimeValueSeperator() {
		return timeValueSeperator;
	}
}
