package com.event.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.dao.EventDao;
import com.event.dao.UserDao;
import com.event.exception.PasswordIncorrectException;
import com.event.model.Event;
import com.event.model.User;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private EventDao ed;
	@Autowired
	private UserDao ud;

	@Override
	public User loginUser(String id, String pass, HttpServletRequest req) {
		User cust = ud.findById(id).get();
		if (cust.getPassword().equals(pass)) {
			req.getSession().setAttribute(id + "1", cust);
			return cust;
		}

		else {
			throw new PasswordIncorrectException("601", "Password does not match");
		}
	}

	@Override
	public User userAddEvent(String uid, String pid, HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute(uid + "1");
		System.out.println(u);
		if (u != null) {
			Event prod = ed.findById(pid).get();
			if (prod != null) {
				u.getCart().add(prod);
				prod.setAdduser(u);
				ed.save(prod);
				u = getTotalPrice(u);
			}
		}
		return u;
	}

	private User getTotalPrice(User user) {
		float totalPrice = 0.0f;
		List<Event> events = user.getCart();
		for (Event p : events) {
			totalPrice += p.getPrice();
		}
		user.setTotalPrice(totalPrice);
		return user;
	}

}