package bl.psmJEEHibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Treino")


public class Treino extends Sessao implements Serializable {

	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.ResultadoTreino.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="TreinoID", nullable=true)
	private Set<ResultadoTreino> resultados = new HashSet<ResultadoTreino>();
	
	public void setResultados(Set<ResultadoTreino> value) {
		this.resultados = value;
	}
	
	public Set<ResultadoTreino> getResultados() {
		return resultados;
	}
	
}
