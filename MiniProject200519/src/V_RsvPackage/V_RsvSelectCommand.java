package V_RsvPackage;

import java.util.List;
import java.util.Scanner;

public class V_RsvSelectCommand implements V_RsvCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
                   
		
		
		V_RsvDAO dao = new V_RsvDAO();
		List<V_RsvDTO> list = dao.selectAll();
		
		for(int i= 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
