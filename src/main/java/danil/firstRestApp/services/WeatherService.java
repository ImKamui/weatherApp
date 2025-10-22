package danil.firstRestApp.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import danil.firstRestApp.dto.GeoPlaceDTO;
import danil.firstRestApp.dto.WeatherDTO;

@Service
public class WeatherService {

	private final RestTemplate restTemplate = new RestTemplate();
	
	public WeatherDTO getWeather(double latitude, double longitude)
	{
		String baseURL = "https://api.open-meteo.com/v1/forecast";
		
		String url = UriComponentsBuilder.fromHttpUrl(baseURL)
				.queryParam("latitude", latitude)
				.queryParam("longitude", longitude)
				.queryParam("current_weather", true)
				.queryParam("temperature_unit", "celsius")
				.toUriString();
		
		try
		{
			return restTemplate.getForObject(url, WeatherDTO.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<GeoPlaceDTO> geoCode(String city)
	{
		String baseUrl = "https://nominatim.openstreetmap.org/search";
		String encodedCity = java.net.URLEncoder.encode(city, java.nio.charset.StandardCharsets.UTF_8);
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
				.queryParam("q", encodedCity)
				.queryParam("format", "json")
				.queryParam("limit", 1)
				.toUriString();
		
		try
		{
			GeoPlaceDTO[] results = restTemplate.getForObject(url, GeoPlaceDTO[].class);
			return results != null ? java.util.Arrays.asList(results) : Collections.emptyList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
