package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private Pronostico pronostico; 
	private int N; 
	private List<Risultato> soluzione;
	
	
	
	
	
	//qui implemento la ricerca delle soluzioni
	/*
	 * Il livello di ricorsione indica il numero di partita che sto 
	 * considerando.
	 * livello 0-1 sono già state decise
	 * la partita di indice livello la devo decidere io
	 * le partite da +1 in poi le decideranno 
	 * le procedure ricorsive sottostanti
	 * 
	 * SOLUZIONE PARZIALE: insieme di RisultatoPartita di lunghezza pari 
	 * al livello
	 * 
	 * Soluzione totale: ho già gli N risultati
	 * 
	 * Condizione di terminazione: Livello ==N
	 * 
	 * Generazione delle soluzioni del livello: provando tutti i
	 * pronostici definiti per quel livello
	 * 
	 */
	
	
	public List<Risultato> cerca(Pronostico pronostico) {
		
		this.pronostico=pronostico; 
		this.N=pronostico.size();
		
		List<RisultatoPartita> parziale = new ArrayList<>();
		int livello =0; 
		
		this.soluzione=new ArrayList<Risultato>();
		
		ricorsiva(parziale, livello);
		
		return soluzione;
		
	}
	
	
	/*
	 * La funzione ricorsiva è:ricorsiva(soluzione parziale,livello)
	 */
	
	private void ricorsiva(List<RisultatoPartita> parziale, int livello) {
		
		//caso terminale??
		//N è la lunghezza del pronostico
		if(livello==N) {
			//questa soluzione parziale è la soluzione completa
			//System.out.println(parziale);
			//TODO: restituire al chiamante
			this.soluzione.add( new Risultato(parziale));
			
		} else {
			
			//caso generale
			
			//[parziale da 0 a livello-1][livello][livello+1 in poi]
			//devo considerare solo la parte livello
			
			PronosticoPartita pp= pronostico.get(livello);
			//pp sono i sottoproblemi da provare 
			
			for(RisultatoPartita ris: pp.getRisultati()) {
				//provo a mettere 'ris' nella posizione 'livello'
				//della sol. parziale
				
				//costruzione soluzione parziale (sottoproblema)
				parziale.add(ris);
				//chiamata ricorsiva
				//aggiorna 
				ricorsiva(parziale, livello+1);
				//backtracking
				//tolgo l'ultimo che ho messo
				parziale.remove(parziale.size()-1);
				
			}
		}
	}
	
	


}
