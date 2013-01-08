package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("PitStop")


public class PitStop extends Castigo implements Serializable {

	
	@Column(name="TempoSeg", nullable=true, length=11)	
	private int tempoSeg;
	
	@Column(name="voltasParaCumprir", nullable=true, length=11)
	private int voltasParaCumprir;
	
	public void setTempoSeg(int value) {
		this.tempoSeg = value;
	}
	
	public int getTempoSeg() {
		return tempoSeg;
	}
	
	public void setVoltasParaCumprir(int value) {
		this.voltasParaCumprir = value;
	}
	
	public int getVoltasParaCumprir() {
		return voltasParaCumprir;
	}

	
}
