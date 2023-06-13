package com.pelitabangsa.upbandroidtv.models.motor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MotorModel {

	@SerializedName("results")
	private List<ResultsItem> results;

	public List<ResultsItem> getResults(){
		return results;
	}
}