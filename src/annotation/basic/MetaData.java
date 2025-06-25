package annotation.basic;

@AnnoMeta
public class MetaData {
    
    private String id;
    
    @AnnoMeta
    public void call(){
        
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Class<MetaData> metaDataClass = MetaData.class;
        AnnoMeta annotation = metaDataClass.getAnnotation(AnnoMeta.class);
        System.out.println("annotation = " + annotation);

        AnnoMeta call = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("call = " + call);
    }
}
