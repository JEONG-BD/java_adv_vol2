package network.tcp.autocloseable;

public class ResourceV2 implements AutoCloseable {
    private String name;

    public ResourceV2(String name) {
        this.name = name;
    }

    public void call(){
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        System.out.println(name + " callException");
        throw  new CallException(name + " ex");
    }

    @Override
    public void close(){
        System.out.println(name + " close");
    }

    public void closeEx() throws CloseException {
        System.out.println(name + " closeException");
        throw  new CloseException(name + "ex");
    }
}
