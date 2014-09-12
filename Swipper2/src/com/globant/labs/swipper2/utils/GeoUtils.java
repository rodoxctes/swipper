package com.globant.labs.swipper2.utils;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;

public class GeoUtils {

	public static JSONObject latLngToJson(LatLng latLng) {
		JSONObject jsonObject = new JSONObject();
			
		try {
			jsonObject.put("lat", latLng.latitude);
			jsonObject.put("lng", latLng.longitude);
		} catch (JSONException e) {	}
				
		return jsonObject;
	}
	
	public static LatLng latLngFromMap(Map<String, ? extends Object> map) {
		return new LatLng(
				(Double) map.get("lat"),
				(Double) map.get("lng"));
	}
	
}
