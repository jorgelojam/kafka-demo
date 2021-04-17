package ec.jtux.kafkademo.deserializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.jtux.kafkademo.pojo.CustomObject;

public class CustomDeserializer implements Deserializer<CustomObject> {

	public static Gson gson = new GsonBuilder().create();

	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}

	public CustomObject deserialize(String topic, byte[] data) {
		CustomObject retObj = null;
		if (null != data) {
			String json = new String(data);
			retObj = gson.fromJson(json, CustomObject.class);
		}
		return retObj;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

}
