package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Registro")



public class Registro implements Serializable {

	
	@Column(name="HoraData", nullable=true)	
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date tempoTransponder;
	
	@Column(name="PotenciaSinal", nullable=false, length=11)	
	private int potenciaSinal;
	
	@Column(name="Hits", nullable=false, length=11)	
	private int hits;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Loop.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="LoopID", referencedColumnName="ID", insertable=true, updatable=false) })
	private Loop loop;
	
	@ManyToOne(targetEntity=bl.psmJEEHibernate.entities.Transponder.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name="TransponderID", referencedColumnName="ID", insertable=true, updatable=false) })
	private Transponder transponder;

    public Date getTempoTransponder() {
        return tempoTransponder;
    }

    public void setTempoTransponder(Date tempoTransponder) {
        this.tempoTransponder = tempoTransponder;
    }
	
	public void setPotenciaSinal(int value) {
		this.potenciaSinal = value;
	}
	
	public int getPotenciaSinal() {
		return potenciaSinal;
	}
	
	public void setHits(int value) {
		this.hits = value;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	
	public void setLoop(Loop value) {
		this.loop = value;
	}
	
	public Loop getLoop() {
		return loop;
	}
	
	public void setTransponder(Transponder value) {
		this.transponder = value;
	}
	
	public Transponder getTransponder() {
		return transponder;
	}

	
}
