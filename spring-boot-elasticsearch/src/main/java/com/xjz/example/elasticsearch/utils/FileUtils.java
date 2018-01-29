/**
 * FileName: FileUtils
 * Author:   xiangjunzhong
 * Date:     2018/1/10 11:15
 * Description: 文件工具类
 */
package com.xjz.example.elasticsearch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件工具类〉
 *
 * @author xiangjunzhong
 * @create 2018/1/10 11:15
 * @since 1.0.0
 */
public class FileUtils {

    /**
     * 复制文件夹
     *
     * @param oldPath 原文件路径
     * @param newPath 复制后路径
     * @return 成功 失败
     */
    public static boolean copyFolder(String oldPath, String newPath) {
        boolean result = false;
        try {
            File file = new File(oldPath);
            if (file.exists()) {
                String[] filePath = file.list();

                if (filePath != null && filePath.length > 0) {
                    if (!(new File(newPath)).exists()) {
                        (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
                    }

                    File temp = null;
                    for (int i = 0; i < filePath.length; i++) {
                        if (oldPath.endsWith(File.separator)) {
                            temp = new File(oldPath + filePath[i]);
                        } else {
                            temp = new File(oldPath + File.separator + filePath[i]);
                        }

                        if (temp.isFile()) {
                            FileInputStream input = new FileInputStream(temp);
                            FileOutputStream output = new FileOutputStream(newPath + File.separator + (temp.getName()).toString());
                            byte[] b = new byte[1024 * 5];
                            int len;
                            while ((len = input.read(b)) != -1) {
                                output.write(b, 0, len);
                            }
                            output.flush();
                            output.close();
                            input.close();
                        }
                        if (temp.isDirectory()) { // 如果是子文件夹
                            copyFolder(oldPath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
                        }
                    }
                    if (new File(newPath).exists()) {
                        result = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        copyFolder("C:\\Users\\Administrator\\Desktop\\QTM", "C:\\Users\\Administrator\\Desktop\\QTM1");
    }
}