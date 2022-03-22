package blog.panditmandar.code.timecalc.console;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.data.CsvDataReader;
import blog.panditmandar.code.timecalc.data.JsonDataReader;
import blog.panditmandar.code.timecalc.data.SourceReader;

@Component
public class ConsoleUtility implements ApplicationContextAware {

	@Autowired
	private ApplicationContext context;

	public void matchSingleArgValue(ConsoleManager csm, String argOption, String argValue) {
		Optional<String> optArgOption = Optional.ofNullable(argOption).filter(Predicate.not(String::isEmpty));
		if (optArgOption.isPresent()) {
			if (ConsoleMenu.DATA.getOption().equals(argOption)) {
				csm.setData(argValue);
			}
			if (ConsoleMenu.FILE.getOption().equals(argOption)) {
				csm.setFilePath(argValue);
			}
			if (ConsoleMenu.SOURCE_READER.getOption().equals(argOption)) {
				if (SourceReader.FORMAT.CSV.toString().equalsIgnoreCase(argValue)) {
					csm.setSourceReader(context.getBean(CsvDataReader.class));
				} else if (SourceReader.FORMAT.JSON.toString().equalsIgnoreCase(argValue)) {
					csm.setSourceReader(context.getBean(JsonDataReader.class));
				}
			}
			if (ConsoleMenu.VALUE_SEPERATOR.getOption().equals(argOption)) {
				if (SourceReader.VALUE_SEPERATOR.SPACE.toString().equalsIgnoreCase(argValue)) {
					csm.setValueSeperator(TimeValueSeperator.SPACE);
				} else if (SourceReader.VALUE_SEPERATOR.COLON.toString().equalsIgnoreCase(argValue)) {
					csm.setValueSeperator(TimeValueSeperator.COLON);
				}
			}
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = applicationContext;
	}
}
