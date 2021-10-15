package com.qhzk.autogen.freemark.util;

import com.qhzk.autogen.freemark.asplusm.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @description: 生成自定义代码类
 * @author: Mr.Muxl
 * @create: 2021-06-28 13:23
 **/
@Component
public class PlusFreemarkerUtils {

    /**
     *  实体类必备字段*
     */
    public static List<String []> varLists = new ArrayList<String []>();
    /**
     * 标题 *
     */
    public static String title = "";
    /**
     * mybatis生成的实体类 *
     */
    public static String objectName = "";
    /**
     * mybatis生成的实体类简写 *
     */
    public static String objectNameLower = "";
    /**
     * mybatis生成的实体类简写 *
     */
    public static String mapping = "";
    /**
     * 查询字段 *
     */
    public static String columns = "";

    /**
     * 配置
     */
    private static Configuration configuration = null;
    //生成文件路径
    private static String createFilePath = "d:/plusFtlFileCreatePath/";

    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }

    public static <T> void  precreatecode(Class<T> attributesModelClass) throws IOException {
        /**
         * 根据类组装生成信息
         */
        StringBuffer clum = new StringBuffer("");
        String claname = attributesModelClass.getName().replace("com.qhzk.autogen.freemark.asplusm.","");
        objectName = claname;
        String lowerclaname = claname.toLowerCase();
        objectNameLower= lowerclaname;
        mapping = lowerclaname;
        Field[] field = attributesModelClass.getDeclaredFields();  //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {  //遍历所有属性
            String name = field[j].getName();    //获取属性的名字
            if(j==0){
                clum.append(name);
            }else {
                clum.append(","+name);
            }

            String uppername = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString();    //获取属性的类型
            System.out.println(claname+"-->"+name+"("+type+")("+uppername+")");


            String clumtype ="VARCHAR";
            String isid ="N";

            if("pkid".equals(name)){
                isid ="Y";
            }
            if (type.equals("class java.lang.String")) {
                clumtype ="VARCHAR";
            }
            if (type.equals("class java.lang.Long")||type.equals("long")) {
                clumtype ="BIGINT";
            }
            if (type.equals("class java.lang.Integer")||type.equals("int")) {
                clumtype ="INTEGER";
            }
            if (type.equals("class java.math.BigDecimal")) {
                clumtype ="DECIMAL";

            }
            if (type.equals("class java.util.Date")) {
                clumtype ="TIMESTAMP";

            }
            varLists.add(new String []{name,uppername,clumtype,isid});
        }
        columns =clum.toString();

        /**
         * 注入参数
         */
        Map map = new HashMap();
        map.put("nowDate", new Date());

        map.put("fieldList", varLists);
        map.put("mapping", mapping);
        map.put("objectNameLower", objectNameLower);
        map.put("objectName",objectName);
        map.put("title", title);

        map.put("columns",columns);

        /**
         * 执行生成
         */
        PlusFreemarkerUtils WordUtils = new PlusFreemarkerUtils();
        File f = WordUtils.createDoc(map);
    }


    public File createDoc(Map<String, Object> dataMap) throws IOException {
        //生成文件名
        String name = "";
        File f = null;
        //加载模板目录，模板在bin/flt/createFm内
        configuration.setClassForTemplateLoading(this.getClass(), "/plus/createFm/");
        Template t = null;
        try {
            Writer w = null;
            //生成mapper
            t = configuration.getTemplate("mapperxmlTemplate.ftl");
            t.setEncoding("utf-8");
            name = createFilePath+dataMap.get("objectName")+"Mapper.xml";
            f = new File(name);
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开

            w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();
            //生成mapper
            t = configuration.getTemplate("mapperTemplate.ftl");
            t.setEncoding("utf-8");
            name = createFilePath+dataMap.get("objectName")+"Mapper.java";
            f = new File(name);
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();

            //生成接口
            t = configuration.getTemplate("serviceTemplate.ftl");
            t.setEncoding("utf-8");
            name = createFilePath+dataMap.get("objectName")+"Service.java";
            f = new File(name);
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开

            w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();
            //生成接口实现
            t = configuration.getTemplate("serviceImplTemplate.ftl");
            t.setEncoding("utf-8");
            name = createFilePath+dataMap.get("objectName")+"ServiceImpl.java";
            f = new File(name);
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();

            //生成APIcontroller
            t = configuration.getTemplate("ApiControllerTemplate.ftl");
            t.setEncoding("utf-8");
            name = createFilePath+dataMap.get("objectName")+"ApiController.java";
            f = new File(name);
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        List<AutoInfo> autos = new ArrayList<>();
//        autos.add(new AutoInfo("","公司信息", Company.class));
//        autos.add(new AutoInfo("","部门信息", Dept.class));
//        autos.add(new AutoInfo("","部门-用户", DeptUser.class));
//        autos.add(new AutoInfo("","文件信息", FileInfo.class));
//        autos.add(new AutoInfo("","菜单信息", Menu.class));
//        autos.add(new AutoInfo("","操作信息", Operate.class));
//        autos.add(new AutoInfo("","页面元素信息", Pelement.class));
//        autos.add(new AutoInfo("","权限-文件信息", PermissFile.class));
//        autos.add(new AutoInfo("","权限-菜单信息", PermissionMenu.class));
//        autos.add(new AutoInfo("","权限信息", Permissions.class));
//        autos.add(new AutoInfo("","权限-页面元素信息", PermissPelement.class));
//        autos.add(new AutoInfo("","角色信息", Role.class));
//        autos.add(new AutoInfo("","用户组-角色关联信息", RolePermissions.class));
//        autos.add(new AutoInfo("","用户-角色关联信息", RoleUser.class));
//        autos.add(new AutoInfo("","用户组信息", Ugroup.class));
//        autos.add(new AutoInfo("","用户组-角色关联信息", UgroupRole.class));
//        autos.add(new AutoInfo("","用户组-用户关联信息", UserUgroup.class));
//        autos.add(new AutoInfo("","用户信息", User.class));
//        autos.add(new AutoInfo("","公司-用户", CompanyUser.class));
        autos.add(new AutoInfo("","列的数据信息", ColumnInfo.class));
        autos.add(new AutoInfo("","代码生成配置", GenConfig.class));

        for (AutoInfo au:autos) {
            varLists  = new ArrayList<String []>();
            mapping ="";
            objectNameLower = "";
            objectName = "";
            title = au.getTitle();

            columns = "";

            precreatecode(au.getModelClass());
        }

    }
}
