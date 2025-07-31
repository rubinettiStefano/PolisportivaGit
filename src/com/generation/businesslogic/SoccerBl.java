package com.generation.businesslogic;

import com.generation.entities.SoccerPlayer;
import com.generation.entities.SoccerTeam;
import com.generation.library.Console;

import java.util.ArrayList;


/**
 * Contiene tutti i sottoprogrammi e le proprietà static che mettevamo nella classe di avvio
 * solo ciò che riguarda il calcio
 */
public class SoccerBl
{
	private final static String[] TEAMS_NAME = {"dry","gigo"};
	private static ArrayList<SoccerTeam> teams = new ArrayList<>();

	//blocco inizializzazione static -> pezzettino di codice avviato quando viene creata la classe all'avvio
	//metodo init autorichiamato
	static
	{
		for(String name:TEAMS_NAME)
		{
			TeamReader reader = new TeamReader(name);
			teams.add(reader.readTeam());
		}
	}

	public static void printAll()
	{
		for (SoccerTeam t:teams)
			System.out.println(t);
	}

	public static void printByTeamNameAndRole()
	{
		System.out.println("Dammi nome team");
		String name = Console.readString();
		System.out.println("Dammi ruolo");
		String role = Console.readString();

		SoccerTeam team= null;
		for(SoccerTeam t:teams)
			if(t.getName().equalsIgnoreCase(name))
				team = t;

		if(team==null)
			System.out.println("non trovato");
		else
			System.out.println(team.regroupByRole().get(role));
	}

}
