package com.mike.domain;

import com.mike.domain.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mike on 22.04.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Character.clueMessages.put("Scalpel", "...something was cutted last night");
        Character.clueMessages.put("Radio", "...some radio noise was heard last night");
        Character.clueMessages.put("Switchblade", "...someone used a blade last night");
        Character.clueMessages.put("Flamethrower", "...something was fired last night");
        Character.clueMessages.put("Pistol", "...shoots were heard last night");

        Character.characters.add(new Character("Blair", "Scalpel"));
        Character.characters.add(new Character("Nauls", "Radio"));
        Character.characters.add(new Character("Palmer", "Switchblade"));
        Character.characters.add(new Character("Childs", "Flamethrower"));
        Character.characters.add(new Character("Dr. Copper", "Scalpel"));
        Character.characters.add(new Character("Bennings", "Pistol"));
        Character.characters.add(new Character("Norris", "Flamethrower"));
        Character.characters.add(new Character("Clark", "Switchblade"));
        Character.characters.add(new Character("Garry", "Pistol"));
        Character.characters.add(new Character("Fuchs", "Scalpel"));
        Character.characters.add(new Character("Windows", "Radio"));
        Character.characters.add(new Character("John", "Pistol"));

        Character.charactersCopy.addAll(Character.characters);
        int dayNumber = 1;
        while (true) {
            System.out.println(" DAY " + dayNumber);
            for (int i = 0; i < Character.characters.size(); i++) {
                System.out.println((i + 1) + " " + Character.characters.get(i).getName() + " " + "(" + Character.characters.get(i).getItem() + ") ");
            }
            if (Character.infectCharacter()) {
                break;
            }

            System.out.println();
            Character.showInfectedCharMessage();
            System.out.println();

            System.out.println("Choose someone to test: ");
            String test = reader.readLine();
            Character.checkCharacter(test);
            dayNumber++;

            System.out.flush();
        }


// - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    }
}