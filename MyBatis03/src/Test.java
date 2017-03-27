import dao.IProductDao;
import dao.IStudentDao;
import dao.ProductDao;
import dao.StudentDao;
import model.Product;
import model.Student;

public class Test {
	public static void main(String[] args) {
		IStudentDao sd = new StudentDao();
		for(Student s : sd.selectAll())
			System.out.println(s);
		
		System.out.println("==================================================================");
		IProductDao pd = new ProductDao();
//		Product product = new Product();
//		product.setName("허니버터칩");
//		product.setPrice(1500);
//		product.setPictureurl("umr");
//		product.setDescription("꿀맛");
//		pd.insertProduct(product);
//		
		for(Product p : pd.selectAll())
			System.out.println(p);
	}
}
