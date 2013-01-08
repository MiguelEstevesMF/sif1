package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@DiscriminatorValue("ResultadoQualificacao")


public class ResultadoQualificacao extends ResultadoPiloto implements Serializable {

	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.Qualificativa.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ResultadoPilotoID", nullable=true)	
	private Set<Qualificativa> qualificativas = new HashSet<Qualificativa>();
	
	public void setQualificativas(Set<Qualificativa> value) {
		this.qualificativas = value;
	}
	
	public Set<Qualificativa> getQualificativas() {
		return qualificativas;
	}

	
}
