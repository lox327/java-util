import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		GetPropValues properties = new GetPropValues();
		
		System.out.println(properties.getProp("user"));
		System.out.println(properties.getProp("password"));

	}

}
