package blog.panditmandar.code.timecalc.data;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonDataReader implements SourceReader {

	@Autowired
	Gson gson;

	@Override
	public String[] readSourceData(String sourceData) {
		// TODO Auto-generated method stub
		Type listType = new TypeToken<List<String>>() {
		}.getType();
		List<String> list = gson.fromJson(sourceData, listType);
		return list.toArray(new String[list.size()]);
	}

}
