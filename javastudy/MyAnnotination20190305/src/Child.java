public class Child extends Base {

    @Override
    public void action() {
        System.out.println("ccc");
    }

    @Override
    public void action2() {
        super.action2();
    }
}
