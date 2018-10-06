# Bad IP Detect - API

This API allows to detect bad IPs (such as VPNs and proxies), to retrieve information on an IP (ASN number, name of the Internet service provider, country, city etc.). You can compile the API yourself or download it directly here to import it into your projects.

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

## Configuration

Configuration is also very simple. You have a config.json file in the ZIP archive (if you download from binaries) that you can configure very easily, with very few variables :

 - **hostname** : The hostname or IP of the TeamSpeak server you are running
 - **queryPort** : The TeamSpeak server query port (10011 by default)
 - **queryPassword** : The TeamSpeak server query password
 - **virtualServerId** : The virtual server ID (1 by default)
 - **nick** : The TeamSpeak bot name
 - **ipDetectorApiKey** : The API key of the service to detect VPNs. If you do not yet have a key, you can create one at https://ipdetector.info by registering.
The free offer can handle up to 30 requests per minute and may be sufficient for small/medium TeamSpeak servers, otherwise there are paid offers at very affordable prices.
- **banIdentity** : Ban TeamSpeak identity of the user who connects to the TeamSpeak server (default: false)
- **banIp** : Ban TeamSpeak IP of the user who connects to the TeamSpeak server (default: true)
- **banReason** : The ban reason
