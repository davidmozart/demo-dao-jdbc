package application;

import java.text.ParseException;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) throws ParseException {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Department obj = new Department(1, "Books");
		//Date data = new Date(sdf.parse("22/10/2000").getTime());
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println("=== TEST 1: seller findById ===");
		System.out.println(seller);
	}
}
