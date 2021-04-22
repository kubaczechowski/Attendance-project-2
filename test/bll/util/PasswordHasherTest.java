package bll.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordHasherTest {

    @Test
    void verifyPasswordCorrect() {
        boolean result = PasswordHasher.verifyPassword("bean",
                "iCPwsZ8VZAusX25+Lhm8z4iwrjEDRNqttQm25m7PVIEbbaxEWJ1M/2cwU4c+vbbEJp8ecrpMnORLML7iQY4Vlw==",
                "9Cc6lix12/ik1RS8nyMdIcp4kd16qLMPFyRrGPRltFYbZKBFGJyIUF+S9S5dqR8edVQjHgFgSUI7GyAusPVPub8xeEsk6Kryit4NtWEM1xiTUwQxrUPwnyRkj7wu8BWX5pU4NOR5k5cdx8Ae1I8J3GPkOYQyKXynp0DXGU8MQFxfoiqhbNPdi/41r07YkEQBa1lCTMEFiVaPrm48ZBLl3cXnjKSD3x+n3JMIrzvvuk2UOG4ztOJ+9Q4VwsaMp4rIXadrLshVWuH1feL7KM8XRIg1yRD4aEzMSNJ9Ye4Ii2YV4IpaSS8Ie912DNmzXka9zuzBu7xgSVIprQ2ck0czLJBQaZDO/oMQtWo6wYes1QwaCqIifYTwFnQ0B90eAgC7ohntK9fqpiHHSKYNFdkokkeIr5oakr+XrBn33n3ZXgOZFUy7sQYRFPvFfqt2o8DL9XNPzRLJSYx3qPklUPYRlLohy6dFz93nsWG2AmcrBkL/TOln646bjKaMVh87O00s+0lBfELpTBJXL/Qb6V8+vXFCuErIsm9qJ4y65YfkslnQCKacshkmynfpCYBbSkEMBKeMlrs2Aq0Dyfsre9uqbQxSVOtlEN+5h/C1L3qo/3fqlG9CDxujHgu++a3Yd3Lpo5Lk2DU61k/Q8l2ICJbApoVZlujEUD1TIvijEVs1fjI=");
        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void verifyPasswordIncorrect() {
        boolean result = PasswordHasher.verifyPassword("test",
                "iCPwsZ8VZAusX25+Lhm8z4iwrjEDRNqttQm25m7PVIEbbaxEWJ1M/2cwU4c+vbbEJp8ecrpMnORLML7iQY4Vlw==",
                "9Cc6lix12/tt1RS8nyMdIcp4kd16qLMPFyRrGPRltFYbZKBFGJyIUF+S9S5dqR8edVQjHgFgSUI7GyAusPVPub8xeEsk6Kryit4NtWEM1xiTUwQxrUPwnyRkj7wu8BWX5pU4NOR5k5cdx8Ae1I8J3GPkOYQyKXynp0DXGU8MQFxfoiqhbNPdi/41r07YkEQBa1lCTMEFiVaPrm48ZBLl3cXnjKSD3x+n3JMIrzvvuk2UOG4ztOJ+9Q4VwsaMp4rIXadrLshVWuH1feL7KM8XRIg1yRD4aEzMSNJ9Ye4Ii2YV4IpaSS8Ie912DNmzXka9zuzBu7xgSVIprQ2ck0czLJBQaZDO/oMQtWo6wYes1QwaCqIifYTwFnQ0B90eAgC7ohntK9fqpiHHSKYNFdkokkeIr5oakr+XrBn33n3ZXgOZFUy7sQYRFPvFfqt2o8DL9XNPzRLJSYx3qPklUPYRlLohy6dFz93nsWG2AmcrBkL/TOln646bjKaMVh87O00s+0lBfELpTBJXL/Qb6V8+vXFCuErIsm9qJ4y65YfkslnQCKacshkmynfpCYBbSkEMBKeMlrs2Aq0Dyfsre9uqbQxSVOtlEN+5h/C1L3qo/3fqlG9CDxujHgu++a3Yd3Lpo5Lk2DU61k/Q8l2ICJbApoVZlujEUD1TIvijEVs1fjI=");
        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }
}