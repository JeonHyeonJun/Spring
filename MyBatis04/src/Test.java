import dao.IProductDao;
import dao.ProductDao;
import model.Product;

public class Test {
	public static void main(String[] args) {
		IProductDao pd = new ProductDao();
//		Product product = new Product();
//		product.setName("버터칩");
//		product.setPrice(400);
//		product.setPicture("naver");
//		product.setDescription("꿀맛");
//		pd.insertProduct(product);
		for(Product p : pd.selectAll())
			System.out.println(p);
	}
}
