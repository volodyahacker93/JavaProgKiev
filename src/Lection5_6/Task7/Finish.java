package Lection5_6.Task7;

import java.math.BigInteger;

public class Finish implements IFinish {

    private BigInteger result = BigInteger.ONE;

    @Override
    public synchronized void done(BigInteger result) {
        this.result = this.result.multiply(result);
    }

    public BigInteger getResult() {
        return result;
    }
}
