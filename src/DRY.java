import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class DRY {
	public static void main(String[] args) {
		String functionType = "";
		if (args.length > 0) {
			functionType = args[0];
		}

		if(functionType.equals("d")) {
			dictionary(args[1]);
		} else if(functionType.equals("rtf")){
			rtfLog2JSON(args[1]);
		}

	}

	/*
		convert rtf log to JSON 
		refer to rtfLogJSONSample.json
	*/
	private static void rtfLog2JSON(String filePath){
		filePath = "C:\\Users\\ldai3\\OneDrive\\Desktop\\nodesoutput_20220428";
		String outputJSON = "";
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fileInputStream);	
			BufferedReader buffer = new BufferedReader(isr);

			System.out.println(splitStr(buffer.readLine())[1]);
			System.out.println(buffer.readLine());
			System.out.println(buffer.readLine());


		} catch (Exception e) {
			System.out.printf(e.getMessage());
		}

	}

	/* 
		split string by whitespace and return array
	*/
	private static String[] splitStr(String s) {
		return s.split("\\s+");
	}

	/* 
		search word definition
	*/
	private static void dictionary(String word) {
		String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
		try 
		{
			URL url = new URL(urlStr);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader buffer = new BufferedReader(isr);	// this does not work		
			System.out.printf(buffer.readLine());

			// TODO: JSON parser
			// look for a lib to parse JSON response
		} 
		catch (Exception e) {
			System.out.printf(e.getMessage());
		}
	}
}