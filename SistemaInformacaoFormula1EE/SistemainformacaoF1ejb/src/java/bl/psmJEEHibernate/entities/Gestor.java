
package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Gestor")


public class Gestor extends Credencial implements Serializable {

	
}
