package text;

import com.yw.model.Gwc;
import com.yw.service.GwcService;
import com.yw.serviceimpl.GwcServiceImpl;

public class aaa {
	
	public static void main(String[] args) {
		 GwcService gs=new GwcServiceImpl();
		Gwc g=new Gwc();
		g.setSname("aa");
		g.setJiage(3333.00);
		g.setSum(1);
		if(gs.addUser(g)){
			System.out.println("³É¹¦");
		}else{
			System.out.println("Ê§°Ü");
		}
		
	}


}
