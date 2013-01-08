package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Equipa")


public class Equipa implements Serializable {
	
	@Column(name="Nome", nullable=false, length=255, unique=true)
	private String nome;
	
	@Column(name="Motor", nullable=false, length=255)
	private String motor;
	
	@Column(name="Chassi", nullable=false, length=255)
	private String chassi;
	
	@Column(name="Pneus", nullable=false, length=255)
	private String pneus;
	
	@Column(name="AnoEntrada", nullable=false, length=11)	
	private int anoEntrada;
	
	@Column(name="MelhorPosicao", nullable=false, length=11)
	private int melhorPosicao;
	
	@Column(name="NumeroVezesMP", nullable=false, length=11)
	private int numeroVezesMP;
	
	@Column(name="Polepositions", nullable=false, length=11)	
	private int polepositions;
	
	@Column(name="Director", nullable=false, length=255)
	private String director;
	
	@Column(name="Sede", nullable=true, length=255)	
	private String sede;
	
	@Column(name="Descricao", nullable=true, length=255)	
	private String descricao;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
	
	@OneToOne(targetEntity=bl.psmJEEHibernate.entities.Utilizador.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL, optional=true)
    @JoinColumn(name="UtilizadorLogin")
	private Utilizador utilizador;
	
	@ManyToMany(mappedBy="equipas", targetEntity=bl.psmJEEHibernate.entities.Campeonato.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
    private Set<Campeonato> campeonatos = new HashSet<Campeonato>();
	
	@OneToMany(mappedBy="equipa_actual", targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
    private Set<Piloto> pilotos = new HashSet<Piloto>();


    @OneToOne(targetEntity=bl.psmJEEHibernate.entities.Imagem.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="Imagem", nullable=true)
	private Imagem imagem;

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = new Imagem();
        this.imagem.setImagem(imagem);
    }

	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setMotor(String value) {
		this.motor = value;
	}
	
	public String getMotor() {
		return motor;
	}
	
	public void setChassi(String value) {
		this.chassi = value;
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setPneus(String value) {
		this.pneus = value;
	}
	
	public String getPneus() {
		return pneus;
	}
	
	public void setAnoEntrada(int value) {
		this.anoEntrada = value;
	}
	
	public int getAnoEntrada() {
		return anoEntrada;
	}
	
	public void setMelhorPosicao(int value) {
		this.melhorPosicao = value;
	}
	
	public int getMelhorPosicao() {
		return melhorPosicao;
	}
	
	public void setNumeroVezesMP(int value) {
		this.numeroVezesMP = value;
	}
	
	public int getNumeroVezesMP() {
		return numeroVezesMP;
	}
	
	public void setPolepositions(int value) {
		this.polepositions = value;
	}
	
	public int getPolepositions() {
		return polepositions;
	}
	
	public void setDirector(String value) {
		this.director = value;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setSede(String value) {
		this.sede = value;
	}
	
	public String getSede() {
		return sede;
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
	
	
	public void setCampeonatos(Set<Campeonato> value) {
		this.campeonatos = value;
	}
	
	public Set<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	
	
	public void setPilotos(Set<Piloto> value) {
		this.pilotos = value;
	}
	
	public Set<Piloto> getPilotos() {
		return pilotos;
	}
	
	
	public void setUtilizador(Utilizador value) {
		this.utilizador = value;
	}
	
	public Utilizador getUtilizador() {
		return utilizador;
	}

    @Transient
    private boolean selected;

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


	
	
}
