package otherSrc;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取文件
 *
 * @author: lll
 * @date: 2021年04月19日 14:04:53
 */
public class ReadFile {
    public static void main(String[] args) throws ParseException {

        File file = new File("D:/illegalInfo20210506.txt");
        List<String> fileDataLst = readFile(file, "utf-8");
//        BigDecimal t=new BigDecimal(0);
//        for (int i = 0; i < fileDataLst.size(); i++) {
//            String amount=fileDataLst.get(i)[6];
//            t=t.add(new BigDecimal(amount));
//        }
//        System.out.println(fileDataLst.size());
//        System.out.println(t);

        for (int i = 0; i < fileDataLst.size(); i++) {
            String key =fileDataLst.get(i);
//            System.out.println(key);
            if(!key.startsWith("36")){
                System.out.println(i);
                System.out.println(key);
            }
        }
//        DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
//        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
//        String beginTime=new String("2018-07-17");
//        String endTime=new String("2021-04-28");
//        Date bd = format2.parse(beginTime);
//        Date ed = format2.parse(endTime);
//       while (true){
//           Calendar calendar2 = Calendar.getInstance();
//           calendar2.setTime(bd);
//           calendar2.add(Calendar.DATE, 1);
//           bd = calendar2.getTime();
//           if(bd.before(ed)){
//               String date=format1.format(bd)+"Y";
//               int key=2;
//               for (int i = 0; i < fileDataLst.size(); i++) {
//                    if(date.equals(fileDataLst.get(i))){
//                        key=1;
//                        break;
//                    }
//               }
//               if(key==2){
//                   System.out.println(format1.format(bd)+"Y");
//               }
//           }else {
//               return;
//           }
//       }
    }


    //根据file和charset读取文件
    public static List<String> readFile(File file, String charset) {
        //设置默认编码
        if (charset == null) {
            charset = "UTF-8";
        }
        if (file.isFile() && file.exists()) {
            FileInputStream fileInputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(fileInputStream, charset);
                bufferedReader = new BufferedReader(inputStreamReader);
                List<String> fileDataList = new ArrayList<String>();
                String text = null;
                int line = 0;
                while ((text = bufferedReader.readLine()) != null) {
                    if (line > 1 && null != text && text.trim().length() > 0) {
                        String[] strings = text.split("#");
                        fileDataList.add(text);
                    }
//                    fileDataList.add(strings);
                    line++;
                }
                return fileDataList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != fileInputStream) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != inputStreamReader) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != bufferedReader) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }


}
