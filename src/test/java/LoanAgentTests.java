import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoanAgentTests {

    LoanAgent uut;
    boolean expectedResult;
    boolean actualResult;
    String dummySSN = "123-45-6789";
    CreditAgency mockCreditAgency;

    @BeforeEach
    public void setUp()  {
        uut = new LoanAgent();
        mockCreditAgency = mock(CreditAgency.class);
        uut.setCreditAgency(mockCreditAgency);
    }

    @AfterEach
    public void tearDown()  {
        uut=null;
    }

    @Test
    public void testWithLowCreditScore()  {
        int testCreditScore = 719;
        expectedResult = false;
        when(mockCreditAgency.getCreditScore(dummySSN)).thenReturn(testCreditScore);

        actualResult = uut.processLoanApplication(dummySSN);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"200, false", "719, false", "720, true", "721, true", "850, true"})
    public void testWithValidCreditScore(int testCreditScore, boolean expectedResult) {

        when(mockCreditAgency.getCreditScore(dummySSN)).thenReturn(testCreditScore);

        actualResult = uut.processLoanApplication(dummySSN);

        assertEquals(expectedResult, actualResult);
    }


}
