package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.pojo.SmbmsRole;
import com.smbms.pojo.SmbmsUser;
import com.smbms.service.UserService;
import com.smbms.utils.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jsp")
public class UserController {
    public static void main(String[] args) {
        System.out.println("hello");
    }


    @Resource
    private UserService userService;

    @RequestMapping(value = "changepassword",method = RequestMethod.POST)
    public String changepassword(HttpServletRequest request,@RequestParam String newpassword){
        SmbmsUser userSession= (SmbmsUser) request.getSession().getAttribute("userSession");
        boolean result= userService.findchangepassword(newpassword,userSession.getId());
        if(result){
            return "frare";
        }else {
            request.setAttribute("message","修改密码失败");
            return "pwdmodify";
        }
    }

    /*根据id查询用户所有信息*/
    @ResponseBody
    @RequestMapping(value = "/userinfo/{id}",method = RequestMethod.GET)
    public String findUserByid(@PathVariable Integer id){
        SmbmsUser smbmsUser= userService.finUserByid(id);
        return JSON.toJSONString(smbmsUser);
    }

    @ResponseBody
    @RequestMapping(value = "ucexist",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ucexist(@RequestParam String userCode){
        SmbmsUser smbmsUser= userService.finduserByUserCode(userCode);
        if(smbmsUser.getUserName()==null){
            smbmsUser.setUserCode("ucexist");
            return JSON.toJSONString(smbmsUser);
        }else {
            smbmsUser.setUserCode("exist");
            return JSON.toJSONString(smbmsUser);
        }
    }

    /*ajax查询用户角色   ajax请求必须加注释@ResponseBody*/
    @ResponseBody
    @RequestMapping(value = "getrolelist",method = RequestMethod.GET)
    public String getrolelist(){
        //
        List<SmbmsRole> roleList = userService.findRoleList();
        //返回ajax字符串
        return JSON.toJSONString(roleList);

    }

    @RequestMapping(value = "useraddsave.html",method = RequestMethod.POST)
    public String addUserSave(HttpServletRequest request,
                              @ModelAttribute SmbmsUser user,
                              @RequestParam(value = "a_idPicPath",required = false) MultipartFile acctch){
        String tangetFileName=null;
            //1.判空
        if (!acctch.isEmpty()){
            //定义目标路径
            tangetFileName=request.getServletContext().getRealPath("static"+File.separator+"fileupLoad");
            //获取源文件
            String oddFliename= acctch.getOriginalFilename();
            //获取文件大小
            int fliSize=500000;//500k
            //获取后缀名
            String extenSion= FilenameUtils.getExtension(oddFliename);
            if (acctch.getSize()>fliSize){
                request.setAttribute("uploadFileError","文件大小超过了");
                return "useradd";
           }else if(extenSion.equalsIgnoreCase("jpg")&&
                    extenSion.equalsIgnoreCase("png")&&
                    extenSion.equalsIgnoreCase("jpeg")){
                    //定义上传文件名
                    String FileName=System.currentTimeMillis()+""+ RandomUtils.nextInt(1000000)+"Person"+extenSion;
                    //创建文件对象
                File file=new File(tangetFileName,FileName);
                if(!file.exists()){
                    file.mkdir();
                }
                try {
                    acctch.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    request.setAttribute("uploadFileError","系统错我请重试");
                    return "useradd";
                }
                //记录文件上传的路径
                tangetFileName=tangetFileName+File.separator+FileName;
            }else {
                request.setAttribute("uploadFileError","上传文件格式不正确");
                return "useradd";
            }
        }
        //定义上传录井
        user.setIdPicPath(tangetFileName);
        //创建着
        SmbmsUser  userSession= (SmbmsUser) request.getSession().getAttribute("userSession");
        user.setCreatedBy(userSession.getId());
        //创建时间
        user.setCreationDate(new Timestamp(new Date().getTime()));


        if(userService.addUserSave(user)){
            return "redirect:/jsp/query";
        }
        return "useradd";
    }





    @RequestMapping(value = "/query")
    public String getUserList(HttpServletRequest request,
                              @RequestParam(required = false) Integer pageIndex,
                              @RequestParam(required = false) String queryname,
                              @RequestParam(required = false) Integer queryUserRole ){
        // 分页查询用户列表
        // 1.定义起始页
        if (pageIndex == null){
            pageIndex = 1;
        }
        // 2.定义每页显示多少行
        Integer pageSize = 5;

        PageBean<SmbmsUser> pageBean =  userService.findUserPage(pageIndex,pageSize,queryname,queryUserRole);

        //  3.查询角色列表
        List<SmbmsRole> roleList = userService.findRoleList();
        // 将数据回显到页面上  增加用户的体验
        request.setAttribute("queryUserName",queryname);
        request.setAttribute("queryUserRole",queryUserRole);
        /* 将查询到的数据传入给前端*/
        request.setAttribute("roleList",roleList);
        request.setAttribute("userList",pageBean.getResult());
        request.setAttribute("totalPageCount",pageBean.getTotalPage());
        request.setAttribute("totalCount",pageBean.getTotalCount());
        request.setAttribute("currentPageNo",pageBean.getCurrentPageNo());

        return "userlist";
    }
}
