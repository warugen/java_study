package com.tj.ex6_boxorrect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;
	
	public BoxOrRect() {}
	
	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		this.depth = 0;
	}
	
	public void calVolume() {
		if(depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		}
	}
	
	
}
