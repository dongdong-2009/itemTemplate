package junit;

import java.util.Date;
import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String u = uuid.toString().replace("-", "").toUpperCase();
		System.out.println("UUID:"+u);
		
		String qqNumber = "68547302";
		String sep = "|";
		//格式化日期 yyyyMMdd
		String date = String.format("%tY", new Date());
		System.out.println("---------------");
		System.out.println("订单号:"+qqNumber+sep+date+sep);
	}
}
