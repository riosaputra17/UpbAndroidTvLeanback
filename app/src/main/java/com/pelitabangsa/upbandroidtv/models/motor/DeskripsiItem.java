package com.pelitabangsa.upbandroidtv.models.motor;

import com.google.gson.annotations.SerializedName;

public class DeskripsiItem{

	@SerializedName("motor_poster")
	private String motorPoster;

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