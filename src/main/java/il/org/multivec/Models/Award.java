package il.org.multivec.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "Awards")
public class Award {
    @Id
    @Column(name = "Award_Id")
    private BigInteger id;
    @Column(name = "Award_Name")
    private String awardName;

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
