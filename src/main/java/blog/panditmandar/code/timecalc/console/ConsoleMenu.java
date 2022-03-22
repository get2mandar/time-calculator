package blog.panditmandar.code.timecalc.console;

public enum ConsoleMenu {

	DATA("--data", "--data <argument>", "Provide the Data Directly in <argument>"),
	FILE("--file", "--file <argument>", "Provide the File Path as an <argument>"),
	SOURCE_READER("--source-reader", "--source-reader <reader>",
			"Defines the Source Reader Format. Supported are 'csv', 'json'"),
	VALUE_SEPERATOR("--value-seperator", "--value-seperator <sep>",
			"Defines the Time Value Seperator. Supported are 'space', 'colon'");

	private final String option;
	private final String optionDisplay;
	private final String description;

	private ConsoleMenu(String option, String optionDisplay, String description) {
		this.option = option;
		this.optionDisplay = optionDisplay;
		this.description = description;
	}

	public String getOption() {
		return option;
	}

	public String getDescription() {
		return description;
	}

	public String getOptionDisplay() {
		return optionDisplay;
	}

}
