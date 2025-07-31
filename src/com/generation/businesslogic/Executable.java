package com.generation.businesslogic;

import com.generation.entities.SoccerPlayer;
import com.generation.library.Console;
/**
 * Contenere il ciclo principale dentro il metodo main + help per i comandi
 */
public class Executable
{

	public static void main(String[] args)
	{

		String cmd;
		help();
		do
		{
			System.out.println("Inserisci comando");
			cmd = Console.readString().toLowerCase();//metto l'input in minuscolo

			switch (cmd)
			{
				case "printeams" 		-> SoccerBl.printAll();
				case "printrole" 		-> SoccerBl.printByTeamNameAndRole();
				case "help"            -> help();
				case "quit"            -> System.out.println("BYE BYE");
				default                -> System.out.println("Comando non valido");
			}

		}while (!cmd.equals("quit"));
	}

	private static void help()
	{
	}


}
