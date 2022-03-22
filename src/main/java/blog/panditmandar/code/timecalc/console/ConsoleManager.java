package blog.panditmandar.code.timecalc.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.data.SourceReader;

@Component
public class ConsoleManager {

	@Autowired
	ConsoleUtility cutil;

	private String data;
	private String filePath;
	private SourceReader sourceReader;
	private TimeValueSeperator valueSeperator;
	private boolean dataFetchSuccess = false;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public SourceReader getSourceReader() {
		return sourceReader;
	}

	public void setSourceReader(SourceReader sourceReader) {
		this.sourceReader = sourceReader;
	}

	public TimeValueSeperator getValueSeperator() {
		return valueSeperator;
	}

	public void setValueSeperator(TimeValueSeperator valueSeperator) {
		this.valueSeperator = valueSeperator;
	}

	public void collectArguments(String... args) {
		if (!verifyArgs(args)) {
			menu();
		}
	}

	private boolean verifyArgs(String... args) {
		if (args.length > 0) {
			int index = 0;
			while ((index + 1) < args.length) {
				cutil.matchSingleArgValue(this, args[index], args[++index]);
			}
			if (index > 0) {
				dataFetchSuccess = true;
			}
		}
		return dataFetchSuccess;
	}

	private void menu() {
		StringBuilder menu = new StringBuilder();

		menu.append("Usage: [-options]\n\n");
		menu.append("Options:");
		menuRow(menu, ConsoleMenu.DATA);
		menuRow(menu, ConsoleMenu.FILE);
		menuRow(menu, ConsoleMenu.SOURCE_READER);
		menuRow(menu, ConsoleMenu.VALUE_SEPERATOR);

		System.out.println(menu.toString());

	}

	private void menuRow(StringBuilder menu, ConsoleMenu menuRow) {
		menu.append("\n  ").append(menuRow.getOptionDisplay());
		if (menuRow.getDescription().length() < 60) {
			menu.append("\t");
		}
		menu.append("\t").append(menuRow.getDescription());
	}

}
