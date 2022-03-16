package blog.panditmandar.code.timecalc.constant;

public enum TimeValueSeperator {

	SPACE(" "), COLON(":");

	public final String seperator;

	private TimeValueSeperator(String seperator) {
		this.seperator = seperator;
	}

	public String getSeperator() {
		return seperator;
	}
}
