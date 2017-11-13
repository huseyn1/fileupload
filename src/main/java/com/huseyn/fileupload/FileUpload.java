
package com.huseyn.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletFileUpload fileUpload=new ServletFileUpload(new DiskFileItemFactory());
        
        
        try {
            List<FileItem> items=fileUpload.parseRequest(request);
            for (FileItem item : items){
            
            item.write(new File("D:\\uploadedfiles\\"+item.getName()));
            
            }
            
            PrintWriter writer=response.getWriter();
            writer.println("file uploaded");
            
        } catch (FileUploadException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("file uploaded");

    }

}
