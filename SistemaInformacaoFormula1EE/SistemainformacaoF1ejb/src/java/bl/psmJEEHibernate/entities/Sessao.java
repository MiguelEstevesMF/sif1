package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Sessao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Sessao")


public class Sessao implements Serializable {

	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@OneToMany(mappedBy="sessao", targetEntity=bl.psmJEEHibernate.entities.Ocorrencia.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Ocorrencia> ocorrencias = new HashSet<Ocorrencia>();
	
    @Column(name="data", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setOcorrencias(Set<Ocorrencia> value) {
		this.ocorrencias = value;
	}
	
	public Set<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	
}
