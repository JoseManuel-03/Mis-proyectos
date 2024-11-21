package paquete;

public class TCountDownE extends Thread {
    private CountDownE countDown;

    public TCountDownE(int start) {
        this.countDown = new CountDownE(start);
    }

    @Override
    public void run() {
        countDown.contar();
    }
}
