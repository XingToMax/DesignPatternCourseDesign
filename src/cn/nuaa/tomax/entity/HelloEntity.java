package cn.nuaa.tomax.entity;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/30 23:16
 */
public class HelloEntity {
    private String name;
    private String signature;
    public HelloEntity(){}

    public HelloEntity(String name, String signature) {
        this.name = name;
        this.signature = signature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
