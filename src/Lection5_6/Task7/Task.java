package Lection5_6.Task7;

import java.math.BigInteger;

public class Task implements Runnable{

    private IFinish finish;
    private BigInteger start;
    private BigInteger end;

    public Task(BigInteger start, BigInteger end, IFinish finish) {
        this.start = start;
        this.end = end;
        this.finish = finish;
    }

    @Override
    public void run() {
        BigInteger res = fact(start);
        if(finish != null) {
            finish.done(res);
        }
    }

    private BigInteger fact(BigInteger start) {
        if (start.equals(end)) {
            return end;
        } else {
            return start.multiply(fact(start.subtract(BigInteger.ONE)));
        }
    }

    public BigInteger getStart() {
        return start;
    }

    public void setStart(BigInteger start) {
        this.start = start;
    }

    public BigInteger getEnd() {
        return end;
    }

    public void setEnd(BigInteger end) {
        this.end = end;
    }
}
