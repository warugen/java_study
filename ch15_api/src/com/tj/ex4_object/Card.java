package com.tj.ex4_object;
// ♥♠♣◆ A(1), 2~10, 11,12,13
public class Card {
	private char kind;	// ♥♠♣◆ 
	private int num;	//
	
	// Card c1 = new Card('♥',2);
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		// 선택하신 카드는 ♥2 입니다.
		return "선택하신 카드는 " + kind + num + "입니다.";
	}
	
	@Override
	public boolean equals(Object obj) {
		// 같다, 다르다
		if (obj != null && obj instanceof Card) {
			return ((this.kind == ((Card) obj).kind) && (this.num == ((Card)obj).num));
		} else {
			return false;
		}
	}
	
}
