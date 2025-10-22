package danil.firstRestApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPlaceDTO {

	
	private String name;
	
	private double lat;
	
	private double lon;
	
	@JsonProperty("display_name")
	private String displayName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
