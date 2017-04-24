package com.mike.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by mike on 22.04.2017.
 */
public class Character {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Character> characters = new ArrayList<Character>();
    static ArrayList<Character> charactersCopy = new ArrayList<Character>();

    static LinkedList<Character> infected = new LinkedList<Character>();

    static Map<String, String> clueMessages = new HashMap<String, String>();


    private String name;
    private String item;

    public Character(String name, String item) {
        this.name = name;
        this.item = item;
    }

    public static boolean infectCharacter() {
        int i = (int) (Math.random() * charactersCopy.size());
        infected.addLast(charactersCopy.get(i));
        charactersCopy.remove(i);
        if (infected.size() == 5) {
            System.out.println("TOO MUCH GUYS ARE INFECTED!");
            System.out.println("G A M E    O V E R");
            return true;
        }
        if (characters.size() == 7) {
            System.out.println("THE STRONGEST GUYS SURVIVED AND ANNIHILATED INFESTED BASTARDS. YOU WON!");
            return true;
        }
        return false;
    }


    public static void showInfectedCharMessage() {
        for (Map.Entry<String, String> map : clueMessages.entrySet())
            if (infected.getLast().getItem().equals(map.getKey())) {
                System.out.println(map.getValue());
            }
    }

    public static void checkCharacter(String s) throws IOException {
        for (int i = 0; i < infected.size(); i++) {
            if (infected.get(i).getName().equals(s)) {
                for (int j = 0; j < characters.size(); j++) {
                    if (characters.get(j).getName().equals(s)) {
                        characters.remove(j);
                    }
                    for (int k = 0; k < charactersCopy.size(); k++) {
                        if (charactersCopy.get(k).getName().equals(s)) {
                            charactersCopy.remove(k);
                        }
                    }
                }
                System.out.println(infected.get(i).getName() + " was infected! Team has burned that bastard!");
                infected.remove(i);
                System.out.println();
                System.out.println();
                System.out.println("Press ENTER to continue...");
                reader.readLine();
                break;
            } else {
                System.out.print(s +" is clean, keep your eyes peeled!");
                System.out.println();
                System.out.println();
                System.out.println("Press ENTER to continue...");
                reader.readLine();
                break;
            }
        }

    }


    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }
}


