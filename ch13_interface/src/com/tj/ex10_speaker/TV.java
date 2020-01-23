package com.tj.ex10_speaker;

public class TV implements IVolume{
	private final int TV_MAX_VOLUME = 30;
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려서 현재 볼륨은 "+volumeLevel+"입니다.");
		} else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못했습니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if ( (volumeLevel + level) <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨을 "+level+"만큼 올려서 현재 볼륨은 "+volumeLevel+"입니다.");
		} else {
			int tmpLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못올리고 "+tmpLevel+"만큼 올려서 최대치 "+TV_MAX_VOLUME+"입니다.");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1만큼 내려서 현재 볼륨은 "+volumeLevel+"입니다.");
		} else {
			System.out.println("TV 볼륨이 최소치여서 내리지 못했습니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if ( (volumeLevel - level) > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 "+level+"만큼 내려서 현재 볼륨은 "+volumeLevel+"입니다.");
		} else {
			int tmpLevel = volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못내리고 "+tmpLevel+"만큼 내려서 최소치 입니다.");
		}
	}

}
