# Bad IP Detect - API

This API allows to detect bad IPs (such as VPNs and proxies), to retrieve information on an IP (ASN number, name of the Internet service provider, country, city etc.). You can compile the API yourself or download it directly here to import it into your projects.

API from https://ipdetector.info

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
