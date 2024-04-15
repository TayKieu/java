package com.example.controller;

import com.example.CONSTAINT.Constaint;
import com.example.model.bean.FileUpload;
import com.example.model.bean.User;
import com.example.model.bo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 500) // 500MB
@WebServlet(name = "ConvertPdfServlet", value = "/ConvertPdfServlet")
public class ConvertPdfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "LogoutServlet":
                logout(request, response);
                break;
            case "DownloadFileServlet":
                download(request,response);
                break;
            case "ShowErrorServlet":
                showError(request,response);
                break;
            case "FileServlet":
                file(request,response);
                break;
            default:
                showLoginForm(request, response);
                break;
        }
    }


    private void file(HttpServletRequest request, HttpServletResponse response) {
        int userId = 0;

        try {
            userId = Integer.parseInt(request.getParameter("userId"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (userId != 0) {
            List<FileUpload> files = ShowProfileBO.GetProcessFile(userId);
            request.setAttribute("Files", files);
            String src = "/File.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(src);
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showError(HttpServletRequest request, HttpServletResponse response) {
        int errorCode = 0;
        int userId = 0;
        try {
            errorCode = Integer.parseInt(request.getParameter("errorCode"));
            userId = Integer.parseInt(request.getParameter("userId"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        switch (errorCode) {
            case Constaint.PROCESSING: {
                break;
            }
            case Constaint.CONVERT_ERROR: {
                request.getSession().setAttribute("message",
                        "Có lỗi xảy ra trong quá trình chuyển đổi, vui lòng kiểm tra lại tên file và thử lại sau!");
                break;
            }
            case Constaint.UPLOAD_ERROR: {
                request.getSession().setAttribute("message",
                        "Có lỗi xảy ra trong quá trình upload file, vui lòng thử lại sau!");
                break;
            }
            default:
                request.getSession().setAttribute("message", "Có lỗi xảy ra, vui lòng thử lại sau!");
                break;
        }

        try {
            response.sendRedirect("UserProfileServlet?userId=" + userId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File GetFolderPath(String folder) {
        File folderUpload = new File(System.getProperty("user.home") + "/" + folder);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
    private void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int fileId = 0;

        try {
            fileId = Integer.parseInt(request.getParameter("fileId"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        if(fileId != 0) {
            FileUpload file = DownloadFileBO.GetFile(fileId);

            String scrpath = GetFolderPath("docxs").getAbsolutePath() + File.separator + file.getFileName();
            Path path = Paths.get(scrpath);
            byte[] data = new byte[0];
            try {
                data = Files.readAllBytes(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; fileName=" + file.getFileName());
            response.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));

            OutputStream outStream = null;
            try {
                outStream = response.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while (true) {
                try {
                    if (!((bytesRead = inputStream.read(buffer)) != -1)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                outStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outStream.close();

        }else {
            request.getSession().setAttribute("message", "File không tồn tại hoặc đã bị xóa!");
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") != null) {
           response.sendRedirect("home.jsp");
            }
         else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "CheckLoginServlet":
                login(request, response);
                break;
            case "UploadfileServlet":
                upload(request,response);
                break;
        }
    }

    private void upload(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part filesPart = request.getPart("files_upload");
            if (filesPart != null && filesPart.getSize() != 0) {
                String username = request.getParameter("username");
                User user = FindUserBO.FindUser(username);
                Thread t = new Thread(new UploadFileBO(request, user));
                t.start();
                request.getSession().setAttribute("message", "Uploading...");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        try {
            response.sendRedirect("home.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user", null);
        try {
            response.sendRedirect("login.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("") || password.equals("")) {
            request.getSession().setAttribute("message",
                    "Tên đăng nhập và mật khẩu không hợp lệ!");
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (CheckLoginBO.CheckLogin(username, password)) {
                User user = FindUserBO.FindUser(username);
//                List<FileUpload> files = ShowProfileBO.GetPdfFiles(user.getUserId());
//                request.setAttribute("Files",files);
                request.getSession().setAttribute("user", user);
//                request.getSession().setAttribute("message", "Đăng nhập thành công!");
//                String src = "/home.jsp";
//                RequestDispatcher rd = request.getRequestDispatcher(src);
                try {
//                    rd.forward(request,response);
                    response.sendRedirect("home.jsp");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                request.getSession().setAttribute("message",
                        "Có lỗi xảy ra, vui lòng kiểm tra lại thông tin tài khoản!");
                try {
                    response.sendRedirect("login.jsp");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
