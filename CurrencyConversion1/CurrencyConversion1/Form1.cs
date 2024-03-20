using System;
using System.Windows.Forms;

namespace CurrencyConverterApp
{
    public partial class Form1 : Form
    {
        // Hardcoded exchange rates (example rates)
        private readonly double usdToEuroRate = 0.85;
        private readonly double euroToUsdRate = 1.18;

        public Form1()
        {
            InitializeComponent();
            // Populate ComboBoxes with currency options
            comboBoxSellCurrency.Items.AddRange(new string[] { "USD", "Euro" });
            comboBoxBuyCurrency.Items.AddRange(new string[] { "USD", "Euro" });
        }

        private void btnExchange_Click(object sender, EventArgs e)
        {
            // Parse the amount to sell
            if (!double.TryParse(txtSellAmount.Text, out double sellAmount))
            {
                MessageBox.Show("Please enter a valid sell amount.");
                return;
            }

            // Determine the currencies
            string sellCurrency = comboBoxSellCurrency.SelectedItem.ToString();
            string buyCurrency = comboBoxBuyCurrency.SelectedItem.ToString();

            // Perform the conversion
            double resultAmount;
            if (sellCurrency == "USD" && buyCurrency == "Euro")
            {
                resultAmount = sellAmount * usdToEuroRate;
            }
            else if (sellCurrency == "Euro" && buyCurrency == "USD")
            {
                resultAmount = sellAmount * euroToUsdRate;
            }
            else
            {
                MessageBox.Show("Unsupported currency conversion.");
                return;
            }

            // Display the result
            txtBuyAmount.Text = resultAmount.ToString();
        }
    }
}
