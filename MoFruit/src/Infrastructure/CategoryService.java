package Infrastructure;

import Entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryService instance;
    private List<Category> categories;

    private CategoryService() {
        if (categories == null) {
            this.categories = new ArrayList<>();
        }
    }

    public static CategoryService GetInstance() {
        if (instance == null) {
            instance = new CategoryService();
        }
        return instance;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void deleteCategory(Category category) {
        categories.remove(category);
    }

    public Category getCategory(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryid() == id) {
                return categories.get(i);
            }
        } throw new IllegalArgumentException("Category is not existed");
    }

    public void getCategories() {
        System.out.println("------ Category Table ------");
        System.out.printf("%-3s | %-20s\n", "ID", "Name");

        for (Category category : categories) {
            System.out.printf("%-3d | %-20s\n",
                    category.getCategoryid(),
                    category.getCategoryName());
        }
        System.out.println("----------------------------");
    }


    public void updateCategory(Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryid() == category.getCategoryid()) {
                categories.get(i).setCategoryName(category.getCategoryName());
            }
        }
    }
}
