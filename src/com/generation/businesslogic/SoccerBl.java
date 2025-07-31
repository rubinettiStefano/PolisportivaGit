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

		SoccerTeam team = findByName(name);

		if(team==null)
			System.out.println("non trovato");
		else
			System.out.println(team.regroupByRole().get(role));
	}

	/**
	 * Chiedere utente nome di un team, stampare
	 * i giocatori di quel team non pronti
	 */
	public static void printFitness()
	{
		System.out.println("Inserisci nome team");
		String teamName = Console.readString();
		SoccerTeam team = findByName(teamName);
		if(team==null)
			System.out.println("non trovato");
		else
		{
			System.out.println("Giocatori non pronti");
			for(SoccerPlayer p : team.getPlayersNotReady())
				System.out.println(p);
		}
	}

	/**
	 * Se abbiamo un team con il nome passato
	 * lo restituisce, altrimenti restituisce null
	 */
	private static SoccerTeam findByName(String teamName)
	{
		SoccerTeam team= null;
		for(SoccerTeam t:teams)
			if(t.getName().equalsIgnoreCase(teamName))
				team = t;

		return team;
	}
}
