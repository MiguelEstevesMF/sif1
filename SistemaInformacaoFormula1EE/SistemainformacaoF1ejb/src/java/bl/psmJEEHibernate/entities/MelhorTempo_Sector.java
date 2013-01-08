package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="MelhorTempo_Sector")


public class MelhorTempo_Sector implements Serializable {

	
	@Column(name="Sector", nullable=false, length=11)	
	private int sector;
	
	@Column(name="Tempo", nullable=false)	
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempo;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	public void setSector(int value) {
		this.sector = value;
	}
	
	public int getSector() {
		return sector;
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
