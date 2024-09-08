public class Phone implements PhoneImpl {
    private int number;
    public Phone(int number) {
        this.number = number;
    }
    @Override
    public String getPhone ()
    {
        return "Phone number " + number;
    }
}
