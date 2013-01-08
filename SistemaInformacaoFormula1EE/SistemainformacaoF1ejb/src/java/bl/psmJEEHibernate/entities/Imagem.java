package bl.psmJEEHibernate.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Imagem")

public class Imagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Lob
    @Column(name="Imagem", nullable=true, length=1000000)
    private byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

}
