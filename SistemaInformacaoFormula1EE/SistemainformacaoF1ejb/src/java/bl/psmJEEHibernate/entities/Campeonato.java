package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;


@Entity
@Table(name="Campeonato")


public class Campeonato implements Serializable {

	
	@Column(name="Designacao", nullable=false, length=255,unique=true)
	private String designacao;
	
	@Column(name="AnoInicio", nullable=false, length=4)
	private int anoInicio;
	
	@Column(name="AnoFim", nullable=true, length=4)
	private int anoFim;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@OneToMany(mappedBy="campeonato", targetEntity=bl.psmJEEHibernate.entities.Evento.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Evento> eventos = new HashSet<Evento>();
	
	@ManyToMany(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinTable(name="Campeonato_Equipa", joinColumns={ @JoinColumn(name="CampeonatoID") }, inverseJoinColumns={ @JoinColumn(name="EquipaID") })	
	private Set<Equipa> equipas = new HashSet<Equipa>();
	
	public void setDesignacao(String value) {
		this.designacao = value;
	}
	
	public String getDesignacao() {
		return designacao;
	}
	
	public void setAnoInicio(int value) {
		this.anoInicio = value;
	}
	
	public int getAnoInicio() {
		return anoInicio;
	}
	
	public void setAnoFim(int value) {
		this.anoFim = value;
	}
	
	public int getAnoFim() {
		return anoFim;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	
	public void setEventos(Set<Evento> value) {
		this.eventos = value;
	}
	
	public Set<Evento> getEventos() {
		return eventos;
	}
	
	
	public void setEquipas(Set<Equipa> value) {
		this.equipas = value;
	}
	
	public Set<Equipa> getEquipas() {
		return equipas;
	}
	

	
}
