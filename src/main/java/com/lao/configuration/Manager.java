package com.lao.configuration;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.text.WordUtils;

import com.lao.player.Player;
import com.lao.player.PlayerBA;
import com.lao.player.factory.PlayerFactory;

public class Manager {
	private static boolean goNoGo = true;
	private static Scanner userInput = new Scanner(System.in);
	private static String in;

	public static void main(String[]args){
		List<Player> players = PlayerFactory.generatePlayers();
		Map<String, Player> playerMap = PlayerBA.getPlayerMap(players);

		System.out.println("type 'q' to quit");userinput:
		while(goNoGo){
			
			//prompt name lookup
			System.out.println("Enter the name to look up");
			in = userInput.next();
			
			// anything other than Q can proceed into scope
			if(!in.equalsIgnoreCase("q")){
				String formatedName=WordUtils.capitalize(in);
			
				
				if(playerMap.containsKey(formatedName)){
					System.out.println(playerMap.get(formatedName).toString());
				}else{
					System.out.println("The player " + formatedName + " does not exist");
				}
				
			}if(in.equalsIgnoreCase("update")){
				System.out.println("update who?");
				String name = userInput.next();
				name = WordUtils.capitalize(name);
				
				if(playerMap.containsKey(name)){
					System.out.println("enter change in the form age|12 or status|2.2");
					String change = userInput.next();
					String key = change.substring(0, change.indexOf('|'));
					
					if(key.equalsIgnoreCase("age")){
						Integer i = new Integer(change.substring(change.indexOf('|')+1));
						playerMap.get(name).setAge(i);
					}else if(key.equalsIgnoreCase("status")){
						Double d = new Double(change.substring(change.indexOf('|')+1));
						playerMap.get(name).setStatusModifier(d);
					}
				}else{
					System.out.println("The player " + name + " does not exist");
				}
			}else{
				System.out.println("Thank you, exiting");
				goNoGo=false;
				continue userinput;
			}
		}
	}
}
