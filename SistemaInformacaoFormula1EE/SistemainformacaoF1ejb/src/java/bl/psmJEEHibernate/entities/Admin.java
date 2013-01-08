package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Admin")


public class Admin extends Credencial implements Serializable {

	
}
