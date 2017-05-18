package br.gov.pbh.prodabel.treinamento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AnimalBean {
	
	private List<Animal> animais;

	public List<Animal> getAnimais() {
		animais = new ArrayList<Animal>();
		animais.add(new Animal("Atreyo", "Cavalo"));
		animais.add(new Animal("Flipper", "Golfinho"));
		animais.add(new Animal("Lassie", "Cadela"));
		return animais;
	}

	public String getMessage(){
		return "Teste";
	}
	
}

