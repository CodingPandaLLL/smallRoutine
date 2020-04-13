

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BookContence {

	public static void main(String[] args) {
		ContencePlan();
	}

	private static void ContencePlan() {
		List<String> lslls = new ArrayList<String>();
		Map<String, String> contence = new IdentityHashMap<String, String>();

		// 输入数据死数据
		String words = "Writing Fast Tests Against Enterprise Rails 60min;Overdoing it in Python 45min;Lua for the Masses 30min;Ruby Errors from Mismatched Gem Versions 45min;Common Ruby Errors 45min;Rails for Python Developers lightning;Communicating Over Distance 60min;Accounting-Driven Development 45min;Woah 30min;Sit Down and Write 30min;Pair Programming vs Noise 45min;Rails Magic 60min;Ruby on Rails: Why We Should Move On 60min;Clojure Ate Scala (on my project) 45min;Programming in the Boondocks of Seattle 30min;Ruby vs. Clojure for Back-End Development 30min;Ruby on Rails Legacy App Maintenance 60min;A World Without HackerNews 30min;User Interface CSS in Rails Apps 30min";
		String[] wordArr = words.split(";");
		for (int i = 0; i < wordArr.length; i++) {
			lslls.add(wordArr[i]);
		}

		// 在控制台输入数据
		// Scanner scanner = new Scanner(System.in);
		// while (scanner.hasNext()) {
		// String str = scanner.nextLine();
		// lslls.add(str);
		// }

		// 数据处理为需要的格式
		dealInput(lslls, contence);

		// 会议数据排序
		List<Plan> planList = dataSort(contence);

		// 处理planList结果，按照时间顺序打印
		resultPrint(planList);
	}

	// 处理planList结果，按照时间顺序打印
	private static void resultPrint(List<Plan> planList) {
		Map<String, List<String>> reultMap = new HashMap<String, List<String>>();
		Set<String> trackSet = new TreeSet<String>();
		for (int i = 0; i < planList.size(); i++) {
			String Track = planList.get(i).getTrack();
			trackSet.add(Track);
			List<String> trackList = new ArrayList<String>();
			String doTime = "";
			String TimeFlag = "";
			int key = 0;
			// System.out.println(Track);
			Map<String, String> contence1 = new IdentityHashMap<String, String>();
			dealInput(planList.get(i).getContents(), contence1);
			if ("上午".equals(planList.get(i).getTime())) {
				TimeFlag = "AM";
				doTime = "09:00";
			} else {
				TimeFlag = "PM";
				doTime = "01:00";
			}
			for (String printKey : contence1.keySet()) {
				key++;
				// 存入list中
				trackList.add(doTime + TimeFlag + " " + contence1.get(printKey));

				// 添加网络时间和午餐时间
				if (key == contence1.size()) {
					if ("上午".equals(planList.get(i).getTime())) {
						trackList.add("12:00PM Lunch");
					} else {
						trackList.add("05:00PM Networking Event");
					}
				}

				// 根据开会时间计算时间时刻
				doTime = addDateMinut(doTime, Integer.valueOf(printKey));
				// System.out.println(doTime + TimeFlag + " " +
				// contence1.get(printKey));
			}
			if (reultMap.containsKey(Track)) {
				List<String> newTrackList = reultMap.get(Track);
				newTrackList.addAll(trackList);
				reultMap.put(Track, newTrackList);
			} else {
				reultMap.put(Track, trackList);
			}
		}

		// track排序
		int[] trackInt = new int[trackSet.size()];
		int i = 0;
		for (String track : trackSet) {
			trackInt[i] = Integer.valueOf(track);
			i++;
		}
		bubbleSort(trackInt, trackInt.length);

		// 在控制台打印
		for (int j = 0; j < trackInt.length; j++) {
			System.out.println("Track" + trackInt[j] + ":");
			for (int k = 0; k < reultMap.get(trackInt[j] + "").size(); k++) {
				System.out.println(reultMap.get(trackInt[j] + "").get(k));
			}
		}
	}

	private static List<Plan> dataSort(Map<String, String> contence) {
		List<Plan> planList = new ArrayList<Plan>();
		int moring = 0;
		int afternoon = 0;

		int track = 1;
		List<String> moringList = new ArrayList<String>();
		List<String> afternoonList = new ArrayList<String>();
		int flag = 0;
		for (String key : contence.keySet()) {
			flag++;
			// 上午180分钟，下午180+60分钟
			if (moring >= 0 && moring + Integer.valueOf(key) <= 180) {
				moringList.add(contence.get(key));
				moring = moring + Integer.valueOf(key);
			} else if (moring + Integer.valueOf(key) > 180 && afternoon + Integer.valueOf(key) <= 240) {

				afternoonList.add(contence.get(key));
				afternoon = afternoon + Integer.valueOf(key);
			} else {

				List<String> moringReList = moringList;
				List<String> afternoonReList = afternoonList;
				Plan mplan = new Plan();
				mplan.setTrack(track + "");
				mplan.setTime("上午");
				mplan.setContents(moringReList);
				planList.add(mplan);

				Plan aplan = new Plan();
				aplan.setTrack(track + "");
				aplan.setTime("下午");
				aplan.setContents(afternoonReList);
				planList.add(aplan);

				moringList = new ArrayList<String>();
				moringList.add(contence.get(key));
				moring = Integer.valueOf(key);
				afternoonList = new ArrayList<String>();
				afternoon = 0;
				track++;
				continue;
			}
			if (contence.size() == flag) {

				List<String> moringReList = moringList;
				List<String> afternoonReList = afternoonList;
				Plan mplan = new Plan();
				mplan.setTrack(track + "");
				mplan.setTime("上午");
				mplan.setContents(moringReList);
				planList.add(mplan);

				Plan aplan = new Plan();
				aplan.setTrack(track + "");
				aplan.setTime("下午");
				aplan.setContents(afternoonReList);
				planList.add(aplan);

				moringList = new ArrayList<String>();
				afternoonList = new ArrayList<String>();
				moring = 0;
				afternoon = 0;
				track++;
			}

		}
		return planList;
	}

	// 将输入开会队列解析为时间和内容的map
	private static void dealInput(List<String> lslls, Map<String, String> contence) {
		for (int i = 0; i < lslls.size(); i++) {
			String str = lslls.get(i).trim();
			String time = str.substring(str.lastIndexOf(" ") + 1);
			// 判断是否是包含lightning
			if ("lightning".equals(time)) {
				time = "5min";
			}
			String str2 = "";
			if (time != null && !"".equals(time)) {
				for (int j = 0; j < time.length(); j++) {
					if (time.charAt(j) >= 48 && time.charAt(j) <= 57) {
						str2 += time.charAt(j);
					}
				}
			}
			contence.put(str2, lslls.get(i));
		}
	}

	// 根据分钟计算时间时刻
	public static String addDateMinut(String day, int x) {

		// 24小时制格式
		SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = newFormat.parse(day);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, x);// 24小时制
		date = cal.getTime();
		cal = null;

		// 转换结果的格式 HH:mm
		return newFormat.format(date);
	}
	

	/**
	 * 冒泡排序 从最后一个元素开始向前，两两相邻元素比较，较小的换到较大的前面，一趟冒泡过后，关键字最小的元素到达最前面
	 * 
	 * @param a
	 * @param n
	 */
	public static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) { // 从n-1到i，比较找出本趟最小元素将其交换到i位置
				if (a[j] < a[j - 1]) { // 如果有后面元素小于前一个元素，交换
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
	}

}
