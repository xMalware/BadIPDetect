package us.ipdetector.api;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

/**
 * 
 * API used: https://ipdetector.info
 * 
 * @author IPDetector
 *
 */
public class BadIPDetectorAPI
{

	// Application name (User agent)
	private final static String		APPLICATION_NAME	= "IPDetectorAPI";
	
	private static BadIPDetectorAPI instance;
	
	// API key
	private String	apiKey;
	private Gson		gson			= new Gson();
	
	public BadIPDetectorAPI(String apiKey)
	{
		this.apiKey = apiKey;
	}
	
	public IPDetectorObject getIPData(String ip)
	{
		// We get the source code
		final String sourceCode = fetchSourceCode(ip, apiKey);
		// If there is an error in the answer (e.g. rate limited)
		if (sourceCode.toLowerCase().contains("\"error\":"))
		{
			// Uncomment if you want to print the error
			// System.out.println(sourceCode);
			// So we return null
			return null;
		}
		// Deserialize data in an object
		return gson.fromJson(sourceCode, IPDetectorObject.class);
	}
	
	public boolean isBadIP(String ip)
	{
		return getIPData(ip).isBadIP();
	}
	
	/**
	 * Fetch the source code
	 * 
	 * @param link
	 * @param apiKey
	 * @return
	 */
	public static String fetchSourceCode(String ip, String apiKey) {
		// Try to
		try
		{
			// Set the user agent
			System.setProperty("http.agent", APPLICATION_NAME);
			// Create url
			final URL url = new URL("https://api.ipdetector.info/" + ip);
			// Do the connection
			final URLConnection con = url.openConnection();
			// Set the user agent
			con.setRequestProperty("User-Agent", APPLICATION_NAME);
			// Set API key
			con.setRequestProperty("API-Key", apiKey);
			// Get input stream
			final InputStream in = con.getInputStream();
			// Get the output stream
			final ByteArrayOutputStream result = new ByteArrayOutputStream();
			// Create a new buffer
			final byte[] buffer = new byte[1024];
			// Buffer length
			int length;
			// While the length isn't equal to -1.
			while ((length = in.read(buffer)) != -1)
			{
				// We write the data
				result.write(buffer, 0, length);
			}
			// Return the result in UTF-8
			return result.toString("UTF-8");
		}
		// Error case
		catch (Exception error)
		{
			// Print the error
			error.printStackTrace();
			// Return null
			return null;
		}
	}
	
	public static BadIPDetectorAPI getInstance()
	{
		// Get instance with the default API
		return getInstance("free");
	}

	public static BadIPDetectorAPI getInstance(String apiKey)
	{
		if (instance == null) return instance = new BadIPDetectorAPI(apiKey);
		return instance;
	}
	
	/**
	 * IP Detector object
	 * @author xMalware
	 */
	public class IPDetectorObject
	{

		// IP address
		public String	ip;
		// Hostname
		public String	hostname;
		// Country name
		public String	countryName;
		// Country ISO
		public String	countryIso;
		// Continent name
		public String	continentName;
		// Contient code
		public String	continentCode;
		// Postal code
		public String	postalCode;
		// Postal code
		public String	error;
		// City name
		public String	cityName;
		// Response time
		public long	responseTime;
		// ASN Id
		public int	asnId;
		// ASN name
		public String	asnName;
		// Organization
		public String	organization;
		// ISP
		public String	isp;
		// Is this a Good IP?
		// 0 = No (VPN/host provider/Proxy)
		// 1 = Yes
		public int	goodIp;
		
		public boolean isBadIP()
		{
			if (error != null && !error.isEmpty())
			{
				System.out.println("Error with IPDetector: " + error);
				return false;
			}
			// ip
			if (ip == null || ip.isEmpty())
			{
				System.out.println("Error with IPDetector. Please check your API key.");
				return false;
			}
			return goodIp == 0;
		}

	}
	
}
