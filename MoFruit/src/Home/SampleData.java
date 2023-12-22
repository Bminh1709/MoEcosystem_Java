package Home;

import Entities.Category;
import Entities.Fruit;
import Infrastructure.CategoryService;
import Infrastructure.FruitService;

public class SampleData {
    public static void addData() {
        CategoryService categoryService = CategoryService.GetInstance();
        FruitService fruitService = FruitService.GetInstance();
        categoryService.addCategory(new Category("Dried Fruits"));
        Category category1 = categoryService.getCategory(1);
        fruitService.addFruit(new Fruit("Raisins", 30.500, 5, category1, "Thailand"));
        fruitService.addFruit(new Fruit("Dried apricots", 27, 8, category1, "Capuchin"));
        fruitService.addFruit(new Fruit("Dried figs", 15, 7, category1, "VietNam"));
        categoryService.addCategory(new Category("Tropical Fruits"));
        Category category2 = categoryService.getCategory(2);
        fruitService.addFruit(new Fruit("Mangoes", 17.600, 2, category2, "Laos"));
        fruitService.addFruit(new Fruit("Bananas", 10.200, 4, category2, "Thailand"));
        fruitService.addFruit(new Fruit("Papayas", 18, 3, category2, "Indonesia"));
        categoryService.addCategory(new Category("Citrus Fruits"));
//        Oranges
//        Lemons
//        Limes
//        Grapefruits
    }
}
