package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Evento")


public class Evento implements Serializable {

    public Evento() {
    }

    public Evento(String designacao, Date data, int numeroVoltas, float distanciaTotalKm, Circuito circuito, Corrida corrida, Qualificacao qualificacao,Set<Treino> treinos, Campeonato campeonato) {
        this.designacao = designacao;
        this.data = data;
        this.numeroVoltas = numeroVoltas;
        this.distanciaTotalKm = distanciaTotalKm;
        this.circuito = circuito;
        this.corrida = corrida;
        this.qualificacao = qualificacao;
        this.campeonato = campeonato;
        this.treinos = treinos;

        this.corrida.setNumeroVoltas(numeroVoltas);
    }

	
	@Column(name="Designacao", nullable=false, length=255, unique=true)
	private String designacao;

	@Column(name="Data", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="NumeroVoltas", nullable=false, length=11)	
	private int numeroVoltas;
	
	@Column(name="DistanciaTotalKm", nullable=false)	
	private float distanciaTotalKm;
	
	@Column(name="TempoVoltaRecord", nullable=true)
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date tempoVoltaRecord;
	
	@Column(name="TempoMelhorVoltaPossivel", nullable=true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date tempoMelhorVoltaPossivel;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Circuito.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="CircuitoID", referencedColumnName="ID", nullable=true)
	private Circuito circuito;
	
	@OneToOne(targetEntity=bl.psmJEEHibernate.entities.Corrida.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CorridaID", nullable=true)
	private Corrida corrida;
	
	@OneToOne(targetEntity=bl.psmJEEHibernate.entities.Qualificacao.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="QualificacaoID", nullable=true)
	private Qualificacao qualificacao;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Campeonato.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="CampeonatoID", referencedColumnName="ID")		
	private Campeonato campeonato;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="PilotoID", referencedColumnName="ID", nullable=true )
	private Piloto pilotoVoltaRecord;
	
	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.Treino.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="EventoID", nullable=true)		
	private Set<Treino> treinos = new HashSet<Treino>();
	
	public void setDesignacao(String value) {
		this.designacao = value;
	}
	
	public String getDesignacao() {
		return designacao;
	}
	
	public void setData(Date value) {
		this.data = value;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setNumeroVoltas(int value) {
		this.numeroVoltas = value;
        this.corrida.setNumeroVoltas(numeroVoltas);
	}
	
	public int getNumeroVoltas() {
		return numeroVoltas;
	}
	
	public void setDistanciaTotalKm(float value) {
		this.distanciaTotalKm = value;
	}
	
	public float getDistanciaTotalKm() {
		return distanciaTotalKm;
	}
	
	public void setTempoVoltaRecord(Date value) {
		this.tempoVoltaRecord = value;
	}
	
	public Date getTempoVoltaRecord() {
		return tempoVoltaRecord;
	}
	
	public void setTempoMelhorVoltaPossivel(Date value) {
		this.tempoMelhorVoltaPossivel = value;
	}
	
	public Date getTempoMelhorVoltaPossivel() {
		return tempoMelhorVoltaPossivel;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	

	
	public void setCampeonato(Campeonato value) {
		this.campeonato = value;
	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	public void setCircuito(Circuito value) {
		this.circuito = value;
	}
	
	public Circuito getCircuito() {
		return circuito;
	}
	
	public void setCorrida(Corrida value) {
		this.corrida = value;
	}
	
	public Corrida getCorrida() {
		return corrida;
	}
	
	public void setQualificacao(Qualificacao value) {
		this.qualificacao = value;
	}
	
	public Qualificacao getQualificacao() {
		return qualificacao;
	}
	
	public void setTreinos(Set<Treino> value) {
		this.treinos = value;
	}
	
	public Set<Treino> getTreinos() {
		return treinos;
	}
	
	
	public void setPilotoVoltaRecord(Piloto value) {
		this.pilotoVoltaRecord = value;
	}
	
	public Piloto getPilotoVoltaRecord() {
		return pilotoVoltaRecord;
	}
	

	
}
