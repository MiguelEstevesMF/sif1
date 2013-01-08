package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Qualificacao")


public class Qualificacao extends Sessao implements Serializable {

	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.ResultadoQualificacao.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="QualificacaoID", nullable=true)
	private Set<ResultadoQualificacao> resultados = new HashSet<ResultadoQualificacao>();
	
	public void setResultados(Set<ResultadoQualificacao> value) {
		this.resultados = value;
	}
	
	public Set<ResultadoQualificacao> getResultados() {
		return resultados;
	}
	
	
	
}
