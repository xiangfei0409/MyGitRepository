import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: xiangfei
 */
public class demo1 {
    public static void main(String[] args) {

        float weatherQualiwtyTrans = 0f;
        float tempTrans = 0f;
        List<Float> engineTrans = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String strs = scanner.nextLine();
            if (strs.contains("优") || strs.contains("良") || strs.contains("差") || strs.contains("中")){
                weatherQualiwtyTrans = getWeatherQuality(strs);
            } else if (strs.contains("温度")){
                tempTrans = getTemperature(strs.trim().substring(4).trim());
            } else if (strs.contains("T3") || strs.contains("T5") || strs.contains("E6")){
                getEngine(strs, engineTrans);
            } else if (strs.contains("HD")){
                String[] healthes = getHealth(weatherQualiwtyTrans, tempTrans, engineTrans);
                for(String health : healthes){
                    System.out.println(health);
                }
                break;
            }
        }
    }

    //计算健康值
    public static String[] getHealth(float weatherQualiwtyTrans, float tempTrans, List<Float> engineTrans){
        String[] health = new String[engineTrans.size()];
        for (int i = 0; i < engineTrans.size(); i++) {
            float num = engineTrans.get(i) / (weatherQualiwtyTrans * tempTrans);
            String result = String.format("%.4f", num);
            health[i] = result;
        }
        return health;
    }

    //获取天气质量
    public static float getWeatherQuality(String str){
        if (str.contains("优")){
            return 4;
        }else if(str.contains("良")){
            return 3;
        }else if(str.contains("中")){
            return 2;
        } else{
            return 1;
        }
    }

    //获得温度差
    public static float getTemperature(String str){
        float a = Float.parseFloat(str.split("-")[0]);
        float b = Float.parseFloat(str.split("-")[1]);
        return b - a;
    }

    //获得发动机转换值
    public static void getEngine(String str, List<Float> engineTrans){
        if (str.contains("T3")){
            int num = Integer.valueOf(str.split("T3")[1].trim());
            if(num < 3000 ){
                engineTrans.add(30f);
            } else if(num >= 3000 && num < 5000){
                engineTrans.add(60f);
            } else {
                engineTrans.add(100f);
            }
        } else if(str.contains("T5")) {
            int num = Integer.valueOf(str.split("T5")[1].trim());
            if (num < 3000) {
                engineTrans.add(20f);
            } else if (num >= 3000 && num < 5000) {
                engineTrans.add(40f);
            } else {
                engineTrans.add(60f);
            }
        } else {
            int num = Integer.valueOf(str.split("E6")[1].trim());
            if (num < 3000) {
                engineTrans.add(10f);
            } else if (num >= 3000 && num < 5000) {
                engineTrans.add(20f);
            } else {
                engineTrans.add(50f);
            }
        }
    }
}
