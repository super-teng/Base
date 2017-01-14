package file.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Super腾 on 2017/1/10.
 * 单文件上传
 */
@Controller
public class FileUpload {
    /**
     * 上传单个文件
     * @param multipartFile 上传的具体媒体文件
     * @param request 传过来的request请求
     * @return 当前上传照片的效果
     */
    @RequestMapping("/uploadOne")
    public String Upload(@RequestParam("file01") MultipartFile multipartFile, HttpServletRequest request,HttpSession session){
        System.out.println("哈哈哈-------------------");
        //获取到当前上传文件的名称构成权限定名 获取当前servlet环境当中的跟路径，也就是webapp
        String dir = request.getSession().getServletContext().getRealPath("") +"upload/";
        //拼接组成当前文件的真是路径
        String filename = multipartFile.getOriginalFilename();
        //健壮性操作，判断当前文件夹是否存在
        File fileDir = new File(dir);
        //如果不存在则创建当前文件夹
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        //健壮性操作，创建一个当前文件名称相同的空文件
        File file = new File(dir+filename);
        System.out.println("dir:"+dir+"----------filename:"+filename);
        //如果当前文件不存在
        if(!file.exists()){
            //创建一个新文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //通过字节流的方式往这个空文件中进行文件的上传读写
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将第一个上传文件上传到session中便于下载
       session.setAttribute("file",filename);
        //通过重定向的方式去访问这个文件的路径进行访问
        return "redirect:http://localhost:8080/SpringMvcBase/upload/"+filename;
    }

    /**
     * 多文件上传
     * @param request request请求
     * @return 显示结果页面
     */
    @RequestMapping("moreUpload")
    public String moreUpload(HttpServletRequest request){
        //将request请求转化成多重servlet类型
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //通过getFileMap方法来获取上传的集合
        Map<String,MultipartFile> files = multipartHttpServletRequest.getFileMap();
        //获取到当前上传文件的名称构成权限定名 获取当前servlet环境当中的跟路径，也就是webapp
        String dir = request.getSession().getServletContext().getRealPath("") +"upload/";
        //健壮性操作，判断当前文件夹是否存在
        File fileDir = new File(dir);
        //如果不存在则创建当前文件夹
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        //存储所有遍历的路径用于处理
        List<String> list = new ArrayList<String>();
        for(MultipartFile file : files.values()){
            File targetFile = new File(dir+file.getOriginalFilename());
            //如果当前文件不存在
            if(!targetFile.exists()){
                //创建一个新文件
                try {
                    targetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //文件传输
                try {
                    file.transferTo(targetFile);
                    //添加路径到list中去
                    list.add("http://localhost:8080/SpringMvcBase/upload/"+file.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        for(String temp:list){
            System.out.println(temp);
        }
        request.setAttribute("files",list);
        return "moreUploadResult";
    }

}
