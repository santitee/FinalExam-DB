package com.company.web;

public class Course {
    private int id;
    private String name;
    private String detail;
    private int price;
    private int teach_by;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the teach_by
     */
    public int getTeach_by() {
        return teach_by;
    }

    /**
     * @param teach_by the teach_by to set
     */
    public void setTeach_by(int teach_by) {
        this.teach_by = teach_by;
    }

    
}