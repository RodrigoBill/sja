package br.com.sja.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Segmento {

	private int segmento;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataSegmento;
	
	private String origem;
	private String destino;
	private String voo; 
	private String cia;
	private String classe;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar horaSaida;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar horaChegada;
	
	public int getSegmento() {
		return segmento;
	}
	public void setSegmento(int segmento) {
		this.segmento = segmento;
	}
	public Calendar getDataSegmento() {
		return dataSegmento;
	}
	public void setDataSegmento(Calendar dataSegmento) {
		this.dataSegmento = dataSegmento;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getVoo() {
		return voo;
	}
	public void setVoo(String voo) {
		this.voo = voo;
	}
	public String getCia() {
		return cia;
	}
	public void setCia(String cia) {
		this.cia = cia;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public Calendar getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
	}
	public Calendar getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(Calendar horaChegada) {
		this.horaChegada = horaChegada;
	}
	public String getLocalizador() {
		return Localizador;
	}
	public void setLocalizador(String localizador) {
		Localizador = localizador;
	}
	private String Localizador;
	
	
}
