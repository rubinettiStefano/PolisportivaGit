package com.generation.eccezioni;

import com.generation.library.Console;

public class Esempio1
{
	public static void main(String[] args)
	{
//		System.out.println("Dammi una stringa con 2 valori separati da virgole");
//		String csv = Console.readString();
//
//		//NullPointerException
//		//eccezione che viene propagata quando un metodo viene invocato su null
//		String[] splittato = csv.split(",");
//		//[0] paperino
//
//		System.out.println("Valori separati");
//		System.out.println(splittato[0]);
//		try
//		{
//			System.out.println(splittato[1]);
//		}
//		catch (RuntimeException e)
//		{
//			System.out.println("E sono finiti perchè non riesci a seguire le istruzioni date");
//		}
		while (true)
			try
			{
				System.out.println("Inserisci numero");
				String in = Console.readString();
				metodoCheStampa(in);
				return;
			} catch (RuntimeException e)
			{
				System.out.println("Maledetto rimetti");
			}

	}

	static void metodoCheStampa(String n)
	{
		int conv = Integer.parseInt(n);
		System.out.println(conv);
	}
}
