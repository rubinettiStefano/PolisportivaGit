package com.generation.businesslogic;

import com.generation.entities.SoccerPlayer;

import java.time.LocalDate;
import java.util.Arrays;

public class EsempioAlchimia
{
	public static void main(String[] args)
	{
		//Abbiamo un array di stringhe csv con diversi dati
		//vogliamo trovare la Persona con nome e cognome più lungo
//		String[] arr =
//				{
//						"Alessandro,Rubinetti,31",
//						"Luca,Rossi,25",
//						"Giulia,Bianchi,30",
//						"Marco,Verdi,28",
//						"Elena,Neri,22",
//						"Francesco,Romano,35",
//						"Sara,Conti,27",
//						"Davide,Greco,33",
//						"Chiara,Esposito,26",
//						"Martina,Ferrari,24"
//				};

//		int[] lunghezze = new int[arr.length];
//
//		for(int i=0;i<arr.length;i++)
//		{
//			String riga = arr[i];
//			String[] rigaSplittata = riga.split(",");
//			//[0] = Luca
//			//[1] = Rossi
//			//[2] = 25
//			String riunita=rigaSplittata[0]+rigaSplittata[1];
//			//LucaRossi
//			int lunghezza = riunita.length();
//			//9
//			lunghezze[i] = lunghezza;
//		}
//
//		Arrays.sort(lunghezze);
//
//		int maggiore = lunghezze[lunghezze.length-1];
//		System.out.println(maggiore);
//

		String[] arr =
				{
						//0          1        2
						"Alessandro,Rubinetti,31",
						"Luca,Rossi,25",
						"Giulia,Bianchi,30",
						"Marco,Verdi,28",
						"Elena,Neri,22",
						"Francesco,Romano,35",
						"Sara,Conti,27",
						"Davide,Greco,33",
						"Chiara,Esposito,26",
						"Martina,Ferrari,24"
				};
		String classe ="JAVITA"+(Integer.parseInt((new SoccerPlayer(
				"S"+'T'+'E'+"fano",
				arr[0].split(",")[1],
				LocalDate.of(Integer.parseInt("199"+arr[1].charAt(arr[1].length()-1)),8,27)
		).getDob().getYear()+"").charAt(1)+"")+138);
		String classe2="JAVITA147";
		System.out.println(classe);
	}
}
