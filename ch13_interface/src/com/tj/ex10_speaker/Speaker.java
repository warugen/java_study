package com.tj.ex10_speaker;

public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 20;
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	public Speaker(int volumelevel) {
		this.volumeLevel = volumelevel;
	}
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("지금 현재 스피커 볼륨이 최대치 "+SPEAKER_MAX_VOLUME+" 입니다.");
		} else {
			System.out.println("스피커 볼륨을 높여서 현재 볼륨이 " + volumeLevel+"입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if (volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("지금 현재 스피커 볼륨이 최대치 "+SPEAKER_MAX_VOLUME+" 입니다.");
		} else {
			System.out.println("스피커 볼륨을 "+level+"만큼 올려서 현재 볼륨이 "+volumeLevel+"입니다.");
		}

	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if ( volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("지금 현재 스피커 볼륨이 최소치 0 입니다.");
		} else {
			System.out.println("스피커 볼륨을 내려서 현재 볼륨이 " + volumeLevel+"입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("지금 현재 스피커 볼륨이 최소치 0입니다.");
		} else {
			System.out.println("스피커 볼륨을 "+level+"만큼 내려서 현재 볼륨이 "+volumeLevel+"입니다.");
		}
	}

}
