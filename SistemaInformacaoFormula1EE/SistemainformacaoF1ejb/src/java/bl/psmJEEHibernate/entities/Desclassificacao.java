package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Desclassificacao")


public class Desclassificacao extends Castigo implements Serializable {

	
}
