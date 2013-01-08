package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Equipa_Piloto")


public class Equipa_Piloto implements Serializable {

	
	@Column(name="DataEntrada", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataEntrada;
	
	@Column(name="DataSaida", nullable=true)	
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSaida;
	
	@Column(name="Descricao", nullable=true, length=255)	
	private String descricao;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="EquipaID", referencedColumnName="ID") })
	private Equipa equipa;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="PilotoID", referencedColumnName="ID" ) })
	private Piloto piloto;
	
	public void setDataEntrada(Date value) {
		this.dataEntrada = value;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataSaida(Date value) {
		this.dataSaida = value;
	}
	
	public java.util.Date getDataSaida() {
		return dataSaida;
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
	
	
	public void setEquipa(Equipa value) {
		this.equipa = value;
	}
	
	public Equipa getEquipa() {
		return equipa;
	}
	
	public void setPiloto(Piloto value) {
		this.piloto = value;
	}
	
	public Piloto getPiloto() {
		return piloto;
	}
	
	
}
