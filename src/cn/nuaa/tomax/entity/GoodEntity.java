package cn.nuaa.tomax.entity;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/24 0:10
 */
public class GoodEntity {
    private long id;
    private String name;
    private float price;

    public GoodEntity() {

    }

    public GoodEntity(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
