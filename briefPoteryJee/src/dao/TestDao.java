package dao;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import metier.entities.Potterie;

public class TestDao {
	
	
	public static void main (String[] args) {
		PotterieDaoImpl prod = new PotterieDaoImpl();
//
//        byte[] image = 105, 109, 103, 49, 46, 106, 112, 103;
//		Potterie p1 = prod.save(new Potterie("tajine", 12, 120, , null));
//		System.out.println(p1.toString());
//		
//		
//		List<Potterie> prodList = prod.nmPotterie("stor");
//
//		for(Potterie p: prodList) {
//			System.out.println("the is"+ p.getNom());
//		}
		
		System.out.println(prod.getPotterie());
		List<Potterie> pot = prod.nmPotterie("fakhara");
		for(Potterie p: pot) {
			System.out.println(p);
		}
		
	}

	
}
