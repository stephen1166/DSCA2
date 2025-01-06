package Util;

public interface iSerializer {
    void save() throws Exception;
    void load() throws Exception;
    public default String fileName(){
        return "Hashmap.xml";
    }
}