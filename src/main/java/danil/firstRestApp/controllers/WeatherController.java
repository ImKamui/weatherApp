package danil.firstRestApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import danil.firstRestApp.dto.GeoPlaceDTO;
import danil.firstRestApp.dto.WeatherDTO;
import danil.firstRestApp.services.WeatherService;
import jakarta.servlet.http.HttpSession;

@Controller
public class WeatherController {

	
	private final WeatherService weatherService;
	
	@Autowired
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GetMapping("/")
	public String redirector()
	{
		return "redirect:/weather";
	}
	
	@GetMapping("/weather")
	public String showWeatherPage(@RequestParam(required = false) String cityName, Model model, HttpSession session)
	{
		WeatherDTO weatherData = null;
		String errorMessage = null;
		
		if (cityName != null && !cityName.trim().isEmpty())
		{
			List<GeoPlaceDTO> geoPlace = weatherService.geoCode(cityName);
			
			if (geoPlace.isEmpty())
			{
				errorMessage = "Город не найден: " + cityName;
			}
			else
			{
				GeoPlaceDTO result = geoPlace.get(0);
				double lat = result.getLat();
				double lon = result.getLon();
				String displayName = result.getDisplayName();
				
				try
				{
					weatherData = weatherService.getWeather(lat, lon);
				}
				catch (Exception e)
				{
					errorMessage = "Ошибка короче";
				}
			}
		}
		model.addAttribute("weatherData", weatherData);
		model.addAttribute("errorMessage", errorMessage);
		
		return "weather";
	}
}
