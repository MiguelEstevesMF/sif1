package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("OcorrenciaPiloto")


public class OcorrenciaPiloto extends Ocorrencia implements Serializable {

	@Column(name="Volta", nullable=true, length=11)	
	private int volta;
	
	@Column(name="TempoEvento", nullable=true)	
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date tempoEvento;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="PilotoID", referencedColumnName="ID" ) })
	private Piloto piloto;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="EquipaID", referencedColumnName="ID" ) })	
	private Equipa equipa;
	
	public void setVolta(int value) {
		this.volta = value;
	}
	
	public int getVolta() {
		return volta;
	}
	
	public void setTempoEvento(Date value) {
		this.tempoEvento = value;
	}
	
	public Date getTempoEvento() {
		return tempoEvento;
	}
	
	public void setPiloto(Piloto value) {
		this.piloto = value;
	}
	
	public Piloto getPiloto() {
		return piloto;
	}
	
	public void setEquipa(Equipa value) {
		this.equipa = value;
	}
	
	public Equipa getEquipa() {
		return equipa;
	}
	
	
}
