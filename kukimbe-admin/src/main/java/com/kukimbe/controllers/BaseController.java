package com.kukimbe.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by chuck on 8/12/16.
 */
@Controller
public class BaseController {
    private final static Logger LOG = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello(Model model){
        model.addAttribute("message", "Hi");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/active")
    public String activeBase(Model model){
        model.addAttribute("message", "Hi");
        return "active";
    }

    @RequestMapping(method = RequestMethod.GET, value="uploadPage")
    public String uploadPage(Model model){

        return "uploadPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file ,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes, ModelMap map) {
        String name=file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(name);
        if(!"xls".equalsIgnoreCase(extension) && !"xlsx".equalsIgnoreCase(extension)){
            redirectAttributes.addFlashAttribute("error",
                    "Unsupporte file type: " + extension);
            return "redirect:uploadPage";
        }
        try {
            this.downloadFile(file, name);
            //Rajat add code here for excel parsing
        }catch(Exception e){
            LOG.error("Error downloading file", e);
        }
        return "uploadSuccess";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uploadSuccess")
    public String uploadSuccess(HttpServletRequest request,
                                   RedirectAttributes redirectAttributes, ModelMap map) {

        return "uploadSuccess";
    }

    private File downloadFile(@RequestParam("file") MultipartFile file, String name) throws IOException {
        File directory = new File("/usr/local/tomcat/temp");//@TODO Rajat to put in properties file (where to write to)
        FileUtils.forceMkdir(directory);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File(directory,name)));
        LOG.debug("Copying file to: [{}]", directory.getAbsoluteFile() + name);
        FileCopyUtils.copy(file.getInputStream(), stream);
        stream.flush();
        stream.close();
        return directory;
    }

}
