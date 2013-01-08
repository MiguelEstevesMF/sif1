package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Corrida")


public class Corrida extends Sessao implements Serializable {

    @Column(name="NumeroVoltas", nullable=true, length=11)
	private int numeroVoltas;
	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.ResultadoCorrida.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CorridaID", nullable=true)
	private Set<ResultadoCorrida> resultados = new HashSet<ResultadoCorrida>();

    public int getNumeroVoltas() {
        return numeroVoltas;
    }

    public void setNumeroVoltas(int numeroVoltas) {
        this.numeroVoltas = numeroVoltas;
    }

	public void setResultados(Set<ResultadoCorrida> value) {
		this.resultados = value;
	}
	
	public Set<ResultadoCorrida> getResultados() {
		return resultados;
	}
	
	
}
