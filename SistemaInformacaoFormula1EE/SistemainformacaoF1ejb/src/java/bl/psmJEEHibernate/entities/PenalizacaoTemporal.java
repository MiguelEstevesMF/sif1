package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("PenalizacaoTemporal")


public class PenalizacaoTemporal extends Castigo implements Serializable {

	@Column(name="Segundos", nullable=true)	
	private float segundos;
	
	public void setSegundos(float value) {
		this.segundos = value;
	}
	
	public float getSegundos() {
		return segundos;
	}
	
}
