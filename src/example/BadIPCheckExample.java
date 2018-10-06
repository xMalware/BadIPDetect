package example;

import us.ipdetector.api.BadIPDetectorAPI;

public class BadIPCheckExample
{

	public static void main(String[] args)
	{
		// free = no api key => 1000 free request/month
		// replace 'free' by your API key.
		// you can find an API key on https://ipdetector.info
		
		BadIPDetectorAPI api = BadIPDetectorAPI.getInstance("free");
		
		if (api.isBadIP("8.8.8.8"))
		{
			System.out.println("8.8.8.8 is a Bad IP!");
		}
		else
		{
			System.out.println("It's not a Bad IP!");
		}
	}
	
}
