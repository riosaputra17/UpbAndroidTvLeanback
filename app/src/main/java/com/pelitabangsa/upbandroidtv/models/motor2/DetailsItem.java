package com.pelitabangsa.upbandroidtv.models.motor2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailsItem{

	@SerializedName("motor_poster")
	private String motorPoster;

	@SerializedName("spesifikasi")
	private List<SpesifikasiItem> spesifikasi;

	@SerializedName("motor_bg")
	private String motorBg;

	@SerializedName("id")
	private int id;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("motor_model")
	private String motorModel;

	public String getMotorPoster(){
		return motorPoster;
	}

	public List<SpesifikasiItem> getSpesifikasi(){
		return spesifikasi;
	}

	public String getMotorBg(){
		return motorBg;
	}

	public int getId(){
		return id;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public String getMotorModel(){
		return motorModel;
	}
}