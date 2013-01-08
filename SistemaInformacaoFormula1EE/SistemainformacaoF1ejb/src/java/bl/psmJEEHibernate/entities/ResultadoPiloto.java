package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="ResultadoPiloto")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("ResultadoPiloto")


public class ResultadoPiloto implements Serializable {
	
	@Column(name="Posicao", nullable=false, length=11)	
	private int posicao;
	
	@Column(name="Tempo", nullable=false)	
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempo;
	
	@Column(name="Voltas", nullable=false, length=11)	
	private int voltas;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="PilotoID", referencedColumnName="ID") })		
	private Piloto piloto;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="EquipaID", referencedColumnName="ID") })		
	private Equipa equipa;
	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.MelhorTempo_Sector.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ResultadoPilotoID", nullable=true)	
	private Set<MelhorTempo_Sector> melhorsTemposPorSector = new HashSet<MelhorTempo_Sector>();
	
	public void setPosicao(int value) {
		this.posicao = value;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setTempo(long value) {
		this.tempo = value;
	}
	
	public long getTempo() {
		return tempo;
	}
	
	public void setVoltas(int value) {
		this.voltas = value;
	}
	
	public int getVoltas() {
		return voltas;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	public void setMelhorsTemposPorSector(Set<MelhorTempo_Sector> value) {
		this.melhorsTemposPorSector = value;
	}
	
	public Set<MelhorTempo_Sector> getMelhorsTemposPorSector() {
		return melhorsTemposPorSector;
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
