import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;

public class DRY {
	public static void main(String[] args) {
		String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/hello";
		try 
		{
			URL url = new URL(urlStr);
			InputStream is = url.openStream();
			BufferedReader buffer = new BufferedReader(is);			
			System.out.printf(buffer.toString());
		} 
		catch (Exception e) {

		}
	}
}