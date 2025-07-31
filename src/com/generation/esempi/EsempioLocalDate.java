package com.generation.esempi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EsempioLocalDate
{
	static final int a=10;

	public static void main(String[] args)
	{

		//data con tre valori
		LocalDate data = LocalDate.of(1995,8,27);
		//potete usare il parse
		LocalDate altraData = LocalDate.parse("2020-03-05");//formato db yyyy-mm-dd es 5 marzo 2020

		LocalDate oggi = LocalDate.now();

		//possiamo confrontare due date con isAfter/before/equals
		if(data.isBefore(altraData))
		{
			//fai qualcosa
		}

		//estrapolazione di un singolo valore
		int soloAnno = data.getYear();

		LocalDate finePrenotazione = oggi.plusDays(10);

 	}
}
