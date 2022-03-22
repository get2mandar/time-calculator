package blog.panditmandar.code.timecalc;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import blog.panditmandar.code.timecalc.console.ConsoleManager;
import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.data.ArgumentTimeDataRetriever;
import blog.panditmandar.code.timecalc.process.TimeCalculationByTimeDivide;

@SpringBootApplication
public class TimeCalculatorApplication implements CommandLineRunner {

	@Autowired
	ConsoleManager csm;

	public static void main(String[] args) {
		SpringApplication.run(TimeCalculatorApplication.class, args);
	}

	@Bean
	public Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	public void run(String... args) throws Exception {
		clearConsole();

		csm.collectArguments(args);

//		csv-space - args[0] = "19h 32m 42s,16h 6m 15s,11h 35m 35s,5h 11m 48s";
//		csv-colon - args[0] = "19h:32m:42s,16h:6m:15s,11h:35m:35s,5h:11m:48s";
//		json-space - args[0] = "['19h 32m 42s','16h 6m 15s','11h 35m 35s','5h 11m 48s']";

		ArgumentTimeDataRetriever retriever = new ArgumentTimeDataRetriever(csm.getData(), csm.getSourceReader(),
				csm.getValueSeperator());
		TimeCalculationByTimeDivide tcp = new TimeCalculationByTimeDivide(retriever);

		SingleTime totalTime = tcp.getTotalTime();
		System.out.println("-----------------");
		System.out.println(totalTime);
		System.out.println("-----------------");
		System.out.println(totalTime.toSimpleString());

	}

	private void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
			System.err.println("clearConsole: " + ex.getMessage());
		}
	}

}
