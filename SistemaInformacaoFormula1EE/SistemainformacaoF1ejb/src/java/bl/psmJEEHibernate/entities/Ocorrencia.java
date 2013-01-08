package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Ocorrencia")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Ocorrencia")


public class Ocorrencia implements Serializable {

	
	@Column(name="Quando", nullable=true)	
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date quando;
	
	@Column(name="Descricao", nullable=true, length=255)	
	private String descricao;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Sessao.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="SessaoID", referencedColumnName="ID") })		
	private Sessao sessao;
	
	public void setQuando(Date value) {
		this.quando = value;
	}
	
	public Date getQuando() {
		return quando;
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	
	public void setSessao(Sessao value) {
		this.sessao = value;
	}
	
	public Sessao getSessao() {
		return sessao;
	}

	
}
