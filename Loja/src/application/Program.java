package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = ler.nextInt();
		ler.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product " + i + " Data:");
			System.out.print("Common, used or imported (c/u/i) ? ");
			char op = ler.next().charAt(0);
			System.out.print("Name: ");
			ler.nextLine();
			String name = ler.nextLine();
			System.out.print("Price: ");
			Double price = ler.nextDouble();
			if (op == 'u' || op == 'U') {
				System.out.print("Manufacture date (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(ler.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			if (op == 'i' || op == 'I') {
				System.out.print("Custom Fee: ");
				Double customFee = ler.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}
			if (op == 'c' || op == 'C') {
				list.add(new Product(name, price));
			}
		}

		System.out.println("PRICE TAGS:\n");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		ler.close();
	}

}
