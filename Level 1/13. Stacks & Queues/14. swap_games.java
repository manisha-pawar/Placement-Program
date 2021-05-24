public class Main {
    public static class Car {
        int speed;
        String model;

        Car() {

        }

        Car(int speed,String model) {
            this.speed = speed;
            this.model = model;
        }

        void sayHi() {
            System.out.println(speed + " " + model);
        }
    }

    public static void main(String[]args) {
        Car c1 = new Car(20,"xyz");

        Car c2 = new Car();
        c2.speed = 30;
        c2.model = "def";

        c1.sayHi();
        c2.sayHi();

        swap1(c1,c2);

        c1.sayHi();
        c2.sayHi();
    }

    public static void swap1(Car v1,Car v2) {
        Car t1 = v1;
        v1 = v2;
        v2 = t1;
    }

    public static void swap2(Car v1,Car v2) {
        Car t1 = v1;

        v1.speed = v2.speed;
        v1.model = v2.model;

        v2.speed = t1.speed;
        v2.model = t1.model;
    }

    public static void swap3(Car v1,Car v2) {
        Car t1 = new Car();
        t1.speed = v1.speed;
        t1.model = v1.model;

        v1.speed = v2.speed;
        v1.model = v2.model;

        v2.speed = t1.speed;
        v2.model = t1.model;
    }
}

