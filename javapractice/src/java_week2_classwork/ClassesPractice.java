package java_week2_classwork;

 abstract class Vehicle{
    public abstract void getWheels();
}

class Bus extends  Vehicle{
    @Override
    public void getWheels() {
        System.out.println(6);
    }
}
class  Auto extends  Vehicle
{
    @Override
    public void getWheels() {
        System.out.println(3);
    }
}
 class ClassesPractice {
    public static void main(String[] args) {
        Bus bus=new Bus();
        bus.getWheels();
        Auto auto= new Auto();
        auto.getWheels();
    }
}
