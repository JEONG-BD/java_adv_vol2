package network.tcp.autocloseable;

public class ResourceCloseMainV3 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("Call Exception 예외처리");
            throw new RuntimeException(e);
        } catch (CloseException e){
            System.out.println("Close  Exception 예외처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
            ResourceV1 resource1 = null;
            ResourceV1 resource2 = null ;
        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx();
        } catch (CallException e){
            System.out.println("ex :" + e);
            throw e;
        } finally {
            System.out.println("자원 정리");

            if (resource2 != null){
                try {
                    resource2.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex : " + e);
                }

            if (resource1 != null){
                try {
                    resource1.closeEx();

                } catch (CloseException e) {
                    System.out.println("close ex : " + e);
                }
            }
        }
    }
    }
}
