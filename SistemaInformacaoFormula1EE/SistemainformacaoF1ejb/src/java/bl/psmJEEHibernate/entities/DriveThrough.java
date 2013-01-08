package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("DriveThrough")


public class DriveThrough extends Castigo implements Serializable {

	@Column(name="VoltasParaCumprir", nullable=true, length=4)
	private int voltasParaCumprir;
	
	public void setVoltasParaCumprir(int value) {
		this.voltasParaCumprir = value;
	}
	
	public int getVoltasParaCumprir() {
		return voltasParaCumprir;
	}

	
}
