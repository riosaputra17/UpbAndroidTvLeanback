package com.pelitabangsa.upbandroidtv.models.motor2;

import com.google.gson.annotations.SerializedName;

public class SpesifikasiItem{

	@SerializedName("image")
	private String image;

	@SerializedName("desc_spec")
	private String descSpec;

	@SerializedName("title_spec")
	private String titleSpec;

	public String getImage(){
		return image;
	}

	public String getDescSpec(){
		return descSpec;
	}

	public String getTitleSpec(){
		return titleSpec;
	}
}