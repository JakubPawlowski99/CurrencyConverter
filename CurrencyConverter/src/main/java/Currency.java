import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currency")
public class Currency {
    private String code;
    private String name;

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}