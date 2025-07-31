package com.generation.businesslogic;

import com.generation.entities.SoccerPlayer;
import com.generation.entities.SoccerTeam;

import com.generation.library.FileReader;

import java.time.LocalDate;

/**
 * Versione specializzata nella lettura di team da csv
 * DESIGN PATTERN -> ADAPTER
 */
public class TeamReader
{
	//HA COME PROPRIETÀ LA VERISIONE GENERICA
	private FileReader reader;

	private SoccerTeam team;

	public TeamReader(String teamName)
	{
		//leggo dati del team specifici
		reader = new FileReader("data/soccer/"+teamName+"/team.csv");

		//creo team vuoto
		team = new SoccerTeam();

		//butto intestazione del csv
		reader.readString();
		//leggo riga del csv e la splitto subito
		String[] splitted = reader.readString().split(",");
		//uso i valori della riga per riempire i campi del team appena creato
		team.setName(splitted[0]);
		team.setDivision(splitted[1]);
		team.setFormation(splitted[2]);
		reader.close();//chiudo il lettore perchè ho finito di leggere il file

		//leggo dati dei giocatori
		reader = new FileReader("data/soccer/"+teamName+"/players.csv");
		//butto intestazione
		reader.readString();
		//vado avanti fin quando non finisce il file
		while(reader.hasRow())
		{
			//leggo riga e la splitto
			String[] playerData = reader.readString().split(",");
			//creo nuovo giocatore passando i valori di quella riga in ordine corretto
			SoccerPlayer p = new SoccerPlayer();
			p.setName(playerData[0]);
			p.setSurname(playerData[1]);
			p.setDob(LocalDate.parse(playerData[2]));
			p.setRole(playerData[3]);
			p.setCountry(playerData[4]);
			p.setHeight(Double.parseDouble(playerData[5]));
			p.setWeight(Double.parseDouble(playerData[6]));
			//lo aggiungo ai giocatori del team
			team.addPlayer(p);
		}
	//quando ho finito chiudo
		reader.close();
	}

	public SoccerTeam readTeam()
	{
		return team;
	}

}
