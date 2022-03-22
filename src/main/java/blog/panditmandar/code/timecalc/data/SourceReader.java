package blog.panditmandar.code.timecalc.data;

public interface SourceReader {

	enum FORMAT {
		CSV, JSON;
	}

	enum VALUE_SEPERATOR {
		SPACE, COLON;
	}

	String[] readSourceData(String sourceData);
}
