//package com.alpha.practice.restaurant_backend.test;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.alpha.practice.restaurant_backend.dao.UserDAO;
//import com.alpha.practice.restaurant_backend.dto.User;
//
//public class CartLineTestCase {
//
//	
//
//	private static AnnotationConfigApplicationContext context;
//	
//	private User user;
//	
//	private static UserDAO userdao;
//	
//	private static CartLineDAO cartLineDAO;
//	private static ProductDAO productDAO;
//	private static UserDAO userDAO;
//	
//	
//	private CartLine cartLine = null;
//	
//	
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.alpha.practice.digimallbackend");
//		context.refresh();
//		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
//		productDAO = (ProductDAO)context.getBean("productDAO");
//		userDAO = (UserDAO)context.getBean("userDAO");
//		
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.alpha.practice.restaurant_backend");
//		context.refresh();
//		userdao = (UserDAO)context.getBean("userRepository");
//	
//	}
//	
//
//	@Test
//	public void testAddCartLine() {
//		
//		// fetch the user and then cart of that user
//		User user = userDAO.getbyEmail("hr@gmail.com");		
//		Cart cart = user.getCart();
//		
//		// fetch the product 
//		Product product = productDAO.get(2);
//		
//		// Create a new CartLine
//		cartLine = new CartLine();
//		cartLine.setCartId(cart.getId());
//		cartLine.setProduct(product);
//		cartLine.setProductCount(1);
//		double oldTotal = cartLine.getTotal();		
//		
//		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
//		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
//		
//		cart.setCartLines(cart.getCartLines() + 1);
//		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
//		assertEquals("Failed to update the cart!",true, cartLineDAO.updateCart(cart));
//		User user = new User("malik", "First", "LastName", "abdulmaliknurudeen4@gmail.com");
//		System.out.println(userdao.save(user));
//		
//	}
//	
//	
//	
//	@Test
//	public void testUpdateCartLine() {
//
//		// fetch the user and then cart of that user
//		User user = userDAO.getbyEmail("hr@gmail.com");		
//		Cart cart = user.getCart();
//				
//		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
//		
//		cartLine.setProductCount(cartLine.getProductCount() + 1);
//				
//		double oldTotal = cartLine.getTotal();
//				
//		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
//		
//		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
//		
//		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	
//
//		
//	}
//	
//	
//	
//}