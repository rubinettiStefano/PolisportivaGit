package com.generation.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Classe aggregatrice di SoccerPlayer, conterrà una lista di player
 * più le informazioni riguardanti il team stesso, come nome, locazione,
 * budget, ecc...
 * Fornisce i metodi per lavorare sulla lista o ottenere dati aggregati
 * su di essa
 */
public class SoccerTeam
{
	private static final int MAX_PLAYERS = 20;

	private String name,division;//proprietà specifiche
	private String formation;//"n-n-n" "4-4-2" 4 difensori 4 centrocampisti 2 attaccanti
	private ArrayList<SoccerPlayer> players = new ArrayList<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDivision()
	{
		return division;
	}

	public void setDivision(String division)
	{
		this.division = division;
	}

	public String getFormation()
	{
		return formation;
	}

	//4-4-2
	public void setFormation(String formation)
	{
		String[] splitted = formation.split("-");
		if(splitted.length!=3)
			throw new RuntimeException("formazione formattata male");

		int[] form = formationAsNumbers(splitted);

		int somma = 0;

		for(int i:form)
			if(i<1||i>8)
				throw new RuntimeException("valori del modulo non validi");
			else
				somma+=i;

		if(somma!=10)
			throw new RuntimeException("numero totale giocatori non valido");

		this.formation = formation;
	}

	private int[] formationAsNumbers(String[] splitted)
	{
		int[] res = new int[3];
		for(int i=0;i<3;i++)
			res[i] = Integer.parseInt(splitted[i]);

		return res;
	}

	public ArrayList<SoccerPlayer> getPlayers()
	{
		return players;
	}

	public void addPlayer(SoccerPlayer p)
	{
		if(p==null || players.contains(p) || players.size()>=20)
			throw new RuntimeException("Non accettabile");
		players.add(p);
	}

	public void removePlayer(SoccerPlayer p)
	{
		players.remove(p);
	}


	public boolean isReadyToPlay()
	{
		HashMap<String,Integer> numberPerRole = new HashMap<>();
		int[] form = formationAsNumbers(formation.split("-"));
		numberPerRole.put(SoccerPlayer.ROLES[0], 1);
		numberPerRole.put(SoccerPlayer.ROLES[1], form[0]);
		numberPerRole.put(SoccerPlayer.ROLES[2], form[1]);
		numberPerRole.put(SoccerPlayer.ROLES[3], form[2]);
		//PORTIERE=1,DIFENSORE=4,CENTRO=4,ATK=2
		//keyset -> [PORTIERE,DIFENSORE,CENTRO,ATK]
		//SCORRO IL KEYSET DELLA PRIMA MAPPA
		HashMap<String,ArrayList<SoccerPlayer>> playersPerRole=regroupByRole();

		for(String role : numberPerRole.keySet())
			if(numberPerRole.get(role)>playersPerRole.get(role).size())
				return false;

		return true;
	}

	public HashMap<String,ArrayList<SoccerPlayer>> regroupByRole()
	{
		HashMap<String,ArrayList<SoccerPlayer>> res = new HashMap<>();

		for(SoccerPlayer p : players)
			if(res.containsKey(p.getRole()))
			{
				//1 - Estraggo dalla mappa lista con chiave ruolo del giocatore
				ArrayList<SoccerPlayer> giocatoriConStessoRuolo = res.get(p.getRole());
				//2 aggiungo giocatore alla lista dei suoi colleghi
				giocatoriConStessoRuolo.add(p);
				//res.get(p.getRole()).add(p);
			}
			else
			{
				ArrayList<SoccerPlayer> giocatoriConStessoRuolo = new ArrayList<>();
				giocatoriConStessoRuolo.add(p);
				res.put(p.getRole(),giocatoriConStessoRuolo);
			}

		return res;
	}

	public String toString()
	{
		return new StringJoiner(", ", SoccerTeam.class.getSimpleName() + "[", "]")
				.add("name='" + name + "'")
				.add("division='" + division + "'")
				.add("players=" + players)
				.toString();
	}

	public ArrayList<SoccerPlayer> getPlayersNotReady()
	{
		ArrayList<SoccerPlayer> res = new ArrayList<>();

		for(SoccerPlayer p : players)
			if(p.bmi()>25)
				res.add(p);

		return res;
	}
}
