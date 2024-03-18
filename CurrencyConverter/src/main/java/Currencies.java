import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "currencies")
public class Currencies {
    private List<Currency> currencyList;

    @XmlElement(name = "currency")
    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }
}