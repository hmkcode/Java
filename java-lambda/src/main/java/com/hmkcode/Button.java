package com.hmkcode;

public class Button {

	private OnClickListener onClickListener;
	private String name;

	public void click(){
		this.onClickListener.onClick(this);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OnClickListener getOnClickListener() {
		return onClickListener;
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}
	
	
	
}
