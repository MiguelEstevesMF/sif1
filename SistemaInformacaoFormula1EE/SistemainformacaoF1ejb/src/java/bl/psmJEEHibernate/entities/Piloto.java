package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Piloto")


public class Piloto implements Serializable {

    public Piloto() {
    }

    public Piloto(int numero, String nome, Date dataNascimento, String Nacionalidade, int melhorPosicao, int numeroVezesMP, int polePositions, String descricao, Transponder transponder, Equipa equipa_actual) {
        this.numero = numero;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.Nacionalidade = Nacionalidade;
        this.melhorPosicao = melhorPosicao;
        this.numeroVezesMP = numeroVezesMP;
        this.polePositions = polePositions;
        this.descricao = descricao;
        this.transponder = transponder;
        this.equipa_actual = equipa_actual;
    }


	@Column(name="Numero", nullable=false, length=11)
	private int numero;

	@Column(name="Nome", nullable=false, length=255, unique=true)
	private String nome;

	@Column(name="DataNascimento", nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataNascimento;

	@Column(name="Nacionalidade", nullable=true, length=255)
	private String Nacionalidade;

	@Column(name="MelhorPosicao", nullable=false, length=11)
	private int melhorPosicao;

	@Column(name="NumeroVezesMP", nullable=false, length=11)
	private int numeroVezesMP;

	@Column(name="PolePositions", nullable=false, length=11)
	private int polePositions;

	@Column(name="Descricao", nullable=true, length=255)
	private String descricao;

	@Column(name="ID", nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;

	@OneToOne(targetEntity=bl.psmJEEHibernate.entities.Transponder.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="TransponderRef") })
	private Transponder transponder;

	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="EquipaID", referencedColumnName="ID") })
	private Equipa equipa_actual;


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


	public void setNumero(int value) {
		this.numero = value;
	}

	public int getNumero() {
		return numero;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public String getNome() {
		return nome;
	}

	public void setDataNascimento(Date value) {
		this.dataNascimento = value;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setNacionalidade(String value) {
		this.Nacionalidade = value;
	}

	public String getNacionalidade() {
		return Nacionalidade;
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

	public void setPolePositions(int value) {
		this.polePositions = value;
	}

	public int getPolePositions() {
		return polePositions;
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


	public void setTransponder(Transponder value) {
		this.transponder = value;
	}

	public Transponder getTransponder() {
		return transponder;
	}

	public void setEquipa_actual(Equipa value) {
		this.equipa_actual = value;
	}

	public Equipa getEquipa_actual() {
		return equipa_actual;
	}

    @Transient
    private boolean selected;

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piloto other = (Piloto) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numero;
        hash = 89 * hash + this.ID;
        return hash;
    }




}
