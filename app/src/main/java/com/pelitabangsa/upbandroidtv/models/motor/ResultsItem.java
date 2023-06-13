package com.pelitabangsa.upbandroidtv.models.motor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsItem{

	@SerializedName("id")
	private int id;

	@SerializedName("deskripsi")
	private List<DeskripsiItem> deskripsi;

	@SerializedName("title")
	private String title;

	@SerializedName("details")
	private List<DetailsItem> details;

	public int getId(){
		return id;
	}

	public List<DeskripsiItem> getDeskripsi(){
		return deskripsi;
	}

	public String getTitle(){
		return title;
	}

	public List<DetailsItem> getDetails(){
		return details;
	}
}