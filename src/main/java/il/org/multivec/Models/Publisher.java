package il.org.multivec.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "Publishers")
public class Publisher {
    @Id
    @Column(name = "Publisher_Id")
    private BigInteger id;
    @Column(name = "Name", nullable = false)
    private String name;
}
