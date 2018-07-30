package basicConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemLocations {

	public Properties getConfigLocation()

	{
		Properties prop = new Properties();
		InputStream input = null;

		try {	

			input = new FileInputStream("conf/config.properties");
			prop.load(input);
		} catch (IOException ex) {
			System.out.print("wrong file locaton");
			ex.printStackTrace();
		} 
		return prop;
	}


}

