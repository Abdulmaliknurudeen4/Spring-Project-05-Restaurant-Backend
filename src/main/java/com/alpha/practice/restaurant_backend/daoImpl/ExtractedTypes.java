package com.alpha.practice.restaurant_backend.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ExtractedTypes {
	/*
	 * Method to return pages available in a list returns the pagelist and returns
	 * +1 if the remainder is greater than 1 so 87/17 is 5 by the int type and 87%17
	 * is 2, that is the remainder if the remainder is greater than zero that means
	 * there is an additional page to the normal ones
	 */
	public int getPages(int roughsum, int pagesize) {
		if (roughsum <= 0 || pagesize <= 0) {
			return 0;
		}
		if (pagesize > roughsum) {
			return 1;
		}

		int numberOfpages = roughsum / pagesize;
		int remainder = roughsum % pagesize;
		if (remainder == 0) {
			return numberOfpages;
		} else {
			return numberOfpages + 1;
		}
	}

	public Query<?> extracted(SessionFactory sessionFactory, String SQL) {
		return sessionFactory.getCurrentSession().createQuery(SQL);
	}
	
	public Query<?> extracted(SessionFactory sessionFactory, String SQL, Class<?> details) {
		return sessionFactory.getCurrentSession().createQuery(SQL, details);
	}

	/*
	 * This method return for the query where it starts it counting in the result
	 * set if the page number is one , start at 0; if the page number is greater
	 * than one, then multiply the pagecapacity with the (page-1); reason for this
	 * is that, if it is page two then start from 10 since page capacity is 10 if
	 * page is 3, start from 20 so start number is returned from here and the caller
	 * method manages the capacity
	 */
	public int startPagination(int pagesize, int page) {

		if (page <= 0) {
			return 0;
		}

		if (page == 1) {
			return 0;
		} else if (page > 1) {
			return pagesize * (page - 1);
		}
		return 0;
	}

}