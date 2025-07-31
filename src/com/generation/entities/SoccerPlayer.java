package com.generation.entities;

//import static importa membri static da una classe facendo finta
//che siano della classe in cui siamo
//* si legge ALL

import static com.generation.library.Validator.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.StringJoiner;

//1- documentazione, decidere obiettivo della classe
//2 - dichiarazione proprietà, decidere che dati contiene
//3 - generazione codice generico, costruttori,getter/setter, toString
//4 - modifica setters per fare controlli
//5 - scrivere metodi specifici per fare calcoli aggiuntivi

/**
 * Rappresenta un singolo giocatore di calcio
 * Contiene sia informazioni anagrafiche che informazioni
 * riguardi il giuoco del calcio in se (ruolo, simili)
 */
public class SoccerPlayer
{
	//final significa costante, quando avete assegnato qualcosa
	//non è più modificabile
	//COSTANTI DI CLASSE
	public static final String[] ROLES = {"GOALKEEPER", "DEFENDER", "MIDFIELDER", "ATTACKER"};


	private String name, surname;
	//Java ha tante classi per gestire le date, la "migliore" si chiama LocalDate
	private LocalDate dob;//date of birth
	private String role;
	private String country;
	private Double height, weight;//m,kg

	//COSTRUTTORI
	//Decidere quali proprietà sono OBBLIGATORIE
	public SoccerPlayer()
	{
	}

	public SoccerPlayer(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}

	public SoccerPlayer(String name, String surname, LocalDate dob, String role, String country, Double height, Double weight)
	{
		setName(name);
		setSurname(surname);
		setDob(dob);
		setRole(role);
		setCountry(country);
		setHeight(height);
		setWeight(weight);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if (!validString(name, 2))
			throw new RuntimeException("Nome non valido");

		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		if (!validString(surname, 2))
			throw new RuntimeException("Cognome non valido");

		this.surname = surname;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	/**
	 * Accettiamo solo maggiorenni
	 */
	public void setDob(LocalDate dob)
	{
		if (!isOfAge(dob))
			throw new RuntimeException("No, solo maggiorenni");
		this.dob = dob;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		if (!isContained(role, ROLES))
			throw new RuntimeException("Ruolo non valido");

		this.role = role;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		if (!validString(country, 3, 26))
			throw new RuntimeException("Nazione non valida");

		this.country = country;
	}

	public Double getHeight()
	{
		return height;
	}

	public void setHeight(Double height)
	{
		if (!numberInRange(height, 1.0, 2.5))
			throw new RuntimeException("Altezza non valida");
		this.height = height;
	}

	public Double getWeight()
	{
		return weight;
	}

	public void setWeight(Double weight)
	{
		if (!numberInRange(weight, 30, 200))
			throw new RuntimeException("Peso non valido");
		this.weight = weight;
	}

	//metodi aggiuntivi
	public String technicalSheet()
	{
		StringBuilder builder = new StringBuilder("Player: ");
		builder.append(name).append(" ").append(surname).append(" - age: ").append(age());
		builder.append(" - ROLE: ").append(role);

		return builder.toString();
	}

	public int age()
	{
		LocalDate now = LocalDate.now();
		return dob.until(now).getYears();
	}

	public String toString()
	{
		return new StringJoiner(", ", SoccerPlayer.class.getSimpleName() + "[", "]")
				.add("name='" + name + "'")
				.add("surname='" + surname + "'")
				.add("dob=" + dob)
				.add("role='" + role + "'")
				.add("country='" + country + "'")
				.add("height=" + height)
				.add("weight=" + weight)
				.toString();
	}

	public double bmi()
	{
		return weight/(height*height);
	}
}
