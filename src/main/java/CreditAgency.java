public interface CreditAgency {

    public int getCreditScore(String ssn);

    public void setMinAndMax(int minimumCreditScore, int maximumCreditScore);
}
