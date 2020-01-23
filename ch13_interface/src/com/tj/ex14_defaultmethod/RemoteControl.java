package com.tj.ex14_defaultmethod;

public interface RemoteControl {
	public int MAX_VOlUME = 10;
	public int MIN_VOLUME = 0;
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	// jdk 1.8부터 추가된 기능 default, static
	public default void mute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리");
		} else {
			System.out.println("무음 해제");
		}
	}
	
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
