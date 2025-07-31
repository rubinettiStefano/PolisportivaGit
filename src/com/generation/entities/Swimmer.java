package com.generation.entities;

import java.time.LocalTime;

/**
 * Un singolo nuotatore, non abbiamo team di nuoto
 * Contiene le informazioni sia anagrafiche sia agonistiche
 * In particolare mettiamo:
 * Nome - Cognome - Data Di Nascita - Nazionalità (come per il player)
 * specialty - (Deve essere uno stile + una distanza, esempio "Butterfly 50m")
 * gli stili possibili sono "Freestyle,Butterfly,Backstroke"
 * le distanze possibili sono 50,100,200,400,1000,5000 m
 * controllate che la specialty sia corretta (con .split(" ") dividete stile e distanza
 *
 * infine deve avere un LocalTime come personalRecord (funziona uguale alle date)
 */
public class Swimmer
{

	private LocalTime personalRecord;
}
