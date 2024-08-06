public class LoanAgent {
    int minimumCreditScore = 720;
    CreditAgency creditAgency;

    public LoanAgent(CreditAgency creditAgency) {
        this.creditAgency = creditAgency;
    }

    public LoanAgent()  {}

    public boolean processLoanApplication(String ssn)  {
        boolean result = false;
        int minimumCreditScore = 720;

        int creditScore;

        creditScore = creditAgency.getCreditScore(ssn);

        if(creditScore>= minimumCreditScore)  {
            result = true;
        }


        return result;
    }

    public int getMinimumCreditScore() {
        return minimumCreditScore;
    }

    public void setMinimumCreditScore(int minimumCreditScore) {
        this.minimumCreditScore = minimumCreditScore;
    }

    public void setCreditAgency(CreditAgency creditAgency) {
        this.creditAgency = creditAgency;
    }
}
