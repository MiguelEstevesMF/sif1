package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("SBTR")


public class SBTR extends Credencial implements Serializable {

	
}
