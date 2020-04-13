import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 输出4到1000 任意大于等于4的数，可以由两个素数组成
 * 
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println(new Date());
		// 查找1到1000的指数
		List<Integer> numO = new ArrayList<Integer>();
		for (int i = 0; i < 3000; i++) {
			if (i % 2 != 0 && i % 5 != 0 && i % 7 != 0 && i % 3 != 0) {
				// System.out.println(i);
				// 如果i是素数，将i赋值到数组中
				numO.add(i);
			}
		}
		numO.add(2);
		numO.add(3);
		numO.add(5);
		numO.add(7);
		

		// 增list保存i，防止重复
		List<Integer> numKey = new ArrayList<Integer>();

		// 三重循环打印出所有的结果
		for (int i = 4; i < 3000; i++) {
		    key:
			for (int j = 0; j < numO.size(); j++) {
				for (int j2 = 0; j2 < numO.size(); j2++) {
					if (i == numO.get(j2) + numO.get(j) && numO.get(j2) != numO.get(j) && !numKey.contains(i)) {

						// 打印结果
						System.out.print(i + "=" + numO.get(j) + "+" + numO.get(j2));
						numKey.add(i);
						
						// 跳出里面两层循环，继续下一个数的判断
						break key;
					}
				}
			}
		}
		System.out.println(new Date());
		System.out.println(new Date());
	}
}
