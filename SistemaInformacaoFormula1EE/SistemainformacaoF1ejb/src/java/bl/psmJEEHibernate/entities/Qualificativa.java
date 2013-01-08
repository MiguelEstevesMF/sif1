package bl.psmJEEHibernate.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Qualificativa")


public class Qualificativa implements Serializable {

	@Column(name="Sessao", nullable=false, length=11)	
	private int sessao;
	
	@Column(name="Tempo", nullable=false)	
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempo;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	public void setSessao(int value) {
		this.sessao = value;
	}
	
	public int getSessao() {
		return sessao;
	}
	
	public void setTempo(long value) {
		this.tempo = value;
	}
	
	public long getTempo() {
		return tempo;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	
}
