package desafio.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_desafio")
public class ClienteDesafio extends PessoaDesafio {

	@Column(length = 100)
	private String email;
	
	@Column(length = 120)
	private String endereco;
	
	@Column(length = 20)
	private String telefone;
}
