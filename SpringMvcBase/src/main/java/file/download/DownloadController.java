package file.download;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件下载
 * Created by Super腾 on 2017/1/11.
 */
@Controller
public class DownloadController {
    @RequestMapping("/download")
    public String download(@RequestParam String filename, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入了下载控制器 ----------------------");
        //通知返回的参数类型
        response.setContentType("text/html;charset=utf-8");
        //请求编码参数设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //定义输入输出流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String path = request.getSession().getServletContext().getRealPath("/") + "upload/" + filename;
        try {
            long fileLength = new File(path).length();
            //设置相应的文件类型，全局下载的类型
            response.setContentType("application/x-msdownload");
            //文件长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            //文件以附件形式进行返回
            response.setHeader("Content-disposition", "attachment;filename=" + new String(filename.getBytes(), "ISO-8859-1"));
            //文件输入流进行读取文件内容
            bis = new BufferedInputStream(new FileInputStream(path));
            //文件输出流进行输出到response请求中去
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            //文件当前读取到的具体行数内容
            int byteRead;
            //如果没有读到底的话
            while ((byteRead = bis.read(buff, 0, buff.length)) != -1) {
                //把信息输出过去
                bos.write(buff, 0, byteRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bis !=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
