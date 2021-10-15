package com.qhzk.imge.utils;

import java.io.*;

/**
 * @description: 命令行执行工具
 * @author: Mr.Muxl
 * @create: 2021-07-06 10:53
 **/
public class ProcessUtil {
    private StringBuffer info;

    private String[] commands;

    ProcessBuilder pbuilder;

    public ProcessUtil() {
        commands = new String[3];
        if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
            commands[0] = "cmd";
            commands[1] = "/c";
        } else {
            commands[0] = "/bin/sh";
            commands[1] = "-c";
        }
    }

    public StringBuffer getInfo() {
        return info;
    }

    public String getOutputMessage() {
        return info.toString();
    }

    public int execute(String command) throws IOException, InterruptedException {
        return execute(command, null, null);
    }

    //重载execute
    public int execute(String command, String env, File dir) throws IOException, InterruptedException {
        if("".equals(command)){
            return -1;
        }
        this.commands[2] = command;
        this.info = new StringBuffer();
        pbuilder = new ProcessBuilder(this.commands);
        pbuilder.directory(dir);
        pbuilder.redirectErrorStream(true);
        if (env != null && !env.trim().isEmpty()) {
            pbuilder.environment().put("Path", String.format("%s;%s", pbuilder.environment().get("Path"), env));
        }
        Process process = pbuilder.start();
        String line;
        InputStreamReader inputStreamReader;
        int resultCode = 0;
        try (InputStream inputStream = process.getInputStream()){
            inputStreamReader = new InputStreamReader(inputStream, "GBK");
            BufferedReader rd = new BufferedReader(inputStreamReader);
            while ((line = rd.readLine()) != null) {
                //特殊处理, 只记录2000 个字符 错误信息太长可导致内存溢出
                if (info.length() < 2000) {
                    this.info.append(line).append("\n");
                }
            }
            resultCode = process.waitFor();
            process.destroy();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultCode;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        String commondstr = "magick convert C:\\Users\\qhzk\\Pictures\\dx1.png  C:\\Users\\qhzk\\Pictures\\bcommond.jpg";
        String convert = "magick convert ( C:\\Users\\qhzk\\Pictures\\dx.png -colorspace gray -type grayscale -contrast-stretch 0 ) ( -clone 0 -colorspace gray -negate -lat 25x25+10% -contrast-stretch 0 ) -compose copy_opacity -composite -fill white -opaque none +matte -deskew 40% -sharpen 0x1 C:\\Users\\qhzk\\Pictures\\dxtext.png";
        ProcessUtil ex = new ProcessUtil();
//        int execute = ex.execute(commondstr);
        int execute = ex.execute(convert);
        System.out.println(execute);
    }
}
