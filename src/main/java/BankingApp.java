public class BankingApp {

    public static void main(String[] args) {

        CreditAgency equifaxCreditAgency = new EquifaxCreditAgency();
        LoanAgent anotherLoanAgent = new LoanAgent(equifaxCreditAgency);
        boolean result = anotherLoanAgent.processLoanApplication("9876-54-321");
        processResult(result);

        TRWCreditAgency creditAgency = new TRWCreditAgency();
        anotherLoanAgent.setCreditAgency(creditAgency);
        result = anotherLoanAgent.processLoanApplication("123-45-6789");
        processResult(result);
    }

        public static void processResult(boolean result){
            if (result) {
                System.out.println("The Loan was approved");
            } else {
                System.out.println("The Loan was rejected");
            }
        }
    }

