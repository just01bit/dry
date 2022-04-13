import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DRY {
	public static void main(String[] args) {
		String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/" + args[0];
		try 
		{
			URL url = new URL(urlStr);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader buffer = new BufferedReader(isr);	// this does not work		
			System.out.printf(buffer.readLine());

			// TODO: JSON parser
		} 
		catch (Exception e) {
			System.out.printf(e.getMessage());
		}
	}
}