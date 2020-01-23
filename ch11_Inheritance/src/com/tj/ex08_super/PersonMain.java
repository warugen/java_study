package com.tj.ex08_super;

public class PersonMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		papa.intro();
		
		Person mom = new Person("엄마곰", "날씬해");
		mom.intro();
		
		Baby baby1 = new Baby();
		baby1.setName("아기곰1");
		baby1.setCharacter("귀엽다");
		baby1.intro();
		Baby baby2 = new Baby("아기곰2", "너무귀여워");
		baby2.intro();
	}
}
