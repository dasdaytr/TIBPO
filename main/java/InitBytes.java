import java.util.concurrent.ThreadLocalRandom;

public class InitBytes {
    public byte getZeros(){
        return 0b00000000;
    }
    public byte getOnes(){
        return 0b1111111;
    }
    public byte getRandomBytes(){
        return (byte) ThreadLocalRandom.current().nextInt(0,127);
    }
}
