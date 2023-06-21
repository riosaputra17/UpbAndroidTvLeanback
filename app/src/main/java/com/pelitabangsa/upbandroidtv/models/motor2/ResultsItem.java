package com.pelitabangsa.upbandroidtv.models.motor2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsItem{

	@SerializedName("details")
	private List<DetailsItem> details;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	public List<DetailsItem> getDetails(){
		return details;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}
}