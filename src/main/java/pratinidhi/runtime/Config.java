package pratinidhi.runtime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

public class Config implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Using
	static long bind_timeout=-10000;
	static int[] ports = {5001,7885,6524};
	
	
	static String mode="server";
	 
	
	static boolean enableANSIColor=true;
	static boolean printSocketComunication=true;
	
	//Methods
	public static void save(String configFile) throws FileNotFoundException, IOException
	{
		Properties properties=new Properties();
		properties.setProperty("config.mode", Config.mode);
		properties.setProperty("config.ports", ""+Arrays.toString(Config.ports));
		
		properties.setProperty("config.bind_timeout", ""+Config.bind_timeout);
		properties.setProperty("config.logging.enableANSIColor",""+Config.enableANSIColor);
		properties.setProperty("config.logging.printSocketComunication",""+Config.printSocketComunication);
		
		properties.store(new FileOutputStream(configFile),"Properties");
		
		
	}
	public static void load(String configFile) throws IOException
	{
		Properties properties=new Properties();
		properties.load(new FileInputStream(configFile));
		Config.mode=properties.getProperty("config.proxy_part_type", Config.mode);
		Config.ports=Arrays.stream(properties.getProperty("config.ports", Arrays.toString(Config.ports)).replace('[', ' ').replace(']', ' ').replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
		
		Config.bind_timeout=Long.parseLong(properties.getProperty("config.bind_timeout", ""+Config.bind_timeout));
		Config.enableANSIColor=Boolean.parseBoolean(properties.getProperty("config.logging.enableANSIColor", ""+Config.enableANSIColor));
		Config.printSocketComunication=Boolean.parseBoolean(properties.getProperty("config.logging.printSocketComunication", ""+Config.printSocketComunication));
		
		properties.store(new FileOutputStream(configFile),"Properties");
	}
}
