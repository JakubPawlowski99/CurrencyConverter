import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;

public class MyPanel extends JPanel implements ActionListener {
    private JLabel amountLabel, fromCurrencyLabel, toCurrencyLabel, resultLabel;
    private JTextField amountTextField, resultTextField;
    private JComboBox<Currency> fromCurrencyComboBox, toCurrencyComboBox;
    private JButton convertButton;

    public MyPanel() {
        setLayout(null);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 80, 25);
        add(amountLabel);

        amountTextField = new JTextField();
        amountTextField.setBounds(100, 20, 100, 25);
        add(amountTextField);

        fromCurrencyLabel = new JLabel("From:");
        fromCurrencyLabel.setBounds(20, 50, 80, 25);
        add(fromCurrencyLabel);

        fromCurrencyComboBox = new JComboBox<>();
        fromCurrencyComboBox.setBounds(100, 50, 100, 25);
        add(fromCurrencyComboBox);

        toCurrencyLabel = new JLabel("To:");
        toCurrencyLabel.setBounds(20, 80, 80, 25);
        add(toCurrencyLabel);

        toCurrencyComboBox = new JComboBox<>();
        toCurrencyComboBox.setBounds(100, 80, 100, 25);
        add(toCurrencyComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(100, 120, 100, 25);
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(220, 80, 80, 25);
        add(resultLabel);

        resultTextField = new JTextField();
        resultTextField.setBounds(300, 80, 80, 25);
        resultTextField.setEditable(false);
        add(resultTextField);

        loadCurrencies(); // Load currencies from XML
    }

    private void loadCurrencies() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Currencies.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Currencies currencies = (Currencies) jaxbUnmarshaller.unmarshal(new File("currencies.xml"));

            List<Currency> currencyList = currencies.getCurrencyList();
            for (Currency currency : currencyList) {
                fromCurrencyComboBox.addItem(currency);
                toCurrencyComboBox.addItem(currency);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            double amount = Double.parseDouble(amountTextField.getText());
            Currency fromCurrency = (Currency) fromCurrencyComboBox.getSelectedItem();
            Currency toCurrency = (Currency) toCurrencyComboBox.getSelectedItem();

            double result = CurrencyConverter.convertCurrency(amount, fromCurrency.getCode(), toCurrency.getCode());

            DecimalFormat df = new DecimalFormat("#.##");
            resultTextField.setText(df.format(result));
        }
    }
}