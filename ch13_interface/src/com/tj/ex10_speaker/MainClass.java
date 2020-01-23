package com.tj.ex10_speaker;

public class MainClass {
	public static void main(String[] args) {
		IVolume sp = new Speaker(3);
		
		IVolume tv = new TV(10);
		
		IVolume[] iv = {sp, tv};
		
		for(IVolume tmp : iv) {
			tmp.volumeUp();
			tmp.volumeUp(10);
			tmp.volumeUp(11);
			
			tmp.volumeDown();
			tmp.volumeDown(10);
			tmp.volumeDown(20);
		}
	}
}
