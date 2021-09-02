package project.two.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.two.dao.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDao;
	
	public List<Map<String, Object>> getOnDemand() {
		List<Object[]> list = productDao.getDemand();
		if(list != null) {
			List<Map<String,Object>> map = new ArrayList<Map<String, Object>>();
			for(Object[] l: list) {
				Map<String, Object> temp = new HashMap<String, Object>();
				temp.put("title", l[0]);
				temp.put("minLimit", l[1]);
				temp.put("demand", (BigInteger.valueOf((Integer)l[1])).subtract(((BigInteger)l[2])));
				map.add(temp);
			}
			return map;
		}
		return null;
	}

	@Override
	public Product findProductById(int productID) {
		// TODO Auto-generated method stub
		return productDao.getById(productID);
	}
	
}
