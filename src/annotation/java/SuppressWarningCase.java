package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning(){
        int unUsedVariable = 10;
    }

    @SuppressWarnings("deprecation")
    public void deprecatedMethod(){
        Date date = new Date();
        int date1 = date.getDate();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast(){
        List list = new ArrayList();
        List<String> stringList = (List<String>)list;
    }
    @SuppressWarnings("all")
    public void allWarning(){
        int unUsedVariable = 10;
        Date date = new Date();
        int date1 = date.getDate();
        List list = new ArrayList();
        List<String> stringList = (List<String>)list;

    }
}
