
package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Castigo")


public class Castigo extends OcorrenciaPiloto implements Serializable {
	
	@Column(name="Executado", nullable=false, length=1)
	private boolean executado;
	
	public void setExecutado(boolean value) {
		this.executado = value;
	}
	
	public boolean getExecutado() {
		return executado;
	}
	
	
}
