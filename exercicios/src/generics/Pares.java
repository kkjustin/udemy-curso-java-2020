package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C extends Number, V> {
	
	private final Set<Par<C, V>> itens = new LinkedHashSet<>(); // Ordena��o por ordem de inclus�o
	//private final Set<Par<C, V>> itens = new TreeSet<>(); // Utiliza comparable (N�o da pra implementar, muito gen�rica nossa classe)
	
	public void adicionar(C chave, V valor) {
		if(chave == null) return;
		
		Par<C, V> novoPar = new Par<C, V>(chave, valor);
		
		// Sem essa remo��o o set ignora a segunda adi��o
		if(itens.contains(novoPar)) {
			itens.remove(novoPar);
		}
		
		itens.add(novoPar);
	}
	
	public V getValor(C chave) {
		Optional<Par<C, V>> parOpcional = itens.stream()
				.filter(par -> chave.equals(par.getChave()))
				.findFirst();
		
		return parOpcional.isPresent() ? parOpcional.get().getValor() : null;
	}
}
