package com.generation.library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe con metodi static per i controlli generici sui tipi base di java
 */
public class Validator
{
	//OVERLOAD di metodo è una forma di polimorfismo, tante cose con stesso nome
	//ma forma diversa
	//avere metodi con stessa firma tranne i parametri
	//usato per creare diverse versioni di un metodo

	/**
	 * Semplice metodo che controlla non nullità non vuotezza della string
	 */
	public static boolean validString(String toCheck)
	{
		return toCheck!=null && !toCheck.isBlank();
	}

	/**
	 * minLength è la lunghezza minima ACCETTATA
	 */
	public static boolean validString(String toCheck,int minLength)
	{
		return validString(toCheck) && toCheck.length()>=minLength;
	}

	/**
	 * minLength è la lunghezza minima ACCETTATA
	 * maxLength è la lunghezza massima ACCETTATA
	 */
	public static boolean validString(String toCheck,int minLength,int maxLength)
	{
		return validString(toCheck,minLength) && toCheck.length()<=maxLength;
	}

	/**
	 * Mi da true se la data è oggi o prima
	 */
	public static boolean validDateNotFuture(LocalDate date)
	{
		return date!=null && !date.isAfter(LocalDate.now());
	}

	/**
	 * Mi da true se la data è quella di nascita di un maggiorenne
	 */
	public static boolean isOfAge(LocalDate date)
	{
		return date!=null && date.isBefore(LocalDate.now().minusYears(18));
	}

	/**
	 * Da true se s è presente nell'array arr
	 */
	public static boolean isContained(String s,String[] arr)
	{
		//converte array in HashSet
		HashSet<String> conv = new HashSet<>(Set.of(arr));
		return conv.contains(s);
	}

	/**
	 da true se val non è nullo ed è compreso tra min e max (inclusi)
	 */
	public static boolean numberInRange(Double val,double min,double max)
	{
		return val!=null && val>=min && val<=max;
	}
}


