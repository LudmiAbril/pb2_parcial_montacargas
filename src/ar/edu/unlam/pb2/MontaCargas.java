package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class MontaCargas {
	private Double peso_maximo;
	private ArrayList<Carga> cargas = new ArrayList<Carga>();
	private ArrayList<Carga> cargasCompletadas = new ArrayList<Carga>();

	public MontaCargas(Double peso_max) {
		this.peso_maximo = peso_max;
	}

	public Double getPeso_maximo() {
		return peso_maximo;
	}

	public Boolean cargar(Carga carga) throws CargaInexistenteException {
		if(carga==null) {
			throw new CargaInexistenteException();
		}
		
		if (carga.getPeso() <= peso_maximo && carga.getPeso() + getPesoActual() <= peso_maximo) {
			return cargas.add(carga);
		}
		return false;

	}

	public Double getPesoActual() {
		Double total = 0.0;
		for (Carga c : cargas) {
			total += c.getPeso();
		}
		return total;
	}

	public Double getPesoPromedioCargasCompletas() {
		Double p_total = 0.0;
		Integer cant = 0;
		for (Carga c : cargasCompletadas) {
			p_total += c.getPeso();
			cant++;
		}

		if (cant == 0) {
			return 0.0;
		}

		Double total = p_total / cant;
		return total;
	}

	public void decargar() {
		for (Carga c : cargas) {
			cargasCompletadas.add(c);
		}
		cargas.clear();

	}

}
