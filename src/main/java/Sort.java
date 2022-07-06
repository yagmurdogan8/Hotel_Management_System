import java.util.List;

public class Sort {
    public double[] sortByPriceHighToLow(Room room[], Customer customer) {
        double[] x = new double[room.length];
        for (int i = 0; i < room.length; i++) {
            x[i] = room[i].calculateTotalPrice(room[i], customer);
        }
        boolean flag = true;
        double temp;
        while (flag) {
            flag = false;
            int maxIndex = x.length - 1;
            for (int i = 0; i < maxIndex; i++) {
                if (x[i] < x[i + 1]) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return x;
    }

    public double[] sortByPriceLowToHigh(Room[] room, Customer customer) {
        double[] x = new double[room.length];
        for (int i = 0; i < room.length; i++) {
            x[i] = room[i].calculateTotalPrice(room[i], customer);
        }
        boolean flag = true;
        double temp;
        while (flag) {
            flag = false;
            int maxIndex = x.length - 1;
            for (int i = 0; i < maxIndex; i++) {
                if (x[i] > x[i + 1]) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return x;
    }

    public float[] sortByStarRates(Room[] room, Customer customer) {
        //HIGH-TO-LOW
        float[] x = new float[room.length];
        for (int i = 0; i < room.length; i++) {
            x[i] = room[i].getStarRates();
        }
        boolean flag = true;
        float temp;
        while (flag) {
            flag = false;
            int maxIndex = x.length - 1;
            for (int i = 0; i < maxIndex; i++) {
                if (x[i] < x[i + 1]) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return x;
    }
}

