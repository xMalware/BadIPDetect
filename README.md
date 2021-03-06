# Bad IP Detect - API

This API allows to detect bad IPs (such as VPNs and proxies), to retrieve information from an IP address (ASN number, name of the Internet service provider, country, city etc.). You can compile the API yourself or [download it directly here](https://github.com/xMalware/BadIPDetect/releases/tag/1.0) to import it into your projects.

Using official Detect VPN API proxy : https://ipwarner.com

# Example
Here is an example with the free API key (limited to 1,000 requests per month)

```
BadIPDetectorAPI api = BadIPDetectorAPI.getInstance("free");
		
if (api.isBadIP("8.8.8.8"))
{
	System.out.println("8.8.8.8 is a Bad IP!");
}
else
{
	System.out.println("It's not a Bad IP!");
}
```

Here is an example with a paid key
```
BadIPDetectorAPI api = BadIPDetectorAPI.getInstance("d4dcd360c99c66ee66d4390f0bc2868e");
		
if (api.isBadIP("8.8.8.8"))
{
	System.out.println("8.8.8.8 is a Bad IP!");
}
else
{
	System.out.println("It's not a Bad IP!");
}
```

