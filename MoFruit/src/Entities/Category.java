package Entities;

public class Category {
    private static int idCount = 1;
    private int categoryid;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryid = idCount++;
        this.categoryName = categoryName;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
