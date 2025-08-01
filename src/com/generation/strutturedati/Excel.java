package com.generation.strutturedati;

import com.generation.library.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Excel
{
	public static void main(String[] args)
	{
//		ArrayList<HashMap<String,String>> excel = new ArrayList<>();
//		HashMap<String,String> riga1 = new HashMap<>();
//		riga1.put("studente","Zargon il Calcolatore");
//		riga1.put("materia","Alchimia Quantistica");
//		excel.add(riga1);
//		HashMap<String,String> riga2 = new HashMap<>();
//		riga2.put("studente","Luna Quasar");
//		riga2.put("materia","Volapük Storico");
//		excel.add(riga2);
//
//
//		String stampa = "Lo studente di nome "+excel.get(0).get("studente")+" ha dato esame di "+excel.get(0).get("materia");
//		System.out.println(stampa);

		ArrayList<HashMap<String,String>> excel = new ArrayList<>();

		FileReader lettore = new FileReader("data/csvs/excel.csv");
		String[] intestazione = lettore.readString().split(",");
		while (lettore.hasRow())
		{
			String[] splittata = lettore.readString().split(",");
			HashMap<String,String> mappa = new HashMap<>();
			for(int i=0;i<intestazione.length;i++)
				mappa.put(intestazione[i].toLowerCase(),splittata[i]);
			excel.add(mappa);
		}

		for(HashMap<String,String> riga: excel)
			if(riga.get("studente").equalsIgnoreCase("Ghignus il Disobbediente"))
				System.out.println(riga.get("insegnante"));
	}
}
