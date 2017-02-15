package text;

import com.yw.model.User;
import com.yw.service.UserService;
import com.yw.serviceimpl.UserServiceImpl;

public class regist {
	public static void main(String[] args) {
		UserService us=new UserServiceImpl();
		User u=new User();
		u.setUname("a");
		u.setUpass("a");
		u.setPhone("123");
		if(us.addUser(u)){
			System.out.println("³É¹¦");
		}else{
			System.out.println("Ê§°Ü");
		}
	}
}
