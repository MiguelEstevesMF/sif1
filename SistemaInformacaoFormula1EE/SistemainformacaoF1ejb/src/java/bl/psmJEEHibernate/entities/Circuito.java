package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Circuito")


public class Circuito implements Serializable {

	@Column(name="Nome", nullable=false, length=255, unique=true )
	private String nome;
	
	@Column(name="ComprimentoKm", nullable=false)
	private float comprimentoKm;

	@Column(name="LarguraM", nullable=false)
	private float larguraM;

	@Column(name="Cidade", nullable=false, length=255)
	private String cidade;

	@Column(name="Pais", nullable=false, length=255)
	private String pais;

	@Column(name="Gmt", nullable=false, length=11)
	private int gmt;

	@Column(name="Descricao", nullable=true, length=255)
	private String descricao;

	@Column(name="HomePage", nullable=true, length=255)
	private String homePage;

	@Column(name="TempoVoltaRecord", nullable=true)
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempoVoltaRecord;

	@Column(name="TempoMelhorVoltaPossivel", nullable=true)
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempoMelhorVoltaPossivel;

	@Column(name="ID", nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;

	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="PilotoID", referencedColumnName="ID", nullable=true) })
	private Piloto pilotoVoltaRecord;

	@OneToMany(targetEntity=bl.psmJEEHibernate.entities.Loop.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="CircuitoID", nullable=true)
    private Set<Loop> loops = new HashSet<Loop>();

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

	public void setComprimentoKm(float value) {
		this.comprimentoKm = value;
	}

	public float getComprimentoKm() {
		return comprimentoKm;
	}

	public void setLarguraM(float value) {
		this.larguraM = value;
	}

	public float getLarguraM() {
		return larguraM;
	}

	public void setCidade(String value) {
		this.cidade = value;
	}

	public String getCidade() {
		return cidade;
	}

	public void setPais(String value) {
		this.pais = value;
	}

	public String getPais() {
		return pais;
	}

	public void setGmt(int value) {
		this.gmt = value;
	}

	public int getGmt() {
		return gmt;
	}

	public void setDescricao(String value) {
		this.descricao = value;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setHomePage(String value) {
		this.homePage = value;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setTempoVoltaRecord(long value) {
		this.tempoVoltaRecord = value;
	}

	public long getTempoVoltaRecord() {
		return tempoVoltaRecord;
	}

	public void setTempoMelhorVoltaPossivel(long value) {
		this.tempoMelhorVoltaPossivel = value;
	}

	public long getTempoMelhorVoltaPossivel() {
		return tempoMelhorVoltaPossivel;
	}

	public void setID(int value) {
		this.ID = value;
	}

	public int getID() {
		return ID;
	}


	public void setLoops(Set<Loop> value) {
		this.loops = value;
	}

	public Set<Loop> getLoops() {
		return loops;
	}

    public void addLoop(Loop value){
        this.loops.add(value);
    }

    public void editLoop(int id, float posicaoKm, String ref){
        for(Loop l:this.getLoops())
            if (l.getID()==id){
                l.setPosicaoKm(posicaoKm);
                l.setRef(ref);
            }
    }

    public void remLoop(Loop value){
        this.loops.remove(value);
    }

	public void setPilotoVoltaRecord(Piloto value) {
		this.pilotoVoltaRecord = value;
	}

	public Piloto getPilotoVoltaRecord() {
		return pilotoVoltaRecord;
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
