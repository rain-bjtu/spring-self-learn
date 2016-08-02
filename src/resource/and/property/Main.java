package resource.and.property;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Remember to close any stream when don't use again.
 * The following codes don't close the stream, and this is a bad habit.
 * 
 * @author rain
 *
 */
public class Main {
	public static final String THIS_PATH = Main.class.getResource("").getPath();
	public static final String CONFIG_FILE = THIS_PATH + "app.properties";
	public static final InputStream INPUT = Main.class
			.getResourceAsStream("app.properties");

	public static void main(String[] args) {
		// new Main().testGetResource();
		// getJVMProperties();
		getProperties();
	}

	public void testGetResource() {

		System.out.println(Main.class.getResource("/").getPath());
		System.out.println(Main.class.getResource("/app.properties").getPath());
		System.out.println(Main.class.getResource("").getPath());
		System.out.println(Main.class.getResource("app.properties").getPath());
		System.out.println("-------------------");
		System.out.println(this.getClass().getResource("/").getPath());
		System.out.println(this.getClass().getResource("/app.properties")
				.getPath());
		System.out.println(this.getClass().getResource("").getPath());
		System.out.println(this.getClass().getResource("app.properties")
				.getPath());
		System.out.println("-------------------");
		System.out.println(Main.class.getClassLoader().getResource("")
				.getPath());
		System.out.println(Main.class.getClassLoader()
				.getResource("app.properties").getPath());
		System.out.println(Main.class.getClassLoader()
				.getResource("resource/and/property").getPath());
		System.out.println(Main.class.getClassLoader()
				.getResource("resource/and/property/app.properties").getPath());
	}

	public static void getJVMProperties() {
		Properties props = System.getProperties();
		props.list(System.out);
	}

	public static void getProperties() {
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream(CONFIG_FILE));
			// pps.load(INPUT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("rawtypes")
		Enumeration enum1 = pps.propertyNames();
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}

	static class TestProperties {
		public static String GetValueByKey(String filePath, String key) {
			Properties pps = new Properties();
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(
						filePath));
				pps.load(in);
				String value = pps.getProperty(key);
				System.out.println(key + " = " + value);
				return value;

			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		@SuppressWarnings("rawtypes")
		public static void GetAllProperties(String filePath) throws IOException {
			Properties pps = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			pps.load(in);
			Enumeration en = pps.propertyNames();

			while (en.hasMoreElements()) {
				String strKey = (String) en.nextElement();
				String strValue = pps.getProperty(strKey);
				System.out.println(strKey + "=" + strValue);
			}

		}

		public static void WriteProperties(String filePath, String pKey,
				String pValue) throws IOException {
			Properties pps = new Properties();
			InputStream in = new FileInputStream(filePath);
			pps.load(in);
			OutputStream out = new FileOutputStream(filePath);
			pps.setProperty(pKey, pValue);
			pps.store(out, "Update " + pKey + " name");
			out.close();
		}

		public static void main(String[] args) throws IOException {
			String value = GetValueByKey(CONFIG_FILE, "name");
			System.out.println(value);
			System.out.println("--------------");
			GetAllProperties(CONFIG_FILE);
			System.out.println("--------------");
			WriteProperties(CONFIG_FILE, "long", "212");
			GetAllProperties(CONFIG_FILE);
		}
	}
}
