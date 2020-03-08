package com.raven.keju.utils;

import com.raven.keju.billing.StraegyFactoy;
import com.raven.keju.billing.TaxiCost;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static String readFile(String filePath) throws IOException {
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        inputStream = new FileInputStream(filePath);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        StringBuffer res=new StringBuffer();
        while ((str = reader.readLine()) != null) {
            TaxiCost taxiCost;
            String line=str;
            // 按指定模式在字符串查找
            String pattern = "[0-9]*";
            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern);
            // 现在创建 matcher 对象
            Matcher m = r.matcher(line);

            if (m.find()){

                taxiCost=StraegyFactoy.getStraegy(Integer.parseInt(m.group(0)),Integer.parseInt(line.split("[等待分钟]")[2]));
                res.append(taxiCost.billing());
            }
        }
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res.toString();
    }

}
